package mycanvas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class ThreadAffichage extends Thread {

	public ThreadAffichage() {
	}

	public ThreadAffichage(String name) {
		super(name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target) {
		super(group, target);

	}

	public ThreadAffichage(ThreadGroup group, String name) {
		super(group, name);

	}

	public ThreadAffichage(Runnable target, String name) {
		super(target, name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);

	}

	public ThreadAffichage(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);

	}

	@Override
	public void run() {
		super.run();
		
		JFrame mainFrame = new JFrame("Intellignece Artificielle - Aspirateur");
		MyCanvas c = new MyCanvas();
		mainFrame.getContentPane().add(c);
		mainFrame.pack();
		mainFrame.setVisible(true);

		while (true) {
			c.paintComponent(c.getGraphics());
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(MyCanvas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
