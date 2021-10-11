/*
 * Designer Patterns
 */
package com.br.sistemajavasamuell.DAO;

import com.br.sistemajavasamuell.Factory.Conexao;
import com.br.sistemajavasamuell.model.CadastroLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author atila
 */
public class LoginDAO {
    
    public void save(CadastroLogin cadastrologin) throws SQLException{
    
        String sql = "INSERT INTO tb_cadastro_login (nome,sobrenome,cpf,email,senha,telefone) VALUES(?,?,?,?,?,?)";
        
        Connection conn=null;
        PreparedStatement pstm = null;
        
        try
        {
            conn = Conexao.createConnectionMySQL();
            pstm= conn.prepareStatement(sql);
            pstm.setString(1,cadastrologin.getNome());
            pstm.setString(2,cadastrologin.getSobrenome());
            pstm.setString(3,cadastrologin.getCpf());
            pstm.setString(4,cadastrologin.getEmail());
            pstm.setString(5,cadastrologin.getSenha());
            pstm.setString(6,cadastrologin.getTelefone());
            
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
    
    public void selecionar(){}
    public void alterar(){}
    public boolean verificaUsuario(String usuario, String senha) throws SQLException, Exception{
        String sql = "SELECT * FROM  tb_cadastro_login WHERE email= '" +usuario+"'";
        Connection conn=null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try
        {   
            conn = Conexao.createConnectionMySQL();
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            rs.next();
            String usuario1 = rs.getString("email");
            String senha1 = rs.getString("senha");
            
            //Verifica se usuario é o mesmo digitado:
            if(usuario1.equals(usuario) && senha1.equals(senha)){
                return true;
            }
        } catch(SQLException ex)
        {
            return false;
            
        }
        return false;
        }
    
        
        
    
    
    public void  deletar(){
}
    
    
   
    
}
