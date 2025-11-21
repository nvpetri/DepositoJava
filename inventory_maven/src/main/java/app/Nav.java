package app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Nav {
    protected void go(ActionEvent e, String fxml){
        try{
            Stage s = (Stage)((javafx.scene.Node)e.getSource()).getScene().getWindow();
            Scene sc = new Scene(FXMLLoader.load(getClass().getResource(fxml)));
            s.setScene(sc);
        }catch(Exception ex){ ex.printStackTrace(); }
    }
    @FXML void goDashboard(ActionEvent e){ go(e,"/dashboard.fxml"); }
    @FXML void goEstoque(ActionEvent e){ go(e,"/estoque.fxml"); }
    @FXML void goVendas(ActionEvent e){ go(e,"/vendas.fxml"); }
    @FXML void goInv(ActionEvent e){ go(e,"/investimentos.fxml"); }
    @FXML void goRel(ActionEvent e){ go(e,"/relatorios.fxml"); }
}
