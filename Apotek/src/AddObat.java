import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

class AddObat extends JFrame {

	JLabel lihatdatabase_jl_ubah = new JLabel(
			new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\fiturubah.png"));
	JLabel lihatdatabase_jl_hapus = new JLabel(
			new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\fiturhapus.png"));
	JLabel lihatdatabase_jl_cari = new JLabel(
			new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\cariadmin.png"));
	JLabel titledatabase = new JLabel(
			new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\databaseobat.png"));

	JLabel Kode_Obat_label = new JLabel("Kode Obat");
	JTextField kode_obat = new JTextField();

	JLabel nama_obat_label = new JLabel("Nama Obat");
	JTextField name = new JTextField();

	JLabel harga_label = new JLabel("Harga");
	
	JTextField Harga = new JTextField();

	JLabel lihatdatabase_jl_cari2 = new JLabel("Kode_Obat");
	JTextField lihatdatabase_jtf_cari = new JTextField();

	JLabel lihatdatabase_jl_logo = new JLabel(
			new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\logo.png"));
	String[] header = { "Kode Obat", "Nama Obat" , "Harga", "Stok","Keterangan","Exp_Date" };
	DefaultTableModel model = new DefaultTableModel(null, header);
	JLabel stock_label,ket_label,Exp;
	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	JDateChooser txtTggl = new com.toedter.calendar.JDateChooser();
	
	private final JLabel lihatdatabase_jl_tambah = new JLabel(new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\fiturtambah.png"));
	private final JLabel lihatdatabase_jl_bersih = new JLabel(new ImageIcon("D:\\Mina\\KULIAH\\Matkul\\SEMESTER 4\\Pemrograman Objek 2\\PRAKTIKUM\\Apotek\\Apotek\\src\\image\\bersih.png"));
	private LabelTime waktu;
	private JTextField stok_field;
	private JTextField keterangan;
	AddObat() {
		setLocation(220, 10);
		setSize(833, 689);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Database Tambah Admin");
		KomponenVisual();
		AksiReaksi();
		setLocationRelativeTo(null);
        userInterface();
        setResizable(false);
	}

	void KomponenVisual() {
		getContentPane().setLayout(null);
		// logo
		getContentPane().add(lihatdatabase_jl_logo);
		lihatdatabase_jl_logo.setBounds(30, 30, 100, 43);
		// title
		getContentPane().add(titledatabase);
		titledatabase.setBounds(71, 11, 440, 79);
		
		getContentPane().add(lihatdatabase_jl_bersih);
		lihatdatabase_jl_bersih.setBounds(394,291,126,20);
		   
		// tabel
		getContentPane().add(pane);
		pane.setBounds(30, 398, 756, 233);

		// kode obat
		getContentPane().add(Kode_Obat_label);
		Kode_Obat_label.setBounds(30, 150, 100, 20);
		Kode_Obat_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		Kode_Obat_label.setForeground(Color.WHITE);
		kode_obat.setEditable(false);
		

		getContentPane().add(kode_obat);
		kode_obat.setBounds(150, 145, 250, 30);

		// merk
		getContentPane().add(nama_obat_label);
		nama_obat_label.setBounds(30, 190, 100, 20);
		nama_obat_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		nama_obat_label.setForeground(Color.WHITE);

		getContentPane().add(name);
		name.setBounds(150, 185, 250, 30);

		// kategori
		getContentPane().add(harga_label);
		harga_label.setBounds(30, 230, 100, 20);
		harga_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		harga_label.setForeground(Color.WHITE);

		getContentPane().add(Harga);
		Harga.setBounds(150, 226, 250, 30);
		
		getContentPane().add(lihatdatabase_jl_ubah);
		lihatdatabase_jl_ubah.setBounds(151, 287, 126, 30);

		// hapus
		getContentPane().add(lihatdatabase_jl_hapus);
		lihatdatabase_jl_hapus.setBounds(274, 287, 126, 30);

		// label cari
		getContentPane().add(lihatdatabase_jl_cari2);
		lihatdatabase_jl_cari2.setBounds(30, 350, 150, 20);
		lihatdatabase_jl_cari2.setFont(new Font("Rockwell", Font.BOLD, 14));
		lihatdatabase_jl_cari2.setForeground(Color.WHITE);
		// cari text field
		getContentPane().add(lihatdatabase_jtf_cari);
		lihatdatabase_jtf_cari.setBounds(114, 349, 130, 25);
		// tombol cari
		getContentPane().add(lihatdatabase_jl_cari);
		lihatdatabase_jl_cari.setBounds(256, 346, 126, 30);

		getContentPane().setBackground(new Color(8, 63, 89));
		lihatdatabase_jl_tambah.setBounds(30, 287, 126, 30);
		
		txtTggl.setBounds(536,226,250,30);
		getContentPane().add(txtTggl);
		
		stock_label = new JLabel("Stok");
		stock_label.setForeground(Color.WHITE);
		stock_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		stock_label.setBounds(416, 150, 100, 20);
		getContentPane().add(stock_label);
		
		stok_field = new JTextField();
		stok_field.setBounds(536, 145, 250, 30);
		getContentPane().add(stok_field);
		
		ket_label = new JLabel("Keterangan");
		ket_label.setForeground(Color.WHITE);
		ket_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		ket_label.setBounds(416, 190, 100, 20);
		getContentPane().add(ket_label);
		
		keterangan = new JTextField();
		keterangan.setBounds(536, 185, 250, 30);
		getContentPane().add(keterangan);
		
		Exp = new JLabel("Exp_Date");
		Exp.setForeground(Color.WHITE);
		Exp.setFont(new Font("Rockwell", Font.BOLD, 14));
		Exp.setBounds(416, 230, 100, 20);
		getContentPane().add(Exp);
		getContentPane().add(lihatdatabase_jl_tambah);
		tampilTabel();
		setVisible(true);
	}
	private void userInterface(){
        waktu = new LabelTime();
        waktu.setForeground(Color.WHITE);
        waktu.setSize(200, 100);
        waktu.setLocation(800, 551);
        waktu.setFont(new Font("Arial", Font.BOLD, 24));
        waktu.setHorizontalAlignment(LabelTime.RIGHT);
        
        getContentPane().add(waktu);
		waktu.setBounds(470, 80, 300, 40);		
		
    }
	
	void AksiReaksi() {
		lihatdatabase_jl_tambah.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection ("jdbc:mysql://localhost/apkapotek","root","");
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					kode_obat.setText("OBT0"+nomor());
					String sql = "INSERT INTO db_obat VALUES(?,?,?,?,?,?)";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.setString(1, kode_obat.getText());
					pr.setString(2, name.getText());
					pr.setString(3, Harga.getText());
					pr.setString(4, stok_field.getText());
					pr.setString(5, keterangan.getText());
					pr.setString(6, date.format(txtTggl.getDate()));
					pr.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					kode_obat.setText("");
					name.setText("");
					Harga.setText("");
					stok_field.setText("");
					keterangan.setText("");
					txtTggl.setDate(null);
					tampilTabel();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Data gagal disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				kode_obat.setText("OBT0"+nomor());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				kode_obat.setText("");
			}
		});
		lihatdatabase_jl_hapus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String kodeobat = kode_obat.getText();
				int tanya = JOptionPane.showConfirmDialog(null,
						"Apakah Anda ingin Menghapus Data dengan kode barang " + kodeobat + " ?", "Konfirmasi",
						JOptionPane.YES_NO_OPTION);
				if (tanya == 0) {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
						String sql = "DELETE FROM db_obat WHERE ID_Obat=?";
						PreparedStatement pr = koneksi.prepareStatement(sql);
						pr.setString(1, kodeobat);
						pr.executeUpdate();
						pr.close();

						koneksi.close();
						JOptionPane.showMessageDialog(null, "Data telah dihapus");
						bersih();
						tampilTabel();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error :" + ex, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		lihatdatabase_jl_ubah.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
					String sql = "UPDATE db_obat SET ID_Obat='"+kode_obat.getText()+"',NamaObat='"+name.getText()+"',Harga='"+Harga.getText()+"',Stok='"+stok_field.getText()+"',Keterangan='"+keterangan.getText()+"'WHERE ID_Obat='"+kode_obat.getText()+"'";
					PreparedStatement pr = koneksi.prepareStatement(sql);
				
					pr.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					bersih();
					tampilTabel();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			}
		});
		lihatdatabase_jl_bersih.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
	            bersih();
	            tampilTabel();
			}
	    });
		lihatdatabase_jl_cari.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == lihatdatabase_jl_cari) {
					try {
						String kb = lihatdatabase_jtf_cari.getText();
						Class.forName("com.mysql.jdbc.Driver");
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
						kode_obat.setText("");
						Statement st = koneksi.createStatement();
						String sql = "SELECT * from db_obat WHERE ID_Obat LIKE '" + kb + "'";
						ResultSet rs = st.executeQuery(sql);
						if (rs.next()) {
							kode_obat.setText(rs.getString(1));
							name.setText(rs.getString(2));
							Harga.setText(rs.getString(3));
							stok_field.setText(rs.getString(4));
							keterangan.setText(rs.getString(5));
							txtTggl.setDate(rs.getDate(6));
							tampilTabel();
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

	}

	void bersih() {
		kode_obat.setText("");
		name.setText("");
		Harga.setText("");
		stok_field.setText("");
		keterangan.setText("");
		txtTggl.setDate(null);
		lihatdatabase_jtf_cari.setText("");
	}

	void tampilTabel() {
		hapusTabel();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
			Statement state = koneksi.createStatement();
			String sql = "SELECT * FROM db_obat ORDER BY ID_Obat ASC";
			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				Object obj[] = new Object[6];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
				obj[3] = rs.getString(4);
				obj[4] = rs.getString(5);
				obj[5] = rs.getString(6);
				model.addRow(obj);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	int nomor() {
		int row = model.getRowCount()+1;
		return row;
	}

	void hapusTabel() {
		int row = model.getRowCount();
		for (int i = 0; i < row; i++) {
			model.removeRow(0);
		}
	}

	public static void main(String args[]) {
		new AddObat();
	}
}