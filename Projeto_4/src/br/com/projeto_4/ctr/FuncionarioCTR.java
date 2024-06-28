package br.com.projeto_4.ctr;

//Importando as classes necessárias para trabalhar nesta classe

import java.sql.ResultSet;
import br.com.projeto_4.dto.FuncionarioDTO;
import br.com.projeto_4.dao.FuncionarioDAO;
import br.com.projeto_4.dao.ConexaoDAO;


public class FuncionarioCTR {
    
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    //Método construtor de classes
    public FuncionarioCTR(){
        
    }//Fecha o método construtor
    
    //Criando o método inserirCliente para retornar uma mensagem na VIEW.
    public String inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionário Cadastrado com Sucesso!";
            }
            else{
                return "Funcionário NÃO Cadastrado!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Funcionário NÃO cadastrado";
        }
    }//Fecha o método inserirFuncionario
    
    
    
    //Método utilizado para controlar o acesso ao método consultarCliente da classe FuncionarioDAO
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao){
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        
        //O atributo rs recebe a consulta realizada pelo método da classe DAO.
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        
        return rs;
    }//Fecha o método consultarFuncionario
    
    
    
    
    //Método utilizado para alterar
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionário Alterado com Sucesso!";
            }
            else{
                return "Funcionário NÃO Alterado!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Funcionário NÃO Alterado";
        }
    }//Fecha o método alterarFuncionario
    
    
    
    //Método utilizado para excluir
     public String excluirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionário Excluído com Sucesso!";
            }
            else{
                return "Funcionário NÃO Excluído!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Funcionário NÃO Excluído";
        }
    }//Fecha o método excluirFuncionario
    
    
     
     
    //Método utilizado para fechar o banco de dados.
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
    
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
        
    }//Fecha o método logarFuncionario
    
    
    
     
}//Fecha a classe FuncionarioCTR
