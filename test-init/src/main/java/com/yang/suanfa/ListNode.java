package com.yang.suanfa;

public class ListNode {
	 //数据
	int data;
	//下一个节点
	ListNode next;
	ListNode before;
	//创建一个无参数构造方法，用于初始化
	public ListNode(){
		
	}
	//创建一个有参数构造方法，便于给结点传数据
   public ListNode(int data){
	   this.data=data;
   }
}