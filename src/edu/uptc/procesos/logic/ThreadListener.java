package edu.uptc.procesos.logic;

import java.util.ArrayList;

import edu.uptc.procesos.gui.MainWindow;

public class ThreadListener extends Thread {

	private ArrayList<Proceso> bloqueados;
	private MainWindow window;

	public ThreadListener(MainWindow window) {
		this.window = window;
		bloqueados = new ArrayList<>();
	}

	public ArrayList<Proceso> getBloqueados() {
		return bloqueados;
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < bloqueados.size(); i++) {
				if (bloqueados.get(i).getEstado().equals(Estados.LISTO)) {
					window.updateTable();
					bloqueados.remove(i);
				}
			}
		}
	}
}
