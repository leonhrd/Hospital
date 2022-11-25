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


public class doctores extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox;

    private Label clave, nombre, sexo, especialidad;
    private Label cveNomina, nss, Cedula, salario;
    private TextArea clavText, nombText, sexoText;
    private TextArea cveNominaText, nssText, CedulaText, salarioText, especiText;
    private Button Anadir;
    private TableView tabla;

    private Scene escena;


    public doctores() {
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

        clavText = new TextArea();
        nombText = new TextArea();
        sexoText = new TextArea();
        cveNominaText = new TextArea();
        especiText = new TextArea();
        nssText = new TextArea();
        CedulaText = new TextArea();
        salarioText = new TextArea();

        clavText.setMaxSize(250, 1);
        nombText.setMaxSize(250, 1);
        sexoText.setMaxSize(250, 1);
        cveNominaText.setMaxSize(250, 1);
        especiText.setMaxSize(250,1);
        nssText.setMaxSize(250, 1);
        CedulaText.setMaxSize(250, 1);
        salarioText.setMaxSize(250, 1);

        clave.setText("Clave");
        nombre.setText("Nombre");
        sexo.setText("Sexo");
        cveNomina.setText("Nomina");
        especialidad.setText("Especialidad");
        nss.setText("nss");
        Cedula.setText("Cedula");
        salario.setText("Salario");

        tabla = new TableView();
        tabla.setMaxSize(650, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveTabla = new TableColumn("Clave");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("Clave"));
        tabla.getColumns().addAll(claveTabla);

        TableColumn<doctores, String> nombreTabla = new TableColumn("Nombre");
        nombreTabla.setCellValueFactory(new PropertyValueFactory<>("Clave"));
        tabla.getColumns().addAll(nombreTabla);

        TableColumn<doctores, String> sexoTabla = new TableColumn("Sexo");
        sexoTabla.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tabla.getColumns().addAll(sexoTabla);

        TableColumn<doctores, String> NominaTabla = new TableColumn("Nomina");
        NominaTabla .setCellValueFactory(new PropertyValueFactory<>("Nomina"));
        tabla.getColumns().addAll(NominaTabla );

        TableColumn<doctores, String> EspecTabla = new TableColumn("Especialidad");
        EspecTabla .setCellValueFactory(new PropertyValueFactory<>("Especilidad"));
        tabla.getColumns().addAll(EspecTabla );

        TableColumn<doctores, String> nssTabla = new TableColumn("nss");
        nssTabla .setCellValueFactory(new PropertyValueFactory<>("nss"));
        tabla.getColumns().addAll(nssTabla );

        TableColumn<doctores, String> cedulaTabla = new TableColumn("Cedula");
        cedulaTabla.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
        tabla.getColumns().addAll(cedulaTabla);

        TableColumn<doctores, String> salarioTabla = new TableColumn("Salario");
        salarioTabla.setCellValueFactory(new PropertyValueFactory<>("Salario"));
        tabla.getColumns().addAll(salarioTabla);

        hBox.setPadding(new Insets(60));
        //vBox.setPadding(new Insets(50));

        Anadir = new Button();
        Anadir.setText("Registrar Doctor");
        Anadir.setPadding(new Insets(20));
        Anadir.setMaxSize(350,10);

        vBox.getChildren().addAll(clave, clavText, nombre, nombText, sexo, sexoText, cveNomina, cveNominaText, especialidad, especiText, nss, nssText, Cedula, CedulaText, salario, salarioText, Anadir);
        vBox.setSpacing(5);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15));

        hBox.getChildren().addAll(vBox, tabla);



        escena = new Scene(hBox, 1280, 600);

    }



    @Override
    public void handle(Event event) {
    }
}
