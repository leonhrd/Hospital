package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargoDAO {
    public int getCveCargo() {
        return CveCargo;
    }

    public void setCveCargo(int cveCargo) {
        CveCargo = cveCargo;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    private int CveCargo;
    private String Descr;

    public ObservableList<CargoDAO> SELECCIONAR(){

        ObservableList<CargoDAO> listaC = FXCollections.observableArrayList();
        CargoDAO objC;
        String query = "SELECT * FROM Cargo";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new CargoDAO();
                objC.setCveCargo(res.getInt("CveCargo"));
                objC.setDescr(res.getString("Descr"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }
}
