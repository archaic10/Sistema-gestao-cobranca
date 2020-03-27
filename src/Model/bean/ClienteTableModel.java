/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.ClienteCons;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */

public class ClienteTableModel {
private final ClienteCons view;
    public ClienteTableModel(ClienteCons view) {
        this.view = view;
    }
    
    public void popularTabela(ArrayList<Cliente> dadosClientes){
       DefaultTableModel tableModel = (DefaultTableModel) this.view.getTabelaCliente().getModel();
       tableModel.setNumRows(0);
       for(Cliente cliente : dadosClientes){
           System.out.println(cliente.getIdCliente());
           tableModel.addRow(new Object[]{           
                cliente.getIdCliente(),
                cliente.getNomeCliente(),
                cliente.getEmail(),
                cliente.getEndereco(),
                cliente.getDocumento(),              
                cliente.getUf(),
                cliente.getTelefone()
           });  
       }
    }

    
}
