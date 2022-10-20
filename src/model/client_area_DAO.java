
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.first_GUI;


public class client_area_DAO {

    static String url = "jdbc:mysql://localhost/spectrum_hb";
    static String username = "root";
    static String password = "";
    
    public static int aprovado = 0;
    
    public static void cadastraCliente(){
        
        controller.Conexao_DB.carregaDriver();

                Connection con = null;

                try{
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(client_area_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                String nome = first_GUI.nomeTXT.getText();
                String cpf = first_GUI.cpfTXT.getText();
                String tel = first_GUI.telTXT.getText();
                String end = first_GUI.endTXT.getText();
                
                
                String SQL = "insert into clientes(nome,cpf,telefone,endereco) values('"+nome+"','"+cpf+"','"+tel+"','"+end+"')";

                try{
                    PreparedStatement insert = (PreparedStatement) con.prepareStatement(SQL);
                    insert.execute();

                    aprovado = 1;

                }catch (Exception ex) {
                    Logger.getLogger(client_area_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    
    public static void consultaCliente() throws SQLException{
        
        String SQL = "select * from clientes where cpf='"+first_GUI.consultaTXT.getText()+"'";
        
        Connection con = (Connection) DriverManager.getConnection(url, username, password);
        
        try{
            
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(SQL);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                notafiscal_DAO.id_cliente = rs.getInt("id_cliente");
                notafiscal_DAO.nome = rs.getString("nome");
                notafiscal_DAO.cpf = rs.getString("cpf");
                notafiscal_DAO.telefone = rs.getString("telefone");
                notafiscal_DAO.endereco = rs.getString("endereco");
                
                aprovado = 1;
            }
            
        }catch (Exception e){
        }
        
    }
    
}
