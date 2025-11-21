package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;

public class DashboardController extends Nav {
    @FXML private Label totalValue;
    @FXML private Label totalProducts;
    @FXML private Label totalSold;

    public void initialize(){
        List<Product> products = JsonStore.loadList("data/products.json", Product.class);
        List<Sale> sales = JsonStore.loadList("data/sales.json", Sale.class);

        double inventoryValue = products.stream().mapToDouble(p->p.cost*p.quantity).sum();
        int count = products.size();
        double sold = sales.stream().mapToDouble(s->s.total).sum();

        totalValue.setText("R$ "+inventoryValue);
        totalProducts.setText(""+count);
        totalSold.setText("R$ "+sold);
    }
}
