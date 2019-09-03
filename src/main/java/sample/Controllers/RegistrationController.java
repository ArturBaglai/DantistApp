package sample.Controllers;

//import com.github.javafaker.Faker;
import DAOimpl.DoctorDAOimpl;
import Services.DoctorService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import model.Doctor;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import model.Doctor;

public class RegistrationController {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;


    @FXML
    private TextField persId;

    @FXML
    private TextField singUpEmail;

    @FXML
    private TextField signUpPhone;

    @FXML
    private TextField signUpAdress;
    @FXML
    private TextField signUpPassword;
    @FXML
    private TextField repeatPassword;

    @FXML
    private TextField userName;

    @FXML
    private ComboBox comboboxRole;
    @FXML
    private Button register;

    public static ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    void initialize() {
        String role1 ="Администратор";
        String role2 ="Врач";
        list.add(role1);
        list.add(role2);
        comboboxRole.setItems(list);

        String name = firstName.getText().trim();
        String surname = lastName.getText().trim();

        register.setOnAction(event -> {
            try {

                signUpNewUser();

            } catch (SQLException ex) {
                Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Доктор с таким именем пользователя уже существует");
            }

        });

    }

    private void signUpNewUser() throws SQLException{

        DoctorService doctorService = new DoctorService();
        DoctorDAOimpl doctorDAOimpl = new DoctorDAOimpl();


        String name = firstName.getText();
        String secondName = lastName.getText();
        String personalId = persId.getText();
        String email = singUpEmail.getText();
        String phone = signUpPhone.getText();
        String adress = signUpAdress.getText();
        String password = signUpPassword.getText();
        String username = userName.getText();
        String role = comboboxRole.getValue().toString();

        Doctor doc = new Doctor(name, personalId, email, phone, adress, password, secondName, username, role);


        if(doctorDAOimpl.checkIfUserNameExists(username)==true){
            System.out.println("Доктор с таким именем пользователя уже существует");
        }else if(doctorDAOimpl.checkIfUserNameExists(username)==false){
            doctorService.saveDoctor(doc);
        }


    }




    private static boolean checkEmail(TextField singUpEmail) {

        String EMAIL_PATTERN = "^[a-zA-Z0-9]{1,20}.[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher regexMatcher =pattern.matcher(singUpEmail.getText());
        if(regexMatcher.matches()){
            System.out.println("вы ввели верный формат email");

            return true;
        }  else {
            System.out.println("вы ввели неверный формат email");
            return false;
        }
    }
}
