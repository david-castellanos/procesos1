package edu.uptc.procesos.logic;

import java.util.Random;
import edu.uptc.procesos.gui.MainWindow;

public class GestionProcesos{

	private LinkedList procesos;

	public GestionProcesos() {
		super();
		procesos = new LinkedList("Procesos");
		// TODO Auto-generated constructor stub
	}

	public void addProcess() {
		String cod = "";
		for (int i = 0; i < 4; i++) {
			Random rnd = new Random();
			cod += rnd.nextInt(10);
		}
		int pid = Integer.parseInt(cod);
		while (procesos.findNode(pid) != null) {
			cod = "";
			for (int i = 0; i < 4; i++) {
				Random rnd = new Random();
				cod += rnd.nextInt(10);
			}
			pid = Integer.parseInt(cod);
		}

		Proceso proceso = new Proceso(pid);
		procesos.addLast(proceso);
	}

	public void deleteProcess(int pid) {

		procesos.deleteNode(pid);

	}
	
	public Proceso getShortest(){
		if (procesos.isEmpty()){
			return null;
		}
		else{
			NodeList aux = procesos.getHead();
			Proceso menor = aux.getProceso(); 

			do {
				
				if (aux.getProceso().getTiempoE() < menor.getTiempoE()) {
					menor = aux.getProceso();
				}
				aux = aux.getNext();
			} while (aux != procesos.getHead());

			return menor;
		}
	}
	
	

	public LinkedList getProcesos() {
		return procesos;
	}

	public void setProcesos(LinkedList procesos) {
		this.procesos = procesos;
	}

}
