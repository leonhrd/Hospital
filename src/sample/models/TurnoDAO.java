package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TurnoDAO {
    public int getCveTurno() {
        return CveTurno;
    }

    public void setCveTurno(int cveTurno) {
        CveTurno = cveTurno;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }

    private int CveTurno;
private String Descr;

    public ObservableList<TurnoDAO> SELECCIONAR(){

        ObservableList<TurnoDAO> listaC = FXCollections.observableArrayList();
        TurnoDAO objC;
        String query = "SELECT * FROM Turno";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new TurnoDAO();
                objC.setCveTurno(res.getInt("CveTurno"));
                objC.setDescr(res.getString("Descr"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }

}
