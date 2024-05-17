package linkedlistmiddle;

class LinkedListMiddle {

    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    
    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = createLinkedList(values);

        LinkedListMiddle solution = new LinkedListMiddle();
        ListNode middle = solution.findMiddle(head);

        System.out.println("The middle element is: " + (middle != null ? middle.val : "List is empty"));
    }
}

