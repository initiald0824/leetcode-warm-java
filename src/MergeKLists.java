//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
// 示例:
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6
// Related Topics 堆 链表 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * @author initiald0824
 * @date 2020/3/2 8:27 下午
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeBorderLists(lists, 0, lists.length);
    }

    private ListNode mergeBorderLists(ListNode[] lists, int start, int end) {
        if (start == end-1) {
            return lists[0];
        }
        int mid = (start+end-1) / 2;
        int distance = mid + 1 - start;
        for (int i = 0; i <= mid; i++) {
            if (i+distance == end) {
                break;
            }
            lists[i] = merge2Lists(lists[i], lists[i+distance]);
        }
        mergeBorderLists(lists, start, mid+1);
        return lists[0];
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l00 = new ListNode(1);
        ListNode l01 = new ListNode(4);
        ListNode l02 = new ListNode(5);
        l00.next = l01;
        l01.next = l02;
        l02.next = null;

        ListNode l10 = new ListNode(1);
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        l10.next = l11;
        l11.next = l12;
        l12.next = null;

        ListNode l20 = new ListNode(2);
        ListNode l21 = new ListNode(6);
        l20.next = l21;
        l21.next = null;

        ListNode[] lists = new ListNode[]{l00, l10, l20};

        ListNode l = new MergeKLists().mergeKLists(lists);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
