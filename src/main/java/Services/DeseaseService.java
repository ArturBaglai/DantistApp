package Services;

import DAOimpl.DeseaseDAOimpl;
import javafx.collections.ObservableList;
import model.Desease;

import java.util.List;

public class DeseaseService {
    DeseaseDAOimpl deseaseDAOimpl = new DeseaseDAOimpl();
    public void saveDesease (Desease desease){
        deseaseDAOimpl.saveDesease(desease);
    }
    public void updateDesease (Desease desease){
        deseaseDAOimpl.updateDesease(desease);
    }
    public void deleteDesease (Desease desease){
        deseaseDAOimpl.deleteDesease(desease);
    }
    public ObservableList<Desease> getDeseaseNames(){

        return deseaseDAOimpl.getDeseaseNames();
    }
}
