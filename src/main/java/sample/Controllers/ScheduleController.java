package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;


import DAOimpl.DoctorDAOimpl;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;


import java.net.URL;
import java.text.SimpleDateFormat;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
public class ScheduleController implements Initializable {
    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;

    @FXML
    public TableColumn time;

    @FXML
    public TableColumn monday;

    @FXML
    public TableColumn tuestady;

    @FXML
    public TableColumn wednesday;

    @FXML
    public TableColumn thursday;

    @FXML
    public TableColumn friday;

    @FXML
    public TableColumn saturday;

    @FXML
    public TableColumn sunday;

    private final static int dataSize = 100;
    @FXML
    public Pagination pagination;
    private final TableView<Data> table = createTable();
    private final List<Data> data = createData();
    private final static int rowsPerPage = 20;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pagination.setPageFactory(this::createPage);

    }
    private  TableView <Data>  createTable(){

        TableView<Data> table = new TableView<>();
        TableColumn<Data, String> timeColumn = new TableColumn<>("Время");
        timeColumn.setCellValueFactory(param -> param.getValue().time);
        timeColumn.setPrefWidth(100);

        TableColumn<Data, String> date = new TableColumn<>();
        date.setCellValueFactory(param -> param.getValue().date);
        date.setPrefWidth(100);
         /*
          TableColumn<Data, String> tuestadyColumn = new TableColumn<>("Вторник");
         tuestadyColumn.setCellValueFactory(param -> param.getValue().tuestady);
         tuestadyColumn.setPrefWidth(100);

         TableColumn<Data, String> wednesdayColumn = new TableColumn<>("Среда");
         wednesdayColumn.setCellValueFactory(param -> param.getValue().wednesday);
         wednesdayColumn.setPrefWidth(100);

          TableColumn<Data, String> thursdayColumn = new TableColumn<>("Четверг");
         thursdayColumn.setCellValueFactory(param -> param.getValue().thursday);
         thursdayColumn.setPrefWidth(100);

         TableColumn<Data, String> fridayColumn = new TableColumn<>("Пятница");
         fridayColumn.setCellValueFactory(param -> param.getValue().friday);
         fridayColumn.setPrefWidth(100);

         TableColumn<Data, String> saturdayColumn = new TableColumn<>("Суббота");
         saturdayColumn.setCellValueFactory(param -> param.getValue().saturday);
         saturdayColumn.setPrefWidth(100);

         TableColumn<Data, String> sundayColumn = new TableColumn<>("Воскресенье");
         sundayColumn.setCellValueFactory(param -> param.getValue().sunday);
         sundayColumn.setPrefWidth(100);

         table.getColumns().addAll(timeColumn,mondayColumn, tuestadyColumn, wednesdayColumn,thursdayColumn, fridayColumn,saturdayColumn,sundayColumn);
          */
        table.getColumns().addAll(timeColumn, date);

        return table;
    }

    private List<Data> createData(){
        DoctorDAOimpl doctorDAOimpl = new DoctorDAOimpl();
        List<Data> data = new ArrayList<>(dataSize);
        for (int i = 0; i < SignUpController.doctorIdLoggedIn.size(); i++) {
            String doctorId=  (String) SignUpController.doctorIdLoggedIn.get(i).toString();
            doctorDAOimpl.findAllPatientsByDoctorId(doctorId);

        }

        /*
        for (int i = 0; i <= dataSize; i++) {
           // data.add(null)
        }*/

        return data;
    }
    private Node createPage(int pageIndex){
        int index= pageIndex *rowsPerPage;
        int toIndex = Math.min(index + rowsPerPage, data.size());
        table.setItems(FXCollections.observableArrayList(createData()));
        return table;
    }

    public static class Data {


        private final SimpleStringProperty time;
        public final SimpleStringProperty date;
        /*
        private final SimpleStringProperty monday;

        private final SimpleStringProperty tuestady;
        private final SimpleStringProperty wednesday;
        private final SimpleStringProperty thursday;
        private final SimpleStringProperty friday;
        private final SimpleStringProperty saturday;
        private final SimpleStringProperty sunday;

         private final SimpleStringProperty firstName;
         private final SimpleStringProperty lastName;



        public Data(String time, String monday, String tuestady, String wednesday, String thursday, String friday, String saturday, String sunday, String firstName, String lastName, String date) {
            this.time = new SimpleStringProperty(time);
            this.monday =  new SimpleStringProperty(monday);
            this.tuestady = new SimpleStringProperty(tuestady) ;
            this.wednesday = new SimpleStringProperty(wednesday);
            this.thursday = new SimpleStringProperty(thursday);
            this.friday = new SimpleStringProperty(friday);
            this.saturday = new SimpleStringProperty(saturday);
            this.sunday = new SimpleStringProperty(sunday);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
           // this.date = new SimpleStringProperty(date);
        }
        */
        public Data (String time, String date){
            this.time = new SimpleStringProperty(time);
            this.date =  new SimpleStringProperty(date);
        }
        public static void getAllDatesINMonth(){ //http://javainfinite.com/java/get-all-dates-in-a-month-using-java/
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 6);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.format(cal.getTime()));
            for (int i = 1; i < maxDay; i++)
            {
                cal.set(Calendar.DAY_OF_MONTH, i + 1);
                System.out.println(df.format(cal.getTime()));
            }
        }


    }


}
