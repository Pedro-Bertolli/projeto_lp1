/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.dao;

import br.com.projeto_4.dto.ClienteDTO;
import br.com.projeto_4.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;


/**
 *
 * @author Aluno
 */
public class VendaDAO {
    
    
    //Método Construtor
    public VendaDAO(){
        
        
    }
    
    
    private ResultSet rs = null;
    
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos){
        try{
            //Chama o método que está na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //Cria o Statment que é responsável por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            //Comando SQL que será executado no banco de dados
            String comando1 = "Insert into Venda (dat_vend, val_vend, "
                    + "id_cli) values ( "
                    + "to_date('" + date.format(vendaDTO.getDat_vend()) + "', 'DD/MM/YYYY'), "
                    + vendaDTO.getVal_vend() + ", "
                    + clienteDTO.getId_cli() + ")";
            
            //Executa o comando SQL no banco de dados
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for(int cont=0; cont < produtos.getRowCount(); cont++){
                String comando2 = "Insert into produto_venda (id_vend, id_prod, "
                        + "val_prod, qtd_prod) values ( "
                        + rs.getInt("id_vend") + ", "
                        + produtos.getValueAt(cont, 0) + ", "
                        + produtos.getValueAt(cont, 2) + ", "
                        + produtos.getValueAt(cont, 3) + "); ";
                
                stmt1.execute(comando2);
            }
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statment
            stmt.close();
            stmt1.close();
            rs.close();
            return true;
        }//Caso tenha um erro acima é enviado uma mensagem no console
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou não ele vai fechar o banco de dados
        finally{
            //Chama o método da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirVenda
    
    
    
}
