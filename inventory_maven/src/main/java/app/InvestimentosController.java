package app;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;
import java.time.LocalDate;

public class InvestimentosController extends Nav {
    @FXML private TextField productField,amountField;
    @FXML private TableView<Investment> table;

    ObservableList<Investment> data;

    public void initialize(){
        data = javafx.collections.FXCollections.observableArrayList(
            JsonStore.loadList("data/investments.json", Investment.class)
        );
        table.setItems(data);
    }

    @FXML void addInv(){
        try{
            Investment i = new Investment();
            i.product = productField.getText();
            i.amount = Double.parseDouble(amountField.getText());
            i.date = LocalDate.now().toString();
            data.add(i);
            JsonStore.saveList("data/investments.json", data);
        }catch(Exception e){ e.printStackTrace();}
    }
}
