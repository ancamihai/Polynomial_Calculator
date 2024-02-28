package org.example.business_logic;

import org.example.data_models.Polynomial;

import java.util.regex.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static org.example.business_logic.Operations.addPolynomial;


public class Parsing {
    public static Polynomial toPolynomial(String s) throws Exception {
        Polynomial thePolynomial = new Polynomial();
        try {
            if (!s.equals("")) {
                Pattern p = Pattern.compile("([+-]?\\d*(?:X(?:\\^\\d+)?)?)");
                int end = 0;
                Matcher m = p.matcher(s);
                while (m.find() && m.start() < s.length()) {
                    String sign = m.group().substring(0, 1);
                    if (sign.equals("-")) {
                        thePolynomial = addPolynomial(thePolynomial, minusParsing(m.group(), m.start(), m.end()));
                    } else if (sign.equals("+")) {
                        thePolynomial = addPolynomial(thePolynomial, plusParsing(m.group(), m.start(), m.end()));
                    } else {
                        thePolynomial = addPolynomial(thePolynomial, noSymbolParsing(m.group(), m.start(), m.end()));
                    }
                    if (m.start() != end) {
                        throw new Exception();
                    } else {
                        end = m.end();
                    }
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("Invalid input format (make sure the fields of the polynomials aren't empty)");
        }
        return thePolynomial;
    }

    private static Polynomial minusParsing(String group, int start, int end) throws Exception {
        Polynomial polynomial = new Polynomial();
        int x = group.indexOf("X");
        if (x == -1) {
            Double value = parseDouble(group);
            polynomial.addMonomial(0, value);
        } else if (x == 1) {
            if (x != end - start - 1) {
                if (group.substring(x + 1, x + 2).equals("^")) {
                    Integer coefficient = parseInt(group.substring(x + 2));
                    polynomial.addMonomial(coefficient, -1.0); }
                else {
                    throw new Exception(); }
            } else {
                polynomial.addMonomial(1, -1.0);
            }
        } else {
            Double value = parseDouble(group.substring(0, x));
            if (x != end - start - 1) {
                if (group.substring(x + 1, x + 2).equals("^")) {
                    Integer coefficient = parseInt(group.substring(x + 2));
                    polynomial.addMonomial(coefficient, value); }
                else {
                    throw new Exception(); }
            } else {
                polynomial.addMonomial(1, value);
            }
        }
        return polynomial;
    }

    private static Polynomial plusParsing(String group, int start, int end) throws Exception {
        Polynomial polynomial = new Polynomial();
        int x = group.indexOf("X");
        if (x == -1) {
            Double value = parseDouble(group.substring(1));
            polynomial.addMonomial(0, value);
        } else if (x == 1) {
            if (x != end - start - 1) {
                if (group.substring(x + 1, x + 2).equals("^")) {
                    Integer coefficient = parseInt(group.substring(x + 2));
                    polynomial.addMonomial(coefficient, 1.0);
                } else {
                    throw new Exception();
                }
            } else {
                polynomial.addMonomial(1, 1.0);
            }
        } else {
            Double value = parseDouble(group.substring(1, x));
            if (x != end - start - 1) {
                if (group.substring(x + 1, x + 2).equals("^")) {
                    Integer coefficient = parseInt(group.substring(x + 2));
                    polynomial.addMonomial(coefficient, value); }
                else {
                    throw new Exception(); }
            } else {
                polynomial.addMonomial(1, value);
            }
        }
        return polynomial;
    }

    private static Polynomial noSymbolParsing(String group, int start, int end) throws Exception {
        Polynomial polynomial = new Polynomial();
        if (start == 0) {
            int x = group.indexOf("X");
            if (x == -1) {
                Double value = parseDouble(group);
                polynomial.addMonomial(0, value); }
            else if (x == 0) {
                if (x != end - start - 1) {
                    if (group.substring(x + 1, x + 2).equals("^")) {
                        Integer coefficient = parseInt(group.substring(x + 2));
                        polynomial.addMonomial(coefficient, 1.0); }
                    else {
                        throw new Exception(); } }
                else {
                    polynomial.addMonomial(1, 1.0); } }
            else {
                Double value = parseDouble(group.substring(0, x));
                if (x != end - start - 1) {
                    if (group.substring(x + 1, x + 2).equals("^")) {
                        Integer coefficient = parseInt(group.substring(x + 2));
                        polynomial.addMonomial(coefficient, value); }
                    else {
                        throw new Exception(); } }
                else {
                    polynomial.addMonomial(1, value); } }

            return polynomial; }
        else {
            throw new Exception(); }
    }

}
