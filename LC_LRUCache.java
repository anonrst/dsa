import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int value, int key){
        this.value  = value;
        this.key = key;
    }
}

class LRUCache {
    private final HashMap<Integer,Node> table;
    private final int cap;
    private final Node head;
    private final Node tell;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.table = new HashMap<>();
        head = new Node(0,0);
        tell = new Node(0,0);
        head.next = tell;
        tell.prev = head;
    }
    
    public int get(int key) {
        if(!table.containsKey(key)) return -1;
        Node va = table.get(key);
        removeLeastUsed(va);
        addToHead(va);
        return va.value;
    }

    private void addToHead(Node m){
        m.next = head.next;
        m.prev = head;
        head.next.prev = m;
        head.next = m;
    }

    private void removeLeastUsed(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public void put(int key, int value) {
        if(table.containsKey(key)){
            Node node = table.get(key);
            node.value = value;
            removeLeastUsed(node);
            addToHead(node);
            return;
        }
        if(table.size() == cap){
            Node last = tell.prev;
            removeLeastUsed(last);
            table.remove(last.key);
        }
        Node newNode = new Node(value, key);
        addToHead(newNode);
        table.put(key, newNode);
    }
}

public class LC_LRUCache {
    public static void main(String[] args) {

    }
}
