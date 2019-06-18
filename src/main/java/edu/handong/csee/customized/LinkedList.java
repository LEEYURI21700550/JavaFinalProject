package edu.handong.csee.customized;

import java.util.ArrayList;

public class LinkedList<D> {
	private ListNode head;
	private ListNode tail;
	
	public LinkedList() {
		head = null;
	}


	public int length() {
		int count = 0;
		ListNode position = head;
		while(position != null) {
			count++;
			position = position.link;
		}
		return count;
	}
	
	public void addANodeToTail(D addData) {
		if(length()==0) {
			tail=new ListNode(addData,tail);
			head=tail;
		}else {
			tail.link = new ListNode(addData,tail.link);
		}
	}
	
	
	public ArrayList<D> toArrayList() {
		ArrayList<D> list = new ArrayList<D>(length());
		ListNode position = head;
		while(position != null) {
			list.add(position.data);
			position = position.link;
		}
		return list;
	}
	
	private class ListNode{
		private D data;
		
		public D getData() {
			return data;
		}

		public ListNode getLink() {
			return link;
		}

		private ListNode link;
		
		public ListNode(D newData, ListNode linkedNode) {
			data = newData;
			link = linkedNode;
		}
	}
}