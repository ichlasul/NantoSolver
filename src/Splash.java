

import itb.ai.tubes1.boundary.WindowUtilities;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Splash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowUtilities.setNativeLookAndFeel();
					Splash frame = new Splash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Eksekusi!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO
				/*
				String[] cmd = {"C:\\Windows\\System32\\cmd.exe", "java", "Demo" };
		        Process p = null;
				try {
					p = Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
		        try {
					p.waitFor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				*/
				try {
					//Process process = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe","java","Demo").start();
					System.out.println(System.getProperty("user.dir"));
					Process start = Runtime.getRuntime().exec(new String[]
							{ "cmd", "/c", "start", "java", "Demo" });
					BufferedReader r = new BufferedReader(
						     new InputStreamReader(start.getErrorStream()));
						String line = null;
						while ((line = r.readLine()) != null)
						{
						    System.out.println(line);
						}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(153, 97, 117, 56);
		contentPane.add(btnNewButton);
	}
}
