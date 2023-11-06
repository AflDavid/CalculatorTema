package org.example;
import java.util.Stack;

public class Calculator {
    private double currentValue;
    private History history;

    public Calculator() {
        currentValue = 0;
        history = new History();
    }

    public void performOperation(char operator, double operand) {
        Operation operation = new Operation(operator, operand);
        history.pushOperation(operation);

        switch (operator) {
            case '+':
                currentValue += operand;
                break;
            case '-':
                currentValue -= operand;
                break;
            case '*':
                currentValue *= operand;
                break;
            case '/':
                if (operand != 0) {
                    currentValue /= operand;
                } else {
                    System.out.println("Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void undo() {
        Operation operation = history.popUndo();
        if (operation != null) {
            currentValue = operation.undo(currentValue);
        } else {
            System.out.println("Cannot undo");
        }
    }

    public void redo() {
        Operation operation = history.popRedo();
        if (operation != null) {
            currentValue = operation.redo(currentValue);
        } else {
            System.out.println("Cannot redo");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.performOperation('+', 5);
        calculator.performOperation('*', 3);
        System.out.println("Value: " + calculator.getCurrentValue());

        calculator.undo();
        System.out.println("Undo: " + calculator.getCurrentValue());

        calculator.redo();
        System.out.println("Redo: " + calculator.getCurrentValue());
    }
}