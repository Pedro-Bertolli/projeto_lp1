/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;
import java.sql.ResultSet;
import br.com.projeto_4.dto.FornecedorDTO;
import br.com.projeto_4.dao.FornecedorDAO;
import br.com.projeto_4.dao.ConexaoDAO;

/**
 *
 * @author Aluno
 */
public class FornecedorCTR {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    
    
    //Método Construtor
    public FornecedorCTR(){
        
        
    }
    
    
    
    //Inserir Fornecedor
    public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor Cadastrado com Sucesso!!!";
            }
            else{
                return "Fornecedor NÃO Cadastrado!!!";
            }
        }//Fecha o try
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado!";
        }
    }//Fecha o método inserirFornecedor
    
    
    
    //Alterar Fornecedor
     public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor Alterado com Sucesso!!!";
            }
            else{
                return "Fornecedor NÃO Alterado!!!";
            }
        }//Fecha o try
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Alterado!";
        }
    }//Fecha o método alterarFornecedor
    
    
     
     //Excluir Fornecedor
      public String excluirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor Excluído com Sucesso!!!";
            }
            else{
                return "Fornecedor NÃO Excluído!!!";
            }
        }//Fecha o try
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Excluído!";
        }
    }//Fecha o método excluirFornecedor
    
      
    
      
     //Consultar Fornecedor
      public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
          
          ResultSet rs = null;
          
          rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
          return rs;
          
      }//Fecha o método consultarFornecedor
      
      
      
      
      //Fecha o Banco de Dados
      public void CloseDB(){
          ConexaoDAO.CloseDB();
      }//Fecha o método CloseDB
      
      
      
    
}//Fecha a classe FornecedorCTR
