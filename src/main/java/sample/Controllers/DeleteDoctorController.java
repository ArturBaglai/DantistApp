package sample.Controllers;
import Services.DoctorService;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteDoctorController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private TextField doctorPersonalId;
    @FXML
    private Button deleteDoctor;
    @FXML
    void initialize() {
        deleteDoctor.setOnAction(event-> {
            DoctorService doctorService = new DoctorService();
            doctorService.deleteDoctorByPersonalCode(doctorPersonalId.getText());

        });

    }
}
