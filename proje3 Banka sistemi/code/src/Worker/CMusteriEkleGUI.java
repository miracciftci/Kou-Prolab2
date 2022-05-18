package Worker;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginGUI;
import functions.WorkerOperations;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CMusteriEkleGUI extends JFrame {
	WorkerOperations mti = new WorkerOperations();
	private JPanel contentPane;
	private JTextField textAdi;
	private JTextField textSoyadi;
	private JTextField textTcNo;
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
					CMusteriEkleGUI frame = new CMusteriEkleGUI();
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
	public CMusteriEkleGUI() {
		setTitle("Müşteri ekle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalisanGUI calisanGUI = new CalisanGUI();
				calisanGUI.setVisible(true);
				dispose();
			}
		});
		btnGeri.setBackground(Color.WHITE);
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);

		JButton btnCikis = new JButton("Çıkış");// CIKIS
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI lGUI = new LoginGUI();
				lGUI.setVisible(true);
				dispose();
			}
		});
		btnCikis.setBackground(Color.RED);
		btnCikis.setBounds(385, 11, 89, 23);
		contentPane.add(btnCikis);

		JLabel lblAdi = new JLabel("Adı");
		lblAdi.setBounds(10, 45, 200, 21);
		contentPane.add(lblAdi);

		textAdi = new JTextField();
		textAdi.setColumns(10);
		textAdi.setBounds(274, 45, 200, 20);
		contentPane.add(textAdi);

		JLabel lblSoyadi = new JLabel("Soyadı");
		lblSoyadi.setBounds(10, 77, 200, 21);
		contentPane.add(lblSoyadi);

		textSoyadi = new JTextField();
		textSoyadi.setColumns(10);
		textSoyadi.setBounds(274, 76, 200, 20);
		contentPane.add(textSoyadi);

		JLabel lblTcNo = new JLabel("T.C. Numarası");
		lblTcNo.setBounds(10, 109, 200, 21);
		contentPane.add(lblTcNo);

		textTcNo = new JTextField();
		textTcNo.setColumns(10);
		textTcNo.setBounds(274, 109, 200, 20);
		contentPane.add(textTcNo);

		JLabel lblGeliri = new JLabel("Bakiye ");
		lblGeliri.setBounds(10, 141, 200, 21);
		contentPane.add(lblGeliri);

		textGeliri = new JTextField();
		textGeliri.setColumns(10);
		textGeliri.setBounds(274, 140, 200, 20);
		contentPane.add(textGeliri);

		JLabel lblTelNo = new JLabel("Telefon Numarası");
		lblTelNo.setBounds(10, 173, 200, 21);
		contentPane.add(lblTelNo);

		textTelNo = new JTextField();
		textTelNo.setColumns(10);
		textTelNo.setBounds(274, 171, 200, 20);
		contentPane.add(textTelNo);

		JLabel lblBorcu = new JLabel("Kredi Borcu");
		lblBorcu.setBounds(10, 205, 200, 21);
		contentPane.add(lblBorcu);

		textBorcu = new JTextField();
		textBorcu.setColumns(10);
		textBorcu.setBounds(274, 205, 200, 20);
		contentPane.add(textBorcu);

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mti.musteriEkleme(textAdi.getText().toString(), textSoyadi.getText().toString(), textTelNo.getText().toString(), textTcNo.getText().toString(),
						LoginGUI.calisanId, Integer.parseInt(textGeliri.getText().toString()),
						Integer.parseInt(textBorcu.getText().toString()), textParaBirimi.getText().toString());
				basarili bsr=new basarili();
				bsr.setVisible(true);
				dispose();

			}
		});
		btnKaydet.setBackground(Color.GREEN);
		btnKaydet.setBounds(385, 327, 89, 23);
		contentPane.add(btnKaydet);

		JLabel lblAlanHesabnPara = new JLabel("Açılan hesabın Para Birimi");
		lblAlanHesabnPara.setBounds(10, 237, 200, 21);
		contentPane.add(lblAlanHesabnPara);

		textParaBirimi = new JTextField();
		textParaBirimi.setColumns(10);
		textParaBirimi.setBounds(274, 237, 200, 20);
		contentPane.add(textParaBirimi);
	}
}
