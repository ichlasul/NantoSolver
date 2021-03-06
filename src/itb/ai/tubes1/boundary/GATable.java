package itb.ai.tubes1.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class GATable {

	private JFrame frmGeneticAlgorithmTable;
	private OptionPreference optionPreference;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					WindowUtilities.setNativeLookAndFeel();
					GATable window = new GATable();
					window.frmGeneticAlgorithmTable.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GATable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		optionPreference = new OptionPreference();

		frmGeneticAlgorithmTable = new JFrame();
		frmGeneticAlgorithmTable.setTitle("Genetic Algorithm Table");
		frmGeneticAlgorithmTable.setBounds(100, 100, 640, 480);
		frmGeneticAlgorithmTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmGeneticAlgorithmTable.setJMenuBar(menuBar);

		JMenu mnGeneticAlgotirhm = new JMenu("  Genetic Algorithm  ");
		menuBar.add(mnGeneticAlgotirhm);

		JMenuItem mntmSolve = new JMenuItem("Solve!");
		mntmSolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					optionPreference.readFromFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(optionPreference.getMaxLoop() + "\n"
						+ optionPreference.isManualLoop() + "\n"
						+ optionPreference.getPathKandidat() + "\n"
						+ optionPreference.getPathTempat() + "\n"
						+ optionPreference.getPathUmum());
			}
		});
		mnGeneticAlgotirhm.add(mntmSolve);

		JMenuItem mntmOption = new JMenuItem("Option...");
		mntmOption.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				OptionDialog optionDialog = new OptionDialog();
				optionDialog.show();
			}
		});
		mnGeneticAlgotirhm.add(mntmOption);

		JMenu mnAbout = new JMenu("  About  ");
		menuBar.add(mnAbout);

		JMenuItem mntmHelp = new JMenuItem("Help...");
		mnAbout.add(mntmHelp);

		JMenuItem mntmAbout = new JMenuItem("About...");
		mnAbout.add(mntmAbout);
		frmGeneticAlgorithmTable.getContentPane().setLayout(
				new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		frmGeneticAlgorithmTable.getContentPane().add(scrollPane,
				BorderLayout.EAST);
	}

}
