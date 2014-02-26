package itb.ai.tubes1.boundary;

import javax.swing.*;
import java.awt.event.*;

public class WindowListener extends JFrame {	
	public static final long serialVersionUID = 1L;
	public WindowListener(String s) {
		super(s);
		setVisible(true);
	}
	
	public static void main (String[] args) {
		WindowListener frame = new WindowListener("Window Listener");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Window Closing");
			}
			
			public void windowActivated(WindowEvent e) {
				System.out.println("Window Activated");
			}
			
			public void windowClosed(WindowEvent e) {
				System.out.println("Window Closed");
			}
			
			public void windowDeactivated(WindowEvent e) {
				System.out.println("Window Deactivated");
			}
			
			public void windowOpened(WindowEvent e) {
				System.out.println("Window Opened");
			}
			
			public void windowIconified(WindowEvent e) {
				System.out.println("Window Iconified");
			}
			
			public void windowDeiconified(WindowEvent e) {
				System.out.println("Window Deiconified");
			}
		});
		
		frame.setSize(50,100);		
	}		
}
