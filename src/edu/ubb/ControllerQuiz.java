package edu.ubb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ControllerQuiz {

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void quizGenerator() throws IOException {

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
    }
}
