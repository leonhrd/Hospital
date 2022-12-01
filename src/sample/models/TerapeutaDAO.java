package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TerapeutaDAO {
    private int CveTer,CveEsp;
    private String EspD,Nombre,Sexo;

    public String getEspD() {
        return EspD;
    }

    public void setEspD(String espD) {
        EspD = espD;
    }

    public int getCveTer() {
        return CveTer;
    }

    public void setCveTer(int cveTer) {
        CveTer = cveTer;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String  sexo) {
        Sexo = sexo;
    }

    public int getCveEsp() {
        return CveEsp;
    }

    public void setCveEsp(int cveEsp) {
        CveEsp = cveEsp;
    }

    public void INSERTAR(){
        String query = "INSERT INTO terapeuta VALUES("+this.CveTer+",'"+this.Nombre+"','"+this.Sexo+"',"+this.CveEsp+")";
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<TerapeutaDAO> SELECCIONAR(){

    ObservableList<TerapeutaDAO> listaC = FXCollections.observableArrayList();
        TerapeutaDAO objC;
        String query = "select terapeuta.CveTer,terapeuta.nombre,terapeuta.sexo,Especialidad.Descr " +
                "from terapeuta inner join Especialidad on terapeuta.CveEsp = Especialidad.CveEsp";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new TerapeutaDAO();
                objC.setCveTer(res.getInt("CveTer"));
                objC.setNombre(res.getString("Nombre"));
                objC.setSexo(res.getString("Sexo"));
                //objC.setCveEsp(res.getInt("CveEsp"));
                objC.setEspD(res.getString("Descr"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }
}
