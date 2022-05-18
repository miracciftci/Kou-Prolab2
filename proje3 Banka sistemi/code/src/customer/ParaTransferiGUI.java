package customer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Login.*;
import functions.CustomerOperations;

public class ParaTransferiGUI extends JFrame {
	CustomerOperations mi = new CustomerOperations();
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaTransferiGUI frame = new ParaTransferiGUI();
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
	public ParaTransferiGUI() {
		setTitle("Para transferi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnGeri = new JButton("Geri");//GERI
		btnGeri.setBackground(Color.WHITE);
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriGUI musteriGUI = new MusteriGUI();
				musteriGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);

		JButton btnNewButton = new JButton("Çıkış");//CIKIS
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(385, 11, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblIstediinizKrediMiktar = new JLabel("Tranfer Edilecek Hesabın ID Numarası");//TRANSFER EDILECEK HESABIN NUMARASI
		lblIstediinizKrediMiktar.setBounds(10, 60, 220, 21);
		contentPane.add(lblIstediinizKrediMiktar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(274, 60, 200, 20);
		contentPane.add(textField);

		JButton btnIlet = new JButton("Gonder");//ILET
		btnIlet.setBackground(Color.GREEN);
		btnIlet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText().toString());
				int miktar = Integer.parseInt(textField_1.getText().toString());
				mi.paraTransferi(LoginGUI.musteriId, id, miktar);
				MHesapAcmaGUI mhaGUI = new MHesapAcmaGUI();
				mhaGUI.setVisible(true);
				dispose();
				
			}
		});
		btnIlet.setBounds(385, 327, 89, 23);
		contentPane.add(btnIlet);

		JLabel lblIletmekIstediinizPara = new JLabel("Gondermek istediğiniz Para Miktarı");//ILETMEK ISTEDIGINIZ PARA MIKTARI
		lblIletmekIstediinizPara.setBounds(10, 92, 200, 21);
		contentPane.add(lblIletmekIstediinizPara);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(274, 91, 200, 20);
		contentPane.add(textField_1);
	}

}
