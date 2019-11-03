package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ImageView imageview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File image = new FileChooser().showOpenDialog(null);
        imageview.setImage(new Image(image.toURI().toString()));
    }
}
