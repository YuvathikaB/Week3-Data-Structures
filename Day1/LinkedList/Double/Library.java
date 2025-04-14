package Double;
import java.util.Scanner;
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;
    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    Book head = null;
    Book tail = null;
    int bookCount = 0;
    void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }
    void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }
    void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            if (temp.next != null) temp.next.prev = newBook;
            temp.next = newBook;
            newBook.prev = temp;
        }
        bookCount++;
    }
    void removeById(int bookId) {
        if (head == null) return;
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                bookCount--;
                return;
            }
            temp = temp.next;
        }
    }
    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: Title: " + temp.title + "\nAuthor: " + temp.author + "\nGenre: " + temp.genre + "\nBook ID: " + temp.bookId + "\nAvailable: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found with the title: " + title);
    }
    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: Title: " + temp.title + "\nAuthor: " + temp.author + "\nGenre: " + temp.genre + "\nBook ID: " + temp.bookId + "\nAvailable: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book found by author: " + author);
    }
    void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Book ID " + bookId + " availability updated to: " + (isAvailable ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
    void displayForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Book ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }
    void displayReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Book ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }
    int countBooks() {
        return bookCount;
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add at Beginning\n2.Add at End\n3.Add at Position\n4.Remove by ID\n5.Search by Title\n6.Search by Author\n7.Update Availability\n8.Display Forward\n9.Display Reverse\n10.Count Books\n11.Exit");
            System.out.println();
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            if (choice == 11) break;
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    library.addAtBeginning(title, author, genre, bookId, isAvailable);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    sc.nextLine();
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    isAvailable = sc.nextBoolean();
                    library.addAtEnd(title, author, genre, bookId, isAvailable);
                    break;
                case 3:
                    System.out.print("Enter Title: ");
                    sc.nextLine();
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    isAvailable = sc.nextBoolean();
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    library.addAtPosition(title, author, genre, bookId, isAvailable, position);
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    bookId = sc.nextInt();
                    library.removeById(bookId);
                    break;
                case 5:
                    System.out.print("Enter Title to search: ");
                    sc.nextLine();
                    title = sc.nextLine();
                    library.searchByTitle(title);
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    sc.nextLine();
                    author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 7:
                    System.out.print("Enter Book ID to update availability: ");
                    bookId = sc.nextInt();
                    System.out.print("Enter new Availability (true/false): ");
                    isAvailable = sc.nextBoolean();
                    library.updateAvailability(bookId, isAvailable);
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    System.out.println("Total Books in Library: " + library.countBooks());
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

