/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.Connection.ConnectionFactory;
import java.sql.Connection;
import Model.bean.Divida;
import Model.bean.Pessoa;
import View.DividaCons;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class DividaDAO {

    private Connection con = null;
    private ArrayList<Divida> listaDivida;

    public DividaDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean Salvar(Divida divida) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String data_formatada = formato.format(divida.getDataAtualizacao());
        System.out.println("credor: "+divida.getCredor().getNomePessoa()+
                "devedor: "+divida.getDevedor().getNomePessoa()+
                "data: "+divida.getDataAtualizacao()+
                "valor: "+divida.getValorDivida());
        String query ="INSERT INTO divida (credor,devedor,data_atualizacao,valor_divida) "+
        "VALUES ((SELECT cod_cliente FROM cliente WHERE nome ='"+divida.getCredor().getNomePessoa()+"'),(SELECT cod_cliente FROM cliente WHERE nome ='"+divida.getDevedor().getNomePessoa()+"'),'"+data_formatada+"', "+divida.getValorDivida()+")";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("ERRO: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public ArrayList<Divida> obterTodos(String filtro) throws SQLException, Exception {
        String query = "SELECT DISTINCT dv.cod_divida, cl.nome AS devedor, cl.documento AS devedor_documento, dv.valor_divida, cli.nome as credor, dv.data_atualizacao "
                + "FROM divida dv "
                + "INNER JOIN cliente cl ON dv.devedor = cl.cod_cliente "
                + "INNER JOIN cliente cli ON dv.credor = cli.cod_cliente ";
        switch(filtro){       
            case "Pagas":
                query+= "INNER JOIN pagamento pg ON dv.cod_divida = pg.cod_divida "; 
            break;
            case "Não pagas":
                query += "WHERE pg.valor_pago IS NULL ";
            break;
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
            listaDivida = new ArrayList<Divida>();
            
            while (rs.next()) {
                Pessoa credor = new Pessoa();
                Pessoa devedor = new Pessoa();
                Integer cod_divida = rs.getInt(1);
                devedor.setNomePessoa(rs.getString(2));
                devedor.setDocumento(rs.getString(3));
                double valor_divida = Double.parseDouble(rs.getString(4));
                credor.setNomePessoa(rs.getString(5));
                Date data_atualizacao = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6));
                listaDivida.add(new Divida(cod_divida, credor, data_atualizacao, valor_divida, devedor));
            }
            return listaDivida;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public ArrayList<Divida> obter(String filtro,String documento, DividaCons view) throws Exception {

       String query = "SELECT DISTINCT dv.cod_divida, cl.nome AS devedor, cl.documento AS devedor_documento, dv.valor_divida, cli.nome as credor, dv.data_atualizacao "
                + "FROM divida dv "
                + "INNER JOIN cliente cl ON dv.devedor = cl.cod_cliente "
                + "INNER JOIN cliente cli ON dv.credor = cli.cod_cliente ";
//        System.out.println("cpf: "+documento.length());
        switch(filtro){       
            case "Pagas":
                query+= "INNER JOIN pagamento pg ON dv.cod_divida = pg.cod_divida "; 
            break;
            case "Não pagas":
                query +="LEFT JOIN pagamento pg ON dv.cod_divida = pg.cod_divida "+ 
                        "WHERE pg.valor_pago IS NULL ";
            break;
        }
        if(documento.length() > 0){
            if(filtro == "Não pagas"){
                query += " AND cl.documento = "+documento;
            }else{
                query += "WHERE cl.documento = "+documento;
                
            }
            
        }
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareCall(query);
            rs = stmt.executeQuery();
            listaDivida = new ArrayList<Divida>();
            while (rs.next()) {
                Pessoa credor = new Pessoa();
                Pessoa devedor = new Pessoa();
                Integer cod_divida = rs.getInt(1);
                devedor.setNomePessoa(rs.getString(2));
                devedor.setDocumento(rs.getString(3));
                double valor_divida = Double.parseDouble(rs.getString(4));
                credor.setNomePessoa(rs.getString(5));
                Date data_atualizacao = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6));
                listaDivida.add(new Divida(cod_divida, credor, data_atualizacao, valor_divida, devedor));
            }

            return listaDivida;
        } catch (SQLException sqle) { 
            DefaultTableModel tableModel = (DefaultTableModel) 
            view.getTabelaDivida().getModel();
            tableModel.setNumRows(0);
            view.getLblErro().setText("Dívida não encontrada!");
            view.getBtnEditar().setVisible(false);
            view.getBtnExcluir().setVisible(false);
            view.getBtnVoltarDivida().setVisible(false);
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    public ArrayList<Divida>obterPorPk(String codigo) throws SQLException, ParseException{
        String query = "SELECT  valor_divida, data_atualizacao FROM divida WHERE cod_divida ="+codigo;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareCall(query);
        rs = stmt.executeQuery();
        listaDivida = new ArrayList<Divida>();
        while (rs.next()) {
           double valor_divida = Double.parseDouble(rs.getString(1));
           
           Date data_atualizacao = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(2));
           listaDivida.add(new Divida(valor_divida,data_atualizacao));
           
        }
        return listaDivida;
        
    }
    public boolean update(Divida divida) throws SQLException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String data_formatada = formato.format(divida.getDataAtualizacao());
        String query = "UPDATE divida SET credor=(SELECT cod_cliente FROM cliente WHERE nome ='"+divida.getCredor().getNomePessoa()+"') ,devedor=(SELECT cod_cliente FROM cliente WHERE nome ='"+divida.getDevedor().getNomePessoa()+"') ,data_atualizacao='" + data_formatada + "', valor_divida=" + divida.getValorDivida() + " where cod_divida='" + divida.getIdDivida()+ "'";
        System.out.println(query);
        try {
            PreparedStatement stmt = null;
            stmt = con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }
    public boolean delete(int codigo){
        String query = "DELETE FROM divida where cod_divida ="+codigo;
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
