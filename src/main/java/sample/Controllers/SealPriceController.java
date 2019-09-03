package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author BagMih
 */
public class SealPriceController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;
    @FXML
    public ComboBox materialCombobox;
    @FXML
    public TextField price;
    @FXML
    public Button addMaterial;
    @FXML
    public Button save;

    @FXML
    public   void  initialize(){
        save.setOnAction(event->{
            materialCombobox.getValue();
            price.getText();
        });
    }
}
