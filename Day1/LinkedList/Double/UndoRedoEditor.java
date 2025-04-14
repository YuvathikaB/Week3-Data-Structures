package Double;
import java.util.Scanner;
class TextState {
    String content;
    TextState prev;
    TextState next;
    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    TextState head;
    TextState tail;
    TextState current;
    int size = 0;
    final int MAX_HISTORY = 10;
    void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null && current.next != null) current.next.prev = null;
        if (current != null) current.next = null;
        if (tail != null) tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        if (head == null) head = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo available.");
        }
    }
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo available.");
        }
    }
    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}
public class UndoRedoEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        while (true) {
            System.out.println();
            System.out.println("1. Type Text\n2. Undo\n3. Redo\n4. Display Current State\n5. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    return;
            }
        }
    }
}

