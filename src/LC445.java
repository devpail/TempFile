/**
 * 445. 两数相加 II
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * <p>
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author zhangzhb
 * @create 2018/5/29 19:39
 **/
public class LC445 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode head1 = l1;
//        l1.next = new ListNode(2);
//        l1 = l1.next;
//        l1.next = new ListNode(4);
//        l1 = l1.next;
//        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode head2 = l2;
//        l2.next = new ListNode(6);
//        l2 = l2.next;
//        l2.next = new ListNode(4);
        System.out.println(head1.toString());
        System.out.println(head2.toString());

        System.out.println(addTwoNumbers(head1,head2).toString());
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode temp = next;
            String str = val + "" ;
            while(temp!=null){
                str += "->" + temp.val;
                temp = temp.next;
            }
            return str;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = reverseListNode(l1);
        ListNode ln2 = reverseListNode(l2);
        System.out.println(ln1.toString());
        System.out.println(ln2.toString());
        ListNode t = new ListNode(0), lns = t;
        int v1, v2, vsum;
        boolean flag = false;
        while (ln1 != null || ln2 != null) {
            v1 = ln1 == null ? 0 : ln1.val;
            v2 = ln2 == null ? 0 : ln2.val;
            vsum = v1 + v2;
            //如果之前有进位则加1
            if (flag) {
                vsum++;
            }
            if (vsum > 9) {
                t.val = vsum % 10;
                flag = true;
            } else {
                t.val = vsum;
                flag = false;
            }
            t.next = new ListNode(0);
            t = t.next;
            ln1 = ln1==null?null:ln1.next;
            ln2 = ln2==null?null:ln2.next;
        }
        if(flag){
            t.val = 1;
        }

        //System.out.println(lns.toString());
        ListNode result = reverseListNode(lns);

        return result;

    }

    //反转链表
    public static ListNode reverseListNode(ListNode head) {
        ListNode cur = head, next = null, pre = null;
        int size = 0;
        while (cur != null) {
            size++;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while(pre.next!=null && pre.val==0){
            pre = pre.next;
        }
        head = pre;
        return head;
    }
}
