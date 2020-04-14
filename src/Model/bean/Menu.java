/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.ClienteCons;
import View.ClienteForm;
import View.DividaCons;
import View.DividaForm;
import View.MenuPrincipal;
import View.PagamentoCons;
import View.PagamentoForm;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class Menu {
    private  MenuPrincipal view;
    //Cadastro
    private  ClienteForm view_cliente;
     private  ClienteCons view_cons_cliente;
    private  PagamentoForm view_pagamento;
    private  DividaForm view_divida;
    //Consulta
    private  ClienteCons view_consulta_cliente;
    private  PagamentoCons view_consulta_pagamento;
    private  DividaCons view_consulta_divida;
    private String compara;
    //Instancias para cadastro
    public Menu(MenuPrincipal view ) {
        this.view = view;
        this.compara = this.view.getClass().toString().replace("class View.", "");
    }
    
    public Menu(ClienteForm view ) {      
        this.view_cliente = view;
        this.compara = this.view_cliente.getClass().toString().replace("class View.", "");
    }
    public Menu(PagamentoForm view ) {
        this.view_pagamento = view;
          this.compara = this.view_pagamento.getClass().toString().replace("class View.", "");
        
    }
     public Menu(DividaForm view ) {
        this.view_divida = view;
        this.compara = this.view_divida.getClass().toString().replace("class View.", "");
    }
     public Menu(ClienteCons view){
      this.view_consulta_cliente = view;
        this.compara = this.view_consulta_cliente.getClass().toString().replace("class View.", "");
     }
     //Instacia para consulta
    public Menu(DividaCons view) {
        this.view_consulta_divida = view;
        this.compara = this.view_consulta_divida.getClass().toString().replace("class View.", "");
    }

    public Menu(PagamentoCons view) {
        this.view_consulta_pagamento = view;
        this.compara = this.view_consulta_pagamento.getClass().toString().replace("class View.", "");
    }
    
     
    
    public void navegar(String item){   
        switch(item){
            //para onde eu vou
            case "cliente":
                //onde estou
                if(this.compara.toLowerCase().contains("menuprincipal")){                    
                  this.view_cliente = new ClienteForm();
                    this.view_cliente.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("dividaform")){
                   this.view_cliente = new ClienteForm();
                    this.view_cliente.setVisible(true);              
                    this.view_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentoform")){                   
                   this.view_cliente = new ClienteForm();
                    this.view_cliente.setVisible(true);
                    this.view_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("dividacons")){
                     try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentocons")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clientecons")){
                     try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_consulta_cliente.dispose();
                }            
               
            break;
            case "pagamento":                
                if(this.compara.toLowerCase().contains("menuprincipal")){                    
                    this.view_pagamento = new PagamentoForm();
                    this.view_pagamento.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("dividaform")){
                    this.view_pagamento = new PagamentoForm();
                    this.view_pagamento.setVisible(true);               
                    this.view_divida.dispose();
                }else if(this.compara.toLowerCase().contains("clienteform")){ 
                    this.view_pagamento = new PagamentoForm();
                    this.view_pagamento.setVisible(true);  
                    this.view_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividacons")){
                     try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentocons")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clientecons")){
                     try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_consulta_cliente.dispose();
                }
            break;
            
            case "divida":
                if(this.compara.toLowerCase().contains("menuprincipal")){                    
                    this.view_divida = new DividaForm();
                    this.view_divida.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentoform")){
                    this.view_divida = new DividaForm();
                    this.view_divida.setVisible(true);                
                    this.view_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clienteform")){ 
                    this.view_divida = new DividaForm();
                    this.view_divida.setVisible(true);    
                    this.view_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividacons")){
                     try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentocons")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clientecons")){
                     try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_consulta_cliente.dispose();
                }
            break;
            case "cliente_consulta":
                 if(this.compara.toLowerCase().contains("menuprincipal")){                    
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("clienteform")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true); 
                    this.view_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividaform")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);            
                    this.view_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentoform")){                   
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("dividacons")){
                     try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentocons")){
                    try {
                        this.view_consulta_cliente = new ClienteCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_cliente.setVisible(true);
                    this.view_consulta_pagamento.dispose();
                }   
            break;
            case "divida_consulta":
                if(this.compara.toLowerCase().contains("menuprincipal")){                    
                    try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("clienteform")){
                    try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true); 
                    this.view_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividaform")){
                    try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);            
                    this.view_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentoform")){                   
                    try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clientecons")){
                     try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_consulta_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentocons")){
                    try {
                        this.view_consulta_divida = new DividaCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_divida.setVisible(true);
                    this.view_consulta_pagamento.dispose();
                }
            break;
            case "pagamento_consulta":
                if(this.compara.toLowerCase().contains("menuprincipal")){                    
                    try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true);                    
                    this.view.dispose();
                }else if(this.compara.toLowerCase().contains("clienteform")){
                    try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true); 
                    this.view_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividaform")){
                    try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true);            
                    this.view_divida.dispose();
                }else if(this.compara.toLowerCase().contains("pagamentoform")){                   
                    try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true);
                    this.view_pagamento.dispose();
                }else if(this.compara.toLowerCase().contains("clientecons")){
                     try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true);
                    this.view_consulta_cliente.dispose();
                }else if(this.compara.toLowerCase().contains("dividacons")){
                    try {
                        this.view_consulta_pagamento = new PagamentoCons();
                    } catch (Exception ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.view_consulta_pagamento.setVisible(true);
                    this.view_consulta_divida.dispose();
                }
            break;

        }
        
        
    }
    
}
