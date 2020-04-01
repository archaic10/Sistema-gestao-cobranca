/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import Model.dao.ClienteDAO;
import View.ClienteCons;
import View.ClienteForm;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author vitor
 */
public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String endereco;
    private String uf;
    private String telefone;
    private String documento;
    private String email;    

    public Cliente(int idCliente, String nomeCliente, String endereco, String uf, String telefone, String documento, String email) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.uf = uf;
        System.out.println("Meu "+uf);
        this.telefone = telefone;
        this.documento = documento;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    public Cliente(String nome, String email, String documento) {
        this.nomeCliente = nome;
        this.email = email;
        this.documento = documento;
        System.out.println(nome);        
  
    }
    

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

    public void carregarTabela(ClienteCons view) throws Exception{
        ClienteDAO cl = new ClienteDAO();   
        ClienteTableModel clienteTableModel = new ClienteTableModel(view);
        clienteTableModel.popularTabela(cl.obterTodos());
        view.getTabelaCliente();
        
    }
    public void buscarClienteCPF(ClienteCons view) throws Exception{
        ClienteDAO cl = new ClienteDAO();   
        ClienteTableModel clienteTableModel = new ClienteTableModel(view);
        clienteTableModel.popularTabela(cl.consultarPorCpf(view.getTxtCPF().getText()));
        view.getTabelaCliente();
        view.getBtnEditar().setVisible(true);
        view.getBtnExcluir().setVisible(true);
        view.getBtnVoltarCliente().setVisible(true);
        
    }
    public void cadastrarCliente(ClienteForm view) throws SQLException{
        
        this.setNomeCliente(view.getTxtNome().getText());
        this.setEndereco(view.getTxtEndereco().getText());
        this.setTelefone(view.getTxtTel().getText());
        this.setUf(view.getSlctUf().getSelectedItem().toString());
        this.setEmail(view.getTxtEmail().getText());
        this.setDocumento(view.getTxtRg().getText());
        ClienteDAO clienteDao = new ClienteDAO();
        if (view.getTxtCodigoCliente().getText() == ""){
            
            if(clienteDao.save(this)){
                view.getLblErro().setText("");
                view.getTxtCodigoCliente().setVisible(false);
                view.getLblCodigo().setVisible(false);
                view.getTxtNome().setVisible(false);
                view.getLblNome().setVisible(false);
                view.getTxtEndereco().setVisible(false);
                view.getLblEndereco().setVisible(false);
                view.getTxtTel().setVisible(false);
                view.getLblTel().setVisible(false);
                view.getSlctUf().setVisible(false);
                view.getLblUf().setVisible(false);
                view.getTxtEmail().setVisible(false);
                view.getLblEmail().setVisible(false);
                view.getTxtRg().setVisible(false);
                view.getLblRg().setVisible(false);
                view.getBtnSalvarCliente().setVisible(false);
                view.getBtnVoltarCliente().setVisible(true);
                view.getLblSucesso().setText("Cadastro realizado com sucesso!");           
            }else{
               
                view.getLblSucesso().setText("");
                view.getLblErro().setText("Erro ao realizar cadastro!");
            }
        }else{
         this.setIdCliente(Integer.parseInt(view.getTxtCodigoCliente().getText())); 
         if(clienteDao.update(this)){
                view.getLblErro().setText("");
                view.getTxtCodigoCliente().setVisible(false);
                view.getLblCodigo().setVisible(false);
                view.getTxtNome().setVisible(false);
                view.getLblNome().setVisible(false);
                view.getTxtEndereco().setVisible(false);
                view.getLblEndereco().setVisible(false);
                view.getTxtTel().setVisible(false);
                view.getLblTel().setVisible(false);
                view.getSlctUf().setVisible(false);
                view.getLblUf().setVisible(false);
                view.getTxtEmail().setVisible(false);
                view.getLblEmail().setVisible(false);
                view.getTxtRg().setVisible(false);
                view.getLblRg().setVisible(false);
                view.getBtnSalvarCliente().setVisible(false);
                view.getBtnVoltarCliente().setVisible(true);
            view.getLblSucesso().setText("Cliente alterado com sucesso!"); 
         }else{
            view.getLblSucesso().setText(""); 
            view.getLblErro().setText("Erro ao alterar cliente!");
         }
        }
                
    }
    public void voltar(ClienteForm view) throws Exception{ 
        if (view.getTxtCodigoCliente().getText() == ""){
           view.getTxtNome().setVisible(true);
           view.getTxtNome().setText("");
           view.getLblNome().setVisible(true);
           view.getTxtEndereco().setVisible(true);
           view.getTxtEndereco().setText("");
           view.getLblEndereco().setVisible(true);
           view.getTxtTel().setVisible(true);
           view.getTxtTel().setText("");
           view.getLblTel().setVisible(true);
           view.getSlctUf().setVisible(true);
           view.getLblUf().setVisible(true);
           view.getTxtEmail().setVisible(true);
           view.getTxtEmail().setText("");
           view.getLblEmail().setVisible(true);
           view.getTxtRg().setVisible(true);
           view.getTxtRg().setText("");
           view.getLblRg().setVisible(true);
           view.getBtnSalvarCliente().setVisible(true);
           view.getBtnVoltarCliente().setVisible(false);
           view.getLblSucesso().setText("");
           view.getLblErro().setText("");
        }else{
            ClienteCons viewClienteCons = new ClienteCons();
            this.voltarConsulta(viewClienteCons);
            viewClienteCons.setVisible(true);
            view.dispose();
        }
  
    }

    public void excluir(ClienteCons view) throws Exception {
        DefaultTableModel dtm = (DefaultTableModel)view.getTabelaCliente().getModel(); 
        int codigo = Integer.parseInt(dtm.getValueAt(0, 0).toString());
        ClienteDAO cl = new ClienteDAO();
        if(cl.delete(codigo)){
            view.getLblErro().setText("");
            view.getLblSucesso().setText("Cliente excluído com sucesso!");
            view.getTabelaCliente().setVisible(false);
            view.getBtnEditar().setVisible(false);
            view.getBtnExcluir().setVisible(false);
            view.getTxtCPF().setVisible(false);
            view.getLblCpf().setVisible(false);
            view.getBtnPesquisar().setVisible(false);
            view.getBtnVoltarCliente().setVisible(true);
            
        }else{
            view.getLblSucesso().setText("");
            view.getLblErro().setText("Erro ao excluir cliente!");
            
            
        }
        
    }
    public void voltarConsulta(ClienteCons view) throws Exception{
            view.getTxtCPF().setText("");
            view.getLblErro().setText("");
            view.getLblSucesso().setText("");
            this.carregarTabela(view);
            view.getBtnVoltarCliente().setVisible(false);
            view.getTabelaCliente().setVisible(true);
            view.getBtnEditar().setVisible(false);
            view.getBtnExcluir().setVisible(false);
            view.getTxtCPF().setVisible(true);
            view.getLblCpf().setVisible(true);
            view.getBtnPesquisar().setVisible(true);
    }
    public void carregarDadosCliente (ClienteCons view) throws Exception{
        DefaultTableModel dtm = (DefaultTableModel)view.getTabelaCliente().getModel(); 
        int codigo = Integer.parseInt(dtm.getValueAt(0, 0).toString());
        ClienteDAO cl = new ClienteDAO();
        ClienteForm clienteForm = new ClienteForm();
        clienteForm.setVisible(true);
        view.dispose();
        clienteForm.getLblTitulo().setText("Alterar dados do cliente");
        clienteForm.getTxtCodigoCliente().setVisible(true);
        clienteForm.getLblCodigo().setVisible(true);
        for(Cliente campoCliente : cl.obterDados(codigo)){             
//            System.out.println("codigo: "+campoCliente.getIdCliente()+
//                    " nome: "+campoCliente.getNomeCliente()+
//                    " email: "+campoCliente.getEmail()+
//                    " endereco: "+campoCliente.getEndereco()+
//                    " cpf: "+campoCliente.getDocumento()+                    
//                    " tel: "+campoCliente.getTelefone()+
//            " uf: "+campoCliente.getUf());
            clienteForm.getTxtCodigoCliente().setText(""+campoCliente.getIdCliente());
            clienteForm.getTxtNome().setText(campoCliente.getNomeCliente());
            clienteForm.getTxtEmail().setText(campoCliente.getEmail());
            clienteForm.getTxtEndereco().setText(campoCliente.getEndereco());
            clienteForm.getTxtRg().setText(campoCliente.getDocumento());
            clienteForm.getTxtTel().setText(campoCliente.getTelefone());
            clienteForm.getSlctUf().setSelectedItem(campoCliente.getUf());
            
        }
    }
}
