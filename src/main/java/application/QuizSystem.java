package application;


import java.util.*;

public class QuizSystem {
    private int totalCorrectAnswer = 0;
    private int totalWrongAnswer = 0;
    private int[] correctAnswerPerQuestion = new int[15];
    private int[] wrongAnswerPerQuestion = new int[15];
    private int totalQuestion = 0;
    private Double correctPercentage = 0.0;
    private Double correctPercentageTotal = 0.0;
    private Double[] correctPercentagePerQuestion = new Double[15];

    public  QuizSystem (){
    }
    public void addQuestion(int questionNumber, int correctAnswer, int wrongAnswer) {
        if (questionNumber < 1 || questionNumber > 14) {
            throw new IllegalArgumentException("The question number is wrong");
        }
        int totalAnswers = wrongAnswer + correctAnswer;
        totalCorrectAnswer += correctAnswer;
        totalWrongAnswer += wrongAnswer;
        totalQuestion++;
        correctAnswerPerQuestion[questionNumber] = correctAnswer;

        if (totalAnswers<=0){
            correctPercentage = 0.0;
        }
        else {
        correctPercentage = (double) correctAnswer * 100 / (totalAnswers);
        }
        int totalAllAnswers = totalCorrectAnswer + totalWrongAnswer;
        if (totalAllAnswers <= 0){
            correctPercentageTotal = 0.0;
        }
        else {
        correctPercentageTotal = ((double) totalCorrectAnswer  * 100 )/ totalAllAnswers;
        }
        correctPercentagePerQuestion[questionNumber] = correctPercentage;
    }

    public String bestQuestion ( ) {
        double result = -1;
        int question=-1;
        for (int i = 1; i <correctPercentagePerQuestion.length; i++){
            if (correctPercentagePerQuestion[i] != null && correctPercentagePerQuestion[i] > result){
                result = correctPercentagePerQuestion[i];
                question = i;
            }
        }
        if (question == -1){
            return "No questions registered";
        }
        return "The question with the most correct answers is " + question + ", with a total of " + result + "% correct questions";
    }
    public String worseQuestion(){
        double min = 101;
        int question = -1;
        int i;
            for (i=1; i<correctPercentagePerQuestion.length; i++){
                if (correctPercentagePerQuestion[i] != null && correctPercentagePerQuestion[i] < min){
                    min = correctPercentagePerQuestion[i];
                    question = i;
                }
                if ((question == -1)){
                    return "No questions registered";
                }
            }
        return "The question with the most wrong answers is " + question + ", with a total of " + (100 - min) + " % wrong questions";
    }
    public Double getCorrectPercentage() {
        return correctPercentage;
    }

    public Double getCorrectPercentageTotal() {
        return correctPercentageTotal;
    }

    public int getTotalCorrectAnswer() {
        return totalCorrectAnswer;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public int getTotalWrongAnswer() {
        return totalWrongAnswer;
    }

    public int[] getCorrectAnswerPerQuestion() {
        return correctAnswerPerQuestion;
    }

    public Double[] getCorrectPercentagePerQuestion() {
        return correctPercentagePerQuestion;
    }

    public int[] getWrongAnswerPerQuestion() {
        return wrongAnswerPerQuestion;
    }

    @Override
    public String toString() {
        return "QuizSystem{" +
                "correctAnswerPerQuestion=" + Arrays.toString(correctAnswerPerQuestion) +
                ", totalCorrectAnswer=" + totalCorrectAnswer +
                ", totalWrongAnswer=" + totalWrongAnswer +
                ", wrongAnswerPerQuestion=" + Arrays.toString(wrongAnswerPerQuestion) +
                ", totalQuestion=" + totalQuestion +
                ", correctPercentage=" + correctPercentage +
                ", correctPercentageTotal=" + correctPercentageTotal +
                ", correctPercentagePerQuestion=" + Arrays.toString(correctPercentagePerQuestion) +
                '}';
    }
}
