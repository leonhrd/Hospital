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
import sample.models.RehabilitaDAO;


public class rehabilitacion extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox;
    private RehabilitaDAO rDAO;


    private Label cveRehabLbl,lugarLbl, tratamientoLbl, cveTerLbl;
    private TextArea clavText, lugarText, trataText, cveTerText;

    private Button Anadir;
    private TableView tabla;

    private Scene escena;


    public rehabilitacion() {
        rDAO = new RehabilitaDAO();
        crearInterfaz();
        this.setTitle("Pacientes en rehabilitacion");
        this.setScene(escena);

        Image logo = new Image("sample/Images/equipoMedico.png");

        this.getIcons().add(logo);
        this.show();

    }

    private void crearInterfaz() {
        vBox = new VBox();
        hBox = new HBox();

        cveRehabLbl = new Label();
        //lugarLbl = new Label();
        //tratamientoLbl = new Label();
        cveTerLbl = new Label();

        cveRehabLbl.setText("Clave de rehabilitacion");
        //lugarLbl.setText("Lugar");
        //tratamientoLbl.setText("Tratamiento");
        cveTerLbl.setText("Clave terapeuta");


        clavText = new TextArea();
        //lugarText = new TextArea();
        //trataText = new TextArea();
        cveTerText = new TextArea();


        clavText.setMaxSize(250, 1);
       //lugarText.setMaxSize(250, 1);
       //trataText.setMaxSize(250, 1);
       cveTerText.setMaxSize(250, 1);





        tabla = new TableView();
        tabla.setMaxSize(800, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveTabla = new TableColumn("Clave Rehabilitacion");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("CveRehab"));
        tabla.getColumns().addAll(claveTabla);

        /*TableColumn<doctores, String> lugarTabla = new TableColumn("Lugar");
        lugarTabla.setCellValueFactory(new PropertyValueFactory<>("Lugar"));
        tabla.getColumns().addAll(lugarTabla);*/

        TableColumn<doctores, String> trataTabla = new TableColumn("Tratamiento");
        trataTabla.setCellValueFactory(new PropertyValueFactory<>("tratamiento"));
        tabla.getColumns().addAll(trataTabla);

        TableColumn<doctores, String> cveterTabla = new TableColumn("clave terapeuta");
        cveterTabla .setCellValueFactory(new PropertyValueFactory<>("CveTer"));
        tabla.getColumns().addAll(cveterTabla );
        tabla.setItems(rDAO.SELECCIONAR());


        Anadir = new Button();
        Anadir.setText("Registrar Doctor");
        Anadir.setPadding(new Insets(20));
        Anadir.setMaxSize(350,10);
        Anadir.setOnAction(event -> {
            rDAO.setCveRehab(Integer.parseInt(clavText.getText()));
            rDAO.setCveTer(Integer.parseInt(cveTerText.getText()));
            rDAO.INSERTAR();
            tabla.setItems(rDAO.SELECCIONAR());
            tabla.refresh();
        });

        vBox.getChildren().addAll(cveRehabLbl,clavText,cveTerLbl,cveTerText, Anadir);
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
