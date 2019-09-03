package DAO;
import model.Material;
import javafx.collections.ObservableList;

public interface MaterialDAO {
    public void saveMaterial(Material material);
    public ObservableList<Material> fildAllMaterials();
}
