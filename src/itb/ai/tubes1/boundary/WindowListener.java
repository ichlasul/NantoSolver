package itb.ai.tubes1.boundary;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowListener extends JFrame {
	public static final long serialVersionUID = 1L;

	public WindowListener(String s) {
		super(s);
		setVisible(true);
	}

	public static void main(String[] args) {
		WindowListener frame = new WindowListener("Window Listener");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Window Closing");
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("Window Activated");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Window Closed");
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("Window Deactivated");
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("Window Opened");
			}

			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("Window Iconified");
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("Window Deiconified");
			}
		});

		frame.setSize(50, 100);
	}
}
