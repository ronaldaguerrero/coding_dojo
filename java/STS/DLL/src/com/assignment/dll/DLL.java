package com.assignment.dll;

public class DLL {
	public Node head;
	public Node tail;
	
	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void push(Node newNode) {
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}
	
	public void printValuesBackward() {
		Node current = this.tail;
		
		while (current != this.head ) {
			System.out.println(current.value);
			current = current.next;
		}
	}
	
	public void pop() {
		if(this.tail != null && this.head != null) {
			Node temp = tail.previous;
			temp.next = null;
		}
	}
	
	public boolean container(Integer value) {
		Node current = this.head;
		if(this.tail != null && this.head != null) {
			do {
				if (current.value == value) {
					System.out.println("The value exists in the DLL");
					return true;
				}
				current = current.next;
			} while (current != null);
		}
		System.out.println("The value does not exist in the DLL");
		return false;
	}
	
	public int size() {
		int count = 0;;
		Node current = this.head;
		while(current != null) {
			current = current.next;
			count++;
		}
		System.out.println("Size of DLL: " + count);
		return count;
	}
	
	public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
}
