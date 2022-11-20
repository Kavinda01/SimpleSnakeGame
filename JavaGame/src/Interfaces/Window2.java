package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window2 {

	public JFrame frmL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
					window.frmL.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Window2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmL = new JFrame();
		frmL.setResizable(false);
		frmL.setTitle("                                                                              Snake Game");
		frmL.getContentPane().setBackground(new Color(71, 71, 71));
		frmL.setBounds(100, 100, 634, 701);
		frmL.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmL.getContentPane().setLayout(null);
		
		GamePanel panel = new GamePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 600, 600);
		frmL.getContentPane().add(panel);
		
		JButton btn1 = new JButton("REPLAY");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmL.setVisible(false);
				Window2 w2 = new Window2();
				w2.frmL.setVisible(true);
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn1.setBackground(Color.YELLOW);
		btn1.setBounds(10, 620, 100, 35);
		frmL.getContentPane().add(btn1);
		
		JButton btn3 = new JButton("QUIT");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				final JOptionPane OptionPane = new JOptionPane(

					    JOptionPane.QUESTION_MESSAGE,
					    JOptionPane.YES_NO_OPTION);
				
				int option = JOptionPane.showConfirmDialog(null,"Are you sure want to quit the game?","Click a button", 1);
				if(option == JOptionPane.YES_OPTION) {
				    System.exit(0);
				}
			}
		});
		btn3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn3.setBackground(new Color(247, 0, 0));
		btn3.setBounds(230, 620, 100, 35);
		frmL.getContentPane().add(btn3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmL.setVisible(false);
				Window w3 = new Window();
				w3.frame.setVisible(true);
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBackground(new Color(255, 119, 53));
		btnBack.setBounds(120, 620, 100, 35);
		frmL.getContentPane().add(btnBack);
	}
}
