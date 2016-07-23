package edu.uptc.procesos.gui;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PanelTabla extends JPanel {

	private JTable tablaProcesos;
	private DefaultTableModel tableModel;
	private MainWindow window;

	public PanelTabla(MainWindow window) {

		this.window = window;

		setLayout(new GridLayout(1, 1));

		initializeComponents();
		addComponents();
	}

	private void initializeComponents() {

		String[] columns = new String[] { "PID", "Estado", "Prioridad", "Tiempo de Ejecución" };

		tableModel = new DefaultTableModel(columns, 0);

		tablaProcesos = new JTable(tableModel);

		ListSelectionModel lsm = tablaProcesos.getSelectionModel();

	}

	private void addComponents() {

		add(new JScrollPane(tablaProcesos));

	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
