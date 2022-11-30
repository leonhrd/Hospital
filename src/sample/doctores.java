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
import sample.models.DoctoresDAO;
import sample.models.NominaDAO;


public class doctores extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox;
    private DoctoresDAO dDAO;
    private NominaDAO nDAO;

    private Label clave, nombre, sexo, especialidad;
    private Label cveNomina, nss, Cedula, salario,turno;
    private TextArea clavText, nombText, sexoText;
    private TextArea cveNominaText, nssText, CedulaText, salarioText, especiText,turnoText;
    private Button Anadir;
    private TableView tabla;

    private Scene escena;


    public doctores() {
        dDAO = new DoctoresDAO();
        nDAO = new NominaDAO();
        crearInterfaz();
        this.setTitle("Doctores de Hospital ");
        this.setScene(escena);

        Image logo = new Image("sample/Images/equipoMedico.png");

        this.getIcons().add(logo);
        this.show();

    }

    private void crearInterfaz() {
        vBox = new VBox();
        hBox = new HBox();

        clave = new Label();
        nombre = new Label();
        sexo = new Label();
        cveNomina = new Label();
        especialidad = new Label();
        nss = new Label();
        Cedula = new Label();
        salario = new Label();
        turno = new Label();


        clavText = new TextArea();
        nombText = new TextArea();
        sexoText = new TextArea();
        cveNominaText = new TextArea();
        especiText = new TextArea();
        nssText = new TextArea();
        CedulaText = new TextArea();
        salarioText = new TextArea();
        turnoText = new TextArea();

        clavText.setMaxSize(250, 1);
        nombText.setMaxSize(250, 1);
        sexoText.setMaxSize(250, 1);
        cveNominaText.setMaxSize(250, 1);
        especiText.setMaxSize(250,1);
        nssText.setMaxSize(250, 1);
        CedulaText.setMaxSize(250, 1);
        salarioText.setMaxSize(250, 1);
        turnoText.setMaxSize(250, 1);

        clave.setText("Clave");
        nombre.setText("Nombre");
        sexo.setText("Sexo");
        cveNomina.setText("Nomina");
        especialidad.setText("Especialidad");
        nss.setText("nss");
        Cedula.setText("Cedula");
        salario.setText("Salario");
        turno.setText("Turno");

        tabla = new TableView();
        tabla.setMaxSize(650, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveTabla = new TableColumn("Clave");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("CveDoctor"));
        tabla.getColumns().addAll(claveTabla);

        TableColumn<doctores, String> nombreTabla = new TableColumn("Nombre");
        nombreTabla.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tabla.getColumns().addAll(nombreTabla);

        TableColumn<doctores, String> sexoTabla = new TableColumn("Sexo");
        sexoTabla.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tabla.getColumns().addAll(sexoTabla);

        TableColumn<doctores, String> NominaTabla = new TableColumn("Nomina");
        NominaTabla .setCellValueFactory(new PropertyValueFactory<>("CveNomina"));
        tabla.getColumns().addAll(NominaTabla );

        TableColumn<doctores, String> EspecTabla = new TableColumn("Especialidad");
        EspecTabla .setCellValueFactory(new PropertyValueFactory<>("CveEsp"));
        tabla.getColumns().addAll(EspecTabla );

        TableColumn<doctores, String> nssTabla = new TableColumn("nss");
        nssTabla .setCellValueFactory(new PropertyValueFactory<>("NSS"));
        tabla.getColumns().addAll(nssTabla );

        TableColumn<doctores, String> cedulaTabla = new TableColumn("Cedula");
        cedulaTabla.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tabla.getColumns().addAll(cedulaTabla);

        TableColumn<doctores, String> salarioTabla = new TableColumn("Salario");
        salarioTabla.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tabla.getColumns().addAll(salarioTabla);
        tabla.setItems(dDAO.SELECCIONAR());


        hBox.setPadding(new Insets(60));
        //vBox.setPadding(new Insets(50));

        Anadir = new Button();
        Anadir.setText("Registrar Doctor");
        Anadir.setPadding(new Insets(20));
        Anadir.setMaxSize(350,10);
        Anadir.setOnAction(Event ->{
            nDAO.setCveNomina(Integer.parseInt(this.cveNominaText.getText()));

            nDAO.setNSS(Integer.parseInt(this.nssText.getText()));
            nDAO.setCedula(Integer.parseInt(this.CedulaText.getText()));
            nDAO.setSalario(Integer.parseInt(this.salarioText.getText()));
            nDAO.INSERTAR();
            dDAO.setCveDoctor(Integer.parseInt(this.clavText.getText()));
            dDAO.setNombre(this.nombText.getText());
            dDAO.setSexo(this.sexoText.getText());
            dDAO.setCveNomina(Integer.parseInt(this.cveNominaText.getText()));
            dDAO.setCveEsp(Integer.parseInt(this.especiText.getText()));
            dDAO.setCveTurno(Integer.parseInt(this.turnoText.getText()));
            dDAO.INSERTAR();
            tabla.setItems(dDAO.SELECCIONAR());
            tabla.refresh();
        });

        vBox.getChildren().addAll(clave, clavText, nombre, nombText, sexo, sexoText, cveNomina, cveNominaText, especialidad, especiText, nss, nssText, Cedula, CedulaText, salario, salarioText,turno,turnoText, Anadir);
        vBox.setSpacing(5);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15));

        hBox.getChildren().addAll(vBox, tabla);



        escena = new Scene(hBox, 1000, 700);

    }



    @Override
    public void handle(Event event) {
    }
}
