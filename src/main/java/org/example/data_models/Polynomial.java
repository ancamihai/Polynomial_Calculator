package org.example.data_models;

import java.util.*;

public class Polynomial {

    private Map<Integer, Double> coefficientToValueMap;

    public Polynomial() {
        this.coefficientToValueMap = new HashMap<Integer, Double>();
    }

    public Map<Integer, Double> getCoefficientToValueMap() {
        return coefficientToValueMap;
    }

    public void setCoefficientToValueMap(Map<Integer, Double> coefficientToValueMap) {
        this.coefficientToValueMap.clear();
        this.coefficientToValueMap.putAll(coefficientToValueMap);
    }

    public TreeMap<Integer, Double> sortPolynomial() {
        TreeMap<Integer, Double> sortedByDegree = new TreeMap<>(Collections.reverseOrder());
        sortedByDegree.putAll(this.coefficientToValueMap);
        return sortedByDegree;
    }

    public void addMonomial(Integer coefficient, Double value) {
        int alreadyExisting = 0;
        int zeroValue = 0;
        for (Map.Entry<Integer, Double> entry : this.coefficientToValueMap.entrySet()) {
            if (Objects.equals(entry.getKey(), coefficient)) {
                if (!Objects.equals(entry.getValue() + value, 0.0)) {
                    this.coefficientToValueMap.put(coefficient, entry.getValue() + value);
                } else {
                    zeroValue = 1;
                }
                alreadyExisting = 1;
            }
        }
        if (alreadyExisting == 0) {
            if (value != 0) {
                this.coefficientToValueMap.put(coefficient, value);
            }
        }
        if (zeroValue == 1) {
            this.coefficientToValueMap.remove(coefficient);
        }
    }

    public String toString() {
        String string = "";
        if (this.coefficientToValueMap.isEmpty()) {
            string = "0"; }
        else {
            TreeMap<Integer, Double> sortedPolynomial = this.sortPolynomial();
            for (Map.Entry<Integer, Double> entry : sortedPolynomial.entrySet()) {
                if (entry.getValue() == 1) {
                    if (!string.equals("")) {
                        string = string + "+"; }
                    if (entry.getKey() == 0) {
                        string = string + "1.0"; }
                } else {
                    if (entry.getValue() < 0) {
                        string = string + entry.getValue();
                    } else if (!string.equals("")) {
                        string = string + "+" + entry.getValue();
                    } else {
                        string = string + entry.getValue();
                    }
                }
                if (entry.getKey() == 1) {
                    string = string + "X";
                } else if (entry.getKey() != 0) {
                    string = string + "X^" + entry.getKey();
                }
            }
        }
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        return this.getCoefficientToValueMap().equals(((Polynomial) obj).getCoefficientToValueMap());
    }

}
