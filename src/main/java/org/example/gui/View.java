package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame jFrame = new JFrame();

    private JTextField polynomial1, polynomial2;

    private JTextArea result;
    Controller controller = new Controller(this);

    public View() {
        this.prepareFrame();
        this.preparePolynomials();
        this.prepareResult();
        this.prepareBinaryOperations();
        this.prepareSubtraction();
        this.prepareUnaryOperationsP1();
        this.prepareUnaryOperationsP2();

        jFrame.setVisible(true);
    }

    private void prepareFrame() {
        jFrame.setBounds(100, 100, 500, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setLayout(null);
        jFrame.setResizable(false);

        JLabel titleLabel = new JLabel("Polynomial calculator");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titleLabel.setBounds(140, 10, 250, 40);
        jFrame.getContentPane().add(titleLabel);

        JButton reset;
        reset = new JButton("Reset fields");
        reset.setFont(new Font("Tahoma", Font.PLAIN, 12));
        reset.setBounds(250, 190, 180, 25);
        reset.setActionCommand("RESET");
        reset.addActionListener(this.controller);
        jFrame.getContentPane().add(reset);
    }

    private void preparePolynomials() {
        polynomial1 = new JTextField();
        polynomial1.setBounds(160, 70, 320, 25);
        jFrame.getContentPane().add(polynomial1);

        polynomial2 = new JTextField();
        polynomial2.setBounds(160, 100, 320, 25);
        jFrame.getContentPane().add(polynomial2);

        JLabel p1 = new JLabel("Polynomial 1 (P1)");
        p1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        p1.setBounds(30, 70, 100, 25);
        jFrame.getContentPane().add(p1);

        JLabel p2 = new JLabel("Polynomial 2 (P2)");
        p2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        p2.setBounds(30, 100, 100, 25);
        jFrame.getContentPane().add(p2);
    }

    private void prepareResult() {
        result = new JTextArea();
        result.setBounds(160, 130, 320, 50);
        result.setEditable(false);
        jFrame.getContentPane().add(result);

        JLabel res = new JLabel("Result");
        res.setFont(new Font("Tahoma", Font.PLAIN, 12));
        res.setBounds(30, 130, 100, 25);
        jFrame.getContentPane().add(res);
    }

    private void prepareBinaryOperations() {
        JButton addition;
        addition = new JButton("Addition");
        addition.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addition.setBounds(50, 190, 180, 25);
        addition.setActionCommand("ADD");
        addition.addActionListener(this.controller);
        jFrame.getContentPane().add(addition);

        JButton division;
        division = new JButton("Division");
        division.setFont(new Font("Tahoma", Font.PLAIN, 12));
        division.setBounds(50, 310, 180, 25);
        division.setActionCommand("DIVIDE");
        division.addActionListener(this.controller);
        jFrame.getContentPane().add(division);

        JButton multiplication;
        multiplication = new JButton("Multiplication");
        multiplication.setFont(new Font("Tahoma", Font.PLAIN, 12));
        multiplication.setBounds(50, 280, 180, 25);
        multiplication.setActionCommand("MULTIPLY");
        multiplication.addActionListener(this.controller);
        jFrame.getContentPane().add(multiplication);
    }

    private void prepareSubtraction() {
        JButton subtraction1;
        subtraction1 = new JButton("Subtract P2 from P1");
        subtraction1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        subtraction1.setBounds(50, 220, 180, 25);
        subtraction1.setActionCommand("SUBTRACT P2 FROM P1");
        subtraction1.addActionListener(this.controller);
        jFrame.getContentPane().add(subtraction1);

        JButton subtraction2;
        subtraction2 = new JButton("Subtract P1 from P2");
        subtraction2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        subtraction2.setBounds(50, 250, 180, 25);
        subtraction2.setActionCommand("SUBTRACT P1 FROM P2");
        subtraction2.addActionListener(this.controller);
        jFrame.getContentPane().add(subtraction2);
    }

    private void prepareUnaryOperationsP1() {
        JButton derivative1;
        derivative1 = new JButton("Derivative of P1");
        derivative1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        derivative1.setBounds(250, 220, 180, 25);
        derivative1.setActionCommand("DERIVATIVE 1");
        derivative1.addActionListener(this.controller);
        jFrame.getContentPane().add(derivative1);

        JButton integral1;
        integral1 = new JButton("Integral of P1");
        integral1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        integral1.setBounds(250, 250, 180, 25);
        integral1.setActionCommand("INTEGRAL 1");
        integral1.addActionListener(this.controller);
        jFrame.getContentPane().add(integral1);
    }

    private void prepareUnaryOperationsP2() {
        JButton integral2;
        integral2 = new JButton("Integral of P2");
        integral2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        integral2.setBounds(250, 310, 180, 25);
        integral2.setActionCommand("INTEGRAL 2");
        integral2.addActionListener(this.controller);
        jFrame.getContentPane().add(integral2);

        JButton derivative2;
        derivative2 = new JButton("Derivative of P2");
        derivative2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        derivative2.setBounds(250, 280, 180, 25);
        derivative2.setActionCommand("DERIVATIVE 2");
        derivative2.addActionListener(this.controller);
        jFrame.getContentPane().add(derivative2);
    }

    public JFrame getJFrame() {
        return jFrame;
    }

    public String getPolynomial1() {
        return polynomial1.getText();
    }

    public String getPolynomial2() {
        return polynomial2.getText();
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    public void reset() {
        polynomial1.setText("");
        polynomial2.setText("");
        setResult(null);
    }
}
