package week2;

/**
 * Created by shrikant.pandhare on 7/20/17.
 */
public class KReverseLinkedList {
    //Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode reverseList(ListNode A, int B) {

        ListNode starNode = A;
        int index = 1;
        int length = size(A);

        while (length > 0) {
            swapKNodes(A, B);
            length -= B;
            A = runToNode(A, B);
            A = A.next;
        }
        return starNode;
    }

    private ListNode runToNode(ListNode a, int number) {
        int index = 1;
        while (a != null) {
            if (index == number) {
                return a;
            }
            a = a.next;
            index++;
        }
        return null;
    }

    private void swapKNodes(ListNode a, int k) {
        ListNode current = a;
        ListNode next;
        while (k > 1 && current != null) {
            ListNode b = runToNode(current, k);
            swapValues(current, b);

            current = current.next;
            k = k - 2;
        }
    }

    private void swapValues(ListNode a, ListNode b) {
        if (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val =temp;
        }
    }

    private int size(ListNode a) {
        int size = 0;
        while (a != null) {
            a = a.next;
            size++;
        }
        return size;
    }

    private ListNode createList(int number) {
        ListNode startNode = null;
        ListNode n = null;
        int val = 1;
        while (number > 0) {
            if (startNode == null) {
                n = new ListNode(val);
                startNode = n;
            } else {
                ListNode newNode = new ListNode(val);
                n.next = newNode;
                n = newNode;
            }
            val++;
            number--;
        }

        return startNode;
    }

    private void printList(ListNode n) {
        System.out.println("Printing list ==>");

        while (n != null) {
            System.out.print(n.val);

            if (n.next != null) {
                System.out.print(" -> ");
            }

            n = n.next;
        }
        System.out.println("  ..done");
    }

    public static void main(String[] args) {
        KReverseLinkedList obj = new KReverseLinkedList();

        ListNode n = obj.createList(12);
        obj.printList(n);
        n = obj.reverseList(n, 3);
        obj.printList(n);

    }
}
