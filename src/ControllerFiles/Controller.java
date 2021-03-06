package ControllerFiles;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    @FXML
    private TextArea textArea;
    public String title = mongo.title;
    public static String comments="";

    public void initialize(){
        Parent tableViewParent = null;
        try {
            textArea.setText(title);
            Logger mongoLogger=Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            System.setProperty("jdk.tls.trustNameService","true");
            MongoClientURI mongo = new MongoClientURI("mongodb+srv://haris:haris123@cluster0.sbil8.mongodb.net/myFirstDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
            try( MongoClient mongoClient = new MongoClient(mongo)) {
                MongoDatabase myDB = mongoClient.getDatabase("firstdb");
                BasicDBObject query = new BasicDBObject("title", title);
                MongoCollection<Document> collection = myDB.getCollection("movies");
                FindIterable<Document> iterDoc = collection.find(query).projection(Projections.fields(Projections.include("title","year","runtime","plot","type","directors","imdb.rating","imdb.votes","countries","genres")));
                Iterator it = iterDoc.iterator();
                ArrayList<String> document= new ArrayList<String>();
                while (it.hasNext()) {
                    String result=it.next().toString();
                    result=result+"\n";
                    document.add(result);
                }
                System.out.println(document);
                textArea.setText(String.valueOf(document));
                textArea.setEditable(false);
                FindIterable<Document> iterDoc2 = collection.find(query).projection(Projections.fields(Projections.include("_id")));
                Iterator it2 = iterDoc2.iterator();
                ArrayList<String> document2= new ArrayList<String>();
                while (it2.hasNext()) {
                    String result2=it2.next().toString();
                    comments=result2;
                }
                comments=comments.substring(14,38);
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Comment(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/Comments.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void ImdbSort(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/imdbSortTitle.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void AwardsSort(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/awardsSortTitle.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void YearSort(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/yearSortTitle.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void RuntimeSort(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/runtimeSortTitle.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void VotesSort(ActionEvent event){
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/votesSortTitle.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            window.centerOnScreen();
            System.out.println(comments);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

