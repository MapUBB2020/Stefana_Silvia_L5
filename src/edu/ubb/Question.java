package edu.ubb;

import java.util.List;

public class Question {

        private int idQuestion;
        List<String> answers;
        List<String> correctAnswers;

        public Question(){}
        public Question(int idQuestion, List<String> answers, List<String> correctAnswers) {
            this.idQuestion = idQuestion;
            this.answers = answers;
            this.correctAnswers = correctAnswers;
        }

        public int getIdQuestion() {
            return idQuestion;
        }

        public void setIdQuestion(int idQuestion) {
            this.idQuestion = idQuestion;
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

        @Override
        public String toString() {
            return "Question{" +
                    "idQuestion=" + idQuestion +
                    ", answers=" + answers +
                    ", correctAnswers=" + correctAnswers +
                    '}';
        }
}
