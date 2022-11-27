package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Turnos extends Stage implements EventHandler {

    private VBox vBox;
    private Scene escena;
    private TableView tabla;

    public Turnos() {
        creaInterfaz();

        this.setTitle("Turnos ");
        this.setScene(escena);

        Image logo = new Image("sample/Images/equipoMedico.png");

        this.getIcons().add(logo);
        this.show();


    }


    private void creaInterfaz() {
        vBox = new VBox();

        tabla = new TableView();
        tabla.setMaxSize(650, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveTabla = new TableColumn("Clave del turno");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("Clave"));
        tabla.getColumns().addAll(claveTabla);

        TableColumn<doctores, String> DescTabla = new TableColumn("Descripcion");
        DescTabla.setCellValueFactory(new PropertyValueFactory<>("Clave"));
        tabla.getColumns().addAll(DescTabla);


        vBox.getChildren().addAll(tabla);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(15));

        escena = new Scene(vBox, 500, 400);


    }

    @Override
    public void handle(Event event) {

    }
}



