package org.example;
import java.util.Stack;

class History {
    private Stack<Operation> undoHistory;
    private Stack<Operation> redoHistory;

    public History() {
        undoHistory = new Stack<>();
        redoHistory = new Stack<>();
    }

    public void pushOperation(Operation operation) {
        undoHistory.push(operation);
        redoHistory.clear();
    }

    public Operation popUndo() {
        if (!undoHistory.isEmpty()) {
            Operation operation = undoHistory.pop();
            redoHistory.push(operation);
            return operation;
        }
        return null;
    }

    public Operation popRedo() {
        if (!redoHistory.isEmpty()) {
            Operation operation = redoHistory.pop();
            undoHistory.push(operation);
            return operation;
        }
        return null;
    }
}