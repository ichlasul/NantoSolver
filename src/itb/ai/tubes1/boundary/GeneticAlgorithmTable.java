package itb.ai.tubes1.boundary;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GeneticAlgorithmTable extends JFrame {
	public static final long serialVersionUID = 1L;	
	private JMenuBar menuBar;
	private JMenu menuContainerGA, menuContainerAbout;
	private JMenuItem solveMenu, helpMenu, aboutMenu;
	private ActionListener solveAction, helpAction, aboutAction;
	
	public GeneticAlgorithmTable() {
		super("Genetic Algorithm Table");				
						
		menuBar = new JMenuBar();		
		
		solveMenu = new JMenuItem("Solve");
		helpMenu = new JMenuItem("Help");
		aboutMenu = new JMenuItem("About");
		
		menuContainerGA = new JMenu("  Genetic Algorithm  ");
		menuContainerAbout = new JMenu("  About  ");
						
		menuBar.add(menuContainerGA);
		menuBar.add(menuContainerAbout);
		
		menuContainerGA.add(solveMenu);
		menuContainerAbout.add(helpMenu);
		menuContainerAbout.add(aboutMenu);	
		
		this.getContentPane().add(BorderLayout.NORTH, menuBar);
		
		solveAction = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Solve text", "Solve Title", 0);
			}
		};
		
		helpAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Help text", "Help Title", 0);
			}
		};
		
		aboutAction = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "About text", "About Title", 0);
			}
		};
		
		solveMenu.addActionListener(solveAction);
		helpMenu.addActionListener(helpAction);
		aboutMenu.addActionListener(aboutAction);
	}
	
	public static void main(String[] args)
	{
		WindowUtilities.setNativeLookAndFeel();
		GeneticAlgorithmTable GAT = new GeneticAlgorithmTable();
		GAT.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GAT.setSize(1000,600);
		GAT.setVisible(true);
	}
}