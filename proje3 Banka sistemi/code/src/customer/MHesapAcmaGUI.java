package customer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Login.*;

public class MHesapAcmaGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MHesapAcmaGUI frame = new MHesapAcmaGUI();
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
	public MHesapAcmaGUI() {
		setTitle("Hesap açma talebi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
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
		
		JLabel lblTalebinizBaarylaIletilmitir = new JLabel("Talebiniz Başarıyla iletilmiştir");
		lblTalebinizBaarylaIletilmitir.setForeground(Color.GREEN);
		lblTalebinizBaarylaIletilmitir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTalebinizBaarylaIletilmitir.setBounds(75, 45, 352, 110);
		contentPane.add(lblTalebinizBaarylaIletilmitir);
	}

}
