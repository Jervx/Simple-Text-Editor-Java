/*
     Copyright © 2019 JerbeeParagas

     Author: Jerbee Paragas
     Date Crated: Oct 2019
     Last Date Modified: Nov 2019
     Application Name: JerbTxtEditor
     Version: 1.2
     IDE: IntellijIDEA Community

     This application is a personal project.
     It include editing,opening and saving file & there's nothing fancy.
     Maybe some update/features will be added in the future, but i am not sure that i can create more features
     due to being a student, and having no time to code.
*/
package mainPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainProcess extends Application {

    @Override
    public void start(Stage prst) throws Exception{
        Parent mainR = FXMLLoader.load(getClass().getResource("ProcessBackbone.fxml"));
        prst.setTitle("JerbTxtEditor");
        prst.setScene(new Scene(mainR));
        prst.setMinHeight(500.500);
        prst.setMinWidth(500.500);
        prst.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
