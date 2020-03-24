/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import View.ClienteCons;
import View.ClienteForm;
import View.DividaForm;
import View.MenuPrincipal;
import View.PagamentoForm;

/**
 *
 * @author vitor
 */
public class Menu {
    private  MenuPrincipal view;
    private  ClienteForm view_cliente;
     private  ClienteCons view_cons_cliente;
    private  PagamentoForm view_pagamento;
    private  DividaForm view_divida;
    private String compara;
    
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
      this.view_cons_cliente = view;
        this.compara = this.view_cons_cliente.getClass().toString().replace("class View.", "");
     }
    
    public void navegar(String item){   
        switch(item){
            case "cliente":
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
                }
            break;
        }
        
        
    }
    
}
