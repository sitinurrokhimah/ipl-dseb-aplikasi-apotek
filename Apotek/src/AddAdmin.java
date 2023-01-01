import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

class AddAdmin extends JFrame {

	JLabel lihatdatabase_jl_ubah = new JLabel(
			new ImageIcon(getClass().getResource("/image/fiturubah.png")));
	JLabel lihatdatabase_jl_hapus = new JLabel(
			new ImageIcon(getClass().getResource("/image/fiturhapus.png")));
	JLabel lihatdatabase_jl_cari = new JLabel(
			new ImageIcon(getClass().getResource("/image/cariadmin.png")));
	JLabel titledatabase = new JLabel(
			new ImageIcon(getClass().getResource("/image/Menuaddadmin.png")));

	JLabel ID_Admin_label = new JLabel("Kode Admin");
	JTextField Kode_Admin = new JTextField();

	JLabel Username_label = new JLabel("Username");
	JTextField name = new JTextField();

	JLabel Password_label = new JLabel("Password");
	
	JPasswordField pass = new JPasswordField();

	JLabel lihatdatabase_jl_cari2 = new JLabel("ID_Admin");
	JTextField lihatdatabase_jtf_cari = new JTextField();

	JLabel lihatdatabase_jl_logo = new JLabel(
			new ImageIcon(getClass().getResource("/image/logo.png")));
	String[] header = { "Kode Admin", "Username" , "Password" };
	DefaultTableModel model = new DefaultTableModel(null, header);

	JTable tabel = new JTable(model);
	JScrollPane pane = new JScrollPane(tabel);
	private final JLabel lihatdatabase_jl_tambah = new JLabel(new ImageIcon(getClass().getResource("/image/fiturhapus.png")));
	private final JLabel lihatdatabase_jl_bersih = new JLabel(new ImageIcon(getClass().getResource("/image/bersih.png")));
	private LabelTime waktu;
	AddAdmin() {
		setLocation(220, 10);
		setSize(553, 689);
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

		// tabel
		getContentPane().add(pane);
		pane.setBounds(30, 398, 481, 233);

		// kode obat
		getContentPane().add(ID_Admin_label);
		ID_Admin_label.setBounds(30, 150, 100, 20);
		ID_Admin_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		ID_Admin_label.setForeground(Color.WHITE);
		Kode_Admin.setEditable(false);
		
		getContentPane().add(lihatdatabase_jl_bersih);
		lihatdatabase_jl_bersih.setBounds(394,291,126,20);
		
		getContentPane().add(Kode_Admin);
		Kode_Admin.setBounds(150, 145, 250, 30);

		// merk
		getContentPane().add(Username_label);
		Username_label.setBounds(30, 190, 100, 20);
		Username_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		Username_label.setForeground(Color.WHITE);

		getContentPane().add(name);
		name.setBounds(150, 185, 250, 30);

		// kategori
		getContentPane().add(Password_label);
		Password_label.setBounds(30, 230, 100, 20);
		Password_label.setFont(new Font("Rockwell", Font.BOLD, 14));
		Password_label.setForeground(Color.WHITE);

		getContentPane().add(pass);
		pass.setBounds(150, 226, 250, 30);
		
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
		waktu.setBounds(220, 80, 300, 40);
    }
	
	void AksiReaksi() {
		lihatdatabase_jl_tambah.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection koneksi = DriverManager.getConnection ("jdbc:mysql://localhost/apkapotek","root","");
					Kode_Admin.setText("ADM00"+nomor());
					String sql = "INSERT INTO admin VALUES(?,?,?)";
					PreparedStatement pr = koneksi.prepareStatement(sql);
					pr.setString(1, Kode_Admin.getText());
					pr.setString(2, name.getText());
					pr.setString(3, pass.getText());
					pr.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data berhasil disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					Kode_Admin.setText("");
					name.setText("");
					pass.setText("");
					tampilTabel();
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Data gagal disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
					System.out.println(ex);
				}
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				Kode_Admin.setText("ADM00"+nomor());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Kode_Admin.setText("");
			}
		});
		lihatdatabase_jl_hapus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String kodeadmin = Kode_Admin.getText();
				int tanya = JOptionPane.showConfirmDialog(null,
						"Apakah Anda ingin Menghapus Data dengan kode barang " + kodeadmin + " ?", "Konfirmasi",
						JOptionPane.YES_NO_OPTION);
				if (tanya == 0) {
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root","");
						String sql = "DELETE FROM admin WHERE ID_Admin=?";
						PreparedStatement pr = koneksi.prepareStatement(sql);
						pr.setString(1, kodeadmin);
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
					String sql = "UPDATE admin SET ID_Admin='"+Kode_Admin.getText()+"',Username='"+name.getText()+"',Password='"+pass.getText()+"'WHERE ID_Admin='"+Kode_Admin.getText()+"'";
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
						Kode_Admin.setText("");
						Statement st = koneksi.createStatement();
						String sql = "SELECT * FROM admin WHERE ID_Admin LIKE '" + kb + "'";
						ResultSet rs = st.executeQuery(sql);
						if (rs.next()) {
							Kode_Admin.setText(rs.getString(1));
							name.setText(rs.getString(2));
							pass.setText(rs.getString(3));
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
		Kode_Admin.setText("");
		name.setText("");
		pass.setText("");
		lihatdatabase_jtf_cari.setText("");
	}

	void tampilTabel() {
		hapusTabel();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/apkapotek", "root", "");
			Statement state = koneksi.createStatement();
			String sql = "SELECT * FROM admin ORDER BY ID_Admin ASC";
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				Object obj[] = new Object[3];
				obj[0] = rs.getString(1);
				obj[1] = rs.getString(2);
				obj[2] = rs.getString(3);
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
		new AddAdmin();
	}
}