package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import java.util.List;

public class EstoqueController extends Nav {
    @FXML private TableView<Product> table;
    @FXML private TextField nameField,typeField,qtyField,costField,priceField;

    ObservableList<Product> data;

    public void initialize(){
        List<Product> list = JsonStore.loadList("data/products.json", Product.class);
        data = FXCollections.observableArrayList(list);
        table.setItems(data);
    }

    @FXML void addProduct(){
        try{
            Product p = new Product(
                nameField.getText(),
                typeField.getText(),
                Integer.parseInt(qtyField.getText()),
                Double.parseDouble(costField.getText()),
                Double.parseDouble(priceField.getText())
            );
            data.add(p);
            JsonStore.saveList("data/products.json", data);
        }catch(Exception e){ e.printStackTrace(); }
    }

    @FXML void deleteProduct(){
        Product p = table.getSelectionModel().getSelectedItem();
        if(p==null) return;
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,"Excluir?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
            data.remove(p);
            JsonStore.saveList("data/products.json", data);
        }
    }
}
