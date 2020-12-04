package edu.ubb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.IOException;

public class Main extends Application {


        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();

            Controller controller = new Controller();


        }


        public static void main(String[] args) throws IOException {
            launch(args);
/*            ControllerQuiz cq = new ControllerQuiz();
            Quiz q=new Quiz(cq.quizGenerator());
            Button start=new Button();
            start.setOnAction(actionEvent -> q.getQuestions());*/

        }
    }

/*
    public static void main(String[] args) {//throws IOException {
        launch(args);
        JsonReader jsonReader=new JsonReader();
        for(Question q: jsonReader.jsonReader())
            System.out.println(q.getQuestion());

        ControllerQuiz cq=new ControllerQuiz();
        cq.quizGenerator();
        JsonReader jsonReader=new JsonReader();
        for(int i=0; i<26; i++)
            System.out.println(cq.getQuiz().getQuestions().get(i));*/



