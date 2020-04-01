/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.Connection.ConnectionFactory;
import Model.bean.Divida;
import Model.bean.Pagamento;
import Model.bean.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author vitor
 */
public class PagamentoDAO {
    private Connection con = null;
    public ArrayList<Pagamento> listaPagamento; 
    public PagamentoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public boolean insert(Pagamento pagamento) {
       SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
       String data_formatada = formato.format(pagamento.getData_pagamento());
        String query = "INSERT INTO pagamento (cod_divida, data_pagamento, valor_pago, periodo ) VALUES ("+pagamento.getDivida().getIdDivida()+",'"+data_formatada+"',"+pagamento.getValorpago()+",'')";
        PreparedStatement stmt = null;
        System.out.println("data: "+data_formatada);
        System.out.println(query);
        try {
            stmt = con.prepareStatement(query);
           
            stmt.executeUpdate();
            System.out.println("Sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public boolean update(Pagamento pagamento){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String data_formatada = formato.format(pagamento.getData_pagamento());
        String query= "UPDATE pagamento SET (cod_divida="+pagamento.getDivida().getIdDivida()+", data_pagamento='"+data_formatada+"', valor_pago="+pagamento.getValorpago()+", periodo='' where cod_pagamento ="+pagamento.getIdpag()+")";
         PreparedStatement stmt = null;
        System.out.println("data: "+data_formatada);
        System.out.println(query);
        try {
            stmt = con.prepareStatement(query);
           
            stmt.executeUpdate();
            System.out.println("Sucesso!");
            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public ArrayList<Pagamento> obterTodos() throws SQLException, ParseException, Exception{
        String query = "SELECT pg.cod_pagamento,dv.cod_divida, cl.nome AS devedor,dv.valor_divida,cli.nome AS credor,  pg.valor_pago,  pg.data_pagamento,dv.data_atualizacao " +
        "FROM pagamento pg "+
        "INNER JOIN divida dv ON pg.cod_divida = dv.cod_divida " +
        "INNER JOIN cliente cl ON dv.devedor = cl.cod_cliente "+
        "INNER JOIN cliente cli ON dv.credor = cli.cod_cliente "+
        "ORDER BY  cod_pagamento";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        stmt = con.prepareCall(query);
        rs = stmt.executeQuery();
        
        listaPagamento = new ArrayList<Pagamento>();
        while (rs.next()) {
            Divida divida = new Divida();
            Pessoa credorPessoa = new Pessoa();
            Pessoa devedorPessoa = new Pessoa();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd",Locale.US); 
            Integer cod_pagamento = Integer.parseInt(rs.getString(1));
            Integer cod_divida = Integer.parseInt(rs.getString(2));
            double valor_divida = Double.parseDouble(rs.getString(4));           
            double valor_pago = Double.parseDouble(rs.getString(6));
            Date data_pagamento = formato.parse(rs.getString(7));
            System.out.println(data_pagamento);
            String data_atualizacao = rs.getString(8);            
            credorPessoa.setNomePessoa(rs.getString(5));            
            devedorPessoa.setNomePessoa(rs.getString(3));
            divida.setCredor(credorPessoa);
            divida.setDevedor(devedorPessoa);
            divida.setIdDivida(cod_divida);
            divida.setDataAtualizacao(formato.parse(data_atualizacao));
            divida.setValorDivida(valor_divida);        
            
            listaPagamento.add(new Pagamento(cod_pagamento,divida,data_pagamento,valor_pago));
        }
            return listaPagamento;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    public boolean delete(int codigo) throws SQLException, Exception {
        String query = "DELETE FROM pagamento WHERE cod_pagamento =" + codigo + " ";
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
