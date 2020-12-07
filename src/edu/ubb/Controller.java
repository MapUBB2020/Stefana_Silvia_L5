package edu.ubb;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    Stage stage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp
    }

    public void startQuiz(ActionEvent e) throws Exception {
        //Parent finishRoot = FXMLLoader.load(getClass().getResource("view2.fxml"));
        //Scene questionScene =  new Scene(finishRoot);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //stage.setScene(questionScene);

        Quiz quiz;
        ControllerQuiz cq = new ControllerQuiz();
        quiz=cq.quizGenerator();


        //HBox headerBox=raspCorecte+raspGresite
        Label nrCorrectAnswers = new Label("✔" + Integer.toString(quiz.getNrCorrectAnswers()));
        nrCorrectAnswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        nrCorrectAnswers.setWrapText(true);
        nrCorrectAnswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrCorrectAnswers.setMaxWidth(700);

        Label nrWrongAmswers = new Label("✘" + Integer.toString(quiz.getNrWrongAnswers()));
        nrWrongAmswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        nrWrongAmswers.setWrapText(true);
        nrWrongAmswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrWrongAmswers.setMaxWidth(700);

        HBox headerBox = new HBox();
        headerBox.setSpacing(600);
        headerBox.setPadding(new Insets(-30, 0, 0, 0));
        headerBox.getChildren().addAll(nrCorrectAnswers, nrWrongAmswers);


        //HBox questionBox=nrIntrb+intrb
        Label nrQuestion = new Label(Integer.toString(quiz.getQuestionNumber() + 1));
        nrQuestion.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        nrQuestion.setWrapText(true);
        nrQuestion.setTextAlignment(TextAlignment.JUSTIFY);
        nrQuestion.setMaxWidth(700);

        Label question = new Label(")  " + quiz.getQuestions().get(0).getQuestion());

        //Setting font to the text
        question.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //setting the position of the text
        question.setWrapText(true);
        question.setTextAlignment(TextAlignment.JUSTIFY);
        question.setMaxWidth(700);

        HBox questionBox = new HBox();
        questionBox.setSpacing(0);
        questionBox.setPadding(new Insets(-10, 0, 0, 0));
        questionBox.getChildren().addAll(nrQuestion, question);


        //VBox answerBox = answer1+2+3
        Label answer1 = new Label(quiz.getQuestions().get(0).getAnswers().get(0));

        //Setting font to the text
        answer1.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer1.setWrapText(true);
        answer1.setTextAlignment(TextAlignment.JUSTIFY);
        answer1.setMaxWidth(700);

        Label answer2 = new Label(quiz.getQuestions().get(0).getAnswers().get(1));

        //Setting font to the text
        answer2.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer2.setWrapText(true);
        answer2.setTextAlignment(TextAlignment.JUSTIFY);
        answer2.setMaxWidth(700);

        Label answer3 = new Label(quiz.getQuestions().get(0).getAnswers().get(2));

        //Setting font to the text
        answer3.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer3.setWrapText(true);
        answer3.setTextAlignment(TextAlignment.JUSTIFY);
        answer3.setMaxWidth(700);

        VBox answerBox = new VBox();
        answerBox.setSpacing(15);
        answerBox.setPadding(new Insets(35, 0, 0, 0));
        answerBox.getChildren().addAll(answer1, answer2, answer3);


        //HBox buttonAnsBox = buttonA+B+C
        Button buttonA = new Button("A");
        buttonA.setPrefSize(95, 65);
        Button buttonB = new Button("B");
        buttonB.setPrefSize(95, 65);
        Button buttonC = new Button("C");
        buttonC.setPrefSize(95, 65);

        HBox buttonAnswBox = new HBox();
        buttonAnswBox.setSpacing(150);
        buttonAnswBox.setPadding(new Insets(70, 0, 0, 0));
        buttonAnswBox.getChildren().addAll(buttonA, buttonB, buttonC);


        //HBox buttonOptBox = raspMaiTz+modifica+sterge
        Button trimiteButton = new Button("Trimite");
        trimiteButton.setPrefSize(140, 60);
        Button modificaButton = new Button("Modifica");
        modificaButton.setPrefSize(140, 60);
        Button raspMaiTzButton = new Button("Raspund mai tarziu");
        raspMaiTzButton.setPrefSize(140, 60);

        HBox buttonOptBox = new HBox();
        buttonOptBox.setSpacing(100);
        buttonOptBox.setPadding(new Insets(10, 0, 0, 0));
        buttonOptBox.getChildren().addAll(raspMaiTzButton, modificaButton, trimiteButton);

        //Creating a scene object
        Scene scene = new Scene(new Group(), 900, 700);


        // VBox myVBox= all my boxes
        VBox myVBox = new VBox();
        myVBox.setSpacing(30);
        myVBox.setPadding(new Insets(100, 0, 0, 120));
        myVBox.setAlignment(Pos.CENTER);
        myVBox.getChildren().addAll(headerBox, questionBox, answerBox, buttonAnswBox, buttonOptBox);
        ((Group) scene.getRoot()).getChildren().addAll(myVBox);

        //Setting title to the Stage
        stage.setTitle("Decorations Example");

        trimiteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                Timeline timeline = new Timeline();
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.playFromStart();
                for(int i=0; i<quiz.getQuestions().size();i++) {

                }
            }
        });

        //Adding scene to the stage
        stage.setScene(scene);


        //Displaying the contents of the stage
        stage.show();

    }

}
