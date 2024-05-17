package RemoveDuplicates;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }


    
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        
        System.out.println("Original List:");
        printList(head);

        
        ListNode result = solution.deleteDuplicates(head);

        
        System.out.println("\nList after removing duplicates:");
        printList(result);
    }

    
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

