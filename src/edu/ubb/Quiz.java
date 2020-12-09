package edu.ubb;

import java.util.List;

public class Quiz {

    private int nrCorrectAnswers;
    private int nrWrongAnswers;
    private List<Question> questions;
    public List<String> userAnswers;


    public Quiz(List<Question> questions) {
        this.questions = questions;
    }


    public int getNrCorrectAnswers() {
        return nrCorrectAnswers;
    }

    public void setNrCorrectAnswers(int nrCorrectAnswers) {
        this.nrCorrectAnswers = nrCorrectAnswers;
    }

    public int getNrWrongAnswers() {
        return nrWrongAnswers;
    }


    public void setNrWrongAnswers(int nrWrongAnswers) {
        this.nrWrongAnswers = nrWrongAnswers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }

}
