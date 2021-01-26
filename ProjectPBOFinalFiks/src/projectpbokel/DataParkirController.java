package projectpbokel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class DataParkirController implements Initializable {
    
    @FXML
    private TableView<DataParkir> table_data;

    @FXML
    private TableColumn<DataParkir, Integer> col_no;

    @FXML
    private TableColumn<DataParkir, String> col_pemilik;

    @FXML
    private TableColumn<DataParkir, String> col_nopol;

    @FXML
    private TableColumn<DataParkir, String> col_jenis;

    @FXML
    private TableColumn<DataParkir, String> col_tanggal;
    
    @FXML
    private TextField txt_no;
    
    @FXML
    private TextField txt_pemilik;

    @FXML
    private TextField txt_nopol;

    @FXML
    private ComboBox txt_jenis;

    @FXML
    private DatePicker txt_tanggal;
    
    @FXML
    private TextField filterField;
    
    
    ObservableList<DataParkir> listM;
    ObservableList<DataParkir> dataList;
    
    
    int index = -1;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     
    public void Add_data() {    
        conn = ConnectDB.ConnectDb();
        String sql = "insert into data (no,pemilik,nopol,jenis,tanggal)values(?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_no.getText());
            pst.setString(2, txt_pemilik.getText());
            pst.setString(3, txt_nopol.getText());
            pst.setString(4, txt_jenis.getValue().toString());
            pst.setString(5, txt_tanggal.getValue().toString());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Add Data Success");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    @FXML
    void getSelected(MouseEvent event) {
    index = table_data.getSelectionModel().getSelectedIndex();
    if (index <= -1) {
        return;
    }
    
    txt_no.setText(col_no.getCellData(index).toString());
    txt_pemilik.setText(col_pemilik.getCellData(index).toString());
    txt_nopol.setText(col_nopol.getCellData(index).toString());
    txt_jenis.setValue(col_jenis.getCellData(index).toString());
    }

    public void Update() {   
        try {
            conn = ConnectDB.ConnectDb();
            String value1 = txt_no.getText();
            String value2 = txt_pemilik.getText();
            String value3 = txt_nopol.getText();
            String value4 = txt_jenis.getValue().toString();
            String value5 = txt_tanggal.getValue().toString();
            String sql = "update data set no= '"+value1+"',pemilik= '"+value2+"',nopol= '"
                        +value3+"',jenis= '"+value4+"',tanggal= '"+value5+"' where no='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update Data Success");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void Delete() {
    conn = ConnectDB.ConnectDb();
    String sql = "delete from data where no = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_no.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete Data Success");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void UpdateTable() {
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_pemilik.setCellValueFactory(new PropertyValueFactory<>("pemilik"));
        col_nopol.setCellValueFactory(new PropertyValueFactory<>("nopol"));
        col_jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        col_tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        
        listM = ConnectDB.getDataparkir();
        table_data.setItems(listM);
    }
    

 @FXML
    void search_user() {          
        col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
        col_pemilik.setCellValueFactory(new PropertyValueFactory<>("pemilik"));
        col_nopol.setCellValueFactory(new PropertyValueFactory<>("nopol"));
        col_jenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        col_tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        
        dataList = ConnectDB.getDataparkir();
        table_data.setItems(dataList);
        
    FilteredList<DataParkir> filteredData = new FilteredList<>(dataList, b -> true);  
    filterField.textProperty().addListener((observable, oldValue, newValue) -> {
    filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
    return true;
    }
    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getPemilik().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
    return true;
    } else if (person.getNopol().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    return true;
    } else if (person.getJenis().toLowerCase().indexOf(lowerCaseFilter) != -1) {
    return true;
    } else if (String.valueOf(person.getTanggal()).indexOf(lowerCaseFilter)!=-1)
    return true;                      
        else  
          return false;
    });
    });
    
  SortedList<DataParkir> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_data.comparatorProperty());  
  table_data.setItems(sortedData); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> jenis = FXCollections.observableArrayList("Mobil", "Motor");
        txt_jenis.setItems(jenis);
    UpdateTable();
    search_user();
    } 
}