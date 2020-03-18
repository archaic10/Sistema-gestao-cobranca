/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import Model.dao.UsuarioDAO;
import View.LoginForm;
import View.MenuPrincipal;
import javax.swing.JLabel;

/**
 *
 * @author vitor
 */
public class Login {
    private String nome_usuario;
    private String senha;
    private final LoginForm view;
    public boolean  autenticacao;
    public Login(LoginForm view) {
        this.view = view;
    }
 
    
    
    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void logar(){
        UsuarioDAO usuario = new UsuarioDAO();
        this.autenticacao = usuario.autenticar(this);
        if(usuario.autenticar(this)){
            System.out.println("Logado com sucesso!");
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);           
            this.view.dispose();
            
        }else{
            System.out.println("Sua senha é: "+this.getSenha());
            System.out.println("Falha ao tentar logar!");
            LoginForm login = new LoginForm();
           

        }
    }
    
}
