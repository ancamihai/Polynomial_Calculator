package org.example.gui;

import org.example.data_models.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.example.business_logic.Operations.*;
import static org.example.business_logic.Parsing.toPolynomial;

public class Controller implements ActionListener {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "ADD") {
            additionController();
        } else if (command == "DIVIDE") {
            divisionController();
        } else if (command == "MULTIPLY") {
            multiplicationController();
        } else if (command == "SUBTRACT P2 FROM P1") {
            subtract1Controller();
        } else if (command == "SUBTRACT P1 FROM P2") {
            subtract2Controller();
        } else if (command == "DERIVATIVE 1") {
            derivative1Controller();
        } else if (command == "INTEGRAL 1") {
            integral1Controller();
        } else if (command == "DERIVATIVE 2") {
            derivative2Controller();
        } else if (command == "INTEGRAL 2") {
            integral2Controller();
        } else if (command == "RESET") {
            view.reset();
        }
    }

    private void additionController() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial sum = addPolynomial(p1, p2);
            view.setResult(sum.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void divisionController() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            ArrayList<Polynomial> division = divisionPolynomial(p1, p2);
            view.setResult("Quotient: " + division.get(0).toString() + "\nRemainder: " + division.get(1).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void multiplicationController() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial product = multiplyPolynomial(p1, p2);
            view.setResult(product.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void subtract1Controller() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial difference1 = subtractPolynomial(p1, p2);
            view.setResult(difference1.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void subtract2Controller() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial difference1 = subtractPolynomial(p2, p1);
            view.setResult(difference1.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void derivative1Controller() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial derivative1 = derivativePolynomial(p1);
            view.setResult(derivative1.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void derivative2Controller() {
        try {
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial derivative2 = derivativePolynomial(p2);
            view.setResult(derivative2.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void integral1Controller() {
        try {
            Polynomial p1 = toPolynomial(view.getPolynomial1());
            Polynomial integral1 = integralPolynomial(p1);
            view.setResult(integral1.toString() + "+C");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }

    private void integral2Controller() {
        try {
            Polynomial p2 = toPolynomial(view.getPolynomial2());
            Polynomial integral2 = integralPolynomial(p2);
            view.setResult(integral2.toString() + " +C");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view.getJFrame(), e.getMessage());
        }
    }
}
