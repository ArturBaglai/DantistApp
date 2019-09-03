package sample.Controllers;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController {

    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;
    @FXML
    private MenuItem camSettings;


    @FXML
    private Button patients;
    @FXML
    private Button schedule;

    @FXML
    private Button UsbCam;
    @FXML
    private Button xray;


    @FXML
    private Button chat;
    @FXML
    private Button email;
    @FXML
    private Button cassa;
    @FXML
    private VBox dataPane;

    @FXML
    void  initialize() {
        patients.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/addPatients.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("patients");
            stage.setMinHeight(433);
            stage.setMinWidth(672);
            //stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        });
        schedule.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Schedule.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("Schedule");
            stage.setMinHeight(433);
            stage.setMinWidth(672);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
           // stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        });

        UsbCam.setOnAction(event -> {


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

            JFrame window = new JFrame("webCamera");
            window.add(panel);
            window.setLayout(new GridBagLayout());

            window.setResizable(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setSize(700,800);
            window.setLayout(new GridBagLayout());

            JButton button= new JButton("снять фото");
            button.setBounds(100,50,200,400);

            button.setVisible(true);
            button.setLocation(232,500);
            button.setLayout(new FlowLayout());
            window.add(button);


        });

        email.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Views/newMailMessage.fxml"));


        });
        }

        public void setDataPane(Node node){
            dataPane.getChildren().setAll(node);
        }


    public void loadPane(MouseEvent mouseEvent) {
        //setDataPane(FXMLLoader.load(getClass().getResource("/sample/Views/.fxml")));
    }
}



