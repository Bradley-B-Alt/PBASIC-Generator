package com.bradleyboxer.i2e.pbasic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	public JPanel freqoutPanel = new JPanel();
	public JPanel freqoutPanel2 = new JPanel();
	public JButton freqoutBtn = new JButton("Generate FREQOUT");
	public JTextField freqoutInput = new JTextField(10);
	public JLabel freqoutInputLbl = new JLabel("Location of CSV File: ");
	public JButton freqoutInputBtn = new JButton("Pick Folder");
	public JFileChooser freqoutInputChooser = new JFileChooser("C:/");
	public JLabel output = new JLabel("");
	
	public Main() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PBASIC Generator Version 1 - Freqout Freakout");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		//this.getContentPane().setBackground(Color.decode("#FFFFFF"));
		this.setResizable(false);
		
		this.add(freqoutPanel);
		this.add(freqoutPanel2);
		
		freqoutPanel.add(freqoutInputLbl);
		freqoutPanel.add(freqoutInput);
		freqoutPanel.add(freqoutInputBtn);
		
		freqoutPanel2.add(freqoutBtn);
		freqoutPanel2.add(output);
		
		freqoutBtn.addActionListener(new Actionlistener());
		freqoutInputBtn.addActionListener(new Actionlistener());
		
		freqoutInputChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		freqoutInputChooser.setDialogTitle("Open CSV File Directory");
		freqoutInputChooser.setAcceptAllFileFilterUsed(false);
	}
	
	private class Actionlistener implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==freqoutBtn) {
				Freqout f =  new Freqout(freqoutInput.getText());
				output.setText(f.getFreqoutCompleted());
			}
			if(e.getSource()==freqoutInputBtn) {
				freqoutInputChooser.showSaveDialog(null);
				freqoutInput.setText(freqoutInputChooser.getSelectedFile().toString());
			}
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
	}
}

