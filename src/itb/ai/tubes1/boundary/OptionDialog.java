import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FileChooserUI;

import java.awt.Label;
import java.awt.GridBagLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.TextField;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JCheckBox;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Path;
import java.util.Formatter;


public class OptionDialog extends JDialog {

	private OptionPreference optionPreference;
	private JFileChooser fileChooser;
	
	final JCheckBox manualLoopChk = new JCheckBox("Enable");
	final TextField maxLoopTxt = new TextField();
	final TextField pathKandidatTxt = new TextField();
	final TextField pathTempatTxt = new TextField();
	final TextField pathUmumTxt = new TextField();
	
	/**
	 * Launch the application.
	 */	
	
	public static void main(String[] args) {
		try {			
			WindowUtilities.setNativeLookAndFeel();			
			OptionDialog dialog = new OptionDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OptionDialog() {		
		setTitle("Option Preference");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		fileChooser = new JFileChooser();
		optionPreference = new OptionPreference();
		
		Label label = new Label("Max Loop");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label.setBounds(10, 10, 111, 22);
		getContentPane().add(label);
		
		Label label_1 = new Label("Manual Loop");
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_1.setBounds(10, 38, 99, 22);
		getContentPane().add(label_1);
		
		Label label_2 = new Label("Path Input Kandidat");
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_2.setBounds(10, 66, 111, 22);
		getContentPane().add(label_2);
		
		Label label_3 = new Label("Path Input Tempat");
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_3.setBounds(10, 94, 111, 22);
		getContentPane().add(label_3);
		
		Label label_4 = new Label("Path Input Umum");
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		label_4.setBounds(10, 122, 111, 22);
		getContentPane().add(label_4);
				
		maxLoopTxt.setBounds(143, 10, 53, 22);
		getContentPane().add(maxLoopTxt);
		
		
		manualLoopChk.setBounds(145, 37, 97, 23);
		getContentPane().add(manualLoopChk);
		
		
		pathKandidatTxt.setBounds(143, 66, 227, 22);
		getContentPane().add(pathKandidatTxt);
		
		
		pathTempatTxt.setBounds(143, 94, 227, 22);
		getContentPane().add(pathTempatTxt);
		
		
		pathUmumTxt.setBounds(143, 122, 227, 22);
		getContentPane().add(pathUmumTxt);
		
		Button pathKandidatBtn = new Button("...");
		pathKandidatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fileChooser.showOpenDialog(OptionDialog.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fileChooser.getSelectedFile();
	                pathKandidatTxt.setText(file.getAbsolutePath());
	            }
			}
		});
		pathKandidatBtn.setBounds(376, 66, 48, 22);
		getContentPane().add(pathKandidatBtn);
		
		Button pathTempatBtn = new Button("...");
		pathTempatBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showOpenDialog(OptionDialog.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fileChooser.getSelectedFile();
	                pathTempatTxt.setText(file.getAbsolutePath());	                
	            }
			}
		});
		pathTempatBtn.setBounds(376, 94, 48, 22);
		getContentPane().add(pathTempatBtn);
		
		Button pathUmumBtn = new Button("...");
		pathUmumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fileChooser.showOpenDialog(OptionDialog.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fileChooser.getSelectedFile();
	                pathUmumTxt.setText(file.getAbsolutePath());	                
	            }
			}
		});
		pathUmumBtn.setBounds(376, 122, 48, 22);
		getContentPane().add(pathUmumBtn);
		
		Button confirmBtn = new Button("OK");	
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionPreference.setMaxLoop(Integer.parseInt(maxLoopTxt.getText()));
				optionPreference.setManualLoop(manualLoopChk.isSelected());
				optionPreference.setPathKandidat(pathKandidatTxt.getText());
				optionPreference.setPathTempat(pathTempatTxt.getText());
				optionPreference.setPathUmum(pathUmumTxt.getText());
				if (validData())
					saveDataToTemp();
				dispose();
			}
					
		});
		confirmBtn.setBounds(270, 229, 70, 22);
		getContentPane().add(confirmBtn);
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(354, 229, 70, 22);
		getContentPane().add(cancelBtn);
	}
	
	/*
	 * Returns object
	 */
	 public OptionPreference getOptionPreference()
	 {
		 return this.optionPreference;
	 }
	 
	 private void saveDataToTemp() {
		 if (!validData())
			 return;		 
		 File tempFile = new File(System.getProperty("user.dir") + "\\temp.txt");		         
         try {
			Formatter formatter = new Formatter(tempFile.getName());
			String sfile = optionPreference.buildString();
			System.out.println(sfile);
			formatter.format(sfile);	
			formatter.close();					
		} catch (Exception err) {								
			
		}
	 }

	 private boolean validData() {
		if (!isNumeric(maxLoopTxt.getText()))
			return false;
		if (pathTempatTxt.getText().length() == 0 || pathKandidatTxt.getText().length() == 0 || pathUmumTxt.getText().length() == 0)
			return false;
		return true;
	 }
	
	 public boolean isNumeric(String str){
		 return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	 }
}
