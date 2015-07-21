package list;

public class ListNode {
	
	private int data;
	private ListNode next;
	
	public ListNode(int data){
		this.data = data; 
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){ 
		return data;
	}
	
	public void setNext(ListNode node){
		next = node;
	}
	
	public ListNode getNext(){
		return next;
	}
	
	public int listLength(){
		int size = 0;
		ListNode header = this;
		while(header != null){
			size++;
			header = header.getNext();
		}
		return size;
	}
	
	public ListNode insertInLinkedList(ListNode insert, int position){
		if(position > listLength() + 1 || position < 1){
			System.err.println("Inavalid Postion " + listLength());
			return this;
		}
		
		if(position == 1){
			insert.setNext(this);
			return insert;
		}else{
			ListNode previousNode = this;
			for(int i = 1; i < position-1; i++){
				previousNode = previousNode.getNext();
			}
			ListNode currentNode = previousNode.getNext();
			 insert.setNext(currentNode);
			previousNode.setNext(insert);
		}
			
		return this;
	}
	
	public ListNode deleteLinkedList(int position){
		
		ListNode head = this;
		//position은 1보다 커야 하며 현재 리스트 사이즈보다 클수 없다.
		if(position > listLength() || position < 1){
			System.err.println("Inavalid Postion " + listLength());
			return this;
		}
		//position이 1이면 현재 포지션다음 노드가 head가 된다.
		if(position == 1){
			ListNode newHead = this.getNext();
			head = null;
			return newHead;
		}
		
		//position에 앞에 해당되는 것이 현재 포지션에 다음 포지션을 next로 취하도록 한다.
		else{
			ListNode previousNode = head;
			for(int i=2; i < position; i++){
				previousNode = this.getNext();
			}
			System.out.println("previousNode : " + previousNode.getData());
			try{
				ListNode afterNode = previousNode.getNext().getNext();
				System.out.println("afterNode : " + afterNode);
				previousNode.setNext(afterNode);
			}catch(Exception e){e.printStackTrace();}
			
		}
		
		return this;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		ListNode node = this;
		int count = 1;
		while(node != null){
			int value = node.getData();
			sb.append("Count : " + count);
			sb.append(", Value : " + value + "\n");
			node = node.getNext();
			count++;
		}
		return sb.toString();
		
	}
}
