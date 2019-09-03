package sample.Controllers;

import DAOimpl.DoctorDAOimpl;
import DAOimpl.PatientDAOimpl;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import model.Doctor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import model.Patient;

import java.io.IOException;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class AddPatientsController {
    @FXML
    private ResourceBundle resourses;


    @FXML
    public TextField name;
    @FXML
    public TextField lastName;


    @FXML
    public TextField adress;
    @FXML
    public TextField email;
    @FXML
    public TextField telefon;
    @FXML
    public TextField personalid;
    @FXML
    private Button registerConsultation;
    @FXML
    private Tab teethFormula;
    @FXML
    private DatePicker datePiker;
    @FXML
    private  Label docName;
    @FXML
    private Label doctorLastName;



    @FXML
    private TextField time;
    @FXML
    private ImageView teeth18;
    @FXML
       void  initialize(){

        registerConsultation.setOnAction(event -> {

            registerPatients();
        });
        DoctorDAOimpl daoImpl = new DoctorDAOimpl ();
        Doctor doctor = new Doctor();
            /*
            for (Doctor doc : SignUpController.doctorFirstNameAndLstNameLoggedIn) {
                String firstName=doc.getFIRSTNAME();
                String lastName= doc.getLASTNAME();
            docName.setText(firstName);
            doctorLastName.setText(lastName);
        }*/

        for (int i = 0; i < SignUpController.doctorFirstName.size(); i++) {
            String firstName =(String) SignUpController.doctorFirstName.get(i);
            docName.setText(firstName);

        }


          for (int i = 0; i < SignUpController.doctorLastNameLoggedIn.size(); i++) {
          String lastName =(String) SignUpController.doctorLastNameLoggedIn.get(i);
          doctorLastName.setText(lastName);

        }
        //docName.setText(daoImpl.findDoctrorNameByUserName().toString());

    }

    public void mousePressed() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        // AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/dentHistory.fxml"));
        //AddPatientsAnchorPane.getChildren().setAll(pane);
        loader.setLocation(getClass().getResource("/dentHistory.fxml"));


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
    private void registerPatients() {
        //DatabaseHandler dbhendeler = new DatabaseHandler();
        PatientDAOimpl patientDAOimpl = new PatientDAOimpl() ;

        //Calendar date = Calendar.getInstance();

        String firstName = name.getText();
        String patientId = personalid.getText();
        String mail = email.getText();
        String  patientAdress= adress.getText();
        String  phone= telefon.getText();
        String secondName = lastName.getText();
        LocalDate visitdate = datePiker.getValue();
        String visitTime = time.getText();

        String doctorSurnameName = doctorLastName.getText();

        Doctor doctor = new Doctor();


        // String doctorUserName = SignUpController.userName.toString();

        for (int i = 0; i <SignUpController.doctorIdLoggedIn.size(); i++) {

            int doctorId=  Integer.parseInt(SignUpController.doctorIdLoggedIn.get(i).toString());
            Patient patient = new Patient(firstName,patientId,mail,patientAdress,phone,secondName,visitdate,doctorId,visitTime );
            //dbhendeler.registerPatient(patient);
            patientDAOimpl.savePatient(patient);
        }

    }
}
