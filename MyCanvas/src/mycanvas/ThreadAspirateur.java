package mycanvas;

import aspirateur.Aspirateur;

public class ThreadAspirateur extends Thread {

	public ThreadAspirateur() {
	}

	public ThreadAspirateur(String name) {
		super(name);

	}

	public ThreadAspirateur(ThreadGroup group, Runnable target) {
		super(group, target);

	}

	public ThreadAspirateur(ThreadGroup group, String name) {
		super(group, name);

	}

	public ThreadAspirateur(Runnable target, String name) {
		super(target, name);

	}

	public ThreadAspirateur(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);

	}

	public ThreadAspirateur(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);

	}


	@Override
	public void run() {
		super.run();

		try {
			MyCanvas.aspirateur.Boucle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
