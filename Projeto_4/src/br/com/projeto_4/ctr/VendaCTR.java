/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dao.ConexaoDAO;
import br.com.projeto_4.dao.VendaDAO;
import br.com.projeto_4.dto.VendaDTO;
import br.com.projeto_4.dto.ClienteDTO;
import javax.swing.JTable;

/**
 *
 * @author Aluno
 */
public class VendaCTR {
    
    VendaDAO vendaDAO = new VendaDAO();
    
    
    //Método Construtor
    public VendaCTR(){
        
    }
    
    
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteCTO, JTable produtos){
        try{
            //Chama o método que está na classe DAO aguardando uma resposta (true ou false)
            if(vendaDAO.inserirVenda(vendaDTO, clienteCTO, produtos)){
                return "Venda Cadastrada Com Sucesso!!!";
            }
            else{
                return "Venda Não Cadastrada!!!";
            }
        }//Fecha o try
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Venda Não Cadastrada!!!";
        }
    }//Fecha o método inserirVenda
    
    
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//Fecha o método Close DB
    
    
    
    
}
