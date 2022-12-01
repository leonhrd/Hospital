package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HabitacionesDAO {
    private int IdPlanta,IdCuarto,IdCama,NoCama;

    public int getIdPlanta() {
        return IdPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        IdPlanta = idPlanta;
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

    public int getNoCama() {
        return NoCama;
    }

    public void setNoCama(int noCama) {
        NoCama = noCama;
    }

    public ObservableList<HabitacionesDAO> SELECCIONAR(){

        ObservableList<HabitacionesDAO> listaC = FXCollections.observableArrayList();
        HabitacionesDAO objC;
        String query = "SELECT * FROM cama";
        //System.out.println(query);
        try {
            Statement stmt = conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new HabitacionesDAO();
                objC.setIdPlanta(res.getInt("IdPlanta"));
                objC.setIdCuarto(res.getInt("IdCuarto"));
                objC.setIdCama(res.getInt("IdCama"));
                objC.setNoCama(res.getInt("NoCama"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    }
}
