package DAO;

import javafx.collections.ObservableList;
import model.Desease;

public interface DeseaseDAO {
    public void saveDesease(Desease desease);
    public void updateDesease(Desease desease);
    public void deleteDesease(Desease desease);
    public ObservableList<Desease> getDeseaseNames();
}
