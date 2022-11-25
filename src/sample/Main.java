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
import javafx.stage.Stage;



public class Main extends Application {

    private VBox vBox;
    private MenuBar MenuBarras;
    private Menu Doctores, Pacientes, Cirugias, Habitacion;
    private MenuItem ingDoc;
    private MenuItem regrPaciente;
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

        //Aquí agregamos los botones a la barra de menu
        MenuBarras.getMenus().addAll(Doctores, Pacientes,Cirugias, Habitacion );

        ingDoc = new MenuItem("Añadir doctores");
        ingDoc.setOnAction(event -> EventosDoctores(1));

        regrPaciente = new MenuItem("Registrar paciente");
        regrPaciente.setOnAction(event -> EventosPacientes(1));



        Doctores.getItems().addAll(ingDoc);
        Pacientes.getItems().addAll(regrPaciente);

        //Aquí se agrega todo al vBox
        vBox.getChildren().addAll(MenuBarras);



       Scene escena = new Scene (vBox,1280,720);

        Image logo = new Image("sample/Images/logodehospital.png");
        primaryStage.getIcons().add(logo);
      //  escena.getStylesheets().add(getClass().getResource("src/sample/css/styles.css").toExternalForm());


        primaryStage.setTitle("Hospital ");
        primaryStage.setScene(escena);

        primaryStage.show();
        ;

    }

    private void EventosDoctores(int i){
        switch (i){
            case 1: new doctores(); break;
        }
    }

    private void EventosPacientes(int i){
        switch (i){
            case 1: new pacientes(); break;
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}



