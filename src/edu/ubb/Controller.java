package edu.ubb;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Stage stage = new Stage();
    Quiz quiz;
    ControllerQuiz cq = new ControllerQuiz();

    private static final Integer start = 60;
    private Timeline timeline;
    private int min = 30;
    private int startTimeSec, startTimeMin;

    private Label timerLabel = new Label();

    int addToLoops = 0;
    private List<String> answersAux;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //StartUp
    }

    public void startQuiz(ActionEvent e) throws Exception {

        Scene scene = new Scene(new Group(), 1100, 800);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        quiz = cq.quizGenerator();

        final int[] count = {0};

        //HBox headerBox=raspCorecte+raspGresite
        timerLabel.setText("30:00");
        timerLabel.setTextFill(javafx.scene.paint.Color.web("#7010ab"));
        timerLabel.setStyle("-fx-font-size: 4em;");

        Label nrCorrectAnswers = new Label("✔" + quiz.getNrCorrectAnswers());
        nrCorrectAnswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        nrCorrectAnswers.setTextFill(javafx.scene.paint.Color.web("#57ca16"));
        nrCorrectAnswers.setWrapText(true);
        nrCorrectAnswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrCorrectAnswers.setMaxWidth(700);

        Label nrWrongAmswers = new Label("✘" + quiz.getNrWrongAnswers());
        nrWrongAmswers.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        nrWrongAmswers.setTextFill(javafx.scene.paint.Color.web("#FD0909"));
        nrWrongAmswers.setWrapText(true);
        nrWrongAmswers.setTextAlignment(TextAlignment.JUSTIFY);
        nrWrongAmswers.setMaxWidth(700);

        HBox headerBox = new HBox();
        headerBox.setSpacing(300);
        headerBox.setPadding(new Insets(-60, 0, 0, 60));
        headerBox.getChildren().addAll(nrCorrectAnswers, timerLabel, nrWrongAmswers);


        Label question = new Label(quiz.getQuestions().get(0).getIdQuestionQuiz() + ")  " + quiz.getQuestions().get(0).getQuestion());
        question.setPadding(new Insets(0, 0, 30, 0));

        //Setting font to the text
        question.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //setting the position of the text
        question.setWrapText(true);
        question.setTextAlignment(TextAlignment.JUSTIFY);
        question.setMaxWidth(900);


        //VBox answerBox = answer1+2+3
        Label answer1 = new Label(quiz.getQuestions().get(0).getAnswers().get(0));

        //Setting font to the text
        answer1.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer1.setWrapText(true);
        answer1.setTextAlignment(TextAlignment.JUSTIFY);
        answer1.setMaxWidth(800);

        Label answer2 = new Label(quiz.getQuestions().get(0).getAnswers().get(1));

        //Setting font to the text
        answer2.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer2.setWrapText(true);
        answer2.setTextAlignment(TextAlignment.JUSTIFY);
        answer2.setMaxWidth(800);

        Label answer3 = new Label(quiz.getQuestions().get(0).getAnswers().get(2));

        //Setting font to the text
        answer3.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

        //setting the position of the text
        answer3.setWrapText(true);
        answer3.setTextAlignment(TextAlignment.JUSTIFY);
        answer3.setMaxWidth(800);

        VBox answerBox = new VBox();
        answerBox.setSpacing(15);
        answerBox.setPadding(new Insets(50, 0, 0, 0));
        answerBox.setAlignment(Pos.CENTER);

        answerBox.getChildren().addAll(question, answer1, answer2, answer3);


        //HBox buttonAnsBox = buttonA+B+C
        Button buttonA = new Button("A");
        buttonA.setPrefSize(95, 65);
        Button buttonB = new Button("B");
        buttonB.setPrefSize(95, 65);
        Button buttonC = new Button("C");
        buttonC.setPrefSize(95, 65);

        answersAux = new ArrayList<>();
        buttonA.setOnAction(actionEvent -> {
            buttonA.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
            answersAux.add("A");
        });
        buttonB.setOnAction(actionEvent -> {
            buttonB.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
            answersAux.add("B");
        });
        buttonC.setOnAction(actionEvent -> {
            buttonC.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
            answersAux.add("C");
        });

        HBox buttonAnswBox = new HBox();
        buttonAnswBox.setSpacing(250);
        buttonAnswBox.setPadding(new Insets(40, 0, 0, 0));
        buttonAnswBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonAnswBox.getChildren().addAll(buttonA, buttonB, buttonC);


        //HBox buttonOptBox = raspMaiTz+modifica+sterge
        Button trimiteButton = new Button("Trimite");
        trimiteButton.setPrefSize(140, 60);
        Button modificaButton = new Button("Modifica");
        modificaButton.setPrefSize(140, 60);
        Button raspMaiTzButton = new Button("Raspund mai tarziu");
        raspMaiTzButton.setPrefSize(140, 60);

        modificaButton.setOnAction(actionEvent -> {
            answersAux.clear();
            quiz.setUserAnswers(answersAux);
            buttonA.setStyle(null);
            buttonB.setStyle(null);
            buttonC.setStyle(null);
        });

        raspMaiTzButton.setOnAction(actionEvent -> {
            cq.answerLater(quiz, 0, quiz.getQuestions());

            count[0] -= 1;
            nextQuestion(quiz, count);
        });


        HBox buttonOptBox = new HBox();
        buttonOptBox.setSpacing(200);
        buttonOptBox.setPadding(new Insets(10, 0, 0, 0));
        buttonOptBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonOptBox.getChildren().addAll(raspMaiTzButton, modificaButton, trimiteButton);


        timeline = new Timeline();
        if (timeline != null) {
            timeline.stop();
        }
        if (startTimeMin >= 0) {
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),
                    event -> {
                        startTimeSec--;
                        boolean isSecondZero = startTimeSec < 0;
                        boolean timeToStop = startTimeSec < 0 && startTimeMin == 0;

                        if (isSecondZero) {
                            startTimeMin--;
                            startTimeSec = 59;
                        }

                        if (timeToStop) {
                            timeline.stop();
                            startTimeMin = 0;
                            startTimeSec = 0;

                            endScene(quiz);

                        }
                        timerLabel.setText(String.format("%02d:%02d", startTimeMin, startTimeSec));

                    });
            startTimeSec = start;
            startTimeMin = min - 1;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.getKeyFrames().add(keyFrame);
            timeline.playFromStart();
        }

        VBox allButtonsBox = new VBox();
        allButtonsBox.setSpacing(30);
        allButtonsBox.setPadding(new Insets(40, 0, 0, 0));
        allButtonsBox.setAlignment(Pos.CENTER);
        allButtonsBox.getChildren().addAll(buttonAnswBox, buttonOptBox);

        // VBox myVBox= all my boxes
        VBox myVBox = new VBox();
        myVBox.setSpacing(30);
        myVBox.setPadding(new Insets(100, 0, 0, 100));
        myVBox.setAlignment(Pos.CENTER);
        myVBox.getChildren().addAll(headerBox, answerBox, allButtonsBox);
        ((Group) scene.getRoot()).getChildren().addAll(myVBox);


        trimiteButton.setOnAction(actionEvent -> {
            quiz.setUserAnswers(answersAux);
            cq.checkAnswer(quiz, 0, answersAux);
            quiz.setNrCorrectAnswers(quiz.getNrCorrectAnswers() + cq.checkAnswer(quiz, 0, answersAux)[0]);
            quiz.setNrWrongAnswers(quiz.getNrWrongAnswers() + cq.checkAnswer(quiz, 0, answersAux)[1]);
            nextQuestion(quiz, count);

            addToLoops += 1;
        });

        //Setting title to the Stage
        stage.setTitle("DRPCIV");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();


    }

    public void nextQuestion(Quiz quiz, int[] count) {


        Scene scene2 = new Scene(new Group(), 1100, 800);
        int i = count[0] += 1;

        if (quiz.getNrWrongAnswers() > 4) {

            endScene(quiz);
        } else if (addToLoops == 26 - 1) {
            endScene(quiz);
        } else if (addToLoops < 26) {


            Label nrCorrectAnswers1 = new Label("✔" + quiz.getNrCorrectAnswers());
            nrCorrectAnswers1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
            nrCorrectAnswers1.setTextFill(javafx.scene.paint.Color.web("#57ca16"));
            nrCorrectAnswers1.setWrapText(true);
            nrCorrectAnswers1.setTextAlignment(TextAlignment.JUSTIFY);
            nrCorrectAnswers1.setMaxWidth(700);

            Label nrWrongAmswers1 = new Label("✘" + quiz.getNrWrongAnswers());
            nrWrongAmswers1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
            nrWrongAmswers1.setTextFill(javafx.scene.paint.Color.web("#FD0909"));
            nrWrongAmswers1.setWrapText(true);
            nrWrongAmswers1.setTextAlignment(TextAlignment.JUSTIFY);
            nrWrongAmswers1.setMaxWidth(700);

            HBox headerBox1 = new HBox();
            headerBox1.setSpacing(300);
            headerBox1.setPadding(new Insets(-60, 0, 0, 60));
            headerBox1.getChildren().addAll(nrCorrectAnswers1, timerLabel, nrWrongAmswers1);


            Label question1 = new Label(quiz.getQuestions().get(i).getIdQuestionQuiz() + ")  " + quiz.getQuestions().get(i).getQuestion());
            question1.setPadding(new Insets(0, 0, 30, 0));

            //Setting font to the text
            question1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            //setting the position of the text
            question1.setWrapText(true);
            question1.setTextAlignment(TextAlignment.JUSTIFY);
            question1.setMaxWidth(900);


            //VBox answerBox = answer1+2+3
            Label answer11 = new Label(quiz.getQuestions().get(i).getAnswers().get(0));

            //Setting font to the text
            answer11.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer11.setWrapText(true);
            answer11.setTextAlignment(TextAlignment.JUSTIFY);
            answer11.setMaxWidth(800);

            Label answer21 = new Label(quiz.getQuestions().get(i).getAnswers().get(1));

            //Setting font to the text
            answer21.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer21.setWrapText(true);
            answer21.setTextAlignment(TextAlignment.JUSTIFY);
            answer21.setMaxWidth(800);

            Label answer31 = new Label(quiz.getQuestions().get(i).getAnswers().get(2));

            //Setting font to the text
            answer31.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));

            //setting the position of the text
            answer31.setWrapText(true);
            answer31.setTextAlignment(TextAlignment.JUSTIFY);
            answer31.setMaxWidth(800);

            VBox answerBox1 = new VBox();
            answerBox1.setSpacing(15);
            answerBox1.setPadding(new Insets(35, 0, 0, 0));
            answerBox1.setAlignment(Pos.CENTER);
            answerBox1.getChildren().addAll(question1, answer11, answer21, answer31);


            //HBox buttonAnsBox = buttonA+B+C
            Button buttonA1 = new Button("A");
            buttonA1.setPrefSize(95, 65);
            Button buttonB1 = new Button("B");
            buttonB1.setPrefSize(95, 65);
            Button buttonC1 = new Button("C");
            buttonC1.setPrefSize(95, 65);

            answersAux = new ArrayList<>();
            buttonA1.setOnAction(actionEvent -> {
                buttonA1.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
                answersAux.add("A");
            });
            buttonB1.setOnAction(actionEvent -> {
                buttonB1.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
                answersAux.add("B");
            });
            buttonC1.setOnAction(actionEvent -> {
                buttonC1.setStyle("-fx-color: #42d4d0; -fx-border-width: 5px; -fx-border-color: #871dc8 ");
                answersAux.add("C");
            });

            HBox buttonAnswBox1 = new HBox();
            buttonAnswBox1.setSpacing(250);
            buttonAnswBox1.setPadding(new Insets(40, 0, 0, 0));
            buttonAnswBox1.setAlignment(Pos.BOTTOM_CENTER);
            buttonAnswBox1.getChildren().addAll(buttonA1, buttonB1, buttonC1);


            //HBox buttonOptBox = raspMaiTz+modifica+sterge
            Button trimiteButton1 = new Button("Trimite");
            trimiteButton1.setPrefSize(140, 60);
            Button modificaButton1 = new Button("Modifica");
            modificaButton1.setPrefSize(140, 60);
            Button raspMaiTzButton1 = new Button("Raspund mai tarziu");
            raspMaiTzButton1.setPrefSize(140, 60);

            modificaButton1.setOnAction(actionEvent -> {
                answersAux.clear();
                quiz.setUserAnswers(answersAux);
                buttonA1.setStyle(null);
                buttonB1.setStyle(null);
                buttonC1.setStyle(null);
            });

            raspMaiTzButton1.setOnAction(actionEvent -> {
                cq.answerLater(quiz, i, quiz.getQuestions());

                count[0] -= 1;
                nextQuestion(quiz, count);
            });

            HBox buttonOptBox1 = new HBox();
            buttonOptBox1.setSpacing(200);
            buttonOptBox1.setPadding(new Insets(10, 0, 0, 0));
            buttonOptBox1.setAlignment(Pos.BOTTOM_CENTER);
            buttonOptBox1.getChildren().addAll(raspMaiTzButton1, modificaButton1, trimiteButton1);

            VBox allButtonsBox1 = new VBox();
            allButtonsBox1.setSpacing(30);
            allButtonsBox1.setPadding(new Insets(40, 0, 0, 0));
            allButtonsBox1.setAlignment(Pos.CENTER);
            allButtonsBox1.getChildren().addAll(buttonAnswBox1, buttonOptBox1);


            // VBox myVBox= all my boxes
            VBox myVBox1 = new VBox();
            myVBox1.setSpacing(30);
            myVBox1.setPadding(new Insets(100, 0, 0, 100));
            myVBox1.setAlignment(Pos.CENTER);
            myVBox1.getChildren().addAll(headerBox1, answerBox1, allButtonsBox1);
            ((Group) scene2.getRoot()).getChildren().addAll(myVBox1);

            stage.setScene(scene2);
            stage.show();


            trimiteButton1.setOnAction(actionEvent -> {
                quiz.setUserAnswers(answersAux);
                cq.checkAnswer(quiz, 0, answersAux);
                quiz.setNrCorrectAnswers(quiz.getNrCorrectAnswers() + cq.checkAnswer(quiz, i, answersAux)[0]);
                quiz.setNrWrongAnswers(quiz.getNrWrongAnswers() + cq.checkAnswer(quiz, i, answersAux)[1]);
                nextQuestion(quiz, count);

                addToLoops += 1;
            });

        }

    }

    public void endScene(Quiz quiz) {
        Scene finalScene = new Scene(new Group(), 1100, 900);


        Label resultLabel = new Label();
        String passed = " ✨ ADMIS! ✨ \uD83D\uDE04 ";
        String failed = "✨ RESPINS! ✨" + " \uD83D\uDE2D";

        if (quiz.getNrCorrectAnswers() >= 22)
            resultLabel.setText(passed);
        else resultLabel.setText(failed);

        resultLabel.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 25));

        Label puncteCorecte = new Label("Raspunsuri corecte: " + quiz.getNrCorrectAnswers());

        puncteCorecte.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        puncteCorecte.setTextFill(javafx.scene.paint.Color.web("#3FC30D"));

        puncteCorecte.setWrapText(true);
        puncteCorecte.setTextAlignment(TextAlignment.JUSTIFY);
        puncteCorecte.setMaxWidth(700);

        Label puncteGresite = new Label("Raspunsuri gresite: " + quiz.getNrWrongAnswers());

        puncteGresite.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        puncteGresite.setTextFill(javafx.scene.paint.Color.web("#d20808"));

        puncteGresite.setWrapText(true);
        puncteGresite.setTextAlignment(TextAlignment.JUSTIFY);
        puncteGresite.setMaxWidth(700);

        Button restart = new Button("RESTART \uD83D\uDC4D");
        restart.setPrefSize(160, 40);
        restart.setTextFill(javafx.scene.paint.Color.web("#F8F9FA"));
        restart.setStyle("-fx-background-color: #2fa1be; -fx-border-width: 1px; -fx-border-color: #f8f9fa ");
        restart.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 23));
        restart.setPadding(new Insets(0, 0, 0, 0));
        restart.setAlignment(Pos.CENTER);

        restart.setOnAction(actionEvent -> {
            try {
                startQuiz(actionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        HBox punctajBox = new HBox();
        punctajBox.setSpacing(150);
        punctajBox.setPadding(new Insets(70, 0, 0, 0));
        punctajBox.getChildren().addAll(puncteCorecte, puncteGresite);

        VBox endBox = new VBox();
        endBox.setSpacing(100);
        endBox.setPadding(new Insets(140, 0, 0, 200));
        endBox.setAlignment(Pos.CENTER);
        endBox.getChildren().addAll(resultLabel, punctajBox, restart);
        ((Group) finalScene.getRoot()).getChildren().addAll(endBox);


        stage.setScene(finalScene);
        stage.show();

    }

}
