/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.Connection.ConnectionFactory;
import Model.bean.Login;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class UsuarioDAO {
    private Connection con = null;

    public UsuarioDAO() {
         con = ConnectionFactory.getConnection();
    }
    
    public boolean autenticar(Login login){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nome_usuario = "";
        String senha = "";
        String sql = "SELECT * FROM usuario where nome_usuario ='"+login.getNome_usuario()+"' AND senha ='"+login.getSenha()+"'";
        try {
            stmt = con.prepareStatement(sql);             
                rs = stmt.executeQuery();
               while (rs.next()) {                   
                   nome_usuario = rs.getString("nome_usuario");               
                   senha = rs.getString("senha");          
                }
                
                if(nome_usuario == "" && senha == ""){
                    return false;
                }else{
                    return true;
                }
                
            } catch (SQLException ex) {
                 System.err.println("Erro: "+ex);
                return false;
            }
        }
       
    }

