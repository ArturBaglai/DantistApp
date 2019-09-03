package Services;

import DAOimpl.MaterialDAOImpl;
import model.Material;
import javafx.collections.ObservableList;
import model.Material;

public class MaterialService {
    private MaterialDAOImpl materialDAOimpl = new MaterialDAOImpl();
    public void saveMaterial(Material material){
        materialDAOimpl.saveMaterial(material);
    }
    public ObservableList<Material> findAllMaterials(){
        return materialDAOimpl.fildAllMaterials();
    }
}
