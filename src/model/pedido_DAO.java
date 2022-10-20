
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static model.estoque_DAO.url;
import view.pedido_GUI;


public class pedido_DAO {
    
    static String url = "jdbc:mysql://localhost/spectrum_hb";
    static String username = "root";
    static String password = "";
    
    // Pré-Estoque Debitado
    
    public static int carne;
    public static int alface;
    public static int tomate;
    public static int cheddar;
    public static int pao;
    public static int agua;
    public static int coca_cola;
    public static int fanta;
    public static int suco;
    public static int molho;
    public static int bacon;
    public static int cebola;
    public static int calabresa;
    
    public static float preco;
    
    public static void carregaEstoque() throws SQLException{
        
        String SQL = "select * from estoque";
        
        Connection con = (Connection) DriverManager.getConnection(url, username, password);
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                String ingrediente = rs.getString("ingrediente").toLowerCase();
                int quantia = rs.getInt("quantidade");
                
                if ("carne".equals(ingrediente)){
                    carne = quantia;
                }else if ("alface".equals(ingrediente)){
                    alface = quantia;
                }else if ("tomate".equals(ingrediente)){
                    tomate = quantia;
                }else if ("cheddar".equals(ingrediente)){
                    cheddar = quantia;
                }else if ("pao".equals(ingrediente)){
                    pao = quantia;
                }else if ("agua".equals(ingrediente)){
                    agua = quantia;
                }else if ("coca-cola".equals(ingrediente)){
                    coca_cola = quantia;
                }else if ("fanta".equals(ingrediente)){
                    fanta = quantia;
                }else if ("suco".equals(ingrediente)){
                    suco = quantia;
                }else if ("molho".equals(ingrediente)){
                    molho = quantia;
                }else if ("bacon".equals(ingrediente)){
                    bacon = quantia;
                }else if ("cebola".equals(ingrediente)){
                    cebola = quantia;
                }else if ("calabresa".equals(ingrediente)){
                    calabresa = quantia;
                }
                
            }
        }catch (Exception e){
        }
        
    }
    
    public static void pedirBurguer(int id){
        
        if (id == 1 && pao >= 2 && alface >= 1 && cheddar >= 2 && cebola >= 3 && tomate >= 2 && carne >= 1
                && bacon >= 5 && molho >= 1){
            pedido_GUI.crookLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.crookLBL.getText())+1));
            pao -= 2;
            alface -= 1;
            cheddar -= 2;
            cebola -= 3;
            tomate -= 2;
            carne -= 1;
            bacon -= 5;
            molho -= 1;
            preco += 15.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 2 && pao >= 2 && alface >= 1 && cheddar >= 2 && tomate >= 6 && carne >= 2
                && molho >= 1){
            pedido_GUI.laicaLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.laicaLBL.getText())+1));
            pao -= 2;
            alface -= 1;
            cheddar -= 2;
            tomate -= 6;
            carne -= 2;
            molho -= 1;
            preco += 20.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 3 && pao >= 2 && alface >= 1 && cheddar >= 2 && cebola >= 4 && tomate >= 2 && carne >= 2
                && molho >= 2){
            pedido_GUI.marceLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.marceLBL.getText())+1));
            pao -= 2;
            alface -= 1;
            cheddar -= 2;
            cebola -= 4;
            tomate -= 2;
            carne -= 2;
            molho -= 2;
            preco += 25.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 4 && pao >= 2 && alface >= 1 && cheddar >= 2 && cebola >= 3 && tomate >= 2 && carne >= 2
                && molho >= 1 && calabresa >= 6){
            pedido_GUI.calabrasaLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.calabrasaLBL.getText())+1));
            pao -= 2;
            alface -= 1;
            cheddar -= 2;
            cebola -= 3;
            tomate -= 2;
            carne -= 2;
            calabresa -= 6;
            molho -= 1;
            preco += 10.50;
            pedido_GUI.valor.setText("R$ "+preco);
        }
        
    }
    
    public static void removerBurguer(int id){
        
        if (id == 1 && Integer.valueOf(pedido_GUI.crookLBL.getText()) >= 1){
            pedido_GUI.crookLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.crookLBL.getText())-1));
            pao += 2;
            alface += 1;
            cheddar += 2;
            cebola += 3;
            tomate += 2;
            carne += 1;
            bacon += 5;
            molho += 1;
            preco -= 15.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 2 && Integer.valueOf(pedido_GUI.laicaLBL.getText()) >= 1){
            pedido_GUI.laicaLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.laicaLBL.getText())-1));
            pao += 2;
            alface += 1;
            cheddar += 2;
            tomate += 6;
            carne += 2;
            molho += 1;
            preco -= 20.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 3 && Integer.valueOf(pedido_GUI.marceLBL.getText()) >= 1){
            pedido_GUI.marceLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.marceLBL.getText())-1));
            pao += 2;
            alface += 1;
            cheddar += 2;
            cebola += 4;
            tomate += 2;
            carne += 2;
            molho += 2;
            preco -= 25.00;
            pedido_GUI.valor.setText("R$ "+preco);
        }if (id == 4 && Integer.valueOf(pedido_GUI.calabrasaLBL.getText()) >= 1){
            pedido_GUI.calabrasaLBL.setText(String.valueOf(Integer.valueOf(pedido_GUI.calabrasaLBL.getText())-1));
            pao += 2;
            alface += 1;
            cheddar += 2;
            cebola += 3;
            tomate += 2;
            carne += 2;
            calabresa += 6;
            molho += 1;
            preco -= 10.50;
            pedido_GUI.valor.setText("R$ "+preco);
        }
        
    }
    
    public static void limparPedido() throws SQLException{
        
        carregaEstoque();
        preco = 0;
        view.pedido_GUI.crookLBL.setText("0");
        view.pedido_GUI.laicaLBL.setText("0");
        view.pedido_GUI.marceLBL.setText("0");
        view.pedido_GUI.calabrasaLBL.setText("0");
        pedido_GUI.valor.setText("R$ "+preco);
        
    }
    
}
