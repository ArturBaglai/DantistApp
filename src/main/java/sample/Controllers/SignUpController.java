package sample.Controllers;

import static sample.Controllers.RegistrationController.list;
import DAOimpl.DoctorDAOimpl;
import model.Doctor;
import Services.DoctorService;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
public  class SignUpController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;

    @FXML
    private   TextField userName;


    @FXML
    private PasswordField password;
    @FXML
    private ComboBox combobox;

    @FXML
    private Button singIn;
    @FXML
    private Button register;
    @FXML
    private Label logInAndPassNotCorrect;


    public static List doctorIdLoggedIn;

    public static List  doctorFirstName;
    public static List doctorLastNameLoggedIn;
    public static ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        String role1 ="Администратор";
        String role2 ="Врач";
        list.add(role1);
        list.add(role2);
        combobox.setItems(list);
        singIn.setOnAction(event -> {
            String username = userName.getText().trim();

            String loginPassword = password.getText().trim();

            if(!username.equals("")&& !loginPassword.equals("")) {
                DoctorDAOimpl docImpl = new DoctorDAOimpl();
                DoctorService service = new DoctorService();
                doctorFirstName= service.findDoctorFirstNameByDoctorUsername(username);
                doctorLastNameLoggedIn = service.findDoctorLastNameByDoctorUsername(username);
                doctorIdLoggedIn= service.findDoctorIdByDoctorUsername(username);
                // Doctor doc = new Doctor();
                if(docImpl.signginDoctor(username, loginPassword) == true) {
                    singIn.getScene().getWindow().hide();
                    //if(docImpl.checkDoctorRole(username,combobox.getValue().toString()).equals("Врач")){


                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/mainWindow.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
            /*
                    } else if (docImpl.checkDoctorRole(username,combobox.getValue().toString()).equals("Администратор")) {

                        FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/Administrator.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

                    }
                    */


                }else{
                    logInAndPassNotCorrect.setText("Неверное имя пользователя или пароль"); ;
                }


            }
            else logInAndPassNotCorrect.setText("Введите имя пользователя и пароль");

        });

        register.setOnAction(event -> {
            register.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/registration.fxml"));


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

    public  void openNewScene(String window){
        singIn.setOnAction(event -> {
            singIn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));


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
