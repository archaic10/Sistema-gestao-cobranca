/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitor França
 */
public class PagamentoModel {
 private int idpag;
 private DividaModel divida;
 private Date data_pagamento;
 private double valorpago;

//    public PagamentoModel(int idpag, double divida, String data_pagamento, double valorpago) {
//        this.idpag = idpag;
//        this.divida = new DividaModel(divida);        
//     try {
//         this.data_pagamento = new SimpleDateFormat("dd/MM/yyyy").parse(data_pagamento);
//     } catch (ParseException ex) {
//         Logger.getLogger(PagamentoModel.class.getName()).log(Level.SEVERE, null, ex);
//     }
//
//        this.valorpago = valorpago;
//    }

    public DividaModel getDivida() {
        return divida;
    }

    public void setDivida(DividaModel divida) {
        this.divida = divida;
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
    
 
 
}
