/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import Model.dao.ClienteDAO;
import Model.dao.DividaDAO;
import View.ClienteCons;
import View.ClienteForm;
import View.DividaCons;
import View.DividaForm;
import View.PagamentoForm;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class Divida {

    private int idDivida;
    private Pessoa credor;
    private Date dataAtualizacao;
    private double valorDivida;
    private Pessoa devedor;

    public Divida(int idDivida, Pessoa credor, Date dataAtualizacao, double valorDivida, Pessoa devedor) {
        this.idDivida = idDivida;
        this.credor = credor;
        this.dataAtualizacao = dataAtualizacao;
        this.valorDivida = valorDivida;
        this.devedor = devedor;
    }

    public Divida(double valor_divida, Date dataAtualizacao) {
        this.valorDivida = valor_divida;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Pessoa getCredor() {
        return credor;
    }

    public Divida() {
    }

    public int getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(int idDivida) {
        this.idDivida = idDivida;
    }

    public void setCredor(Pessoa credor) {
        this.credor = credor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public Pessoa getDevedor() {
        return devedor;
    }

    public void setDevedor(Pessoa devedor) {
        this.devedor = devedor;
    }

    public void carregarTabela(DividaCons view) throws Exception {
        DividaDAO dividaDao = new DividaDAO();
        DividaTableModel dividaTm = new DividaTableModel(view);
        dividaTm.popularTabela(dividaDao.obterTodos("Todos"));
        view.getTabelaDivida();

    }

    public void carregarTabela(String filtro, DividaCons view, String documento) throws Exception {
        DividaDAO dividaDao = new DividaDAO();
        DividaTableModel dividaTm = new DividaTableModel(view);
        dividaTm.popularTabela(dividaDao.obter(filtro, documento, view));
        view.getTabelaDivida();
        if(filtro == "Pagas" || filtro == "Todas"){
            view.getBtnPagamento().setVisible(false);
        }else{
            
            if(documento.length() > 0){
                if(!view.getTabelaDivida().getValueAt(0,0).toString().equals("")){
                    view.getBtnPagamento().setVisible(true);
                }else{
                    view.getLblErro().setText("Dívida não encontrada!");
                }
            }
            
        }
        view.getBtnEditar().setVisible(true);
        view.getBtnExcluir().setVisible(true);
        view.getBtnVoltarDivida().setVisible(true);
        

    }

    public void excluir(DividaCons view) {
        DefaultTableModel dtm = (DefaultTableModel) view.getTabelaDivida().getModel();
        int codigo = Integer.parseInt(dtm.getValueAt(0, 0).toString());
        DividaDAO dividaDao = new DividaDAO();
        
        if (dividaDao.delete(codigo)) {
            view.getLblErro().setText("");
            view.getLblSucesso().setText("Dívida excluída com sucesso!");
            view.getTxtDocumento().setVisible(false);
            view.getLblCpf().setVisible(false);
            view.getBtnEditar().setVisible(false);
            view.getBtnVoltarDivida().setVisible(true);
            view.getBtnExcluir().setVisible(false);
            view.getSlcFiltro().setVisible(false);
            view.getBtnPesquisar().setVisible(false);
            view.getTabelaDivida().setVisible(false);
        } else {
            view.getLblSucesso().setText("");
            view.getLblErro().setText("Não é possível excluir essa dívida!");
        }
        
    }

    public void buscarDevedorCPF(DividaCons view) throws Exception {
        view.getLblErro().setText("");
        view.getLblSucesso().setText("");
        String documento = view.getTxtDocumento().getText();
        String filtro = view.getSlcFiltro().getSelectedItem().toString();
        this.carregarTabela(filtro, view, documento);
    }

    public void carregarDados(ClienteCons view) throws Exception {
        String documento = view.getTxtCPF().getText();
        ClienteDAO clienteDao = new ClienteDAO();

        DividaForm proxView = new DividaForm();
        proxView.setVisible(true);
        view.dispose();

        for (Cliente listaClientes : clienteDao.obterTodos()) {
            proxView.getSlcCredor().addItem(listaClientes.getNomeCliente());
            proxView.getSlcDevedor().addItem(listaClientes.getNomeCliente());

        }
        ClienteDAO clienteDao1 = new ClienteDAO();
        for (Cliente nomeCliente : clienteDao1.consultarPorCpf(documento)) {
            proxView.getSlcDevedor().setSelectedItem(nomeCliente.getNomeCliente());
            
        }
        proxView.getSlcDevedor().setEditable(false);
    }
    public void carregarDados(DividaCons view) throws Exception {
        DividaForm dividaForm = new DividaForm();
        ClienteDAO clienteDao = new ClienteDAO();
        DefaultTableModel dtm = (DefaultTableModel) view.getTabelaDivida().getModel();
        String codigo = dtm.getValueAt(0,0).toString();
        String nome_devedor = dtm.getValueAt(0,1).toString();
        String vlDivida = dtm.getValueAt(0,3).toString();
        String nome_credor = dtm.getValueAt(0,4).toString();
        String documento = dtm.getValueAt(0,2).toString();
        String dtAtualizacao = dtm.getValueAt(0,5).toString();
        System.out.println("escreva "+codigo+" "+nome_devedor+" "+nome_credor+" "+dtAtualizacao);
        for (Cliente listaClientes : clienteDao.obterTodos()) {
            dividaForm.getSlcCredor().addItem(listaClientes.getNomeCliente());
            dividaForm.getSlcDevedor().addItem(listaClientes.getNomeCliente());

        }
        ClienteDAO clienteDao1 = new ClienteDAO();
        for (Cliente nomeCliente : clienteDao1.consultarPorCpf(documento)) {
            dividaForm.getSlcDevedor().setSelectedItem(nomeCliente.getNomeCliente());
            
        }
        dividaForm.setVisible(true);
        dividaForm.getTxtCodigoDivida().setVisible(true);
         dividaForm.getTxtCodigoDivida().setText(codigo);
        dividaForm.getSlcDevedor().setSelectedItem(nome_devedor);
        dividaForm.getSlcCredor().setSelectedItem(nome_credor);
         dividaForm.getTxtDataAtualizacao().setText(dtAtualizacao);
         dividaForm.getTxtDivida().setText(vlDivida);
//        String documento = view.getTxtCPF().getText();
//        ClienteDAO clienteDao = new ClienteDAO();
//
//        DividaForm proxView = new DividaForm();
//        proxView.setVisible(true);
//        view.dispose();
//
//        for (Cliente listaClientes : clienteDao.obterTodos()) {
//            proxView.getSlcCredor().addItem(listaClientes.getNomeCliente());
//            proxView.getSlcDevedor().addItem(listaClientes.getNomeCliente());
//
//        }
//        ClienteDAO clienteDao1 = new ClienteDAO();
//        for (Cliente nomeCliente : clienteDao1.consultarPorCpf(documento)) {
//            proxView.getSlcDevedor().setSelectedItem(nomeCliente.getNomeCliente());
//            
//        }
//        proxView.getSlcDevedor().setEditable(false);
    }

    public void salvarDivida(DividaForm view) throws ParseException {
        String formato = "dd/MM/yyyy";
        Date data = new SimpleDateFormat(formato).parse(view.getTxtDataAtualizacao().getText());
        Pessoa credorPessoa = new Pessoa();
        Pessoa devedorPessoa = new Pessoa();
        credorPessoa.setNomePessoa(view.getSlcCredor().getSelectedItem().toString());
        devedorPessoa.setNomePessoa(view.getSlcDevedor().getSelectedItem().toString());
        this.setCredor(credorPessoa);
        this.setDevedor(devedorPessoa);
        this.setValorDivida(Double.parseDouble(view.getTxtDivida().getText()));
        this.setDataAtualizacao(data);
        DividaDAO dividaDao = new DividaDAO();
        if(view.getTxtCodigoDivida().getText().equals("")){
            if (dividaDao.Salvar(this)) {
                view.getLblErro().setText("");
                view.getLblSucesso().setText("Divida registrada com sucesso!");
                view.getTxtDivida().setVisible(false);
                view.getTxtDataAtualizacao().setVisible(false);
                view.getLblDivida().setVisible(false);
                view.getLblCodigo().setVisible(false);
                view.getLblData().setVisible(false);
                view.getLblDevedor().setVisible(false);
                view.getLblCredor().setVisible(false);
                view.getTxtCodigoDivida().setVisible(false);
                view.getBtnSalvarDivida().setVisible(false);
                view.getSlcCredor().setVisible(false);
                view.getSlcDevedor().setVisible(false);
                view.getBtnVoltarDivida().setVisible(true);
            } else {
                view.getLblSucesso().setText("");
                view.getLblErro().setText("Falha ao registrar dívida!");
            }
        }else{
            try {
                this.setIdDivida(Integer.parseInt(view.getTxtCodigoDivida().getText()));
                if(dividaDao.update(this)){
                    view.getLblErro().setText("");
                    view.getLblSucesso().setText("Divida alterada com sucesso!");
                    view.getTxtDivida().setVisible(false);
                    System.out.println("aqui");
                    view.getTxtDataAtualizacao().setVisible(false);
                    view.getLblDivida().setVisible(false);
                    view.getLblCodigo().setVisible(false);
                    view.getLblData().setVisible(false);
                    view.getLblDevedor().setVisible(false);
                    view.getLblCredor().setVisible(false);
                    view.getTxtCodigoDivida().setVisible(false);
                    view.getBtnSalvarDivida().setVisible(false);
                    view.getSlcCredor().setVisible(false);
                    view.getSlcDevedor().setVisible(false);
                    view.getBtnVoltarDivida().setVisible(true);
                }else{
                    view.getLblSucesso().setText("");
                    view.getLblErro().setText("Falha ao alterar dívida!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Divida.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
        

    }

    public void voltarConsultaDivida(DividaCons view) throws Exception {
        view.getLblErro().setText("");
        view.getLblSucesso().setText("");
        view.getLblCpf().setVisible(true);
        view.getTxtDocumento().setVisible(true);
        view.getBtnVoltarDivida().setVisible(false);
        view.getSlcFiltro().setVisible(true);
        view.getBtnPesquisar().setVisible(true);
        view.getTabelaDivida().setVisible(true);
        this.carregarTabela(view);
    }

    public void voltar(DividaForm view) throws Exception {
        ClienteCons cliente = new ClienteCons();
        cliente.setVisible(true);
        view.setVisible(false);
    }

    public void carregarDadosPagamento(DividaCons view) throws ParseException {
        DefaultTableModel dtm = (DefaultTableModel) view.getTabelaDivida().getModel();
        this.setIdDivida(Integer.parseInt(dtm.getValueAt(0, 0).toString()));
        this.setValorDivida(Double.parseDouble(dtm.getValueAt(0, 3).toString()));
        PagamentoForm pagamentoForm = new PagamentoForm();
        pagamentoForm.setVisible(true);
        view.dispose();
        pagamentoForm.getTxtDivida().setText(dtm.getValueAt(0, 0).toString());
        System.out.println("Mostre :" + dtm.getValueAt(0, 5).toString());
        pagamentoForm.getTxtDataAtu().setText(dtm.getValueAt(0, 5).toString());
        pagamentoForm.getTxtvalorDivida().setText(dtm.getValueAt(0, 3).toString());
        pagamentoForm.getTxtvalorDivida().setEditable(false);
        pagamentoForm.getTxtDataAtu().setEditable(false);

        pagamentoForm.getTxtDivida().setEditable(false);

    }

}
