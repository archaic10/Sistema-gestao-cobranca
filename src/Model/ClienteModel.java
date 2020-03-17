/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ALUNO
 */
public class ClienteModel {
    private int idCliente;
    private String nomeCliente;
    private String endereco;
    private String uf;
    private String telefone;
    private String documento;
    private String email;

//    public ClienteModel(int idCliente, String nomeCliente, String endereco, String uf, String telefone, String documento, String email) {;
//        this.idCliente = idCliente;
//        this.nomeCliente = nomeCliente;
//        this.endereco = endereco;
//        this.uf = uf;
//        this.telefone = telefone;
//        this.documento = documento;
//        this.email = email;
//    }

   
    

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void salvarCliente(ClienteModel cliente){
        
        String query = "INSERT INTO cliente (nome, endereco, codigocat) "+ 
                "values ("+cliente.nomeCliente+","+cliente.endereco+" ,"+cliente.uf+","+cliente.telefone+","+cliente.documento+","+cliente.email+" )";
        System.out.println(query);
    }
    public void excluir (ClienteModel cliente){
        String Query = "DELETE from cliente WHERE codigo='"+cliente.idCliente+"'";
    }
}
