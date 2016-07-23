package edu.uptc.procesos.logic;

public class LinkedList {

	private String lista;
	private NodeList head, tail;

	
	public LinkedList(String lista) {
		super();
		this.lista = lista;
	}

	
	public NodeList findNode(int serial) {
		if (isEmpty()){
			return null;
		}
		else{
			NodeList aux = head;

			do {
				if (aux.getProceso().getPid() == serial) {
					return aux;
				}
				aux = aux.getNext();
			} while (aux != head);

			return null;
		}
		
	}

	
	public NodeList addFirst(Proceso proceso) {
		NodeList newNode = new NodeList();
		newNode.setProceso(proceso);

		if (isEmpty()) {

			newNode.setNext(newNode);
			newNode.setBack(newNode);
			head = newNode;
			tail = newNode;

		}

		else {
			newNode.setNext(head);
			newNode.setBack(tail);
			head.setBack(newNode);
			head = newNode;
			tail.setNext(head);

		}
		return head;
	}
	
	public NodeList addLast(Proceso proceso) {
		NodeList newNode = new NodeList();
		newNode.setProceso(proceso);

		if (isEmpty()) {

			newNode.setNext(newNode);
			newNode.setBack(newNode);
			head = newNode;
			tail = newNode;

		}

		else {
			newNode.setNext(head);
			newNode.setBack(tail);
			head.setBack(newNode);
			tail.setNext(newNode);
			tail = newNode;

		}
		return head;
	}
	
	public NodeList kick(){
		head = head.getNext();
		tail = head.getBack();
		return tail;
	}

	
	public NodeList deleteNode(int pid) {

		NodeList next = head;
		NodeList last = null;

		if (findNode(pid) == head) {
			if (findNode(pid) == tail){
				head = null;
				tail = null;
			}
			else{
				tail.setNext(head.getNext());
				head.getNext().setBack(tail);
				head = head.getNext();
			}
			

			return head;
		}

		else {
			while (next != findNode(pid)) {

				last = next;
				next = next.getNext();

			}

			if (findNode(pid).getNext() == null) {
				tail = findNode(pid).getBack();
				last.setNext(findNode(pid).getNext());
			} else {
				findNode(pid).getNext().setBack(last);
				last.setNext(findNode(pid).getNext());
			}

			return head;
		}
	}
	
	public boolean isEmpty() {

		if (head == null) {
			return true;
		}

		return false;

	}

	public void listNodes() {

		NodeList aux = head;
		int back, next;
		
		if (isEmpty()){
			System.out.println("Empty List");
		}
		else{
			do {
				back = aux.getBack().getProceso().getPid();

				next = aux.getNext().getProceso().getPid();

				System.out.println("back= " + back + "  --  "
						+ aux.getProceso().getPid() + "  --  " + "next= " + next);
				aux = aux.getNext();
			} while (aux != head);
		}

	}

	public NodeList getHead() {
		return head;
	}

	public NodeList getTail() {
		return tail;
	}

	public void setHead(NodeList head) {
		this.head = head;
	}

}
