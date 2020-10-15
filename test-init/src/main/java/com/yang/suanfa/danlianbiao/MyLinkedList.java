package com.yang.suanfa.danlianbiao;

public class MyLinkedList {

    private Node head;        //头节点

    // 新增节点,在尾部新增
    public void addHead(Node node) {
        //头节点是否存在
        if (head == null) {
            head = node;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    // 新增节点，在头部新增
    public void addTail(Node node) {
        node.next = head;
        head = node;
    }

    // 删除下标为k的节点
    public boolean delete(int k) {
        if (k < 0 || k > length() - 1) {
            //todo 下标越界异常处理
            return false;
        }
        if (k == 0) {
            head = head.next;
            return true;
        }
        int j = 1;
        Node currentNode = head;
        Node nextNode = currentNode.next;
        while (j < k) {
            currentNode = currentNode.next;
            nextNode = nextNode.next;
            j++;
        }
        currentNode.next = nextNode.next;
        return true;
    }

    // 查询下标为k的节点
    public Node query(int k) {
        if (k < 0 || k > length() - 1) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        Node currentNode = head;
        int j = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            j++;
            if (j == k) {
                return currentNode;
            }
        }
        return null;
    }

    // 查询链表长度
    public int length() {
        if (head == null) {
            return 0;
        }
        int length = 1;
        Node currentNode = head;
        while (currentNode.next != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    // 遍历节点
    public void getAllNode() {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        System.out.print(head.data + ", ");
        while (currentNode.next != null) {
            System.out.print(currentNode.next.data + ", ");
            currentNode = currentNode.next;
        }
    }

    // 在下标为k的位置插入节点
    public boolean insert(int k, Node node) {
        if (k < 0 || k > length() - 1) {
            //todo 下标越界异常处理
            return false;
        }
        if (k == 0) {
            node.next = head;
            head = node;
            return true;
        }
        Node currentNode = head;
        int i = 1;
        while (i < k) {
            currentNode = currentNode.next;
            i++;
        }
        node.next = currentNode.next;
        currentNode.next = node;
        return true;
    }

    // 排序节点 int类型的可以这样排序
    public void sort() {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            while (nextNode != null) {
                // int 类型的节点可以这样子排序
                if ((int) currentNode.data > (int) nextNode.data) {
                    int temp = (int) currentNode.data;
                    currentNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;
        }
    }

    // 链表反转，遍历法  输入原链表头节点，返回反转后链表的头节点(即原链表的尾节点)
    public Node reversal(Node head) {
        if (head == null || head.next == null) return head;
        Node preNode = head;                //上个节点
        Node currentNode = head.next;       //当前节点
        Node temp;                          //临时节点，用于保存当前节点的下一个节点
        while (currentNode != null) {       //假如当前节点为null，说明此时位于尾节点
            temp = currentNode.next;
            currentNode.next = preNode;     //节点指向反转
            //节点向后移动
            preNode = currentNode;
            currentNode = temp;
        }
        head.next = null;
        return preNode;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        Node node6 = new Node(60);
        ll.addHead(node1);
        ll.addHead(node2);
        ll.addHead(node5);
        ll.addHead(node3);
        ll.addHead(node6);
        ll.addHead(node4);

        System.out.print("排序前：");
        ll.getAllNode();
        ll.sort();
        System.out.print("\n排序后：");
        ll.getAllNode();

        System.out.println("\n链表长度=" + ll.length());
        ll.delete(2);
        System.out.print("\n删除下标为2的节点：");
        ll.getAllNode();
        System.out.println("\n删除后长度=" + ll.length());

        System.out.println("\n下标为0的节点=" + ll.query(0).data);

        Node reversal = ll.reversal(node1);
        //遍历反转后的链表
        System.out.print("\n 反转后的链表：" + reversal.data + ", ");
        while (reversal.next != null) {
            reversal = reversal.next;
            System.out.print(reversal.data + ", ");
        }

    }

}
