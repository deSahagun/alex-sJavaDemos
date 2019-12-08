/**
 * Created by Alex on 6/8/19.
 */

public class LeetCode21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {


        ListNode firstdummy = new ListNode(0); //create a node
        ListNode iterate    = firstdummy;


        while(list1 != null || list2 != null)
        {
            if((list1 != null && list2 != null && list1.val <= list2.val) || (list1 != null) && (list2 != null))
            {
                iterate.next = list1;
                list1 = list1.next;
            }

            else{
                iterate.next = list2;
                list2 = list2.next;
            }

            iterate = iterate.next;

        }

        return firstdummy.next;

       // ListNode list3 = new ListNode();


    }


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 != null && l2 == null)
//        {
//            return l1;
//        }
//        else if (l2 != null && l1 == null) {
//            return l2;
//        }
//        else if (l1 == null && l2 == null) {
//            return null;
//        }
//        else{
//            ListNode head = null;
//            if (l1.val > l2.val) {
//                head = l2;
//                head.next = mergeTwoLists(l1, l2.next);
//            } else {
//                head = l1;
//                head.next = mergeTwoLists(l1.next, l2);
//            }
//
//            return head;
//        }
//
//    }
//


    ListNode buildList(ListNode head, int factor, int limit, int counter) {
        if (counter > limit || head == null)
            return head;

        ListNode node = new ListNode(counter * factor);
        head.next = node;

        return buildList(node, factor, limit, counter + 1);

    }





    void SOP(ListNode root)
    {
        while (root != null) {
            System.out.print(root.val + "\t");
            root = root.next;
        }
    }


    void recursiveSop(ListNode root)
    {
        if(root == null)
        {
            return;
        }

        System.out.print(root.val + "\t");
        recursiveSop(root.next);

    }



    public static void main(String[] args) {
        LeetCode21_MergeTwoSortedLists merge = new LeetCode21_MergeTwoSortedLists();

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        merge.buildList(list1, 1, 8, 2);  // ListNode head, int factor, int limit, int counter
        merge.buildList(list2, 2, 4, 2);
        merge.SOP(list1);
        System.out.println();
        merge.SOP(list2);
        System.out.println();
        ListNode head = merge.mergeTwoLists(list1, list2);
        merge.SOP(head);

    }
}

class ListNode {
    int val;
    ListNode next;

    public String toString() {
        String s;

        return "val=" + val + "  " + ((next != null) ? next.toString() : "null");
    }

    ListNode(int x) { val = x; }

   // ListNode(int x, int y) { val = x; }
}