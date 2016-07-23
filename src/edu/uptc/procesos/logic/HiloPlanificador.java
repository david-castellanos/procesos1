package edu.uptc.procesos.logic;

import edu.uptc.procesos.gui.MainWindow;

public class HiloPlanificador extends Thread {

	private int planificador;
	private MainWindow window;
	LinkedList procesos;
	private ThreadListener listener;

	public HiloPlanificador(MainWindow window, LinkedList procesos) {
		this.window = window;
		this.procesos = procesos;
		planificador = 0;
		listener = new ThreadListener(window);
		listener.start();
	}

	private void fcfs() {
		int n = 1;
		if (procesos.getHead() != null) {
			while (procesos.getHead() != null) {
				Proceso proceso = procesos.getHead().getProceso();
				if (proceso.getEstado() == Estados.LISTO) {
					try {
						sleep(600);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					proceso.setEstado(Estados.EJECUTANDO);
					window.updateTable();
					window.getPanelInformacion().getProcesoActivo().setText(proceso.getPid() + "");
					int time = 0;
					if (proceso.isInterrupt()) {
						window.getPanelInformacion().getProgreso().setMaximum(proceso.getTiempoE());
						while (time < (proceso.getTiempoE() - proceso.getTiempoInterrupt())) {
							try {
								sleep(1);
								time = time + 2;
								window.getPanelInformacion().getProgreso().setValue(time);
								window.getPanelInformacion().getProgreso().setString(time + "");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						proceso.setEstado(Estados.BlOQUEADO);
						listener.getBloqueados().add(procesos.kick().getProceso());
						proceso.setInterrupt(false);
						window.updateTable();
						proceso.start();
					} else {
						time = proceso.getTiempoInterrupt() - 2;
						window.getPanelInformacion().getProgreso().setMaximum(proceso.getTiempoE());
						while (time < proceso.getTiempoE()) {
							try {
								sleep(1);
								time = time + 2;
								window.getPanelInformacion().getProgreso().setValue(time);
								window.getPanelInformacion().getProgreso().setString(time + "");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						procesos.deleteNode(proceso.getPid());
						window.updateTable();
					}

					window.getPanelInformacion().getProgreso().setValue(0);
					window.getPanelInformacion().getProgreso().setString("-");
					window.getPanelInformacion().getProcesoActivo().setText("-");
				} else {
					procesos.kick();
					try {
						sleep(600);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (n == 1) {
						window.getPanelInformacion().getProgreso().setString("Esperando.");
						n++;
					} else if (n == 2) {
						window.getPanelInformacion().getProgreso().setString("Esperando..");
						n++;
					} else if (n == 3) {
						window.getPanelInformacion().getProgreso().setString("Esperando...");
						n = 1;
					}
				}

			}
		}
	}

	private void sjf() {
		if (procesos.getHead() != null) {
			while (procesos.getHead() != null) {
				Proceso proceso = procesos.getHead().getProceso();
				if (proceso.getEstado() == Estados.LISTO) {
					try {
						sleep(600);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					proceso.setEstado(Estados.EJECUTANDO);
					window.updateTable();
					window.getPanelInformacion().getProcesoActivo().setText(proceso.getPid() + "");
					int time = 0;
					if (proceso.isInterrupt()) {
						window.getPanelInformacion().getProgreso().setMaximum(proceso.getTiempoE());
						while (time < (proceso.getTiempoE() - proceso.getTiempoInterrupt())) {
							try {
								sleep(1);
								time = time + 2;
								window.getPanelInformacion().getProgreso().setValue(time);
								window.getPanelInformacion().getProgreso().setString(time + "");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						proceso.setEstado(Estados.BlOQUEADO);
						listener.getBloqueados().add(procesos.kick().getProceso());
						proceso.setInterrupt(false);
						window.updateTable();
						proceso.start();
					} else {
						time = proceso.getTiempoInterrupt() - 2;
						window.getPanelInformacion().getProgreso().setMaximum(proceso.getTiempoE());
						while (time < proceso.getTiempoE()) {
							try {
								sleep(1);
								time = time + 2;
								window.getPanelInformacion().getProgreso().setValue(time);
								window.getPanelInformacion().getProgreso().setString(time + "");
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						procesos.deleteNode(proceso.getPid());
						window.updateTable();
					}

					window.getPanelInformacion().getProgreso().setValue(0);
					window.getPanelInformacion().getProgreso().setString("-");
					window.getPanelInformacion().getProcesoActivo().setText("-");
				} else {
					procesos.kick();
					int n = 1;
					n++;
					window.getPanelInformacion().getProgreso().setString("Esperando..." + n);
				}

			}
		}
	}

	public void setPlanificador(int planificador) {
		this.planificador = planificador;
	}

	@Override
	public void run() {

		switch (planificador) {
		case 1:
			fcfs();
			break;
		case 2:
			sjf();
			break;
		}

	}

}
