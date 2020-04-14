/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import Model.dao.DividaDAO;
import Model.dao.PagamentoDAO;
import View.PagamentoCons;
import View.PagamentoForm;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class Pagamento {

    private int idpag;
    private Divida divida;
    private Date data_pagamento;
    private double valorpago;

    public Pagamento() {
    }

    public Pagamento(int cod_pagamento, Divida divida, Date data_pagamento, double valorpago) throws ParseException {
        this.idpag = cod_pagamento;
        this.divida = divida;
        this.data_pagamento = data_pagamento;
        this.valorpago = valorpago;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    public int getIdpag() {
        return idpag;
    }

    public void setIdpag(int idpag) {
        this.idpag = idpag;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public void realizarPagamento(PagamentoForm view) throws ParseException, SQLException {
        String formato = "dd/MM/yyyy";
        Date data = new SimpleDateFormat(formato).parse(view.getTxtDataPg().getText());
        Divida divida = new Divida();

        //Acessar DAO Divida 
        DividaDAO dividaBean = new DividaDAO();
        String cod_divida = view.getTxtDivida().getText();

        for (Divida dadosDivida : dividaBean.obterPorPk(cod_divida)) {
            divida = dadosDivida;
        }
        //Formatar datas para Dias mês e ano
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtu = formatar.format(divida.getDataAtualizacao());

        //Converter para duas casas decimais
        DecimalFormatSymbols x = new DecimalFormatSymbols();
        x.setDecimalSeparator('.');
        DecimalFormat decimalForm = new DecimalFormat("##.##", x);
        Date data_pagamentos = formatar.parse(view.getTxtDataPg().getText());
        Date data_atualizacao = formatar.parse(dataAtu);
        //Verificar se a data de atualização 
        long diferenca = ((data_atualizacao.getTime() - data_pagamentos.getTime()) + 3600000) / 86400000L;
        if (diferenca < 0) {
            double multa = (divida.getValorDivida() + (divida.getValorDivida() * 2 / 100));
            System.out.println("Multa " + multa);
            System.out.println("absoluto " + Math.abs(diferenca));
            double juros = multa + (multa * (Math.abs(diferenca) * 0.35) / 100);
            System.out.println("Juros " + juros);
            divida.setValorDivida(Double.parseDouble(decimalForm.format(juros)));
            view.getTxtvalorDivida().setText(String.valueOf(decimalForm.format(juros)));
        }

        this.setValorpago(Double.parseDouble(view.getTxtValor().getText()));

        divida.setIdDivida(Integer.parseInt(cod_divida));
        String codigo = view.getTxtCodigoPagamento().getText() ;
        this.setIdpag(Integer.parseInt(codigo));
        this.setDivida(divida);
        

        this.setData_pagamento(data);
        if (this.getValorpago() < divida.getValorDivida()) {
            view.getLblSucesso().setText("");
            view.getLblErro().setText("O pagamento não pode ser inferior a dívida");
        } else {
            PagamentoDAO pagamentoDao = new PagamentoDAO();
            if(codigo == ""){
                if (pagamentoDao.insert(this)) {
                    view.getLblErro().setText("");
                    view.getLblSucesso().setText("Pagamento realizado com sucesso!");

                    view.getTxtDataAtu().setVisible(false);
                    view.getTxtDataPg().setVisible(false);
                    view.getTxtDivida().setVisible(false);
                    view.getTxtValor().setVisible(false);
                    view.getTxtvalorDivida().setVisible(false);

                    view.getLblDataPag().setVisible(false);
                    view.getLblDataAtu().setVisible(false);
                    view.getLblDivida().setVisible(false);
                    view.getLblValorDivida().setVisible(false);
                    view.getLblValorDivida().setVisible(false);
                    view.getLblValorPg().setVisible(false);

                    view.getBtnSalvarPagamento().setVisible(false);

                } else {
                    view.getLblSucesso().setText("");
                    view.getLblErro().setText("Falha ao realizar pagamento!");
                }
            }else{
                if (pagamentoDao.update(this)) {
                    view.getLblErro().setText("");
                    view.getLblSucesso().setText("Pagamento alterado com sucesso!");

                    view.getTxtDataAtu().setVisible(false);
                    view.getTxtDataPg().setVisible(false);
                    view.getTxtDivida().setVisible(false);
                    view.getTxtValor().setVisible(false);
                    view.getTxtvalorDivida().setVisible(false);

                    view.getLblDataPag().setVisible(false);
                    view.getLblDataAtu().setVisible(false);
                    view.getLblDivida().setVisible(false);
                    view.getLblValorDivida().setVisible(false);
                    view.getLblValorDivida().setVisible(false);
                    view.getLblValorPg().setVisible(false);

                    view.getBtnSalvarPagamento().setVisible(false);

                } else {
                    view.getLblSucesso().setText("");
                    view.getLblErro().setText("Falha ao alterar pagamento!");
                }
            }
            
            
        }
    }

    public void carregarTabela(PagamentoCons view) throws ParseException, Exception {
        PagamentoDAO pagamentoDao = new PagamentoDAO();
        PagamentoTableModel pagamentoTm = new PagamentoTableModel(view);
        pagamentoTm.popularTabela(pagamentoDao.obterTodos());
        view.getTabelaPagamento();
    }
    
    public void buscarPorCPF(PagamentoCons view){
        String documento =view.getTxtCPF().getText();
        PagamentoDAO pagamento = new PagamentoDAO();
        PagamentoTableModel pagamentoTm = new PagamentoTableModel(view);
        try {
           pagamentoTm.popularTabela(pagamento.obter(documento));
           view.getTabelaPagamento();
           if(view.getTabelaPagamento().getRowCount() == 1){
               view.getBtnEditar().setVisible(true);
               view.getBtnExcluir().setVisible(true);
           }
        } catch (ParseException ex) {
            Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregarDados(PagamentoCons view){
        PagamentoForm novaView = new PagamentoForm();
        DefaultTableModel pagamentoTm = (DefaultTableModel) view.getTabelaPagamento().getModel();
        String codigo = pagamentoTm.getValueAt(0, 0).toString();
        String codigo_divida = pagamentoTm.getValueAt(0, 1).toString();
        String valor_divida = pagamentoTm.getValueAt(0, 4).toString();
        String valor_pago = pagamentoTm.getValueAt(0, 6).toString();
        String data_pg = pagamentoTm.getValueAt(0, 7).toString();
        String data_at = pagamentoTm.getValueAt(0, 8).toString();
        novaView.setVisible(true);
        view.dispose();
        novaView.getTxtCodigoPagamento().setText(codigo);
        novaView.getTxtvalorDivida().setText(valor_divida);
        novaView.getTxtValor().setText(valor_pago);
        novaView.getTxtDataPg().setText(data_pg);
        novaView.getTxtDataAtu().setText(data_at);
        novaView.getTxtDivida().setText(codigo_divida);
        novaView.getTxtDivida().setEditable(false);
        
    }
    public void excluir(PagamentoCons view) {
        PagamentoDAO pagamentoDao = new PagamentoDAO();
       DefaultTableModel pgtm = (DefaultTableModel) view.getTabelaPagamento().getModel();
       int codigo = Integer.parseInt(pgtm.getValueAt(0, 0).toString());
        try {
            
            if(pagamentoDao.delete(codigo)){
                view.getLblErro().setText("");
                view.getLblSucesso().setText("Pagamento excluído com sucesso!");
                view.getTxtCPF().setVisible(false);
                view.getBtnEditar().setVisible(false);
                view.getBtnExcluir().setVisible(false);
                view.getBtnPesquisar().setVisible(false);
                view.getLblCpf().setVisible(false);
                view.getTabelaPagamento().setVisible(false);
            }else{
                view.getLblSucesso().setText("");
                view.getLblErro().setText("Não foi possível excluir pagamento!");
            }
        } catch (Exception ex) {
            Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void voltar(PagamentoForm view) throws Exception{
        PagamentoCons  nova_view = new PagamentoCons();
        nova_view.setVisible(true);
        view.dispose();
    }
    public void voltarConsulta(PagamentoCons view){
                 view.getLblErro().setText("");
                view.getLblSucesso().setText("");
                view.getTxtCPF().setVisible(true);            
                view.getBtnPesquisar().setVisible(true);
                view.getLblCpf().setVisible(true);
                view.getTabelaPagamento().setVisible(true);
        try {
            this.carregarTabela(view);
        } catch (Exception ex) {
            Logger.getLogger(Pagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
