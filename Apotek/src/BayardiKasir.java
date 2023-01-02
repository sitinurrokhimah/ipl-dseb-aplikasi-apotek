import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

class BayardiKasir extends JFrame {
	JLabel keranjang_jl_logo = new JLabel(new ImageIcon(getClass().getResource("/image/logo.png")));

	JLabel titlekasir = new JLabel(new ImageIcon(getClass().getResource("/image/menukasir.png")));
	Date tgl = new Date();
	JLabel keranjang_jl_kodebarang = new JLabel("Kode Barang");
	JTextField keranjang_jtf_kodeobat = new JTextField();

	JLabel keranjang_jl_merk = new JLabel("Merk");
	JTextField keranjang_jtf_merk = new JTextField();
	JLabel keranjang_jl_hargajual = new JLabel("Harga Jual");
	JTextField keranjang_jtf_hargajual = new JTextField();
	JLabel keranjang_jl_jumlahitem = new JLabel("Jumlah Item");
	JTextField keranjang_jtf_item = new JTextField();
	JLabel keranjang_jl_jumlah = new JLabel("Jumlah");
	JTextField keranjang_jtf_jumlah = new JTextField();
	JLabel proses = new JLabel(new ImageIcon(getClass().getResource("/image/proses.png")));
	JLabel batal = new JLabel(new ImageIcon(getClass().getResource("/image/kbatal.png")));
	JLabel keranjang_jl_cari = new JLabel(new ImageIcon(getClass().getResource("/image/kcari.png")));

	JTextField waktu = new JTextField((tgl.getYear() + 1900) + "/" + (tgl.getMonth() + 1) + "/" + tgl.getDate(), 10);

	JLabel keranjang_jl_total = new JLabel("Total");
	JTextField keranjang_jtf_total = new JTextField();

	JLabel keranjang_jl_tunai = new JLabel("Tunai");
	JTextField keranjang_jtf_tunai = new JTextField();

	JLabel keranjang_jl_kembalian = new JLabel("Kembalian");
	JTextField keranjang_jtf_kembalian = new JTextField();

	JLabel keranjang_jb_oke = new JLabel(new ImageIcon(getClass().getResource("/image/oke.png")));
	JLabel keranjang_jb_hapus = new JLabel(new ImageIcon(getClass().getResource("/image/fiturhapus.png")));
	JLabel keranjang_jb_hitung = new JLabel(new ImageIcon(getClass().getResource("/image/hitung.png")));
	JLabel keranjang_jb_reset = new JLabel(new ImageIcon(getClass().getResource("/image/bersih.png")));
	JLabel opt = new JLabel(new ImageIcon("image/ioption.png"));

	String[] header = { "Kode Obat","Nama Obat", "Harga", "Item", "Jumlah" };
	DefaultTableModel model = new DefaultTableModel(null, header);

	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);

	BayardiKasir() {
		setLocation(350, 50);
		setSize(650, 650);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Kasir");
		KomponenVisual();
		AksiReaksi();

	}

	void KomponenVisual() {
		getContentPane().setLayout(null);
		// logo
		getContentPane().add(keranjang_jl_logo);
		keranjang_jl_logo.setBounds(30, 30, 100, 43);

		// titlekasir
		getContentPane().add(titlekasir);
		titlekasir.setBounds(160, 40, 85, 20);
		// kode barang
		getContentPane().add(keranjang_jl_kodebarang);
		keranjang_jl_kodebarang.setBounds(30, 100, 100, 20);
		keranjang_jl_kodebarang.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_kodeobat);
		keranjang_jtf_kodeobat.setBounds(120, 100, 100, 20);

		// merk
		getContentPane().add(keranjang_jl_merk);
		keranjang_jl_merk.setBounds(30, 130, 100, 20);
		keranjang_jl_merk.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_merk);
		keranjang_jtf_merk.setBounds(120, 130, 100, 20);

		// item
		getContentPane().add(keranjang_jl_jumlahitem);
		keranjang_jl_jumlahitem.setBounds(230, 130, 100, 20);
		keranjang_jl_jumlahitem.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_item);
		keranjang_jtf_item.setBounds(320, 130, 100, 20);

		// harga_jual
		getContentPane().add(keranjang_jl_hargajual);
		keranjang_jl_hargajual.setBounds(30, 160, 100, 20);
		keranjang_jl_hargajual.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_hargajual);
		keranjang_jtf_hargajual.setBounds(120, 160, 100, 20);

		// jumlah
		getContentPane().add(keranjang_jl_jumlah);
		keranjang_jl_jumlah.setBounds(230, 160, 100, 20);
		keranjang_jl_jumlah.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_jumlah);
		keranjang_jtf_jumlah.setBounds(320, 160, 100, 20);

		// proses
		getContentPane().add(keranjang_jl_cari);
		keranjang_jl_cari.setBounds(230, 100, 55, 20);
		// hitung
		getContentPane().add(proses);
		proses.setBounds(450, 130, 55, 20);
		// batal
		getContentPane().add(batal);
		batal.setBounds(450, 160, 55, 20);

		// tabel
		getContentPane().add(pane);
		pane.setBounds(30, 200, 572, 180);

		// total
		getContentPane().add(keranjang_jl_total);
		keranjang_jl_total.setBounds(30, 480, 100, 20);
		keranjang_jl_total.setFont(new Font("Graduate", Font.BOLD, 17));
		keranjang_jl_total.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_total);
		keranjang_jtf_total.setBounds(180, 475, 200, 30);
		keranjang_jtf_total.setEditable(false);

		// tunai
		getContentPane().add(keranjang_jl_tunai);
		keranjang_jl_tunai.setBounds(30, 515, 100, 20);
		keranjang_jl_tunai.setFont(new Font("Graduate", Font.BOLD, 17));
		keranjang_jl_tunai.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_tunai);
		keranjang_jtf_tunai.setBounds(180, 510, 200, 30);

		// kembalian
		getContentPane().add(keranjang_jl_kembalian);
		keranjang_jl_kembalian.setBounds(30, 550, 120, 20);
		keranjang_jl_kembalian.setFont(new Font("Graduate", Font.BOLD, 17));
		keranjang_jl_kembalian.setForeground(Color.WHITE);

		getContentPane().add(keranjang_jtf_kembalian);
		keranjang_jtf_kembalian.setBounds(180, 545, 200, 30);
		keranjang_jtf_kembalian.setEditable(false);

		// oke
		getContentPane().add(opt);
		opt.setBounds(88, 400, 41, 30);
		getContentPane().add(keranjang_jb_oke);
		keranjang_jb_oke.setBounds(70, 416, 126, 20);

		// cetak
		getContentPane().add(keranjang_jb_hitung);
		keranjang_jb_hitung.setBounds(190, 416, 126, 20);

		// hapus
		getContentPane().add(keranjang_jb_hapus);
		keranjang_jb_hapus.setBounds(310, 411, 126, 30);

		// bersihkan
		getContentPane().add(keranjang_jb_reset);
		keranjang_jb_reset.setBounds(430, 416, 126, 20);

		// baggy
		getContentPane().setBackground(new Color(8, 63, 89));

		tampilTabel();
		setVisible(true);
	}

	public void AksiReaksi() {
		keranjang_jl_cari.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == keranjang_jl_cari) {
					try {
						String kb = keranjang_jtf_kodeobat.getText();
						Class.forName("com.mysql.jdbc.Driver");
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root",
								"");

						Statement st = koneksi.createStatement();
						String sql = "SELECT NamaObat,Harga FROM db_obat WHERE ID_Obat='" + kb + "'";
						ResultSet rs = st.executeQuery(sql);
						if (rs.next()) {
							keranjang_jtf_merk.setText(rs.getString(1));
							keranjang_jtf_hargajual.setText(rs.getString(2));
						} else {
							JOptionPane.showMessageDialog(null, "Data yang anda cari tidak ada", "Konfirmasi",
									JOptionPane.INFORMATION_MESSAGE);
						}
						st.close();
						koneksi.close();
					} catch (Exception ex) {
						System.out.println("Error :" + ex);
					}
				}
			}
		});

		batal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				batal();
			}
		});

		keranjang_jb_reset.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				batal();
				keranjang_jtf_total.setText("0");
				keranjang_jtf_tunai.setText("0");
				keranjang_jtf_kembalian.setText("0");
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					String sql = "TRUNCATE TABLE kasir";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.executeUpdate();
					pr.close();
					koneksi.close();
					tampilTabel();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error :" + ex, "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		keranjang_jb_hitung.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					String sql = "SELECT SUM(jumlah) AS tot FROM kasir";
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					PreparedStatement sta = con.prepareStatement(sql);
					ResultSet set = sta.executeQuery();
					while (set.next()) {
						String tota = set.getString(".tot");
						// tota = tota.substring(0, tota.length() - 2);

						keranjang_jtf_total.setText(tota);
					}
				} catch (Exception ie) {
					System.out.println(ie);
				}
			}
		});
		keranjang_jtf_item.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					int a = Integer.parseInt(keranjang_jtf_hargajual.getText());
					int b = Integer.parseInt(keranjang_jtf_item.getText());

					String c = String.valueOf(a * b);
					keranjang_jtf_jumlah.setText(c);
				}
			}
		});

		keranjang_jtf_tunai.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_ENTER) {
					int g = Integer.parseInt(keranjang_jtf_tunai.getText());
					int h = Integer.parseInt(keranjang_jtf_total.getText());

					String f = String.valueOf(g - h);
					keranjang_jtf_kembalian.setText(f);
				}
			}
		});

		proses.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					String sql = "INSERT INTO kasir VALUES(?,?,?,?,?)";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.setString(1, keranjang_jtf_kodeobat.getText());
					pr.setString(2, keranjang_jtf_merk.getText());
					pr.setString(3, keranjang_jtf_hargajual.getText());
					pr.setString(4, keranjang_jtf_item.getText());
					pr.setString(5, keranjang_jtf_jumlah.getText());

					pr.executeUpdate();
					proses();
					tampilTabel();
					batal();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			}
		}

		);

		keranjang_jb_oke.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// ==============bagian bawah =========//
				int y = 0;
				Frame fr = new Frame();
				PrintJob print = fr.getToolkit().getPrintJob(fr, "Prinnting", null, null);
				if (print != null) {
					Graphics g = print.getGraphics();
					if (g != null) {
						g.setFont(new Font("ARCHIVE", 1, 11));
						g.drawString("Apotek Unjani", 120, 30);

						g.setFont(new Font("Dialog", 0, 8));
						String merk = tabel.getColumnName(0);
						String harga = tabel.getColumnName(1);
						String item = tabel.getColumnName(2);
						String jumlah = tabel.getColumnName(3);
						g.setFont(new Font("Dialog", 1, 8));
						g.drawString(merk, 30, 60);
						g.drawString(harga, 110, 60);
						g.drawString(item, 170, 60);
						g.drawString(jumlah, 230, 60);
						g.drawLine(30, 63, 280, 63);
						int n = model.getRowCount();

						for (int i = 0; i < n; i++) {
							int k = i + 1;
							int j = 10 * k;
							y = 73 + j;
							g.setFont(new Font("Dialog", 0, 8));
							merk = model.getValueAt(i, 0).toString();
							harga = model.getValueAt(i, 1).toString();
							item = model.getValueAt(i, 2).toString();
							jumlah = model.getValueAt(i, 3).toString();
							g.drawString(merk, 30, y);
							g.drawString(harga, 110, y);
							g.drawString(item, 175, y);
							g.drawString(jumlah, 230, y);
						}

						String total = keranjang_jtf_total.getText();
						String tunai = keranjang_jtf_tunai.getText();
						String kembalian = keranjang_jtf_kembalian.getText();
						g.setFont(new Font("Dialog", 1, 10));
						g.drawLine(40, y + 5, 251, y + 5);
						g.drawString("Total", 150, y + 15);
						g.drawString(":", 190, y + 15);
						g.drawString(total, 210, y + 15);
						g.drawString("Bayar", 150, y + 25);
						g.drawString(":", 190, y + 25);
						g.drawString(tunai, 210, y + 25);
						g.drawString("Kembali", 150, y + 35);
						g.drawString(":", 190, y + 35);
						g.drawString(kembalian, 210, y + 35);
					}
					print.end();
					print.end();
				}
				keranjang_jtf_kodeobat.requestFocus();
				keranjang_jtf_total.setText("0");
				keranjang_jtf_tunai.setText("");
				keranjang_jtf_kembalian.setText("0");

				// ==============bagian bawah =========//
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					String sql = "TRUNCATE TABLE kasir";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.executeUpdate();
					pr.close();
					koneksi.close();
					tampilTabel();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error :" + ex, "Error", JOptionPane.ERROR_MESSAGE);
				}


			}
		});
		keranjang_jb_hapus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					String kodeobat = keranjang_jtf_kodeobat.getText();
					int tanya = JOptionPane.showConfirmDialog(null,
							"Apakah Anda ingin Menghapus Data dengan kode barang " + kodeobat + " ?", "Konfirmasi",
							JOptionPane.YES_NO_OPTION);
					if (tanya == 0) {
						try {
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
							String sql = "DELETE FROM kasir WHERE ID_Obat=?";
							PreparedStatement pr = koneksi.prepareStatement(sql);
							pr.setString(1, kodeobat);
							pr.executeUpdate();
							pr.close();

							koneksi.close();
							JOptionPane.showMessageDialog(null, "Data telah dihapus");
							batal();
							tampilTabel();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Error :" + ex, "Error", JOptionPane.ERROR_MESSAGE);
						}
					}

			}
		});
		keranjang_jb_reset.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				batal();
				tampilTabel();
			}
		});

	}

	void hapusTabel() {
		int row = model.getRowCount();
		for (int i = 0; i < row; i++) {
			model.removeRow(0);
		}
	}

	void batal() {
		keranjang_jtf_kodeobat.setText("");
		keranjang_jtf_merk.setText("");
		keranjang_jtf_hargajual.setText("");
		keranjang_jtf_item.setText("");
		keranjang_jtf_jumlah.setText("");
	}

	void tampilTabel() {
		hapusTabel();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
			Statement state = koneksi.createStatement();
			String sql = "SELECT ID_Obat,NamaObat,harga_jual,item,jumlah from kasir";
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Object obj[] = new Object[5];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				obj[3] = rs.getString(4);
				obj[4] = rs.getString(5);
				model.addRow(obj);

//keranjang_jtf_item
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	void proses() {
		try {
			String kb = keranjang_jtf_kodeobat.getText();
			Class.forName("com.mysql.jdbc.Driver");
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");

			Statement st = koneksi.createStatement();
			String sql = "SELECT Stok FROM db_obat WHERE ID_Obat='" + kb + "'";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				String stockdb = rs.getString(1);
				int b1 = Integer.parseInt(stockdb);
				int b2 = Integer.parseInt(keranjang_jtf_item.getText());

				String kirimdb = String.valueOf(b1 - b2);

				JTextField ini = new JTextField();
				ini.setText(kirimdb);
				String sql2 = "UPDATE db_obat SET Stok=? WHERE ID_Obat=?";
				PreparedStatement pr = koneksi.prepareStatement(sql2);
				pr.setString(1, ini.getText());
				pr.setString(2, keranjang_jtf_kodeobat.getText());

				pr.executeUpdate();

			} else {
				JOptionPane.showMessageDialog(null, "Data yang anda cari tidak ada", "Konfirmasi",
						JOptionPane.INFORMATION_MESSAGE);
			}
			st.close();
			koneksi.close();
		} catch (Exception ex) {
			System.out.println("Error :" + ex);
		}

	}

	public static void main(String args[]) {
		new BayardiKasir();
	}
}