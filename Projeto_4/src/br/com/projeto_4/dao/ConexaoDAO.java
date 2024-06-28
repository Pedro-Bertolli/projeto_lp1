package br.com.projeto_4.dao;

import java.sql.*;

//Essa classe contém os métodos para abrir e fechar o banco de dados
public class ConexaoDAO {
    
  //Criando um atributo do tipo Connection que servirá para guardar a conexão  
  public static Connection con = null;
  
  //Método construtor da classe
  public ConexaoDAO(){
      
  }
  
  
  public static void ConnectDB(){
      try{
          //Dados para conectar com o banco de dados Postgres
          String dsn = "projeto_4"; //nome do banco de dados(igual ao criado no Postgres)
          String user = "postgres"; //nome do usuário utilizado para se conectar
          String senha = "postdba"; //senha do usuário acima informado
          
          DriverManager.registerDriver(new org.postgresql.Driver());
          
          String url = "jdbc:postgresql://localhost:5433/" + dsn; //é a letra l e não o número 1!!!!
          
          con = DriverManager.getConnection(url, user, senha);
          
          con.setAutoCommit(false);
          if(con == null){
              System.out.println("erro ao abrir o banco");
          }
      }//Fecha o try
      //Caso ocorra problemas para abrir o banco de dados é emitido a mensagem no console.
      catch(Exception e){
          System.out.println("Problema ao abrir a base de dados! " + e.getMessage());
      }//Fecha o catch
  }//Fecha o método ConnectDB
    
  
  public static void CloseDB(){
      try{
          con.close();
      }//Fecha o try
      //Caso ocorra problema para fechar o banco de dados é emitido a mensagem n console
      catch(Exception e){
          System.out.println("Problema ao fechar a base de dados!" + e.getMessage());
      }//Fecha o catch
  }//Fecha o método CloseDB
    
  
  
}//Fecha a classe ConexaoDAO
