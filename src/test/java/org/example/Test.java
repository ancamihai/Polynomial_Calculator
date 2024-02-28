package org.example;

import org.example.business_logic.Operations;
import org.example.data_models.Polynomial;

import static org.example.business_logic.Operations.*;
import static org.example.business_logic.Parsing.toPolynomial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Test {
    Operations operations=new Operations();
    Polynomial p1;
    Polynomial p2;

    @org.junit.jupiter.api.Test
    void addPolynomialsTest() throws Exception {
        p1=toPolynomial("4X^5-3X^4+X^2-8X+1");
        p2=toPolynomial("3X^4-X^3+X^2+2X-1");
        Polynomial result=addPolynomial(p1,p2);
        Polynomial expectedResult=toPolynomial("4X^5-X^3+2X^2-6X");
        assertEquals(expectedResult,result);
    }

    @org.junit.jupiter.api.Test
    void subtractPolynomialsTest() throws Exception {
        p1=toPolynomial("4X^5-3X^4+X^2-8X+1");
        p2=toPolynomial("3X^4-X^3+X^2+2X-1");
        Polynomial result=subtractPolynomial(p1,p2);
        Polynomial expectedResult=toPolynomial("4X^5-6X^4+X^3-10X+2");
        assertEquals(result,expectedResult);
    }

    @org.junit.jupiter.api.Test
    void multiplyPolynomialsTest() throws Exception {
        p1=toPolynomial("3X^2-X+1");
        p2=toPolynomial("X-2");
        Polynomial result=multiplyPolynomial(p1,p2);
        Polynomial expectedResult=toPolynomial("3X^3-7X^2+3X-2");
        assertEquals(result,expectedResult);
    }

    @org.junit.jupiter.api.Test
    void quotientDividePolynomialsTest() throws Exception {
        p1=toPolynomial("X^3-2X^2+6X-5");
        p2=toPolynomial("X^2-1");
        Polynomial result=divisionPolynomial(p1,p2).get(0);
        Polynomial expectedResult=toPolynomial("X-2");
        assertEquals(result,expectedResult);
    }

    @org.junit.jupiter.api.Test
    void remainderDividePolynomialsTest() throws Exception {
        p1=toPolynomial("X^3-2X^2+6X-5");
        p2=toPolynomial("X^2-1");
        Polynomial result=divisionPolynomial(p1,p2).get(1);
        Polynomial expectedResult=toPolynomial("7X-7");
        assertEquals(result,expectedResult);
    }

    @org.junit.jupiter.api.Test
    void derivativePolynomialTest() throws Exception {
        p1=toPolynomial("X^3-2X^2+6X-5");
        Polynomial result=derivativePolynomial(p1);
        Polynomial expectedResult=toPolynomial("3X^2-4X+6");
        assertEquals(result,expectedResult);
    }

    @org.junit.jupiter.api.Test
    void integralPolynomialTest() throws Exception {
        p1=toPolynomial("4X^3+3X^2+5");
        Polynomial result=integralPolynomial(p1);
        Polynomial expectedResult=toPolynomial("X^4+X^3+5X");
        assertEquals(result,expectedResult);
    }

}
