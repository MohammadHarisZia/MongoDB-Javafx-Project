package ControllerFiles;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CommentsController {
    @FXML
    private TextArea textArea;
    public String comm = Controller.comments;

    public void initialize(){
        Parent tableViewParent = null;
        try {
            System.out.println("here");
            textArea.setText(comm);
            Logger mongoLogger=Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            System.setProperty("jdk.tls.trustNameService","true");
            MongoClientURI mongo = new MongoClientURI("mongodb+srv://haris:haris123@cluster0.sbil8.mongodb.net/myFirstDatabase?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");
            try( MongoClient mongoClient = new MongoClient(mongo)) {
                MongoDatabase myDB = mongoClient.getDatabase("firstdb");
                BasicDBObject query = new BasicDBObject();
                ObjectId id=new ObjectId(comm);
                query.append("movie_id",id);
                MongoCollection<Document> collection = myDB.getCollection("comments");
                FindIterable<Document> iterDoc = collection.find(query);
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
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Back(ActionEvent event) throws IOException {
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("../FxmlFiles/SearchWindow.fxml"));
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
}


