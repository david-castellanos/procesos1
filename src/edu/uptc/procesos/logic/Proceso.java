package edu.uptc.procesos.logic;

import java.util.Random;

public class Proceso extends Thread {

	private int tiempoInterrupt, duracionInterrupt, tiempoE, prioridad, pid;
	private boolean interrupt;
	private Estados estado;

	public Proceso(int tiempoE, int prioridad, int pid) {
		super();
		this.tiempoE = tiempoE;
		this.prioridad = prioridad;
		this.pid = pid;
		this.estado = Estados.LISTO;
	}

	public Proceso(int pid) {
		super();
		Double aleatorio = Math.floor(Math.random() * (10000 - 1000 + 1) + 1000);
		tiempoE = aleatorio.intValue();
		prioridad = 0;
		estado = Estados.LISTO;
		this.pid = pid;
		Random rnd = new Random();
		int resultado = rnd.nextInt(3);
		if (resultado == 1) {
			interrupt = true;
			tiempoInterrupt = rnd.nextInt(tiempoE + 1);
			duracionInterrupt = rnd.nextInt(30000);
		} else {
			interrupt = false;
		}
	}

	public int getTiempoE() {
		return tiempoE;
	}

	public void setTiempoE(int tiempoE) {
		this.tiempoE = tiempoE;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public int getTiempoInterrupt() {
		return tiempoInterrupt;
	}

	public void setTiempoInterrupt(int tiempoInterrupt) {
		this.tiempoInterrupt = tiempoInterrupt;
	}

	public boolean isInterrupt() {
		return interrupt;
	}

	public void setInterrupt(boolean interrupt) {
		this.interrupt = interrupt;
	}

	@Override
	public String toString() {
		return "Proceso [tiempoE=" + tiempoE + ", prioridad=" + prioridad + ", pid=" + pid + ", estado=" + estado + "]";
	}

	@Override
	public void run() {
		try {
			sleep(duracionInterrupt);
			estado = Estados.LISTO;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
