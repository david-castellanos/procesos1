package edu.uptc.procesos.gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelAcciones extends JPanel {

	private MainWindow window;
	private JComboBox<String> planificadores;
	private JButton salir, ejecutar, nuevoProceso;

	public PanelAcciones(MainWindow window) {
		super();
		this.window = window;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder(new EtchedBorder(), "Opciones"));
		planificadores = new JComboBox<>();
		planificadores.addItem("FCFS");
		planificadores.addItem("SJF");
		planificadores.addItem("Por Prioridad");
		planificadores.addItem("Round Robin");
		salir = new JButton("Salir");
		salir.setActionCommand(ManagementEvent.EXIT);
		salir.addActionListener(window.getEventos());
		ejecutar = new JButton("Ejecutar");
		ejecutar.setActionCommand(ManagementEvent.EJECUTAR);
		ejecutar.addActionListener(window.getEventos());
		nuevoProceso = new JButton("Nuevo proceso");
		nuevoProceso.setActionCommand(ManagementEvent.ADD);
		nuevoProceso.addActionListener(window.getEventos());

		JPanel cont1 = new JPanel();
		JPanel cont2 = new JPanel();
		JPanel cont = new JPanel();
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		cont.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		cont2.setLayout(new GridLayout(2, 1, 0, 15));
		cont1.setLayout(new GridLayout(4, 1, 0, 15));
		cont2.add(new JLabel("Planificador:"));
		cont2.add(planificadores);
		cont1.add(cont2);
		cont1.add(ejecutar);
		cont1.add(nuevoProceso);
		cont1.add(salir);
		cont.add(cont1);
		add(cont);

	}

	public JComboBox<String> getPlanificadores() {
		return planificadores;
	}

	public void setPlanificadores(JComboBox<String> planificadores) {
		this.planificadores = planificadores;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JButton getEjecutar() {
		return ejecutar;
	}

	public void setEjecutar(JButton ejecutar) {
		this.ejecutar = ejecutar;
	}

	public JButton getNuevoProceso() {
		return nuevoProceso;
	}

	public void setNuevoProceso(JButton nuevoProceso) {
		this.nuevoProceso = nuevoProceso;
	}

}
