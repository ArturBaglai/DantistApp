package sample.Controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class WebCamController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;
    @FXML
    private Button capture;
    @FXML
    private Pane ImageHolder;

    @FXML
    void initialize() {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(176, 144));

        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setBounds(400,300,450,400);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        panel.setSize(234,345);


    }


}
