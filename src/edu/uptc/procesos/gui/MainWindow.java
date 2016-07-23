package edu.uptc.procesos.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import edu.uptc.procesos.logic.GestionProcesos;
import edu.uptc.procesos.logic.HiloPlanificador;
import edu.uptc.procesos.logic.NodeList;

public class MainWindow extends JFrame {

	private GestionProcesos gestion;
	private PanelTabla panelTabla;
	private PanelAcciones panelAcciones;
	private PanelInformacion panelInformacion;
	private ManagementEvent eventos;
	private HiloPlanificador hilo;

	public MainWindow(String title) throws HeadlessException {
		super(title);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(15, 15));
		eventos = new ManagementEvent(this);
		panelTabla = new PanelTabla(this);
		panelAcciones = new PanelAcciones(this);
		panelInformacion = new PanelInformacion(this);
		gestion = new GestionProcesos();

		this.add(panelTabla, BorderLayout.CENTER);
		this.add(panelAcciones, BorderLayout.EAST);
		this.add(panelInformacion, BorderLayout.SOUTH);

	}

	public ManagementEvent getEventos() {
		return eventos;
	}

	public void setEventos(ManagementEvent eventos) {
		this.eventos = eventos;
	}

	public void addProcess() {
		gestion.addProcess();
		updateTable();

	}

	public void ejecutar() {
		switch (panelAcciones.getPlanificadores().getSelectedItem().toString()) {
		case "FCFS": {
			hilo = new HiloPlanificador(this, gestion.getProcesos());
			hilo.setPlanificador(1);
			hilo.start();
		}
			break;
		case "SJF":
			System.out.println("SJF");
			break;
		case "Por Prioridad":
			System.out.println("prioridad");
			break;
		case "Round Robin":
			System.out.println("robin");
			break;
		}
	}

	public void updateTable() {
		NodeList aux = gestion.getProcesos().getHead();
		panelTabla.getTableModel().setRowCount(0);
		if (aux != null) {
			do {
				Object[] row = { aux.getProceso().getPid(), aux.getProceso().getEstado(),
						aux.getProceso().getPrioridad(), aux.getProceso().getTiempoE() };
				panelTabla.getTableModel().addRow(row);
				aux = aux.getNext();

			} while (aux != gestion.getProcesos().getHead());
		}

	}

	public PanelInformacion getPanelInformacion() {
		return panelInformacion;
	}

	public void setPanelInformacion(PanelInformacion panelInformacion) {
		this.panelInformacion = panelInformacion;
	}

	public GestionProcesos getGestion() {
		return gestion;
	}

	public void setGestion(GestionProcesos gestion) {
		this.gestion = gestion;
	}

	public static void main(String[] args) {
		MainWindow ventana = new MainWindow("Planificadores");
		ventana.setVisible(true);
	}

}
