/**
 * @author initiald0824
 * @date 2019/12/31 18:29
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int val1, val2;
        while (l1 != null || l2 != null) {
            val1 = val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sumVal = val1 + val2 + carry;
            int val = sumVal % 10;
            carry = sumVal / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    }
}
