/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author vitor
 */
public class PagamentoController {
    private int idPagamento;
    private DividaController divida ;
    private Date data_pagamento;
    private double valor_pago;

    public PagamentoController(int idPagamento, DividaController divida, Date data_pagamento, double valor_pago) {
        this.idPagamento = idPagamento;
        this.divida = divida;
        this.data_pagamento = data_pagamento;
        this.valor_pago = valor_pago;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public DividaController getDivida() {
        return divida;
    }

    public void setDivida(DividaController divida) {
        this.divida = divida;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }
    
    
}
