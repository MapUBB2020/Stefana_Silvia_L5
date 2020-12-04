package edu.ubb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    Stage stage = new Stage();
    ControllerQuiz cq = new ControllerQuiz();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp

    }

    public void startQuiz(ActionEvent e) throws IOException {
        Parent finishRoot = FXMLLoader.load(getClass().getResource("view2.fxml"));
        //Scene questionScene =  new Scene(finishRoot);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //stage.setScene(questionScene);

        //Creating a Text object
        Label nameLabel = new Label("intrb");
        nameLabel.setFont(new Font("Arial", 20));
        Text text = new Text();

        //Setting font to the text
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //setting the position of the text
        text.setX(50);
        text.setY(130);


        //Setting the text to be added.
        text.setText(cq.quizGenerator().get(0).getQuestion());

        //Creating a Group object
        Group root = new Group(text);

        //Creating a scene object
       // Scene scene = new Scene(root, 600, 300);
        Scene questionScene =  new Scene(finishRoot);

        //Setting title to the Stage
        stage.setTitle("Setting Font to the text");

        //Adding scene to the stage


        VBox myVBox = new VBox();
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(nameLabel);

        //((Group) questionScene.getRoot()).getChildren().addAll(myVBox);

        stage.setScene(questionScene);

        //Displaying the contents of the stage
        stage.show();

    }

}
