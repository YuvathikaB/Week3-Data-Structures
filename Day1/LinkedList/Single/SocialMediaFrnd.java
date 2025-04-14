package Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
class SocialMedia {
    User head;
    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }
    User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }
    void addFriend(int id1, int id2) {
        User user1 = findUser(id1);
        User user2 = findUser(id2);
        if (user1 != null && user2 != null && id1 != id2) {
            if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
            if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);
        }
    }
    void removeFriend(int id1, int id2) {
        User user1 = findUser(id1);
        User user2 = findUser(id2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(id2));
            user2.friendIds.remove(Integer.valueOf(id1));
        }
    }
    void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            for (int id : user.friendIds) {
                User friend = findUser(id);
                if (friend != null) System.out.print(friend.name + " ");
            }
            System.out.println();
        }
    }
    void mutualFriends(int id1, int id2) {
        User u1 = findUser(id1);
        User u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            boolean found = false;
            System.out.print("Mutual friends: ");
            for (int id : u1.friendIds) {
                if (u2.friendIds.contains(id)) {
                    User mutual = findUser(id);
                    if (mutual != null) {
                        System.out.print(mutual.name + " ");
                        found = true;
                    }
                }
            }
            if (!found) System.out.print("None.");
            System.out.println();
        }
    }

    void searchUserById(int id) {
        User user = findUser(id);
        if (user != null) System.out.println("Found: " + user.name + ", Age: " + user.age);
        else System.out.println("User not found.");
    }
    void searchUserByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: ID=" + temp.userId + ", Age=" + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }
    void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
public class SocialMediaFrnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        while (true) {
            System.out.println("\n1. Add User\n2. Add Friend\n3. Remove Friend\n4. Display Friends\n5. Mutual Friends\n6. Search by ID\n7. Search by Name\n8. Count Friends\n9. Display All Users\n10. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Age: ");
                    sm.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter User1 ID and User2 ID to connect: ");
                    sm.addFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter User1 ID and User2 ID to remove: ");
                    sm.removeFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    sm.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter two User IDs: ");
                    sm.mutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    sm.searchUserById(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter Name: ");
                    sm.searchUserByName(sc.next());
                    break;
                case 8:
                    sm.countFriends();
                    break;
                case 9:
                    sm.displayAllUsers();
                    break;
                case 10:
                    return;
            }
        }
    }
}

