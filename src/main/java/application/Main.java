package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int correct, wrong, question;
        int totalGeral = 0;
        int correctQuestion = 0;

        for (int i = 0; i < 13; i++) {
            System.out.println("Number of the question");
            question = sc.nextInt();
            sc.nextLine();
            System.out.println("put the correct answer");
            correct = sc.nextInt();
            sc.nextLine();
            System.out.println("put the false answer");
            wrong = sc.nextInt();
            sc.nextLine();
            formulary f = new formulary(correct, wrong, question);
            int total = f.logic(correct, wrong);
            totalGeral += total;
            correctQuestion += correct;
        }
        formulary f = new formulary(0, 0, 0);
        double porcentagem = f.CorrectPercentage(correctQuestion, totalGeral);
        System.out.println("A porcentagem é " + porcentagem + "%");
    }
}