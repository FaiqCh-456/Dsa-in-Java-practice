package Lab_midterm;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class MergeSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {


            if (l1.val < l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else {

                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;

        }

        if (l1 != null)
        {

            curr.next = l1;

        }
        else {

            curr.next = l2;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);


        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);

        MergeSortedLinkedLists merger = new MergeSortedLinkedLists();
        ListNode mergedList = merger.mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}

