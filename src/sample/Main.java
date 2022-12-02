package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.models.conexion;
//import sample.models.conexion;



public class Main extends Application {

    private VBox vBox;
    private MenuBar MenuBarras;
    private Menu Doctores, Pacientes, Cirugias, Habitacion, Puestos;
    private MenuItem ingDoc, ingTer;
    private MenuItem regrPaciente, rehbPacientes;
    private MenuItem Cargos, Turnos;
    private MenuItem ProCirug,conCirug;
    private MenuItem habitaciones;

    private HBox hBox;


    @Override
    public void start(Stage primaryStage) throws Exception{



        vBox=new VBox();
        MenuBarras = new MenuBar();
        //Menus en la barra de menus
        Doctores = new Menu("Doctores");
        Pacientes = new Menu("Pacientes");
        Cirugias = new Menu("Cirugias");
        Habitacion = new Menu("Habitaciones");
        Puestos = new Menu("Cargos y Turnos");


        //Aquí agregamos los botones a la barra de menu
        MenuBarras.getMenus().addAll(Doctores, Pacientes,Cirugias, Habitacion, Puestos);

        ingDoc = new MenuItem("Añadir doctores");
        ingDoc.setOnAction(event -> EventosDoctores(1));

        ingTer = new MenuItem("Añadir Terapeuta");
        ingTer.setOnAction(event -> EventosDoctores(2));

        regrPaciente = new MenuItem("Registrar paciente");
        regrPaciente.setOnAction(event -> EventosPacientes(1));
        rehbPacientes = new MenuItem("Pacientes en rehabilitacion");
        rehbPacientes.setOnAction(event -> EventosPacientes(2));

        Cargos = new MenuItem("Cargo");
        Cargos.setOnAction(event -> EventosPuestos(1));
        Turnos = new MenuItem("Turnos");
       Turnos.setOnAction(event -> EventosPuestos(2));

       ProCirug = new MenuItem("Programar cirugía");
       ProCirug.setOnAction(event -> EventosCirugia(1));
       conCirug = new MenuItem("Consultar cirugia");
       conCirug.setOnAction(event -> EventosCirugia(2));

        habitaciones = new MenuItem("Ver habitaciones");
        habitaciones.setOnAction(event -> EventosHabitacion(1));








        Doctores.getItems().addAll(ingDoc, ingTer);
        Pacientes.getItems().addAll(regrPaciente,rehbPacientes);
        Puestos.getItems().addAll(Cargos,Turnos);
        Cirugias.getItems().addAll(ProCirug, conCirug);
        Habitacion.getItems().addAll(habitaciones);


        //Aquí se agrega todo al vBox
        vBox.getChildren().addAll(MenuBarras);


       Scene escena = new Scene (vBox,1280,720);


        Image logo = new Image("sample/Images/logodehospital.png");
        primaryStage.getIcons().add(logo);
      //  escena.getStylesheets().add(getClass().getResource("src/sample/css/styles.css").toExternalForm());


        primaryStage.setTitle("Hospital ");
        primaryStage.setScene(escena);

        primaryStage.show();


        conexion.crearConexion();
    }

    private void EventosDoctores(int i){
        switch (i){
            case 1: new doctores(); break;
            case 2: new terapeuta(); break;
        }
    }

    private void EventosPacientes(int i){
        switch (i){
            case 1: new pacientes(); break;
            case 2: new rehabilitacion();break;
        }

    }

    private void EventosPuestos(int i){
        switch (i)
        {
            case 1:new puestos(); break;
            case 2: new Turnos(); break;
        }
    }

    private void EventosCirugia(int i){
        switch (i)
        {
            case 1: new cirugia();break;
            case 2: new consultarCirugia(); break;
        }
    }

    private void EventosHabitacion(int i ){
        switch (i){
            case 1:new habitaciones(); break;

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}



