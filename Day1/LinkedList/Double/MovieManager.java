package Double;
import java.util.Scanner;
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;
    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}
class MovieList {
    Movie head, tail;
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            Movie newMovie = new Movie(title, director, year, rating);
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }
    void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }
    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + temp.title + "\nYear: " + temp.year + "\nRating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by director " + director);
    }
    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + "\nDirector: " + temp.director + "\nYear: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }
    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println();
            System.out.println("Title: " + temp.title + "\nDirector: " + temp.director + "\nYear: " + temp.year + "\nRating: " + temp.rating);
            temp = temp.next;
            System.out.println();
        }
    }
    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println();
            System.out.println("Title: " + temp.title + "\nDirector: " + temp.director + "\nYear: " + temp.year + "\nRating: " + temp.rating);
            temp = temp.prev;
            System.out.println();
        }
    }
}
public class MovieManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieList list = new MovieList();
        while (true) {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Title\n5. Search by Director\n6. Search by Rating\n7. Update Rating\n8. Display Forward\n9. Display Reverse\n10. Exit");
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director1 = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year1 = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating1 = scanner.nextDouble();
                    scanner.nextLine();
                    list.addAtBeginning(title1, director1, year1, rating1);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director2 = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year2 = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating2 = scanner.nextDouble();
                    scanner.nextLine();
                    list.addAtEnd(title2, director2, year2, rating2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title3 = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director3 = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int year3 = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating3 = scanner.nextDouble();
                    scanner.nextLine();
                    list.addAtPosition(pos, title3, director3, year3, rating3);
                    break;
                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    list.removeByTitle(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Director Name to Search: ");
                    list.searchByDirector(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Rating to Search: ");
                    list.searchByRating(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Enter Movie Title: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    double newRating = scanner.nextDouble();
                    scanner.nextLine();
                    list.updateRating(updateTitle, newRating);
                    break;
                case 8:
                    list.displayForward();
                    break;
                case 9:
                    list.displayReverse();
                    break;
                case 10:
                    return;
            }
        }
    }
}
