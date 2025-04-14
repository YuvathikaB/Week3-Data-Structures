package Single;
import java.util.Scanner;
class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;
    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    Item head = null;
    void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }
    void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }
    void addAtPosition(String name, int id, int qty, double price, int pos) {
        if (pos <= 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        int count = 1;
        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }
    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }
    void updateQuantity(int id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = qty;
                return;
            }
            temp = temp.next;
        }
    }
    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Item Found: " + temp.name + "\nID: " + temp.id + "\nQty: " + temp.quantity + "\nPrice: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Item Found: " + temp.name + "\nID: " + temp.id + "\nQty: " + temp.quantity + "\nPrice: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }
    void totalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }
    Item mergeSort(Item head, String key, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item mid = getMiddle(head);
        Item nextMid = mid.next;
        mid.next = null;
        Item left = mergeSort(head, key, ascending);
        Item right = mergeSort(nextMid, key, ascending);
        return merge(left, right, key, ascending);
    }
    Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    Item merge(Item a, Item b, String key, boolean asc) {
        Item result = null;
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (key.equals("name")) {
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }
        if (condition) {
            result = a;
            result.next = merge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = merge(a, b.next, key, asc);
        }
        return result;
    }
    void sortInventory(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
    }
    void display() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + " | ID: " + temp.id + " | Qty: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add at Begin\n2.Add at End\n3.Add at Pos\n4.Remove by ID\n5.Update Qty\n6.Search by ID\n7.Search by Name\n8.Total Value\n9.Sort by Name\n10.Sort by Price\n11.Display\n12.Exit");
            System.out.println();
            System.out.print("Your choice: ");
            int ch = sc.nextInt();
            if (ch == 12) break;
            switch (ch) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Qty: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    if (ch == 1) inventory.addAtBeginning(name, id, qty, price);
                    else if (ch == 2) inventory.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(name, id, qty, price, pos);
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to remove: ");
                    int rid = sc.nextInt();
                    inventory.removeById(rid);
                    break;
                case 5:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("New Quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(uid, newQty);
                    break;
                case 6:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    inventory.searchById(sid);
                    break;
                case 7:
                    System.out.print("Enter Name to search: ");
                    sc.nextLine();
                    String sname = sc.nextLine();
                    inventory.searchByName(sname);
                    break;
                case 8:
                    inventory.totalValue();
                    break;
                case 9:
                    System.out.print("Sort by Name Asc(1)/Desc(0): ");
                    boolean ascName = sc.nextInt() == 1;
                    inventory.sortInventory("name", ascName);
                    inventory.display();
                    break;
                case 10:
                    System.out.print("Sort by Price Asc(1)/Desc(0): ");
                    boolean ascPrice = sc.nextInt() == 1;
                    inventory.sortInventory("price", ascPrice);
                    inventory.display();
                    break;
                case 11:
                    inventory.display();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

