package Circular;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;
    public Ticket(int ticketID, String customerName, String movieName, String seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = getCurrentDateTime();
        this.next = null;
    }
    private String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }
}
class CircularLinkedList {
    Ticket head = null;
    Ticket tail = null;
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }
    public void removeTicket(int ticketID) {
        if (head == null) return;
        if (head.ticketID == ticketID && head == tail) {
            head = null;
            tail = null;
            return;
        }
        Ticket current = head;
        Ticket prev = null;
        do {
            if (current.ticketID == ticketID) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                } else {
                    head = current.next;
                    tail.next = head;
                }
                System.out.println("Ticket removed successfully.");
                return;
            }
            prev = current;
            current = current.next;

        } while (current != head);
        System.out.println("Ticket ID " + ticketID + " not found.");
    }
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + "\nCustomer: " + current.customerName + "\nMovie: " + current.movieName + "\nSeat: " + current.seatNumber + "\nBooking Time: " + current.bookingTime);
            current = current.next;
            System.out.println();
        } while (current != head);
    }
    public Ticket searchTicket(String searchTerm) {
        if (head == null) return null;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }
    public int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}
public class TicketReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList ticketList = new CircularLinkedList();
        boolean running = true;
        while (running) {
            System.out.println("\nTicket Reservation System");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer or Movie Name");
            System.out.println("5. Show Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int ticketID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seatNumber = scanner.nextLine();
                    ticketList.addTicket(ticketID, customerName, movieName, seatNumber);
                    System.out.println("Ticket added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeID = scanner.nextInt();
                    ticketList.removeTicket(removeID);
                    break;
                case 3:
                    ticketList.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String searchTerm = scanner.nextLine();
                    Ticket foundTicket = ticketList.searchTicket(searchTerm);
                    if (foundTicket != null) {
                        System.out.println("Found Ticket: Ticket ID: " + foundTicket.ticketID + "\nCustomer: " + foundTicket.customerName + "\nMovie: " + foundTicket.movieName);
                    } else {
                        System.out.println("Ticket not found.");
                    }
                    break;
                case 5:
                    System.out.println("Total booked tickets: " + ticketList.totalTickets());
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}
