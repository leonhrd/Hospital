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


public class pacientes extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox, vBox2;

    private Label nss, nombre, sexo;
    private Label Idpaciente, FechaNac, IdHist, IdPlanta,cveRehab;

    private TextArea nssText, nombText, sexoText;
    private TextArea IdpacienteText, FechaNacText, IdHistText, IdPlantaText,cveRehabText;
    private Button Anadir,DarAlta;
    private TableView tabla;

    private Scene escena;


    public pacientes() {
        crearInterfaz();
        this.setTitle("Pacientes");
        this.setScene(escena);

        Image logo = new Image("sample/Images/examen.png");

        this.getIcons().add(logo);
        this.show();

    }

    private void crearInterfaz() {
        vBox = new VBox();
        hBox = new HBox();
        vBox2 = new VBox();

        nss = new Label();
        nombre = new Label();
        sexo = new Label();
        Idpaciente = new Label();
        FechaNac = new Label();
        IdHist = new Label();
        IdPlanta = new Label();
        cveRehab = new Label();

        nssText = new TextArea();
        nombText = new TextArea();
        sexoText = new TextArea();
        IdpacienteText = new TextArea();
        FechaNacText = new TextArea();
        IdHistText = new TextArea();
        IdPlantaText = new TextArea();
        cveRehabText = new TextArea();

        nssText.setMaxSize(150, 1);
        nombText.setMaxSize(150, 1);
        sexoText.setMaxSize(150, 1);
        IdpacienteText.setMaxSize(150, 1);
        FechaNacText.setMaxSize(150, 1);
        IdPlantaText.setMaxSize(150, 1);
        IdHistText.setMaxSize(150, 1);
        cveRehabText.setMaxSize(150, 1);

        nss.setText("Número de Seguridad Social");
        nombre.setText("Nombre");
        sexo.setText("Sexo");
        Idpaciente.setText("Numero de Identificacion");
        FechaNac.setText("Fecha de nacimiento --/--/--");
        IdHist.setText("Identificador historial medico");
        IdPlanta.setText("Numero de planta");
        cveRehab.setText("Clave de rehabilitacion");

        tabla = new TableView();
        tabla.setMaxSize(800, 350);
        tabla.setEditable(true);

        TableColumn<pacientes, String> nssTabla = new TableColumn("nss");
        nssTabla.setCellValueFactory(new PropertyValueFactory<>("nss"));
        tabla.getColumns().addAll(nssTabla);

        TableColumn<pacientes, String> nombreTabla = new TableColumn("Nombre");
        nombreTabla .setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tabla.getColumns().addAll(nombreTabla );

        TableColumn<pacientes, String> sexoTabla  = new TableColumn("Sexo");
        sexoTabla .setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tabla.getColumns().addAll(sexoTabla);

        TableColumn<pacientes, String> IdPacienteTabla  = new TableColumn("Id.Paciente");
        IdPacienteTabla .setCellValueFactory(new PropertyValueFactory<>("Id.Paciente"));
        tabla.getColumns().addAll(IdPacienteTabla);

        TableColumn<pacientes, String> FechaNacTabla  = new TableColumn("F.Nacimiento");
        FechaNacTabla  .setCellValueFactory(new PropertyValueFactory<>("F.Nacimiento"));
        tabla.getColumns().addAll(FechaNacTabla );

        TableColumn<pacientes, String> HistorialTabla  = new TableColumn("Historial");
        HistorialTabla  .setCellValueFactory(new PropertyValueFactory<>("Historial"));
        tabla.getColumns().addAll(HistorialTabla );

        TableColumn<pacientes, String> PlantaTabla  = new TableColumn("Planta");
        PlantaTabla  .setCellValueFactory(new PropertyValueFactory<>("Historial"));
        tabla.getColumns().addAll(PlantaTabla );

        TableColumn<pacientes, String> cveRehabTabla  = new TableColumn("Rehabilitacion");
        cveRehabTabla .setCellValueFactory(new PropertyValueFactory<>("Rehabilitacion"));
        tabla.getColumns().addAll(cveRehabTabla );




        hBox.setPadding(new Insets(10));

        Anadir = new Button();
        Anadir.setText("Ingresar Paciente");
        Anadir.setPadding(new Insets(5));
        Anadir.setMaxSize(300,1);
        Anadir.setOnAction(event -> {                 });



        DarAlta = new Button();
        DarAlta.setText("Dar de alta ");
        DarAlta.setPadding(new Insets(1));
        DarAlta.setMaxSize(300,1);
        DarAlta.setOnAction(event1 -> {                  });

        vBox2.getChildren().addAll(Anadir,DarAlta);
        //vBox2.setSpacing(1);

        vBox.getChildren().addAll(nss,nssText, nombre,nombText,sexo,sexoText,Idpaciente,IdpacienteText,FechaNac,FechaNacText,IdHist,IdHistText,IdPlanta,IdPlantaText,cveRehab,cveRehabText);

        vBox.setSpacing(5);
        vBox2.setSpacing(10);
        hBox.setSpacing(5);
        //hBox.setPadding(new Insets(15));

        hBox.getChildren().addAll(vBox, tabla, vBox2);




        escena = new Scene(hBox, 1000, 650);

    }



    @Override
    public void handle(Event event) {
    }
}