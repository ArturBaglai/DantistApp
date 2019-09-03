package DAO;

import model.Dent;

public interface DentDAO {
    public void saveDent(Dent dent);
    public void updateDent(Dent dent);
    public void deleteDent(Dent dent);
}
