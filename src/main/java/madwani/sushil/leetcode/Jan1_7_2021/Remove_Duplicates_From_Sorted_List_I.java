package madwani.sushil.leetcode.Jan1_7_2021;

public class Remove_Duplicates_From_Sorted_List_I {
    public static void main(String[] args) {
        ListNode inp1 = constructInput(new int[] {1, 1, 1 , 2, 2, 2, 3, 4, 5 , 6, 6});
        ListNode inp2 = constructInput(new int[] {-1 , -2, -2, 2, 3, 4, 5 , 6, 6});
        ListNode inp3 = constructInput(new int[0]);
        ListNode inp4 = constructInput(new int[] {1, 2, 3, 4, 5, 6});
        deleteDuplicates(inp1); // output : [1,2,3,4,5,6]
        deleteDuplicates(inp2); // output : [-1,-2,2,3,4,5,6]
        deleteDuplicates(inp3); // output : null
        deleteDuplicates(inp4); // output : [1, 2, 3, 4, 5, 6]
        deleteDuplicates(null); // output: null
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(-2000, head);
        ListNode temp1 = temp;
        while (temp1 !=null && temp1.next !=null) {
            if (temp1.val == temp1.next.val) {
                temp1.next = temp1.next.next;
            } else {
                temp1 = temp1.next;
            }
        }
        return temp.next;
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
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}

