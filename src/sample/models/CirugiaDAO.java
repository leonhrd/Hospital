package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CirugiaDAO {
    private int CveDoctor, IdQuir, NSS;
    private String Fecha;

    public int getCveDoctor() {
        return CveDoctor;
    }

    public void setCveDoctor(int cveDoctor) {
        CveDoctor = cveDoctor;
    }

    public int getIdQuir() {
        return IdQuir;
    }

    public void setIdQuir(int idQuir) {
        IdQuir = idQuir;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public void INSERTAR(){
        String query = "INSERT INTO Cirugia VALUES("+this.CveDoctor+","+this.IdQuir+","+this.NSS+",'"+this.Fecha+"')";
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<CirugiaDAO> SELECCIONAR(){

        ObservableList<CirugiaDAO> listaC = FXCollections.observableArrayList();
        CirugiaDAO objC;
        String query = "select * from cirugia";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new CirugiaDAO();
                objC.setCveDoctor(res.getInt("CveDoctor"));
                objC.setIdQuir(res.getInt("IdQuir"));
                objC.setNSS(res.getInt("NSS"));
                //objC.setCveEsp(res.getInt("CveEsp"));
                objC.setFecha(res.getString("Fecha"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }

    public ObservableList<CirugiaDAO> SELECCIONARF(String e1){

        ObservableList<CirugiaDAO> listaC = FXCollections.observableArrayList();
        CirugiaDAO objC;
        String query = "select * from cirugia where fecha = '"+e1+"'";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new CirugiaDAO();
                objC.setCveDoctor(res.getInt("CveDoctor"));
                objC.setIdQuir(res.getInt("IdQuir"));
                objC.setNSS(res.getInt("NSS"));
                //objC.setCveEsp(res.getInt("CveEsp"));
                objC.setFecha(res.getString("Fecha"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }
}
