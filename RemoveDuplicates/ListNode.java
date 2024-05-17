package RemoveDuplicates;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }


    
    // Example usage:
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        
        // Create a sorted linked list with duplicates
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        // Print original list
        System.out.println("Original List:");
        printList(head);

        // Remove duplicates
        ListNode result = solution.deleteDuplicates(head);

        // Print modified list without duplicates
        System.out.println("\nList after removing duplicates:");
        printList(result);
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

