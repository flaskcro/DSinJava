package list.test;

import list.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ListNodeTest {

	@Test
	public void testListNode() {
		ListNode node = new ListNode(10);
		assertEquals(10,node.getData());
	}

	@Test
	public void testSetData() {
		ListNode node = new ListNode(20);
		node.setData(10); 
	}

	@Test
	public void testGetData() {
		ListNode node = new ListNode(10);
		assertEquals(10,node.getData());
	}

	@Test
	public void testSetNext() {
		ListNode node = new ListNode(20);
		node.setNext(new ListNode(10));
		assertEquals(10,node.getNext().getData());
	}

	@Test
	public void testGetNext() {
		ListNode node = new ListNode(20);
		node.setNext(new ListNode(10));
		assertEquals(10,node.getNext().getData());
	}
	
	@Test
	public void testListLength() {
		ListNode node = new ListNode(10);
		ListNode child1 = new ListNode(11);
		node.setNext(child1);
		ListNode child2 = new ListNode(12);
		child1.setNext(child2);
		assertEquals(3,node.listLength());
	}
	
	@Test
	public void testInsertInLinkedList() {
		System.out.println("TEST");
		ListNode head = new ListNode(10);
		ListNode child1 = new ListNode(11);
		head.setNext(child1);
		ListNode child2 = new ListNode(12);
		child1.setNext(child2);
		System.out.println(head.toString());		
		
		ListNode tail = new ListNode(13);
		head = head.insertInLinkedList(tail,4);
		System.out.println("TEST STEP 1");
		assertEquals(13,head.getNext().getNext().getNext().getData());
		System.out.println(head.toString());		
		
		ListNode tail2 = new ListNode(20);
		head = head.insertInLinkedList(tail2,3);
		System.out.println("TEST STEP 2 : " + head.getData());
		assertEquals(20,head.getNext().getNext().getData());
		System.out.println(head.toString());	
		
		ListNode newHead = new ListNode(100);
		head = head.insertInLinkedList(newHead,1);
		System.out.println("TEST STEP 3 : " + head.getData());
		assertEquals(100,head.getData());
		System.out.println(head.toString());		
	}
	
	@Test
	public void testDeleteLinkedList(){
		ListNode head = new ListNode(10);
		ListNode child1 = new ListNode(11);
		head.setNext(child1);
		ListNode child2 = new ListNode(12);
		child1.setNext(child2);
		ListNode child3 = new ListNode(13);
		child2.setNext(child3);
		
		head = head.deleteLinkedList(1);
		assertEquals(11,head.getData());
		System.out.println(head.toString());		
		
		head = head.deleteLinkedList(2);
		assertEquals(2,head.listLength());
		System.out.println(head.toString());		
		
		head = head.deleteLinkedList(2);
		assertEquals(1,head.listLength());
		System.out.println(head.toString());		
	}

}
