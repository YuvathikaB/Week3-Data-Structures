package HashMap;
import java.util.Scanner;
public class HashMap {
    static class Entry {
        int key;
        String value;
        Entry next;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    static class MyHashMap {
        private final int SIZE = 100;
        private Entry[] table;

        public MyHashMap() {
            table = new Entry[SIZE];
        }
        private int hash(int key) {
            return key % SIZE;
        }
        public void put(int key, String value) {
            int index = hash(key);
            Entry head = table[index];
            while (head != null) {
                if (head.key == key) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            Entry newEntry = new Entry(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
        }
        public String get(int key) {
            int index = hash(key);
            Entry head = table[index];
            while (head != null) {
                if (head.key == key) {
                    return head.value;
                }
                head = head.next;
            }
            return null;
        }
        public boolean remove(int key) {
            int index = hash(key);
            Entry head = table[index];
            Entry prev = null;
            while (head != null) {
                if (head.key == key) {
                    if (prev == null) {
                        table[index] = head.next;
                    } else {
                        prev.next = head.next;
                    }
                    return true;
                }
                prev = head;
                head = head.next;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyHashMap map = new MyHashMap();
        while (true) {
            System.out.println("\nHashMap Operations:");
            System.out.println("1. Put (key value)");
            System.out.println("2. Get (key)");
            System.out.println("3. Remove (key)");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose operation (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter key and value: ");
                    int key = scanner.nextInt();
                    String value = scanner.next();
                    map.put(key, value);
                    System.out.println("Inserted (" + key + ", " + value + ")");
                    break;
                case 2:
                    System.out.print("Enter key to get: ");
                    key = scanner.nextInt();
                    String result = map.get(key);
                    if (result != null)
                        System.out.println("Value = " + result);
                    else
                        System.out.println("Key not found.");
                    break;
                case 3:
                    System.out.print("Enter key to remove: ");
                    key = scanner.nextInt();
                    boolean removed = map.remove(key);
                    if (removed)
                        System.out.println("Key removed.");
                    else
                        System.out.println("Key not found.");
                    break;
               case 4:
                   return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
