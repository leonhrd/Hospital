package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NominaDAO {
    int CveNomina;
    int NSS;
    int Cedula;
    int Salario;

    public int getCveNomina() {
        return CveNomina;
    }

    public void setCveNomina(int cveNomina) {
        CveNomina = cveNomina;
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int salario) {
        Salario = salario;
    }

    public void INSERTAR(){
        String query = "INSERT INTO Nomina " +
                "VALUES("+this.CveNomina+","+this.NSS+","+this.Cedula+","+this.Salario+")";
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ACTUALIZAR(){
        /*String query = "UPDATE tblclientes SET nomcte='"+this.nomcte+"',telcte='"+this.telcte+"'," +
                "dircte='"+this.dircte+"' WHERE cvecte = "+this.cvecte;
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void ELIMINAR(){
        /*String query = "DELETE FROM tblclientes WHERE cvecte = "+this.cvecte;
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
    public ObservableList<NominaDAO> SELECCIONAR(){

        ObservableList<NominaDAO> listaC = FXCollections.observableArrayList();
        NominaDAO objC;
        String query = "SELECT * FROM taqueriadb.tblclientes ORDER BY nomcte";
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
               /* objC = new NominaDAO();
                objC.setCvecte(res.getInt("cvecte"));
                objC.setNomcte(res.getString("nomcte"));
                objC.setTelcte(res.getString("telcte"));
                objC.setDircte(res.getString("dircte"));
                listaC.add(objC);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    } // RECUPERAR TODOS LOS REGISTROS

    public void SELECCIONARBYID(){}


}
