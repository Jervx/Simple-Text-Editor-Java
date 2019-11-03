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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Process implements Initializable {
    @FXML TextArea textArea; @FXML AnchorPane StartPage; @FXML AnchorPane mainTextEditor; @FXML Label linecount;

    int line = 1;

    String fileExtension = "unsave/unknown";

    public void entered(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)) {
            line += 1;
        }
        getCount();
    }

    void getCount(){
        line = 0;
        for(int x = 0 ; x < textArea.getText().length();x++){
            linecount.setText(String.format("Lines:%d\t\t\tFileType: %s", line+1,fileExtension));
            if(x+1 > textArea.getText().length())break;
            else if(textArea.getText().substring(x,x+1).equals("\n"))line+=1;
        }
    }

    public void openFile() {
        try {
            File f = new FileChooser().showOpenDialog(null);
            fileExtension = f.getAbsolutePath().toString().substring(f.getAbsolutePath().toString().lastIndexOf('.')+1);
            Scanner scan = new Scanner(f);
            while (scan.hasNext()) textArea.setText(textArea.getText() + scan.nextLine() + "\n");
            getCount();
        } catch (IOException e) {}
    }

    public void startCreate(){
        mainTextEditor.setVisible(true);
        StartPage.setVisible(false);
    }

    public void startOpen(){
        textArea.clear();
        openFile();
        mainTextEditor.setVisible(true);
        StartPage.setVisible(false);
    }

    public void saveAs() {
        try {
            File f = new FileChooser().showSaveDialog(null);
            fileExtension = f.getAbsolutePath().toString().substring(f.getAbsolutePath().toString().lastIndexOf('.')+1);
            PrintWriter print = new PrintWriter(f);
            print.print(textArea.getText());
            print.flush();
            print.close();
            saved = true;
            getCount();
        } catch (Exception e) {}
    }

    public void mainMenu() {
        if(textArea.getText().length() > 0 && saved == false) JOptionPane.showMessageDialog(null,"Save The File First");
        else{
            textArea.clear();
            mainTextEditor.setVisible(false);
            StartPage.setVisible(true);
        }
    }

    public void clearAll(){
        textArea.clear();
    }

    public void about() throws IOException {
        Stage st = new Stage();
        Parent mainR = FXMLLoader.load(getClass().getResource("About.fxml"));
        st.setScene(new Scene(mainR));
        st.setResizable(false);
        st.show();
    }

    boolean saved = false;

    public void close() {
        if(textArea.getText().length() > 0 && saved == false) JOptionPane.showMessageDialog(null,"Save The File First");
        else System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainTextEditor.setVisible(false);
        StartPage.setVisible(true);
        textArea.setPromptText("Onichang Enter Some Text Here!  U w U");
    }
}
