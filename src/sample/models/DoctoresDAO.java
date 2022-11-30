package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctoresDAO {
    private int CveDoctor, CveNomina, CveEsp,CveTurno;
    private String Nombre;
    private String Sexo;
    int NSS;
    int Cedula;
    int Salario;
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



    public int getCveDoctor() {
        return CveDoctor;
    }

    public void setCveDoctor(int cveDoctor) {
        CveDoctor = cveDoctor;
    }

    public int getCveNomina() {
        return CveNomina;
    }

    public void setCveNomina(int cveNomina) {
        CveNomina = cveNomina;
    }

    public int getCveEsp() {
        return CveEsp;
    }

    public void setCveEsp(int cveEsp) {
        CveEsp = cveEsp;
    }

    public int getCveTurno() {
        return CveTurno;
    }

    public void setCveTurno(int cveTurno) {
        CveTurno = cveTurno;
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

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public void INSERTAR(){
        String query = "INSERT INTO doctor VALUES("+this.CveDoctor+",'"+this.Nombre+"','"+this.Sexo+"',"+this.CveNomina+","+this.CveEsp+","+this.CveTurno+")";
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
    public ObservableList<DoctoresDAO> SELECCIONAR(){

        ObservableList<DoctoresDAO> listaC = FXCollections.observableArrayList();
        DoctoresDAO objC;
        String query = "select doctor.CveDoctor, doctor.Nombre,Doctor.sexo,Doctor.cvenomina," +
                "doctor.cveEsp,nomina.NSS,nomina.cedula,nomina.salario from doctor inner join nomina on doctor.cvenomina = nomina.cvenomina;";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new DoctoresDAO();/*
                objC.setNSS(res.getInt("NSS"));
                objC.setIdPaci(res.getInt("IdPaci"));
                objC.setNombre(res.getString("Nombre"));
                objC.setFNacimiento(res.getString("FNacimiento"));
                objC.setSexo(res.getString("Sexo"));
                objC.setIdHist(res.getInt("IdHist"));
                objC.setIdPlanta(res.getInt("IdPlanta"));
                objC.setCveRehab(res.getInt("CveRehab"));
                objC.setIdCuarto(res.getInt("IdCuarto"));
                objC.setIdCama(res.getInt("IdCama"));*/
                objC.setCveDoctor(res.getInt("CveDoctor"));
                objC.setNombre(res.getString("Nombre"));
                objC.setSexo(res.getString("Sexo"));
                objC.setCveNomina(res.getInt("CveNomina"));
                objC.setCveEsp(res.getInt("CveEsp"));
                objC.setNSS(res.getInt("NSS"));
                objC.setCedula(res.getInt("cedula"));
                objC.setSalario(res.getInt("salario"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    } // RECUPERAR TODOS LOS REGISTROS

    public ObservableList<DoctoresDAO> SELECCIONARTABLA(){
        ObservableList<DoctoresDAO> listaC = FXCollections.observableArrayList();
        DoctoresDAO objC;
        String query = "SELECT * FROM doctor ORDER BY NSS";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new DoctoresDAO();/*
                objC.setNSS(res.getInt("NSS"));
                objC.setIdPaci(res.getInt("IdPaci"));
                objC.setNombre(res.getString("Nombre"));
                objC.setFNacimiento(res.getString("FNacimiento"));
                objC.setSexo(res.getString("Sexo"));
                objC.setIdHist(res.getInt("IdHist"));
                objC.setIdPlanta(res.getInt("IdPlanta"));
                objC.setCveRehab(res.getInt("CveRehab"));
                objC.setIdCuarto(res.getInt("IdCuarto"));
                objC.setIdCama(res.getInt("IdCama"));*/
                objC.setCveDoctor(res.getInt("CveDoctor"));
                objC.setNombre(res.getString("Nombre"));
                objC.setSexo(res.getString("Sexo"));
                objC.setCveNomina(res.getInt("CveNomina"));
                objC.setCveEsp(res.getInt("CveEsp"));
                objC.setCveTurno(res.getInt("CveTurno"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;
    }

}
