import java.awt.EventQueue;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class employee {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee window = new employee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 Connection connection = null;
	 private JTable table;
	 private JTable table_1;
	 private JTable table_2;
	 private JScrollPane scrollPane;
	/**
	 * Create the application.
	 */
	public employee() {
		initialize();
		connection = sqlConnection.dbconnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String query = " Select * From Mountain";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(34, 24, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 141, 153, -77);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(97, 97, 1, 1);
		frame.getContentPane().add(table_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 387, 188);
		frame.getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
	}
}
