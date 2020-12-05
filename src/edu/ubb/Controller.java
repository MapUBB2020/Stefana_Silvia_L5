package edu.ubb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    @FXML
    public Label intrb;

    Stage stage = new Stage();
    ControllerQuiz cq;

    public Controller(ControllerQuiz cq){this.cq=cq;}

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp
        ControllerQuiz cq = new ControllerQuiz();
        intrb.setText(cq.getQuiz().getQuestions().get(0).getQuestion());
    }

    public void startQuiz(ActionEvent e) throws Exception {
        Parent finishRoot = FXMLLoader.load(getClass().getResource("view2.fxml"));
        Scene questionScene =  new Scene(finishRoot);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(questionScene);
        stage.show();

    }

}
