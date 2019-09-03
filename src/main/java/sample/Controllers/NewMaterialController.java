package sample.Controllers;

import DAOimpl.MaterialDAOImpl;
import model.Material;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Material;

/**
 *
 * @author BagMih
 */
public class NewMaterialController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private TextField materialName;

    @FXML
    private TextField materialPrice;

    @FXML
    private Button saveMaterial;

    @FXML
    public   void  initialize(){
        saveMaterial.setOnAction(event->{
            MaterialDAOImpl materialDAOImpl = new MaterialDAOImpl();

            String matName = materialName.getText();
            double price = Double.parseDouble(materialPrice.getText());
            Material material = new Material(matName,price);
            materialDAOImpl.saveMaterial(material);
        });

    }

}