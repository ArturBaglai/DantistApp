package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author BagMih
 */
public class AdministratorController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;
    @FXML
    private Button deleteDcotor;

    @FXML
    private Button changeUser;
    @FXML
    private TableView table;

    @FXML
    public void initialize(){
        deleteDcotor.setOnAction(event->{

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/deleteDoctor.fxml"));


            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }
}
