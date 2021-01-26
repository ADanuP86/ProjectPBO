package projectpbokel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class ConnectDB {
    Connection conn = null;
    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/parkir","root","");
            //JOptionPane.showMessageDialog(null, "Connection Success");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static ObservableList<DataParkir> getDataparkir() {
        Connection conn = ConnectDb();
        ObservableList<DataParkir> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from data");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {   
                list.add(new DataParkir(Integer.parseInt(rs.getString("no")), rs.getString("pemilik"), rs.getString("nopol"), rs.getString("jenis"), rs.getString("tanggal")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
}