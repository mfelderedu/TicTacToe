import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Presenter implements Initializable {
    private final Model model;

    public Presenter(Model model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // add change listener
    }

    private void selectedNodeHandler(Observable observable) {

    }

    public void submitButtonHandler(ActionEvent actionEvent) {

    }


}