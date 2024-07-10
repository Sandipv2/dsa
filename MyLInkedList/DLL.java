package MyLInkedList;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DLL {
    static public Node ArrToDLL(int[] nums) {
        if(nums.length == 0) return null;

        Node head = new Node(nums[0]);
        Node temp = head;

        for(int i = 1; i < nums.length; i++) {
            Node node = new Node(nums[i], null, temp);
            temp.next = node;
            temp = node;
        }

        return head;
    }

    static public void print(Node head) {
        if(head == null) return;
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static public Node AddHead(Node head, int val) {
        Node node = new Node(val, head, null);
        head.back = node;

        return node;
    }

    static public Node AddTail(Node head, int val) {
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }

        Node node = new Node(val, null, tail);
        tail.next = node;

        return head;
    }

    static public Node AddAtKth(Node head, int val, int k) {
        if(head == null) return head;
        if(k == 1) {
            return AddHead(head, val);
        }

        int count = 0;
        Node temp = head;

        while(temp != null) {
            count++;
            if (count == k) break;
            temp = temp.next;
        }

        if(temp == null) return null;

        Node prev = temp.back;
        Node node = new Node(val, temp, prev);

        prev.next = node;
        temp.back = node;

        return head;
    }

    static public void AddAtNode(Node node, int val) {
        Node back = node.back;
        Node newNode = new Node(val, node, back);

        back.next = newNode;
        node.back = newNode;
    }

    static public Node DeleteAtK(Node head, int k) {
        if(head.next == null && head.back == null) {
            if(k == 1) return null;
        }

        Node temp = head;
        int count = 0;

        while(temp != null) {
            count++;
            if(count == k) break;
            temp = temp.next;
        }
        if(temp == null) return null;

        Node back = temp.back;
        Node next = temp.next;

        if(back == null) {
            temp.next = null;
            next.back = null;
            return next;
        }
        else if(next == null) {
            temp.back = null;
            back.next = null;
            return back;
        }

        back.next = next;
        next.back = back;
        temp.next = temp.back = null;

        return head;
    }

    static public void DeleteNode(Node node) {
        Node prev = node.back;
        Node front = node.next;

        prev.next = front;
        front.back = prev;
        node.next = null;
        node.back = null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Node head = ArrToDLL(nums);
//        Node ans = DeleteAtK(head, 3);
        DeleteNode(head.next.next);

        print(head);
    }
}
