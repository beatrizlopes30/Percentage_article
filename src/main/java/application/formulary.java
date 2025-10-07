package application;

public class formulary {
    int correct;
    int wrong;
    int question;

    public formulary(int correct, int wrong, int question) {
        this.correct = correct;
        this.wrong = wrong;
        this.question = wrong;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int logic(int correct, int wrong){
        int total = correct+wrong;
        return total;
    }
    public double CorrectPercentage (int correct, int total){
        double correctPercentage = (correct* 100)/total;
        return correctPercentage;
    }
}
