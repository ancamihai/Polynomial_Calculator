package org.example.business_logic;

import org.example.data_models.Polynomial;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Operations {

    public static Polynomial addPolynomial(Polynomial p1, Polynomial p2) {
        Polynomial sum = new Polynomial();
        sum.setCoefficientToValueMap(p1.getCoefficientToValueMap());
        for (Map.Entry<Integer, Double> entry : p2.getCoefficientToValueMap().entrySet()) {
            sum.addMonomial(entry.getKey(), entry.getValue());
        }
        return sum;
    }

    public static Polynomial subtractPolynomial(Polynomial p1, Polynomial p2) {
        Polynomial difference = new Polynomial();
        difference.setCoefficientToValueMap(p1.getCoefficientToValueMap());
        for (Map.Entry<Integer, Double> entry : p2.getCoefficientToValueMap().entrySet()) {
            difference.addMonomial(entry.getKey(), 0.0 - entry.getValue());
        }
        return difference;
    }

    public static Polynomial multiplyPolynomial(Polynomial p1, Polynomial p2) {
        Polynomial product = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getCoefficientToValueMap().entrySet()) {
            for (Map.Entry<Integer, Double> entry1 : p2.getCoefficientToValueMap().entrySet()) {
                product.addMonomial(entry.getKey() + entry1.getKey(), entry.getValue() * entry1.getValue());
            }
        }
        return product;
    }

    public static ArrayList<Polynomial> divisionPolynomial(Polynomial p1, Polynomial p2) throws Exception {
        ArrayList<Polynomial> resultOfDivision = new ArrayList<>();
        try {
            if (p1.getCoefficientToValueMap().isEmpty() || p2.getCoefficientToValueMap().isEmpty()) {
                throw new Exception();
            } else {
                if (p1.sortPolynomial().firstKey() >= p2.sortPolynomial().firstKey()) {
                    resultOfDivision = dividePolynomial(p1, p2);
                } else {
                    resultOfDivision = dividePolynomial(p2, p1);
                }
            }
        } catch (Exception e) {
            throw new Exception("You can't divide by 0");
        }
        return resultOfDivision;
    }

    private static ArrayList<Polynomial> dividePolynomial(Polynomial p1, Polynomial p2) {
        Polynomial quotient = new Polynomial();
        Polynomial currentMonomial = new Polynomial();
        Polynomial remainder = new Polynomial();
        ArrayList<Polynomial> resultOfDivision = new ArrayList<>();
        TreeMap<Integer, Double> sortedP1 = p1.sortPolynomial();
        TreeMap<Integer, Double> sortedP2 = p2.sortPolynomial();
        Integer p2Degree = sortedP2.firstEntry().getKey();
        while (!sortedP1.isEmpty() && sortedP1.firstEntry().getKey() > p2Degree) {
            int currentMonomialDegree = sortedP1.firstEntry().getKey() - p2Degree;
            double currentMonomialValue = sortedP1.firstEntry().getValue() / sortedP2.firstEntry().getValue();
            quotient.addMonomial(currentMonomialDegree, currentMonomialValue);
            currentMonomial.addMonomial(currentMonomialDegree, currentMonomialValue);
            remainder = subtractPolynomial(p1, multiplyPolynomial(currentMonomial, p2));
            p1.setCoefficientToValueMap(remainder.getCoefficientToValueMap());
            sortedP1.clear();
            sortedP1.putAll(remainder.sortPolynomial());
            currentMonomial.getCoefficientToValueMap().clear();
        }
        if (!sortedP1.isEmpty()) {
            ArrayList<Polynomial> temporaryResult = divideSameDegree(p1, p2);
            quotient = addPolynomial(quotient, temporaryResult.get(0));
            remainder.setCoefficientToValueMap(temporaryResult.get(1).getCoefficientToValueMap());
        }
        resultOfDivision.add(quotient);
        resultOfDivision.add(remainder);
        return resultOfDivision;
    }

    private static ArrayList<Polynomial> divideSameDegree(Polynomial p1, Polynomial p2) {
        Polynomial quotient = new Polynomial();
        Polynomial currentMonomial = new Polynomial();
        Polynomial remainder = new Polynomial();
        ArrayList<Polynomial> resultOfDivision = new ArrayList<>();
        TreeMap<Integer, Double> sortedP1 = p1.sortPolynomial();
        TreeMap<Integer, Double> sortedP2 = p2.sortPolynomial();
        Integer p2Degree = sortedP2.firstEntry().getKey();
        int enteredLoop = 0;
        while (!sortedP1.isEmpty() && sortedP1.firstEntry().getKey() == p2Degree) {
            enteredLoop = 1;
            double currentMonomialValue = sortedP1.firstEntry().getValue() / sortedP2.firstEntry().getValue();
            quotient.addMonomial(0, currentMonomialValue);
            currentMonomial.addMonomial(0, currentMonomialValue);
            remainder = subtractPolynomial(p1, multiplyPolynomial(currentMonomial, p2));
            if (remainder.getCoefficientToValueMap().isEmpty()) {
                break; }
            else {
                p1.setCoefficientToValueMap(remainder.getCoefficientToValueMap());
                sortedP1.clear();
                sortedP1.putAll(remainder.sortPolynomial());
                currentMonomial.getCoefficientToValueMap().clear(); }
        }
        resultOfDivision.add(quotient);
        if (enteredLoop == 1) {
            resultOfDivision.add(remainder); }
        else {
            resultOfDivision.add(p1); }

        return resultOfDivision;
    }

    public static Polynomial derivativePolynomial(Polynomial p1) {
        Polynomial derivative = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getCoefficientToValueMap().entrySet()) {
            if (entry.getKey() != 0) {
                derivative.addMonomial(entry.getKey() - 1, entry.getKey() * entry.getValue());
            }
        }
        return derivative;
    }

    public static Polynomial integralPolynomial(Polynomial p1) {
        Polynomial integral = new Polynomial();
        for (Map.Entry<Integer, Double> entry : p1.getCoefficientToValueMap().entrySet()) {
            integral.addMonomial(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
        }
        return integral;
    }

}
