package edu.uptc.procesos.logic;

public class NodeList {

	private Proceso proceso;
	private NodeList next, back;

	public NodeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public Proceso getProceso() {
		return proceso;
	}





	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}





	public NodeList getNext() {
		return next;
	}

	public void setNext(NodeList next) {
		this.next = next;
	}
	
	



	public NodeList getBack() {
		return back;
	}



	public void setBack(NodeList back) {
		this.back = back;
	}



	@Override
	public String toString() {
		return "NodeList [guitar=" + proceso + ", next=" + next + ", back="
				+ back + "]";
	}


	
	
}
