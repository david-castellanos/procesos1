package edu.uptc.procesos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagementEvent implements ActionListener {
	private MainWindow window;
	private boolean fileChange = false;

	public static final String ABOUT = "Acerca de";
	public static final String EJECUTAR = "Ejecutar planificador";
	public static final String ADD = "Mostrar Add Dialog";
	public static final String ADD2 = "Agregar Guitarra";
	public static final String DELETE = "Mostrar Delete Dialog";
	public static final String DELETE2 = "Eliminar Guitarra";
	public static final String FIND = "Buscar Guitarra";
	public static final String EXIT = "Salir";
	public static final String EXIT_DIALOG = "Salir del dialogo";

	public ManagementEvent(MainWindow window) {
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch (arg0.getActionCommand()) {
		case ADD:
			window.addProcess();
			break;
		case EXIT:
			System.exit(0);
			break;
		case EJECUTAR:
			window.ejecutar();
			break;

		}

	}

}