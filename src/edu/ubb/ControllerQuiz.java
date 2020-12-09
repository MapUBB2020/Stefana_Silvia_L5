package edu.ubb;

import java.io.IOException;
import java.util.*;

public class ControllerQuiz {


    public ControllerQuiz() {}

    private Quiz quiz;


    /**
     * @return Quiz object-the questions are randomly chosen
     * @throws IOException
     */
    public Quiz quizGenerator() throws IOException {

        JsonReader jsonReader = new JsonReader();
        List<Question> allQuestions = jsonReader.jsonReader();
        Random random = new Random();

        List<Question> quizQuestions = new ArrayList<Question>();
        for (int i = 0; i < 26; i++) {

            int randomIndex = random.nextInt(allQuestions.size());
            quizQuestions.add(allQuestions.get(randomIndex));
            allQuestions.remove(randomIndex);
        }

        quiz = new Quiz(quizQuestions);

        for (int i = 0; i < 26; i++)
            quiz.getQuestions().get(i).setIdQuestionQuiz(i + 1);
        return quiz;
    }


    /**
     * method compares the users' answers with the correct answers ("Trimite" button)
     * @param quiz the current quiz
     * @param i which question from quiz
     * @param aux list with questions to be initialised in quiz
     * @return list with two elems:if first elem is 1 then the answer is right, if second elem is 1 otherwise
     */
    public int[] checkAnswer(Quiz quiz, int i, List<String> aux) {
        int[] points = new int[2];

        quiz.setUserAnswers(aux);

        Collections.sort(quiz.getUserAnswers());
        boolean isCorrect = quiz.getQuestions().get(i).getCorrectAnswers().equals(quiz.getUserAnswers());

        if (isCorrect)
            points[0] += 1;
        else points[1] += 1;

        return points;
    }

    /**
     * method moves the current question at the end of the quiz ("Raspund mai tarziu" button)
     * @param quiz current
     * @param i which question from quiz
     * @param aux list with questions to be initialised in quiz
     */
    public void answerLater(Quiz quiz, int i, List<Question> aux) {

        quiz.setQuestions(aux);
        Question later = quiz.getQuestions().get(i);
        quiz.getQuestions().remove(i);
        quiz.getQuestions().add(later);

    }

}
