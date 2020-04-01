/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import Model.dao.PagamentoDAO;
import View.PagamentoCons;
import View.PagamentoForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Pagamento(int cod_pagamento,Divida divida,Date data_pagamento, double valorpago) throws ParseException {
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
    public void realizarPagamento(PagamentoForm view) throws ParseException{
        String formato = "dd/MM/yyyy";  
        Date data =  new SimpleDateFormat(formato).parse(view.getTxtDataPg().getText());
        Divida divida = new Divida();
        divida.setValorDivida(20.00);
        
        this.setValorpago(Double.parseDouble(view.getTxtValor().getText()));
        this.setDivida(divida);
        this.setData_pagamento(data);
        if(this.getValorpago() < divida.getValorDivida()){
            System.out.println("O pagamento não pode ser inferior a dívida");
        }else{
            PagamentoDAO pagamentoDao = new PagamentoDAO();
            if(pagamentoDao.insert(this)){
                System.out.println("Pagamento realizado com sucesso!");
            }else{
                System.out.println("Falha ao realizar pagamento!");
            }
        }
    }
    public void carregarTabela(PagamentoCons view) throws ParseException, Exception{        
        PagamentoDAO pagamentoDao = new PagamentoDAO();        
        PagamentoTableModel pagamentoTm = new PagamentoTableModel(view);
        pagamentoTm.popularTabela(pagamentoDao.obterTodos());
        view.getTabelaPagamento();
    }
    public void excluir(PagamentoCons view){
    
    }
}
