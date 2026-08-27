public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
