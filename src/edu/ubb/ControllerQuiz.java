package edu.ubb;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.*;

public class ControllerQuiz {

    public List<String> rasp;


    public ControllerQuiz() {}
    public ControllerQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz quizGenerator() throws IOException {

        JsonReader jsonReader=new JsonReader();
        List<Question> allQuestions = jsonReader.jsonReader();
        Random random=new Random();

        List<Question> quizQuestions = new ArrayList<Question>();
        for (int i=0; i<26; i++){

            int randomIndex = random.nextInt(allQuestions.size());
            quizQuestions.add(allQuestions.get(randomIndex));

            allQuestions.remove(randomIndex);
        }

        quiz = new Quiz(quizQuestions);
        return quiz;
    }


    public int[] checkAnswer(Quiz quiz, int i, List<String> aux){
        int[] points = new int[2];

        quiz.setUserAnswers(aux);

        Collections.sort(quiz.getUserAnswers());
        boolean isCorrect=quiz.getQuestions().get(i).getCorrectAnswers().equals(quiz.getUserAnswers());

        if (isCorrect)
            points[0] += 1;
        else points[1] += 1;

        return points;
    }

}
