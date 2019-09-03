/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Controllers;

/**
 *
 * @author BagMih
 */
import Services.DentService;
import Services.DeseaseService;
import Services.PatientService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.layout.TilePane;
import model.Dent;
import model.Desease;
import model.Material;
import model.Patient;
import Services.MaterialService;

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import jdk.nashorn.internal.objects.NativeArray;
import sample.Controllers.AddPatientsController;

public class DentHistoryController {

    @FXML
    private ResourceBundle resourses;

    @FXML
    private Button save;
    @FXML
    private Button addMaterial;
    @FXML
    private ComboBox dentDesease;
    @FXML
    private ComboBox materialCombobox;
    @FXML
    private DatePicker dentDate;


    private final ObservableList deseases = FXCollections.observableArrayList();
    private final ObservableList materials = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        save.setOnAction(event -> {
            //String firstName = name.
            //PatientService patientService = new PatientService();

            AddPatientsController addPatientsController = new AddPatientsController();
            String firstName = addPatientsController.name.getText();
            String personalid = addPatientsController.personalid.getText();
            String email = addPatientsController.email.getText();
            String adress = addPatientsController.adress.getText();
            String telefon = addPatientsController.telefon.getText();
            String lastName = addPatientsController.lastName.getText();

            Dent dent = new Dent();
            //dent.
            DentService dentService = new DentService();
            dentService.saveDent(dent);
        });
        //dentDesease.setOnAction((event -> {

        DeseaseService deseaseService = new DeseaseService();
        MaterialService materialService = new MaterialService();
        ObservableList<Desease> deseaseNames = FXCollections.observableList(deseaseService.getDeseaseNames());
        ObservableList<Material> materialsNames = FXCollections.observableList(materialService.findAllMaterials());

        for (Desease deseaseName : deseaseNames) {
            deseases.add(deseaseName.NAME);
            dentDesease.setItems(deseases);
            //dentDesease = new ComboBox(deseaseNames);
        }

        for (Material material : materialsNames) {
            materials.add(material.MATERIALNAME);
            materialCombobox.setItems(materials);
        }

        addMaterial.setOnAction(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/newMaterial.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("Новый мытериал");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        });

    }

}
