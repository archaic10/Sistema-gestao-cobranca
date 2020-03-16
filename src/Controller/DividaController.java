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
public class DividaController extends PessoaController {
    private int codigo;
    private PessoaController credor;
    private Date data_atualizacao;
    private double valor_divida;

    public DividaController(int codigo, PessoaController credor, Date data_atualizacao, double valor_divida, int id, String nome, String cpf, Date data_nascimento) {
        super(id, nome, cpf, data_nascimento);
        this.codigo = codigo;
        this.credor = credor;
        this.data_atualizacao = data_atualizacao;
        this.valor_divida = valor_divida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PessoaController getCredor() {
        return credor;
    }

    public void setCredor(PessoaController credor) {
        this.credor = credor;
    }

    public Date getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Date data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }

    public double getValor_divida() {
        return valor_divida;
    }

    public void setValor_divida(double valor_divida) {
        this.valor_divida = valor_divida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


   
}
