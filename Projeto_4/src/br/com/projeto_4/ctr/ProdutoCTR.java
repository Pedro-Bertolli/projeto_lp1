package br.com.projeto_4.ctr;

import java.sql.ResultSet;
import br.com.projeto_4.dto.FornecedorDTO;
import br.com.projeto_4.dto.ProdutoDTO;
import br.com.projeto_4.dao.ProdutoDAO;
import br.com.projeto_4.dao.ConexaoDAO;



public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    
    //Método construtor
    public ProdutoCTR(){
    
    
    }
    
   
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto Cadastrado Com Sucesso!!!";
            }
            else{
                return "Produto Não Cadastrado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Cadastrado!!!";
        }
    }//Fecha o método inserirProduto
    
    
    
    
     public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            
            if(produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produto Alterado Com Sucesso!!!";
            }
            else{
                return "Produto Não Alterado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Alterado!!!";
        }
    }//Fecha o método alterarProduto
     
     
     
     
      public String excluirProduto(ProdutoDTO produtoDTO){
        try{
            
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto Excluído Com Sucesso!!!";
            }
            else{
                return "Produto Não Excluído!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto Não Excluído!!!";
        }
    }//Fecha o método excluirProduto
    
    
      
      
   public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
       
       ResultSet rs = null;
       
       rs = produtoDAO.consultarProduto(produtoDTO, opcao);
       return rs;
   }//Fecha o método consultarProduto
   
   
   
   
   public void CloseDB(){
       ConexaoDAO.CloseDB();
   }//Fecha o método CloseDB, que fecha o banco de dados
   
   
    
    
}//Fecha a classe ProdutoCTR
