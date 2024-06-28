package br.com.projeto_4.ctr;

//Importando as classes necessárias para trabalhar nesta classe

import java.sql.ResultSet;
import br.com.projeto_4.dto.ClienteDTO;
import br.com.projeto_4.dao.ClienteDAO;
import br.com.projeto_4.dao.ConexaoDAO;


public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    //Método construtor de classes
    public ClienteCTR(){
        
    }//Fecha o método construtor
    
    //Criando o método inserirCliente para retornar uma mensagem na VIEW.
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente Cadastrado com Sucesso!";
            }
            else{
                return "Cliente NÃO Cadastrado!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrado";
        }
    }//Fecha o método inserirCliente
    
    
    //Método utilizado para controlar o acesso ao método consultarCliente da classe ClienteDAO
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;
        
        //O atributo rs recebe a consulta realizada pelo método da classe DAO.
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        
        return rs;
    }//Fecha o método consultarCliente
    
    
    //Método utilizado para fechar o banco de dados.
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB
    
    
    //Método utilizado para alterar
    public String alterarCliente(ClienteDTO clienteDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente Alterado com Sucesso!";
            }
            else{
                return "Cliente NÃO Alterado!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO Alterado";
        }
    }//Fecha o método alterarCliente
    
    
    
    //Método utilizado para excluir
     public String excluirCliente(ClienteDTO clienteDTO){
        try{
            //Chama o método que está na classe DAO aguradando uma resposta (true ou false)
            if(clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente Excluído com Sucesso!";
            }
            else{
                return "Cliente NÃO Excluído!";
            }
        }//Caso tenha algum erro no codigo acima é enviado uma mensagem no
        //console com o que está acontecendo.
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO Excluído";
        }
    }//Fecha o método excluirCliente
    
    
     
}//Fecha a classe ClienteCTR
