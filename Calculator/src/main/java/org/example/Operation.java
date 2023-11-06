package org.example;
import java.util.Stack;

class Operation {
    private char operator;
    private double operand;

    public Operation(char operator, double operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public double undo(double currentValue) {
        switch (operator) {
            case '+':
                return currentValue - operand;
            case '-':
                return currentValue + operand;
            case '*':
                return currentValue / operand;
            case '/':
                return currentValue * operand;
            default:
                return currentValue;
        }
    }

    public double redo(double currentValue) {
        switch (operator) {
            case '+':
                return currentValue + operand;
            case '-':
                return currentValue - operand;
            case '*':
                return currentValue * operand;
            case '/':
                return currentValue / operand;
            default:
                return currentValue;
        }
    }
}