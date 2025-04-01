import java.util.*;

public class CustomHashMapDemo {
    static class CustomHashMap<K, V> {
        private class Node {
            K key;
            V value;
            Node next;
            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private Node[] table;
        private static final int INITIAL_CAPACITY = 16;
        @SuppressWarnings("unchecked")
        public CustomHashMap() {
            table = (Node[]) new CustomHashMap.Node[INITIAL_CAPACITY];
        }
        private int hash(K key) {
            return Math.abs(key.hashCode()) % table.length;
        }
        public void put(K key, V value) {
            int index = hash(key);
            Node node = table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = table[index];
            table[index] = newNode;
        }
        public V get(K key) {
            int index = hash(key);
            Node node = table[index];
            while (node != null) {
                if (node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }
        public void remove(K key) {
            int index = hash(key);
            Node node = table[index];
            Node prev = null;
            while (node != null) {
                if (node.key.equals(key)) {
                    if (prev == null) {
                        table[index] = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    return;
                }
                prev = node;
                node = node.next;
            }
        }
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        System.out.println(map.get("apple"));
        map.remove("apple");
        System.out.println(map.get("apple"));
    }
}
