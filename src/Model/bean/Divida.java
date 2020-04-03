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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vitor
 */
public class Divida {
    private int idDivida;
    private Pessoa credor;
    private Date dataAtualizacao;
    private double valorDivida;
    private Pessoa devedor ;

    public Divida(int idDivida, Pessoa credor, Date dataAtualizacao, double valorDivida, Pessoa devedor) {
        this.idDivida = idDivida;
        this.credor = credor;
        this.dataAtualizacao = dataAtualizacao;
        this.valorDivida = valorDivida;
        this.devedor = devedor;
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
    public void carregarTabela(DividaCons view) throws Exception{
        DividaDAO dividaDao = new DividaDAO();
        DividaTableModel dividaTm = new DividaTableModel(view);
        dividaTm.popularTabela(dividaDao.obterTodos("Todos"));
        view.getTabelaDivida();
        
    }
    public void carregarTabela(String filtro, DividaCons view,String documento) throws Exception {
        DividaDAO dividaDao = new DividaDAO();
        DividaTableModel dividaTm = new DividaTableModel(view);
            dividaTm.popularTabela(dividaDao.obter(filtro,documento));
            view.getTabelaDivida();
        
      
    }
    public void excluir(DividaCons view) {
        
    }

    public void buscarDevedorCPF(DividaCons view) throws Exception {      
       String documento =  view.getTxtDocumento().getText();
        String filtro = view.getSlcFiltro().getSelectedItem().toString();          
        this.carregarTabela(filtro, view, documento);                
    }
    public void carregarDados(ClienteCons view) throws Exception{
        String documento = view.getTxtCPF().getText();
        ClienteDAO clienteDao = new ClienteDAO();
        
        DividaForm proxView = new DividaForm();
        proxView.setVisible(true);
        view.dispose();
        
        for(Cliente listaClientes : clienteDao.obterTodos()){
            proxView.getSlcCredor().addItem(listaClientes.getNomeCliente());
            proxView.getSlcDevedor().addItem(listaClientes.getNomeCliente());
            
        }
        ClienteDAO clienteDao1 = new ClienteDAO();
        for(Cliente nomeCliente : clienteDao1.consultarPorCpf(documento)){
            proxView.getSlcDevedor().setSelectedItem(nomeCliente.getNomeCliente());
        }
        
    }
    
    public void cadastrarDivida(DividaForm view) throws ParseException{
        String formato = "dd/MM/yyyy";  
        Date data =  new SimpleDateFormat(formato).parse(view.getTxtData().getText());
        Pessoa credorPessoa = new Pessoa();
        Pessoa devedorPessoa = new Pessoa();
        credorPessoa.setNomePessoa(view.getSlcCredor().getSelectedItem().toString());
        devedorPessoa.setNomePessoa(view.getSlcDevedor().getSelectedItem().toString());
        this.setCredor(credorPessoa);
        this.setDevedor(devedorPessoa);
        this.setValorDivida(Double.parseDouble(view.getTxtDivida().getText()));
        this.setDataAtualizacao(data);
        DividaDAO dividaDao = new DividaDAO();
        dividaDao.Salvar(this);

       
    }
   
    
    
}
