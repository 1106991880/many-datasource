package com.yang.arithmetic;

import com.yang.java8.Student;
import org.junit.Test;

/**
 * @Author: yang
 * @Date: 2020/12/8 下午4:05
 * @Description: 两数相加
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 解法1：
 * 整体思路：
 * 将长度较短的链表在末尾补零使得两个连表长度相等，再一个一个元素对其相加（考虑进位）
 * 获取两个链表所对应的长度
 * 在较短的链表末尾补零
 * 对齐相加考虑进位
 * <p>
 * 解法2：
 * 整体思路：
 * 不对齐补零，若链表不为空则用 sum(代表每个位的和的结果)加上，考虑进位。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;
            // 判断有没有大于10 大于10 要进位 并且保留数字
            // 获得个位数字
            ListNode listNode = new ListNode(sumVal % 10);
            cursor.next = listNode;
            cursor = listNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 返回最终的链表
        return root.next;
    }


    @Test
    public void test1() {
        String s = "string data";
        String a = s;
        a = "new string data";
        System.out.println("a=====" + a);
        System.out.println("s=====" + s);
        TestType testType = new TestType();
        Student student = new Student();
        Student student1 = student;
        student1.setAge(13);
        System.out.println(student.getAge());
        System.out.println(student1.getAge());
    }


    @Test
    public void test() {
        System.out.println("result:" + 11 % 10);
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        printListNode(l1);
        int listNodeLength1 = getListNodeLength(l1);
        System.out.println("链表的长度：" + listNodeLength1);
        ListNode l2 = new ListNode(7, new ListNode(0, new ListNode(8)));
        printListNode(l2);
        int listNodeLength2 = getListNodeLength(l2);
        System.out.println("链表的长度：" + listNodeLength2);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("打印相加完的链表");
        printListNode(listNode);
    }

    // 遍历单链表
    public void printListNode(ListNode listNode) {
        ListNode cur = listNode;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.val + "->");
            } else {
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
        System.out.println();
    }

    // 获取单链表的长度
    public int getListNodeLength(ListNode listNode) {
        ListNode cur = listNode;
        int length = 0;
        if (cur == null) {
            return length;
        }
        while (cur != null) {
            cur = cur.next;
            length = length + 1;
        }
        return length;
    }
}

// 单链表
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
