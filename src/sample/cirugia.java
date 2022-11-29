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


public class cirugia extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox;


    private Label cvedocbl,idquirLbl,nssLbl, fechaLbl;
    private TextArea clavdoctxt, idquirText, nssText, fechaText;

    private Button Anadir;
    private TableView tabla;

    private Scene escena;


    public cirugia() {
        crearInterfaz();
        this.setTitle("Cirugías");
        this.setScene(escena);

        Image logo = new Image("sample/Images/equipoMedico.png");

        this.getIcons().add(logo);
        this.show();

    }

    private void crearInterfaz() {
        vBox = new VBox();
        hBox = new HBox();

        cvedocbl = new Label();
        idquirLbl = new Label();
        nssLbl = new Label();
        fechaLbl = new Label();

        cvedocbl.setText("Clave del doctor");
        idquirLbl.setText("Id Quirofano");
        nssLbl.setText("Numero Seguridad Social");
        fechaLbl.setText("Fecha");


        clavdoctxt = new TextArea();
        idquirText = new TextArea();
        nssText = new TextArea();
        fechaText= new TextArea();


        clavdoctxt.setMaxSize(250, 1);
        idquirText.setMaxSize(250, 1);
        nssText.setMaxSize(250, 1);
        fechaText.setMaxSize(250, 1);





        tabla = new TableView();
        tabla.setMaxSize(800, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveDocTabla = new TableColumn("Clave de doctor");
        claveDocTabla.setCellValueFactory(new PropertyValueFactory<>("Clave de doctor"));
        tabla.getColumns().addAll(claveDocTabla);

        TableColumn<doctores, String> quirofanoTabla = new TableColumn("Quirofano");
        quirofanoTabla.setCellValueFactory(new PropertyValueFactory<>("Quirofano"));
        tabla.getColumns().addAll(quirofanoTabla);

        TableColumn<doctores, String> nssTabla = new TableColumn("NSS Paciente");
        nssTabla.setCellValueFactory(new PropertyValueFactory<>("NSS"));
        tabla.getColumns().addAll(nssTabla);

        TableColumn<doctores, String> fechaTabla = new TableColumn("Fecha");
        fechaTabla .setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        tabla.getColumns().addAll(fechaTabla );


        Anadir = new Button();
        Anadir.setText("Programar cirugía");
        Anadir.setPadding(new Insets(20));
        Anadir.setMaxSize(350,10);

        vBox.getChildren().addAll(cvedocbl,clavdoctxt,idquirLbl,idquirText,nssLbl,nssText,fechaLbl,fechaText, Anadir);
        vBox.setSpacing(5);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15));

        hBox.getChildren().addAll(vBox, tabla);



        escena = new Scene(hBox, 600, 600);

    }



    @Override
    public void handle(Event event) {
    }
}
