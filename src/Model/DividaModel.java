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
 * @author ALUNO
 */
public class DividaModel {
    private int idDivida;
    private PessoaModel credor;
    private Date dataAtualizacao;
    private double valorDivida;
    private PessoaModel devedor ;

//    public DividaModel(int idDivida, String credor, String dataAtualizacao, double valorDivida, PessoaModel devedor) {
//        this.idDivida = idDivida;
//        this.credor = new PessoaModel(credor);
//       
//        try {
//            this.dataAtualizacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataAtualizacao);
//        } catch (ParseException ex) {
//            Logger.getLogger(DividaModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.valorDivida = valorDivida;
//        this.devedor = devedor;
//    }

    

    public DividaModel(double valorDivida) {
        this.valorDivida = valorDivida;
    }
    

    public PessoaModel getCredor() {
        return credor;
    }

    public void setCredor(PessoaModel credor) {
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

    public PessoaModel getDevedor() {
        return devedor;
    }

    public void setDevedor(PessoaModel devedor) {
        this.devedor = devedor;
    }
    
    
}
