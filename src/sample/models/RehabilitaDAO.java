package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RehabilitaDAO {
    private int CveRehab,CveTer;
    private String tratamiento;

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getCveRehab() {
        return CveRehab;
    }

    public void setCveRehab(int cveRehab) {
        CveRehab = cveRehab;
    }

    public int getCveTer() {
        return CveTer;
    }

    public void setCveTer(int cveTer) {
        CveTer = cveTer;
    }

    public void INSERTAR(){
        String query = "INSERT INTO rehabilita VALUES("+this.CveRehab+","+this.CveTer+")";
        try {
            Statement stmt = conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<RehabilitaDAO> SELECCIONAR(){

        ObservableList<RehabilitaDAO> listaC = FXCollections.observableArrayList();
        RehabilitaDAO objC;
        String query = "select rehabilita.cverehab,rehabilitacion.tratamiento,rehabilita.CveTer" +
                " from rehabilita inner join rehabilitacion on rehabilita.CveRehab = rehabilitacion.cverehab;";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new RehabilitaDAO();
                objC.setCveRehab(res.getInt("CveRehab"));
                objC.setTratamiento(res.getString("tratamiento"));
                objC.setCveTer(res.getInt("CveTer"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }
}
