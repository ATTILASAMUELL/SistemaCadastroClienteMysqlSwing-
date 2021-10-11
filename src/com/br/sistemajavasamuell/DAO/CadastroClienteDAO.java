/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sistemajavasamuell.DAO;

import com.br.sistemajavasamuell.Factory.Conexao;
import com.br.sistemajavasamuell.model.CadastroCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author atila
 */
public class CadastroClienteDAO {
    
      public void save(CadastroCliente cadastroCliente) throws SQLException{
    
        String sql = "INSERT INTO tb_cadastro (nome,sobrenome,id_cadastro_login,email) VALUES(?,?,?,?)";
        
        Connection conn=null;
        PreparedStatement pstm = null;
        
        try
        {
            conn = Conexao.createConnectionMySQL();
            pstm= conn.prepareStatement(sql);
            pstm.setString(1,cadastroCliente.getNome());
            pstm.setString(2,cadastroCliente.getSobrenome());
            pstm.setString(3,cadastroCliente.getId_usuario());
            pstm.setString(4,cadastroCliente.getEmail());
            
           
            
            pstm.execute();
            
            
                    
        }
        catch(Exception e)
                
        {
            e.printStackTrace();
        }
        finally{
            //fechar Conexão:
            try{
                if(pstm!= null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
        }
    }
      
      public String idSolicitado(String usuarioLogado) throws Exception{
        
        String sql = "SELECT * FROM  tb_cadastro_login WHERE nome= '" +usuarioLogado+"'";

        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try
        {   
            conn = Conexao.createConnectionMySQL();
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.next();
            String id_email_usuario_logado = rs.getString("email");
            
            
            
            
            
            return id_email_usuario_logado;
            
            
        } catch(SQLException ex)
        {
            
            
        }
  
    return null;
}

      public List<CadastroCliente> getClientes(String sqls){
          String sql= sqls;
          
          
          
          List<CadastroCliente> clientes = new ArrayList<CadastroCliente>();
          
          Connection conn = null;
          PreparedStatement pstm = null;
          
          ResultSet rset = null;
          
          
          try
          {
              conn = Conexao.createConnectionMySQL();
              pstm  = conn.prepareStatement(sql);
              rset = pstm.executeQuery();
              
              while(rset.next()){
                  CadastroCliente clientess = new CadastroCliente();
                  
                  clientess.setId(rset.getInt("id_cadastro"));
                  clientess.setNome(rset.getString("nome"));
                  clientess.setSobrenome(rset.getString("sobrenome"));
                  clientess.setEmail(rset.getString("email"));
                  
                  clientes.add(clientess);
                  
                  
                  
                  
               
                  
              }
             
              
              return clientes;
          
          }
          
          catch(Exception e)
          {
              e.printStackTrace();
          }finally{
          }
          
          return null;
      }

      public void update(CadastroCliente cadastroCliente, int id) throws Exception, SQLException{
          
          String sql ="UPDATE tb_cadastro SET nome = ?, sobrenome = ?, email = ?"+
                  "WHERE id_cadastro= '" +id+"'";
          Connection conn = null;
          PreparedStatement pstm = null;
          
          try
          {
            conn = Conexao.createConnectionMySQL();
            pstm  = conn.prepareStatement(sql);
            pstm.setString(1, cadastroCliente.getNome());
            pstm.setString(2, cadastroCliente.getSobrenome());
            pstm.setString(3,cadastroCliente.getEmail());
            
            
            
            pstm.execute();
            
            
          
          }catch(Exception e)
          {
              
          }finally{
              try{
                  if(pstm!=null){
                      pstm.close();
                  }
                  if(conn!=null){
                      conn.close();
                  
                  }
              
              }catch(Exception e){
                  e.printStackTrace();
              
              }
          
          }
      
          
                  
                  
      
      
      }

      public void deleteByID(int id) throws Exception{
          String sql = "DELETE FROM tb_cadastro WHERE id_cadastro= ? ";
          Connection conn = null;
          PreparedStatement pstm = null;
          
          try{
              conn =  Conexao.createConnectionMySQL();
              pstm = conn.prepareStatement(sql);
              pstm.setInt(1,id);
              pstm.execute();
          }catch(Exception e){
              e.printStackTrace();
          }finally {
              try{
                  if(pstm != null){
                      pstm.close();
                  }
                  if(conn!= null){
                      conn.close();
                  
                  }
              } catch(Exception e){
                  e.printStackTrace();
              }
          }
                  
      
      
      
      
      
      }





}
