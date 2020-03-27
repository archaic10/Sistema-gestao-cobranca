/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.Connection.ConnectionFactory;
import Model.bean.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author vitor
 */
public class ClienteDAO {
    private Connection con = null;
    public  ArrayList<Cliente> listaCliente;
    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
    public boolean save(Cliente cliente){
        String sql = "INSERT INTO cliente (nome, endereco, uf, telefone, documento, email) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        System.out.println(cliente.getNomeCliente());
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getUf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getDocumento());
            stmt.setString(6, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println(stmt);
            System.out.println("Sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }   
    
    public ArrayList<Cliente> obterTodos() throws SQLException, Exception{
        String query = "SELECT * FROM cliente";
        PreparedStatement stmt = null;
        ResultSet rs = null;       
        try {
            stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
//            List<Cliente> list = new ArrayList<Cliente>();            
           listaCliente = new ArrayList<Cliente>();
            while(rs.next()){
                    Integer cod_cliente = rs.getInt(1);                 
                    String nome = rs.getString(2);
                    String endereco = rs.getString(3);        
                    String telefone = rs.getString(4);
                    String uf = rs.getString(5);
                    String documento= rs.getString(6);
                    String email = rs.getString(7);
    //                list.add(new Cliente (nome,email,documento)); 
                    listaCliente.add(new Cliente (cod_cliente, nome, endereco, uf, telefone, documento, email));
            }
           
            //aff não ta dando pra mostrar a tela da aplicacao
           
        return listaCliente;
        } catch (SQLException sqle) {
           throw new Exception(sqle);
       } finally {
           ConnectionFactory.closeConnection(con, stmt, rs);
       }       
       
    }
        public ArrayList<Cliente> consultarPorCpf(String cpf) throws SQLException, Exception{
            String query = "SELECT * FROM cliente where documento ="+cpf+" ";
            PreparedStatement stmt = null;
            ResultSet rs = null;       
            try {
                stmt = con.prepareCall(query);
                rs = stmt.executeQuery();
    //            List<Cliente> list = new ArrayList<Cliente>();            
               listaCliente = new ArrayList<Cliente>();
                while(rs.next()){
                    Integer cod_cliente = rs.getInt(1);                    
                    String nome = rs.getString(2);
                    String endereco = rs.getString(3);        
                    String telefone = rs.getString(4);
                    String uf = rs.getString(5);
                    String documento= rs.getString(6);
                    String email = rs.getString(7);
    //                list.add(new Cliente (nome,email,documento)); 
                    listaCliente.add(new Cliente (cod_cliente, nome, endereco, uf, telefone, documento, email));
                }
      

                //aff não ta dando pra mostrar a tela da aplicacao

            return listaCliente;
            } catch (SQLException sqle) {
               throw new Exception(sqle);
           } finally {
               ConnectionFactory.closeConnection(con, stmt, rs);
           }       

        }
        
        public boolean delete(int codigo) throws SQLException, Exception{
            String query = "DELETE FROM cliente where cod_cliente ="+codigo+" ";
            System.out.println(query);
             PreparedStatement stmt = null;
             try {
            stmt = con.prepareCall(query);
              stmt.executeUpdate();
            return true;      
            } catch (SQLException sqle) {             
               return false;
           } 
        }
    }
 
