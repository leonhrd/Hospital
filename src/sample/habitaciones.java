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


public class habitaciones extends Stage implements EventHandler {

    private VBox vBox;
    private Scene escena;
    private TableView tabla;

    public habitaciones() {
        creaInterfaz();

        this.setTitle("Habitaciones ");
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

        TableColumn<doctores, String> IdPlantaTabla = new TableColumn("Planta");
        IdPlantaTabla.setCellValueFactory(new PropertyValueFactory<>("Planta"));
        tabla.getColumns().addAll(IdPlantaTabla);

        TableColumn<doctores, String> IdCuartoTabla = new TableColumn("Cuarto");
        IdCuartoTabla.setCellValueFactory(new PropertyValueFactory<>("Cuarto"));
        tabla.getColumns().addAll(IdCuartoTabla);

        TableColumn<doctores, String> IdCamaTabla = new TableColumn("Id cama");
        IdCamaTabla.setCellValueFactory(new PropertyValueFactory<>("Id cama"));
        tabla.getColumns().addAll(IdCamaTabla);

        TableColumn<doctores, String> CamaTabla = new TableColumn("No. Cama");
        CamaTabla.setCellValueFactory(new PropertyValueFactory<>("No. Cama"));
        tabla.getColumns().addAll(CamaTabla);



        vBox.getChildren().addAll(tabla);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(15));

        escena = new Scene(vBox, 500, 400);


    }

    @Override
    public void handle(Event event) {

    }
}



