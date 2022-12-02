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
import sample.models.PacientesDAO;



public class pacientes extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox, vBox2;
    private PacientesDAO pDAO;
    private Label nss, nombre, sexo;
    private Label Idpaciente, FechaNac, IdHist, IdPlanta,cveRehab,IdCuarto,IdCama;

    private TextArea nssText, nombText, sexoText;
    private TextArea IdpacienteText, FechaNacText, IdHistText, IdPlantaText,cveRehabText,IdCuartoText,IdCamaText;
    private Button Anadir,DarAlta;
    private TableView tabla;

    private Scene escena;


    public pacientes() {
        pDAO = new PacientesDAO();
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
        IdCuarto = new Label();
        IdCama = new Label();

        nssText = new TextArea();
        nombText = new TextArea();
        sexoText = new TextArea();
        IdpacienteText = new TextArea();
        FechaNacText = new TextArea();
        IdHistText = new TextArea();
        IdPlantaText = new TextArea();
        cveRehabText = new TextArea();
        IdCuartoText = new TextArea();
        IdCamaText = new TextArea();

        nssText.setMaxSize(150, 1);
        nombText.setMaxSize(150, 1);
        sexoText.setMaxSize(150, 1);
        IdpacienteText.setMaxSize(150, 1);
        FechaNacText.setMaxSize(150, 1);
        IdPlantaText.setMaxSize(150, 1);
        IdHistText.setMaxSize(150, 1);
        cveRehabText.setMaxSize(150, 1);
        IdCuartoText.setMaxSize(150,1);
        IdCamaText.setMaxSize(150,1);

        nss.setText("Número de Seguridad Social");
        nombre.setText("Nombre");
        sexo.setText("Sexo");
        Idpaciente.setText("Numero de Identificacion");
        FechaNac.setText("Fecha de nacimiento --/--/--");
        IdHist.setText("Identificador historial medico");
        IdPlanta.setText("Numero de planta");
        cveRehab.setText("Clave de rehabilitacion");
        IdCuarto.setText("Numero de cuarto");
        IdCama.setText("Numero de cama");

        tabla = new TableView();
        tabla.setMaxSize(800, 350);
        tabla.setEditable(true);

        TableColumn<PacientesDAO, String> nssTabla = new TableColumn("NSS");
        nssTabla.setCellValueFactory(new PropertyValueFactory<>("NSS"));
        tabla.getColumns().addAll(nssTabla);

        TableColumn<PacientesDAO, String> nombreTabla = new TableColumn("Nombre");
        nombreTabla .setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tabla.getColumns().addAll(nombreTabla );

        TableColumn<PacientesDAO, String> sexoTabla  = new TableColumn("Sexo");
        sexoTabla .setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tabla.getColumns().addAll(sexoTabla);

        TableColumn<PacientesDAO, String> IdPacienteTabla  = new TableColumn("IdPaci");
        IdPacienteTabla .setCellValueFactory(new PropertyValueFactory<>("IdPaci"));
        tabla.getColumns().addAll(IdPacienteTabla);

        TableColumn<PacientesDAO, String> FechaNacTabla  = new TableColumn("FNacimiento");
        FechaNacTabla  .setCellValueFactory(new PropertyValueFactory<>("FNacimiento"));
        tabla.getColumns().addAll(FechaNacTabla );

        TableColumn<PacientesDAO, String> HistorialTabla  = new TableColumn("IdHist");
        HistorialTabla  .setCellValueFactory(new PropertyValueFactory<>("IdHist"));
        tabla.getColumns().addAll(HistorialTabla );

        TableColumn<PacientesDAO, String> PlantaTabla  = new TableColumn("IdPlanta");
        PlantaTabla  .setCellValueFactory(new PropertyValueFactory<>("IdPlanta"));
        tabla.getColumns().addAll(PlantaTabla );

        TableColumn<PacientesDAO, String> cveRehabTabla  = new TableColumn("CveRehab");
        cveRehabTabla .setCellValueFactory(new PropertyValueFactory<>("CveRehab"));
        tabla.getColumns().addAll(cveRehabTabla );

        TableColumn<PacientesDAO, String> CuartoTabla  = new TableColumn("IdCuarto");
        CuartoTabla .setCellValueFactory(new PropertyValueFactory<>("IdCuarto"));
        tabla.getColumns().addAll(CuartoTabla );

        TableColumn<PacientesDAO, String> CamaTabla  = new TableColumn("IdCama");
        CamaTabla .setCellValueFactory(new PropertyValueFactory<>("IdCama"));
        tabla.getColumns().addAll(CamaTabla );
        tabla.setItems(pDAO.SELECCIONAR());


        hBox.setPadding(new Insets(10));

        Anadir = new Button();
        Anadir.setText("Ingresar Paciente");
        Anadir.setPadding(new Insets(5));
        Anadir.setMaxSize(300,1);
        Anadir.setOnAction(event -> {
            pDAO.setNSS(Integer.parseInt(this.nssText.getText()));
            pDAO.setNombre(this.nombText.getText());
            pDAO.setSexo(this.sexoText.getText());
            pDAO.setIdPaci(Integer.parseInt(this.IdpacienteText.getText()));
            pDAO.setFNacimiento(this.FechaNacText.getText());
            pDAO.setIdHist(Integer.parseInt(this.IdHistText.getText()));
            pDAO.setIdPlanta(Integer.parseInt(this.IdPlantaText.getText()));
            pDAO.setCveRehab(Integer.parseInt(this.cveRehabText.getText()));
            pDAO.setIdCuarto(Integer.parseInt(this.IdCuartoText.getText()));
            pDAO.setIdCama(Integer.parseInt(this.IdCamaText.getText()));
            pDAO.INSERTAR();
            tabla.setItems(pDAO.SELECCIONAR());
            tabla.refresh();
        });



        DarAlta = new Button();
        DarAlta.setText("Dar de alta ");
        DarAlta.setPadding(new Insets(1));
        DarAlta.setMaxSize(300,1);
        DarAlta.setOnAction(event1 -> {                  });

        vBox2.getChildren().addAll(Anadir);
        //vBox2.setSpacing(1);

        vBox.getChildren().addAll(nss,nssText, nombre,nombText,sexo,sexoText,Idpaciente,IdpacienteText,FechaNac,FechaNacText,IdHist,IdHistText,IdPlanta,IdPlantaText,cveRehab,cveRehabText,IdCama,IdCamaText,IdCuarto,IdCuartoText);

        vBox.setSpacing(5);
        vBox2.setSpacing(10);
        hBox.setSpacing(5);
        //hBox.setPadding(new Insets(15));

        hBox.getChildren().addAll(vBox, tabla, vBox2);




        escena = new Scene(hBox, 1300, 650);

    }



    @Override
    public void handle(Event event) {
    }
}