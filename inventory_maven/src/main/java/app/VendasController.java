package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import java.time.LocalDate;
import java.util.List;

public class VendasController extends Nav {
    @FXML private ComboBox<String> productBox;
    @FXML private TextField qtyField;
    @FXML private TableView<Sale> table;

    ObservableList<Sale> data;
    List<Product> products;

    public void initialize(){
        products = JsonStore.loadList("data/products.json", Product.class);
        productBox.getItems().setAll(products.stream().map(p->p.name).toList());
        data = javafx.collections.FXCollections.observableArrayList(
            JsonStore.loadList("data/sales.json", Sale.class)
        );
        table.setItems(data);
    }

    @FXML void addSale(){
        try{
            String prod = productBox.getValue();
            int qty = Integer.parseInt(qtyField.getText());
            Product selected = products.stream().filter(p->p.name.equals(prod)).findFirst().orElse(null);
            if(selected==null) return;
            double total = qty * selected.price;

            Sale s = new Sale();
            s.product = prod;
            s.quantity = qty;
            s.total = total;
            s.date = LocalDate.now().toString();

            data.add(s);
            JsonStore.saveList("data/sales.json", data);
        }catch(Exception e){ e.printStackTrace(); }
    }
}
