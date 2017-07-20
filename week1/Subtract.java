package week1;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class Subtract {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode subtract(ListNode a) {

        int length = size(a);
        int half = length / 2;

        int firstPtr = 1;

        ListNode startNode = a;
        ListNode middleNode = a;
        ListNode middle = middleNode(middleNode);


        ListNode reverseHead = reverse(middle);
        ListNode reverseList = reverseHead;
        //firstPtr <= half &&
        while (a != null && reverseList != null) {
            a.val = reverseList.val - a.val;
            a = a.next;
            reverseList = reverseList.next;
            firstPtr++;
        }
        reverse(reverseHead);
        return startNode;
    }

    private int runToNode(ListNode a, int number) {
        int index = 1;
        while (a != null) {
            if (index == number) {
                return a.val;
            }
            a = a.next;
            index++;
        }

        return -1;
    }

    private ListNode middleNode(ListNode a) {
        ListNode sizeNode = a;
        int size = size(sizeNode);
        ListNode fastRunner = a;
        ListNode slowRunner = a;
        int length = 0;
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            length++;
        }
        if (size % 2 != 0) slowRunner = slowRunner.next; //adjust for middle
        return slowRunner;
    }

    private ListNode reverse(ListNode a) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        a = prev;
        return a;
    }

    private int size(ListNode a) {
        int size = 0;
        while (a != null) {
            a = a.next;
            size++;
        }
        return size;
    }
}
