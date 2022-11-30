package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.CargoDAO;






    public class puestos extends Stage implements EventHandler{

        private VBox vBox;
        private Scene escena;
        private TableView tabla;
        private CargoDAO cDAO;

        public puestos(){
            cDAO = new CargoDAO();
            creaInterfaz();

            this.setTitle("Cargos ");
            this.setScene(escena);

            Image logo = new Image("sample/Images/equipoMedico.png");

            this.getIcons().add(logo);
            this.show();


        }


        private void creaInterfaz(){
            vBox= new VBox();

            tabla = new TableView();
            tabla.setMaxSize(650, 350);
            tabla.setEditable(true);

            TableColumn<doctores, String> claveTabla = new TableColumn("CveCargo");
            claveTabla.setCellValueFactory(new PropertyValueFactory<>("CveCargo"));
            tabla.getColumns().addAll(claveTabla);

            TableColumn<doctores, String> DescTabla = new TableColumn("Descripcion");
            DescTabla.setCellValueFactory(new PropertyValueFactory<>("Descr"));
            tabla.getColumns().addAll( DescTabla);
            tabla.setItems(cDAO.SELECCIONAR());




            vBox.getChildren().addAll(tabla);
            vBox.setSpacing(5);
            vBox.setPadding(new Insets(15));

            escena = new Scene(vBox, 500,400);



        }













        @Override
        public void handle(Event event) {

        }
    }


