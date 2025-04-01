class TextStateNode {
    String textState;
    TextStateNode next;
    TextStateNode prev;
    public TextStateNode(String textState) {
        this.textState = textState;
        this.next = null;
        this.prev = null;
    }
}
class TextEditor {
    TextStateNode currentState;
    TextStateNode undoState;
    TextStateNode redoState;
    public void addTextState(String textState) {
        TextStateNode node = new TextStateNode(textState);
        if (currentState != null) {
            currentState.next = node;
            node.prev = currentState;
        }
        currentState = node;
        redoState = null;
    }
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            redoState = currentState;
            currentState = currentState.prev;
        }
    }
    public void redo() {
        if (redoState != null) {
            currentState.next = redoState;
            redoState.prev = currentState;
            currentState = redoState;
            redoState = null;
        }
    }
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.textState);
        }
    }
}
public class TextEditorDoublyLinkedList {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
