/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.sistemajavasamuell.Factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author atila
 */
public class Conexao {
    
    //INSERIR SEUS DADOS LOCAIS, COMO USER E SENHA(PASS):
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "***";
    private static final String PASS = "*****";
    
    public static Connection createConnectionMySQL() throws Exception{
        
        Class.forName(DRIVER);
        
        Connection connection = DriverManager.getConnection(URL,USER,PASS);
        return connection;
       
    }
}
