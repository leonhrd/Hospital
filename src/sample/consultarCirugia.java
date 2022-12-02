package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.TurnoDAO;


public class consultarCirugia extends Stage implements EventHandler {

    private VBox vBox, vBox2;
    private HBox hBox;
    private Scene escena;
    private Label fechalbl;
    private TextArea fechaText;
    private Button botonBuscar;
    private TableView tabla;


    public consultarCirugia() {

        creaInterfaz();

        this.setTitle("Busqueda de cirugía");
        this.setScene(escena);

        Image logo = new Image("sample/Images/equipoMedico.png");

        this.getIcons().add(logo);
        this.show();


    }


    private void creaInterfaz() {
        vBox = new VBox();
        vBox2 = new VBox();

        hBox = new HBox();



        tabla = new TableView();
        tabla.setMaxSize(650, 350);
        tabla.setEditable(true);

        fechalbl = new Label();

        fechalbl.setText("Introduce fecha ");

        fechaText = new TextArea();
        fechaText.setMaxSize(150,1);
        vBox.setSpacing(5);
        vBox.setSpacing(15);
        botonBuscar = new Button();






        TableColumn<doctores, String> claveTabla = new TableColumn("Clave del doctor");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("Clave del doctor"));
        tabla.getColumns().addAll(claveTabla);

        TableColumn<doctores, String> quirofanoTabla = new TableColumn("id. quirofano");
        quirofanoTabla.setCellValueFactory(new PropertyValueFactory<>("id. quirofano"));
        tabla.getColumns().addAll(quirofanoTabla);

        TableColumn<doctores, String> nssTabla = new TableColumn("Nss");
        nssTabla.setCellValueFactory(new PropertyValueFactory<>("Nss"));
        tabla.getColumns().addAll(nssTabla);




        vBox.getChildren().addAll(fechalbl, fechaText, botonBuscar);
        botonBuscar.setMaxSize(150,1);
        botonBuscar.setText("Buscar cirugia");

        vBox2.getChildren().addAll(tabla);
        hBox.getChildren().addAll(vBox,vBox2);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(15));

        escena = new Scene(hBox, 500, 400);


    }

    @Override
    public void handle(Event event) {

    }
}



