/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

/**
 *
 * @author vitor
 */
abstract class Pessoa {
    private int idPessoa;
    protected String nomePessoa;   

    protected String getNomePessoa() {
        return nomePessoa;
    }

    protected void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
    
    
}
