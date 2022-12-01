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
import sample.models.TerapeutaDAO;


public class terapeuta extends Stage implements EventHandler {

    private HBox hBox;
    private VBox vBox;

    private Label clave, nombre, sexo, especialidad;

    private TextArea clavText, nombText, sexoText, espText;

    private Button Anadir;
    private TableView tabla;
    private TerapeutaDAO tDAO;

    private Scene escena;


    public terapeuta() {
        tDAO = new TerapeutaDAO();
        crearInterfaz();
        this.setTitle("Terapeutas de Hospital ");
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
        especialidad = new Label();


        clavText = new TextArea();
        nombText = new TextArea();
        sexoText = new TextArea();
        espText= new TextArea();




        clavText.setMaxSize(250, 1);
        nombText.setMaxSize(250, 1);
        sexoText.setMaxSize(250, 1);

        espText.setMaxSize(250,1);


        clave.setText("Clave");
        nombre.setText("Nombre");
        sexo.setText("Sexo");

        especialidad.setText("Especialidad");


        tabla = new TableView();
        tabla.setMaxSize(650, 350);
        tabla.setEditable(true);

        TableColumn<doctores, String> claveTabla = new TableColumn("Clave");
        claveTabla.setCellValueFactory(new PropertyValueFactory<>("CveTer"));
        tabla.getColumns().addAll(claveTabla);

        TableColumn<doctores, String> nombreTabla = new TableColumn("Nombre");
        nombreTabla.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tabla.getColumns().addAll(nombreTabla);

        TableColumn<doctores, String> sexoTabla = new TableColumn("Sexo");
        sexoTabla.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tabla.getColumns().addAll(sexoTabla);

        TableColumn<doctores, String> EspecTabla = new TableColumn("Especialidad");
        EspecTabla .setCellValueFactory(new PropertyValueFactory<>("EspD"));
        tabla.getColumns().addAll(EspecTabla );
        tabla.setItems(tDAO.SELECCIONAR());



        hBox.setPadding(new Insets(60));
        //vBox.setPadding(new Insets(50));

        Anadir = new Button();
        Anadir.setText("Registrar Terapeuta");
        Anadir.setPadding(new Insets(20));
        Anadir.setMaxSize(350,10);
        Anadir.setOnAction(Event ->{
            tDAO.setCveTer(Integer.parseInt(clavText.getText()));
            tDAO.setNombre(nombText.getText());
            tDAO.setSexo(sexoText.getText());
            tDAO.setCveEsp(Integer.parseInt(espText.getText()));
            tDAO.INSERTAR();
            tabla.setItems(tDAO.SELECCIONAR());
            tabla.refresh();
        });

        vBox.getChildren().addAll(clave, clavText, nombre, nombText, sexo, sexoText, especialidad, espText, Anadir);
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
