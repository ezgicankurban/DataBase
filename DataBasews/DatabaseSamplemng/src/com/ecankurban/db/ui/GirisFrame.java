package com.ecankurban.db.ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GirisFrame  extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	
	public GirisFrame() {
		initialize();
		
	}

	private void initialize() {
		setTitle("Kullanýcý giriþ ekraný");
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);;
		getContentPane().setLayout(null);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.setBounds(53, 273, 91, 23);
		getContentPane().add(btnGiris);
		
		JButton btnÝptal = new JButton("\u0130ptal");
		btnÝptal.setBounds(236, 273, 91, 23);
		getContentPane().add(btnÝptal);
		
		textField = new JTextField();
		textField.setBounds(196, 66, 140, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 124, 143, 23);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblKuladi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKuladi.setBounds(53, 66, 78, 18);
		getContentPane().add(lblKuladi);
		
		JLabel lblSifre = new JLabel("\u015Eifre");
		lblSifre.setBounds(53, 128, 46, 14);
		getContentPane().add(lblSifre);
	}
}
