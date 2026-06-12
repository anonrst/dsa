import java.util.HashMap;

class Node {
    int key;
    int value;
    int freq;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
class DoubleLinkedList {
    Node head,tail;
    int size;
    DoubleLinkedList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        size++;
    }
    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        size--;
    }
    public Node removeLast(){
        if(size == 0) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }
    public boolean isEmpty(){return size == 0;};
}
class LFUCache {
    private final HashMap<Integer, Node> table;
    private final HashMap<Integer, DoubleLinkedList> frequencyTable;
    private final int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.table = new HashMap<>();
        this.frequencyTable = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = Integer.MAX_VALUE;
    }

    private void PromoteNext(Node n) {
        int freq = n.freq;
        DoubleLinkedList oldList = frequencyTable.get(n.freq);
        oldList.remove(n);
        if (oldList.isEmpty() && minFreq == freq) {
            minFreq = freq + 1;
        };
        n.freq++;
        frequencyTable.computeIfAbsent(n.freq, k -> new DoubleLinkedList()).addFirst(n);
    }

    public int get(int key) {
        if (!table.containsKey(key)) {
            return -1;
        }
        Node nod = table.get(key);
        PromoteNext(nod);
        return nod.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;
        if (table.containsKey(key)) {
            table.get(key).value = value;
            PromoteNext(table.get(key));
            return;
        }
        if (table.size() == capacity) {
            DoubleLinkedList leastList = frequencyTable.get(minFreq);
            Node leastNode = leastList.removeLast();
            table.remove(leastNode.key);
        }
        Node newNode = new Node(key, value);
        table.put(key, newNode);
        frequencyTable.computeIfAbsent(1, k -> new DoubleLinkedList()).addFirst(newNode);
        minFreq = 1;

    }
}

public class LC_LFUCache {

    public static void main(String[] args) {

    }
}