package com.yang.suanfa;

/**
 * @Author: yang
 * @Date: 2020-08-16 22:48
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
//        int target = 9;
//        int arr[] = new int[]{2, 7, 11, 15};
//        int[] ints = twoSum(arr, target);
//        System.out.println(ints[0]);
//        System.out.println(ints[1]);
        ListNode dummyHead = new ListNode(3);
        dummyHead.next = new ListNode(4);
        dummyHead.next.next = new ListNode(2);

        ListNode dummyHead2 = new ListNode(4);
        dummyHead2.next = new ListNode(6);
        dummyHead2.next.next = new ListNode(7);
        printList(dummyHead);
        System.out.println("------------------------------------");
        printList(dummyHead2);

        ListNode listNode = addTwoNumbers(dummyHead, dummyHead2);

        printList(listNode);

    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            if (head.next == null)
                System.out.println(head.data);
            else
                System.out.print(head.next.data + " --> ");
            head = head.next;
        }
    }
}
