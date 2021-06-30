package ControllerFiles;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class mongo extends Application {
    public static String title="";
    public static String actor="";
    public static String director="";
    public static String genre="";
    public static int num = 0;

    @FXML
    private TextField movietxt,actortxt,genretxt,directortxt;
    @FXML
    private TextArea textArea;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FxmlFiles/SearchWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Class Project Mongo DB IMDB MOVIES");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    public void searchByTitle(ActionEvent event) throws IOException {
        Parent tableViewParent = null;
        try {
            title = movietxt.getText();
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/titleSearch.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void searchByActor(ActionEvent event){
        Parent tableViewParent = null;
        try {
            actor = actortxt.getText();
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/actorSearch.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void searchByDirector(ActionEvent event){
        Parent tableViewParent = null;
        try {
            director = directortxt.getText();
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/directorSearch.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void searchByGenre(ActionEvent event){
        Parent tableViewParent = null;
        try {
            genre=genretxt.getText();
            System.out.println(genre);
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/genreSearch.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
