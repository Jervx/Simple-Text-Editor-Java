package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.File;

public class Main extends Application {

    Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AnchorPane anch = new AnchorPane();
        File fimage = new FileChooser().showOpenDialog(null);
        ImageView imgv = new ImageView();
        Image image = new Image(fimage.toURI().toString());
        imgv.setImage(image);
        anch.getChildren().add(imgv);
        primaryStage.setTitle("Image Viewer");
        primaryStage.setScene(new Scene(anch,image.getWidth(),image.getHeight()));
        primaryStage.show();
        primaryStage.setResizable(false);
        stg = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
