package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;

public class RelatoriosController extends Nav {
    @FXML private Label lucroLabel;

    public void initialize(){
        List<Product> products = JsonStore.loadList("data/products.json", Product.class);
        List<Sale> sales = JsonStore.loadList("data/sales.json", Sale.class);
        List<Investment> invs = JsonStore.loadList("data/investments.json", Investment.class);

        double invTotal = invs.stream().mapToDouble(i->i.amount).sum();
        double sold = sales.stream().mapToDouble(s->s.total).sum();
        double lucro = sold - invTotal;

        lucroLabel.setText("Lucro: R$ "+lucro);
    }
}
