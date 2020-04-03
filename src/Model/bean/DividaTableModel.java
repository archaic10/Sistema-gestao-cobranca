/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.DividaCons;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class DividaTableModel {
    private final DividaCons view;

    public DividaTableModel(DividaCons view) {
        this.view = view;
    }
    public void popularTabela(ArrayList<Divida> dadosDivida){
    DefaultTableModel tableModel = (DefaultTableModel) this.view.getTabelaDivida().getModel();
    tableModel.setNumRows(0);
    SimpleDateFormat  formatador  =  new SimpleDateFormat("dd/MM/yyyy");
        for(Divida dividas : dadosDivida){
            tableModel.addRow(new Object[]{
                dividas.getIdDivida(),
                dividas.getDevedor().getNomePessoa(),
                dividas.getDevedor().getDocumento(),
                dividas.getValorDivida(),
                dividas.getCredor().getNomePessoa(),
                formatador.format(dividas.getDataAtualizacao())
                
            });
        }
    }
}
