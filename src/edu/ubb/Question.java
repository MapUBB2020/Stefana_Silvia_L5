package edu.ubb;

import java.util.List;

public class Question {

    private int idQuestion;
    private String question;
    List<String> answers;
    List<String> correctAnswers;
    private int idQuestionQuiz;

    public int getIdQuestionQuiz() {
        return idQuestionQuiz;
    }

    public void setIdQuestionQuiz(int idQuestionQuiz) {
        this.idQuestionQuiz = idQuestionQuiz;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

}
