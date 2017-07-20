package week2;

/**
 * Created by shrikant.pandhare on 7/19/17.
 */
public class PalidromeList {

     //Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int lPalin(ListNode A) {
        ListNode startPtr = A;
        ListNode middlePtr = middleNode(A);
        ListNode reversedStart = reverse(middlePtr);
        while (reversedStart != null) {
            if (startPtr.val != reversedStart.val) {
                return 0;
            }
            reversedStart = reversedStart.next;
            startPtr = startPtr.next;
        }
        return 1;
    }

    private ListNode middleNode(ListNode a) {
        ListNode sizeNode = a;
        ListNode fastRunner = a;
        ListNode slowRunner = a;

        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

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
}
