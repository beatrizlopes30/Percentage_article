package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleQuizUI extends JFrame {
    private QuizSystem qs;
    private JTextArea resultArea;

    public SimpleQuizUI() {
        qs = new QuizSystem();
        setupUI();
    }

    private void setupUI() {
        setTitle("Analisador de Quiz Simples");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Painel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adicionar Questão"));

        JLabel numberLabel = new JLabel("Número da Questão:");
        JSpinner numberSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 14, 1));

        JLabel correctLabel = new JLabel("Respostas Corretas:");
        JSpinner correctSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        JLabel wrongLabel = new JLabel("Respostas Erradas:");
        JSpinner wrongSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));

        JButton addButton = new JButton("Adicionar Questão");

        inputPanel.add(numberLabel);
        inputPanel.add(numberSpinner);
        inputPanel.add(correctLabel);
        inputPanel.add(correctSpinner);
        inputPanel.add(wrongLabel);
        inputPanel.add(wrongSpinner);
        inputPanel.add(new JLabel()); // espaço vazio
        inputPanel.add(addButton);

        // Painel de controles
        JPanel controlPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Estatísticas"));

        JButton statsButton1 = new JButton("Porcentagem de Acertos");
        JButton statsButton2 = new JButton("Porcentagem de Erros");
        JButton bestButton = new JButton("Melhor Questão");
        JButton worstButton = new JButton("Pior Questão");

        controlPanel.add(statsButton1);
        controlPanel.add(statsButton2);
        controlPanel.add(bestButton);
        controlPanel.add(worstButton);

        // Área de resultados
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 240, 240));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));

        // Adicionar tudo ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(controlPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        // Ações dos botões
        addButton.addActionListener(e -> {
            int number = (Integer) numberSpinner.getValue();
            int correct = (Integer) correctSpinner.getValue();
            int wrong = (Integer) wrongSpinner.getValue();

            try {
                qs.addQuestion(number, correct, wrong);
                resultArea.append("Questão " + number + " adicionada: " + correct + "✓, " + wrong + "✗\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        statsButton1.addActionListener(e -> {
            double percentage = qs.getCorrectPercentageTotal();
            resultArea.append("Porcentagem geral de acertos: " + String.format("%.2f", percentage) + "%\n");
        });

        statsButton2.addActionListener(e -> {
            double percentage = 100 - qs.getCorrectPercentageTotal();
            resultArea.append("Porcentagem geral de erros: " + String.format("%.2f", percentage) + "%\n");
        });

        bestButton.addActionListener(e -> {
            resultArea.append(qs.bestQuestion() + "\n");
        });

        worstButton.addActionListener(e -> {
            resultArea.append(qs.worseQuestion() + "\n");
        });
    }

    public static void main(String[] args) {
        // Tornar a interface mais bonita
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new SimpleQuizUI().setVisible(true);
        });
    }
}