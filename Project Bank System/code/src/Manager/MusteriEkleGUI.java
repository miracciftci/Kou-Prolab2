package Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import Login.*;
import functions.WorkerOperations;

public class MusteriEkleGUI extends JFrame {
	WorkerOperations mti = new WorkerOperations();
	
	
	private JPanel contentPane;
	private JTextField textAdi;
	private JTextField textSoyadi;
	private JTextField textTCNO;
	private JTextField textGeliri;
	private JTextField textTelNo;
	private JTextField textBorcu;
	private JTextField textParaBirimi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriEkleGUI frame = new MusteriEkleGUI();
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
	public MusteriEkleGUI() {
		setTitle("Müşteri ekleme");
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
				Mudur mudurr = new Mudur();
				MudurGUI mGUI = new MudurGUI(mudurr);
				mGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);

		JButton btnCikis = new JButton("Çıkış");//CIKIS
		btnCikis.setBackground(Color.RED);
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBounds(385, 11, 89, 23);
		contentPane.add(btnCikis);

		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setBounds(10, 45, 200, 21);
		contentPane.add(lblAdi);

		textAdi = new JTextField();
		textAdi.setColumns(10);
		textAdi.setBounds(274, 45, 200, 20);
		contentPane.add(textAdi);

		JLabel lblSoyadi = new JLabel("Soyad\u0131");
		lblSoyadi.setBounds(10, 77, 200, 21);
		contentPane.add(lblSoyadi);

		textSoyadi = new JTextField();
		textSoyadi.setColumns(10);
		textSoyadi.setBounds(274, 76, 200, 20);
		contentPane.add(textSoyadi);

		JLabel lblTcNo = new JLabel("T.C. Numaras\u0131");
		lblTcNo.setBounds(10, 109, 200, 21);
		contentPane.add(lblTcNo);

		textTCNO = new JTextField();
		textTCNO.setColumns(10);
		textTCNO.setBounds(274, 109, 200, 20);
		contentPane.add(textTCNO);

		JLabel lblGeliri = new JLabel("Bakiye: ");
		lblGeliri.setBounds(10, 141, 200, 21);
		contentPane.add(lblGeliri);

		textGeliri = new JTextField();
		textGeliri.setColumns(10);
		textGeliri.setBounds(274, 141, 200, 20);
		contentPane.add(textGeliri);

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mti.musteriEkleme(textAdi.getText().toString(), textSoyadi.getText().toString(), textTelNo.getText().toString(), textTCNO.getText().toString(),
						LoginGUI.mcalisanId, Integer.parseInt(textGeliri.getText().toString()),
						Integer.parseInt(textBorcu.getText().toString()), textParaBirimi.getText().toString());
				Islembasarili isb=new Islembasarili();
				isb.setVisible(true);
				dispose();
			}
		});
		btnKaydet.setBackground(Color.GREEN);
		btnKaydet.setBounds(385, 327, 89, 23);
		contentPane.add(btnKaydet);
		
		JLabel lblTelNo = new JLabel("Telefon Numaras\u0131");
		lblTelNo.setBounds(10, 173, 200, 21);
		contentPane.add(lblTelNo);
		
		textTelNo = new JTextField();
		textTelNo.setColumns(10);
		textTelNo.setBounds(274, 172, 200, 20);
		contentPane.add(textTelNo);
		
		JLabel lblBorcu = new JLabel("Kredi Borcu");
		lblBorcu.setBounds(10, 205, 200, 21);
		contentPane.add(lblBorcu);
		
		textBorcu = new JTextField();
		textBorcu.setColumns(10);
		textBorcu.setBounds(274, 205, 200, 20);
		contentPane.add(textBorcu);
		
		JLabel lblAlanHesabnPara = new JLabel("A\u00E7\u0131lan Hesab\u0131n Para Birimi");
		lblAlanHesabnPara.setBounds(10, 237, 200, 21);
		contentPane.add(lblAlanHesabnPara);
		
		textParaBirimi = new JTextField();
		textParaBirimi.setColumns(10);
		textParaBirimi.setBounds(274, 237, 200, 20);
		contentPane.add(textParaBirimi);
	}
}
