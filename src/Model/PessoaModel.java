/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Vitor França
 */
public class PessoaModel {
    private int idPessoa;
    protected String nomePessoa;

//    public PessoaModel(int idPessoa, String nomePessoa) {
//        this.idPessoa = idPessoa;
//        this.nomePessoa = nomePessoa;
//    }

    public PessoaModel(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }
    
    
    
    
}
