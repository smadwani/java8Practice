package madwani.sushil.leetcode.Jan1_7_2021;

public class MergeTwoSortedLists {
    static ListNode temp = null;
    static ListNode root = null;

    public static void main(String[] args) {
        ListNode inp1 = constructInput(new int[] {1, 2, 4});
        ListNode inp2 = constructInput(new int[] {1, 3, 4});
        ListNode inp3 = constructInput(new int[] {});
        ListNode inp4 = constructInput(new int[] {});
        ListNode root3 = mergeTwoLists(inp1, inp3);
        System.out.println(root3);
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            if ( temp == null) {
                temp = l2;
            } else {
                temp.next = l2;
            }
            return temp;
        }
        if (l2 == null) {
            if ( temp == null) {
                temp = l1;
            } else {
                temp.next = l1;
            }
            return temp;
        }
        int val;
        if (l1.val <= l2.val) {
            val = l1.val;
            l1 = l1.next;
        } else {
            val = l2.val;
            l2 = l2.next;
        }
        if (temp == null) {
            temp = new ListNode(val, new ListNode());
            root = temp;
        } else {
            temp.next = new ListNode(val, new ListNode());
            temp = temp.next;
        }
        mergeTwoLists(l1, l2);
        return root;
    }


    static ListNode constructInput(int[] ints) {
        if ( ints.length == 0) {
            return null;
        }
        ListNode inp = new ListNode(ints[0]);
        ListNode inp1 = inp;
        for ( int i =1; i< ints.length; i++) {
            inp.next = new ListNode(ints[i]);
            inp = inp.next;
        }
        return inp1;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



