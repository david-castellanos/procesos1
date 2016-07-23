package edu.uptc.procesos.gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelInformacion extends JPanel {

	private JProgressBar progreso;
	private JLabel procesoActivo;
	private MainWindow window;

	public PanelInformacion(MainWindow window) {
		super();
		this.window = window;
		progreso = new JProgressBar();
		progreso.setStringPainted(true);
		progreso.setString("-");
		procesoActivo = new JLabel("-");
		this.window = window;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new TitledBorder(new EtchedBorder(), "Información"));

		JPanel cont1 = new JPanel();
		cont1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		cont1.setLayout(new BoxLayout(cont1, BoxLayout.X_AXIS));

		JPanel cont2 = new JPanel();
		cont2.setLayout(new GridLayout(2, 1, 0, 15));
		cont2.add(new JLabel("Proceso en ejecución:"));
		cont2.add(procesoActivo);
		cont1.add(cont2);

		JPanel cont3 = new JPanel();
		cont3.setLayout(new GridLayout(2, 1, 0, 15));
		cont3.add(new JLabel("Tiempo Restante:"));
		cont3.add(progreso);

		cont1.add(cont2);
		cont1.add(cont3);
		add(cont1);

	}

	public JProgressBar getProgreso() {
		return progreso;
	}

	public void setProgreso(JProgressBar progreso) {
		this.progreso = progreso;
	}

	public JLabel getProcesoActivo() {
		return procesoActivo;
	}

	public void setProcesoActivo(JLabel procesoActivo) {
		this.procesoActivo = procesoActivo;
	}

}
