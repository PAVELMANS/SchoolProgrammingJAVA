/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polishieraksts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author pivanovs3
 */
public class PolishIeraksts {

    private final String strEquation;
    private String postfixEquation = ""; // bija = 0 
    private Stack<String> operands = new Stack<>();
    private Stack<Double> numbers = new Stack<>();
    private static double answer;
    private boolean firstNumIs = true;
    private double firstNum;
//    Stack<char> ch = new Stack<>();

    public PolishIeraksts(String x) {
        this.strEquation = "(" + x + ")";
        answer = 0;
        transform();
        System.out.println(postfixEquation);
        calculate();
    }

    private boolean isNumber(char c) {
        return (c >= '0') && (c <= '9') || c == '.';
    }

    private boolean isOperand(char c) {
        return (c == '+') || (c == '-') || (c == '*') || (c == '/');
    }

    @SuppressWarnings("empty-statement")
    private void transform() {
        int i = 0;
        numbers.push(0.0);
        while (i < strEquation.length()) {
            char ch = strEquation.charAt(i);
            if (isNumber(ch)) {
                int j = i + 1;
                for (; isNumber(strEquation.charAt(j)); j++);
                numbers.add(Double.parseDouble(strEquation.substring(i, j)));

                if (firstNumIs) {
                    if (strEquation.charAt(i - 1) == '-') {
                        firstNum = -Double.parseDouble(strEquation.substring(i, j));
                    } else {
                        firstNum = Double.parseDouble(strEquation.substring(i, j));
                    }
                    firstNumIs = false;
                    System.out.println(firstNum);
                }

                postfixEquation += " " + strEquation.substring(i, j);
                i = j;
                continue;
            }
            switch (ch) {
                case '(':
                    operands.push(ch + "");
                    break;
                case '*':
                case '/':
                    while (operands.peek().equals("*") || operands.peek().equals("/")) {
                        postfixEquation += operands.pop();
                    }
                    operands.push(ch + "");
                    break;
                case '+':
                case '-':
                    while (operands.peek().equals("*") || operands.peek().equals("/")
                            || operands.peek().equals("-") || operands.peek().equals("+")) {
                        postfixEquation += operands.pop();
                    }
                    operands.push(ch + "");
                    break;
                case ')':
                    while (!operands.peek().equals("(")) {
                        postfixEquation += operands.pop();
                    }
                    operands.pop();
            }
            i++;
        }
        postfixEquation = postfixEquation.substring(1); // nodzest atstarpi sākumā
    }

    private static void doOperation(char operand, double number) {
        switch (operand) {
            case '+':
                answer += number;
                break;
            case '-':
                answer -= number;
                break;
            case '*':
                answer *= number;
                break;
            case '/':
                answer /= number;
        }
    }

    @SuppressWarnings("empty-statement")
    private void calculate() {

        answer = firstNum;

        int i = 1; // jo pirmais simbols poļu pierasktā vienmēr ir skaitlis
        while (i < postfixEquation.length()) {
            char ch = postfixEquation.charAt(i);
            if (isOperand(ch)) {
                double number;
                int j;
                for (j = i - 1; isNumber(postfixEquation.charAt(j)); j--);
                number = Double.parseDouble(postfixEquation.substring(j, i));
                doOperation(ch, number);
            }
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("REMEMBER. USE FULL STOPS FOR DOUBLES");
        System.out.print("Please type in an equation: ");
        PolishIeraksts equation = new PolishIeraksts(bf.readLine());
        System.out.print("the new look: " + equation.postfixEquation + "\n");
        System.out.println("the answer is: " + equation.answer);

    }

}
