import java.util.*;
class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;
    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
class SocialMedia {
    UserNode head;
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }
    public UserNode searchUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }
    public UserNode searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) return temp;
            temp = temp.next;
        }
        return null;
    }
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }
    public void displayFriends(int userId) {
        UserNode user = searchUserById(userId);
        if (user != null) {
            for (int friendId : user.friendIds) {
                UserNode friend = searchUserById(friendId);
                if (friend != null) {
                    System.out.println(friend.userId + " - " + friend.name);
                }
            }
        }
    }
    public void mutualFriends(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            for (int id : user1.friendIds) {
                if (user2.friendIds.contains(id)) {
                    UserNode mutual = searchUserById(id);
                    if (mutual != null) {
                        System.out.println(mutual.userId + " - " + mutual.name);
                    }
                }
            }
        }
    }
    public int countFriends(int userId) {
        UserNode user = searchUserById(userId);
        if (user != null) {
            return user.friendIds.size();
        }
        return 0;
    }
}
public class SocialMediaSinglyLinkedList {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 25);
        sm.addUser(4, "David", 21);
        sm.addUser(5, "Eve", 23);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(2, 4);
        sm.addFriend(3, 5);
        System.out.println("Alice's Friends:");
        sm.displayFriends(1);
        System.out.println("Bob's Friends:");
        sm.displayFriends(2);
        System.out.println("Mutual Friends of Alice and Bob:");
        sm.mutualFriends(1, 2);
        System.out.println("Number of friends for Charlie: " + sm.countFriends(3));
        sm.removeFriend(1, 2);
        System.out.println("Alice's Friends after removing Bob:");
        sm.displayFriends(1);
    }
}
