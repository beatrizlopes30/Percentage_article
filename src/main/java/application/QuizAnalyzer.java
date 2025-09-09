package application;

import java.util.*;

public class QuizAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuizSystem qs = new QuizSystem();
        for (int i = 0; i<14; i++){
        System.out.println("Qual o número da questão que você quer adicionar?");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("Quantas respostas certas?");
        int correctAnswer = Integer.parseInt(sc.nextLine());
        System.out.println("Quantas respostas erradas?");
        int wrongAnswer = Integer.parseInt(sc.nextLine());
        qs.addQuestion(number,correctAnswer,wrongAnswer);
        }
        System.out.println("Digite:");
        System.out.println("1: Ver a Porcentagem geral de respostas certas");
        System.out.println("2: Ver a Porcentagem geral de respostas erradas");
        System.out.println("3: Ver a Porcentagem correta de uma pergunta específica");
        System.out.println("4: Ver a Porcentagem errada de uma pergunta específica");
        int response = Integer.parseInt(sc.nextLine());
        Double [] percentege = qs.getCorrectPercentagePerQuestion();
        switch (response){
            case 1:
                System.out.println("A porcentagem total é " + qs.getCorrectPercentageTotal()+ "%");
                break;
            case 2:
                System.out.println("A porcentagem total é " + (100 - (qs.getCorrectPercentageTotal()) + "%"));
                break;
            case 3:
                System.out.println("De qual pergunta você quer?");
                int question = Integer.parseInt(sc.nextLine());
                if (question< 1 || question >14){
                    throw new IllegalArgumentException("Número de questão inválido!");
                }
                if (percentege[question]!= null){
                    System.out.println("A porcentagem de acertos na questão " + question + "é" + percentege[question] + "%" );
                }
                else {
                    System.out.println("Questão não encontrada!");
                }
                break;

            case 4:
                System.out.println("De qual pergunta você quer?");
                int question2 = Integer.parseInt(sc.nextLine());
                if (question2< 1 || question2 >14){
                    throw new IllegalArgumentException("Número de questão inválido!");
                }
                if (percentege[question2]!= null){
                    System.out.println("A porcentagem de erros na questão " + question2 + "é" + (100 - percentege[question2]) + "%" );
                }
                else {
                    System.out.println("Questão não encontrada!");
                }
                break;
            default:
                System.out.println("Opção não encontrada!");
        }


    }
}
