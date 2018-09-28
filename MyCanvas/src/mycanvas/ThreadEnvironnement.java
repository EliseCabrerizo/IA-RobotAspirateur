package mycanvas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadEnvironnement extends Thread {

	public ThreadEnvironnement() {
	}

	public ThreadEnvironnement(Runnable target) {
		super(target);

	}

	public ThreadEnvironnement(String name) {
		super(name);

	}

	public ThreadEnvironnement(ThreadGroup group, Runnable target) {
		super(group, target);

	}

	public ThreadEnvironnement(ThreadGroup group, String name) {
		super(group, name);

	}

	public ThreadEnvironnement(Runnable target, String name) {
		super(target, name);

	}

	public ThreadEnvironnement(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);

	}

	public ThreadEnvironnement(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);

	}

	@Override
	public void run() {
		super.run();

		while (true) {
			MyCanvas.environnement.Generation();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
