package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacientesDAO {
    private int NSS;
    private int IdPaci;
    private String Nombre;
    private String FNacimiento;
    private String Sexo;
    private int IdPlanta;
    private int CveRehab;
    private int IdCuarto;
    private int IdCama;
    private int IdHist;

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public int getIdHist() {
        return IdHist;
    }

    public void setIdHist(int IdHist) {
        this.IdHist = IdHist;
    }

    public int getIdPaci() {
        return IdPaci;
    }

    public void setIdPaci(int idPaci) {
        IdPaci = idPaci;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFNacimiento() {
        return FNacimiento;
    }

    public void setFNacimiento(String FNacimiento) {
        this.FNacimiento = FNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public int getIdPlanta() {
        return IdPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        IdPlanta = idPlanta;
    }

    public int getCveRehab() {
        return CveRehab;
    }

    public void setCveRehab(int cveRehab) {
        CveRehab = cveRehab;
    }

    public int getIdCuarto() {
        return IdCuarto;
    }

    public void setIdCuarto(int idCuarto) {
        IdCuarto = idCuarto;
    }

    public int getIdCama() {
        return IdCama;
    }

    public void setIdCama(int idCama) {
        IdCama = idCama;
    }

    public void INSERTAR(){
        String query = "INSERT INTO Paciente VALUES('"+this.NSS+"',"+this.IdPaci+",'"+this.Nombre+"','"+this.FNacimiento+"','"+this.Sexo+"',"+IdHist+","+IdPlanta+","+CveRehab+","+IdCuarto+","+IdCama+")";
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ACTUALIZAR(){
        /*String query = "UPDATE tblordenes SET fechaorden='"+this.fechaorden+"',montoorden="+this.montoorden+"," +
                "cveemp="+this.cveemp+" ,cvecte= "+this.cvecte+" WHERE cveorden = "+this.cveorden;
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void ELIMINAR(){
        /*String query = "DELETE FROM tblordenes WHERE cveorden = "+this.cveorden;
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
    public ObservableList<PacientesDAO> SELECCIONAR(){

        ObservableList<PacientesDAO> listaC = FXCollections.observableArrayList();
        PacientesDAO objC;
        String query = "SELECT * FROM Paciente ORDER BY NSS";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new PacientesDAO();
                /*objC.setCvecte(res.getInt("cvecte"));
                objC.setNomcte(res.getString("nomcte"));
                objC.setTelcte(res.getString("telcte"));
                objC.setDircte(res.getString("dircte"));*/
               /* objC.setCvecte(res.getInt("cvecte"));
                objC.setCveemp(res.getInt("cveemp"));
                objC.setCveorden(res.getInt("cveorden"));
                objC.setMontoorden(res.getDouble("montoorden"));
                objC.setFechaorden(res.getString("fechaorden"));*/
                ///////////////
                objC.setNSS(res.getInt("NSS"));
                objC.setIdPaci(res.getInt("IdPaci"));
                objC.setNombre(res.getString("Nombre"));
                objC.setFNacimiento(res.getString("FNacimiento"));
                objC.setSexo(res.getString("Sexo"));
                objC.setIdHist(res.getInt("IdHist"));
                objC.setIdPlanta(res.getInt("IdPlanta"));
                objC.setCveRehab(res.getInt("CveRehab"));
                objC.setIdCuarto(res.getInt("IdCuarto"));
                objC.setIdCama(res.getInt("IdCama"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    } // RECUPERAR TODOS LOS REGISTROS

    public void SELECCIONARBYID(){}
}
