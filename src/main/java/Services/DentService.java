package Services;

import DAOimpl.DentDAOimpl;
import model.Dent;

public class DentService {
    private DentDAOimpl dentDAOimpl = new DentDAOimpl();
    public void saveDent (Dent dent){
        dentDAOimpl.saveDent(dent);
    }
    public void updateDent (Dent dent){
        dentDAOimpl.updateDent(dent);
    }
    public void delteDent (Dent dent){
        dentDAOimpl.deleteDent(dent);
    }
}
