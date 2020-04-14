/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.PagamentoCons;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class PagamentoTableModel {
    private final PagamentoCons view;

    public PagamentoTableModel(PagamentoCons view) {
        this.view = view;
    }
    public void popularTabela(ArrayList<Pagamento> dadosPagamento){
        DefaultTableModel tableModel = (DefaultTableModel) this.view.getTabelaPagamento().getModel();
         tableModel.setNumRows(0);
          
        SimpleDateFormat  formatador  =  new SimpleDateFormat("dd/MM/yyyy");
         for(Pagamento   pagamentos :dadosPagamento){
             
             tableModel.addRow(new Object[]{           
                pagamentos.getIdpag(),
                pagamentos.getDivida().getIdDivida(),                
                pagamentos.getDivida().getDevedor().getNomePessoa(),
                pagamentos.getDivida().getDevedor().getDocumento(),
                pagamentos.getDivida().getValorDivida(),
                pagamentos.getDivida().getCredor().getNomePessoa(),
                pagamentos.getValorpago(),              
                formatador.format(pagamentos.getData_pagamento()),
                formatador.format(pagamentos.getDivida().getDataAtualizacao())
           });  
         }
    }
    
}
