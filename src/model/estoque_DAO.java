
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class estoque_DAO {

    static String url = "jdbc:mysql://localhost/spectrum_hb";
    static String username = "root";
    static String password = "";
    
    public static void carregaEstoque() throws SQLException{
        
        String SQL = "select * from estoque";
        
        DefaultTableModel model = (DefaultTableModel)  view.estoque_GUI.registros.getModel();
        model.setRowCount(0);
        
        Connection con = (Connection) DriverManager.getConnection(url, username, password);
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                String ingrediente = rs.getString("ingrediente");
                String quantia = rs.getString("quantidade");
                
                String tBD[] = {ingrediente, quantia};
                model.addRow(tBD);
                
            }
        }catch (Exception e){
        }
        
    }
    
    public static void insereEstoque(){
        
        controller.Conexao_DB.carregaDriver();

                Connection con = null;

                try{
                    con = (Connection) DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                String SQL = "insert into estoque(ingrediente, quantidade) values('"+view.estoque_GUI.ingreTXT.getText()+"',"
                        + "'"+Integer.valueOf(view.estoque_GUI.quantiaTXT.getText())+"')";

                try{
                    PreparedStatement insert = (PreparedStatement) con.prepareStatement(SQL);
                    insert.execute();

                }catch (Exception ex) {
                    Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        try {
            carregaEstoque();
        } catch (SQLException ex) {
            Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void abasteceEstoque() throws SQLException{
        
        DefaultTableModel model = (DefaultTableModel) view.estoque_GUI.registros.getModel();
        int row = view.estoque_GUI.registros.getSelectedRow();
        String ingrediente = view.estoque_GUI.registros.getModel().getValueAt(row, 0).toString();
        int quantia = Integer.valueOf(view.estoque_GUI.quantiaSTXT.getText());
        
        String SQL = "update estoque set quantidade=? where ingrediente=?";
        
        Connection con = (Connection) DriverManager.getConnection(url, username, password);
        
        try{
            PreparedStatement insert = (PreparedStatement) con.prepareStatement(SQL);
            insert.setInt(1, quantia);
            insert.setString(2, ingrediente);
            insert.executeUpdate();
            
        }catch (Exception ex) {
            Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregaEstoque();
        
    }
    
    public static void apagarEstoque(){
        
        controller.Conexao_DB.carregaDriver();

        Connection con = null;
        
        try{
            con = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) view.estoque_GUI.registros.getModel();
        int row = view.estoque_GUI.registros.getSelectedRow();
        String ingrediente = view.estoque_GUI.registros.getModel().getValueAt(row, 0).toString();
        int quantia = Integer.valueOf(view.estoque_GUI.registros.getModel().getValueAt(row, 1).toString());
        
        String SQL = "delete from estoque where ingrediente='"+ingrediente+"' and quantidade='"+quantia+"'";
        
        try{
            PreparedStatement insert = (PreparedStatement) con.prepareStatement(SQL);
            insert.execute();
            
        }catch (Exception ex) {
            Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            carregaEstoque();
        } catch (SQLException ex) {
            Logger.getLogger(estoque_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
