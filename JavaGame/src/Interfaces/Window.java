package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Window {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 634, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(255, 255, 255));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		menuBar.setForeground(new Color(2, 120, 0));
		menuBar.setBackground(new Color(2, 120, 0));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Game");
		mnNewMenu.setBackground(new Color(0, 0, 0));
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Play");
		mntmNewMenuItem.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Window2 w1 = new Window2();
				w1.frmL.setVisible(true);
			
				

			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setBackground(new Color(0, 0, 0));
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Pause & Play");
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setBackground(new Color(255, 255, 255));
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Press SpaceBar");
		mntmNewMenuItem_2.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_2.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Snake Move");
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		mnNewMenu_3.setBackground(new Color(255, 255, 255));
		mnNewMenu_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Up - Press Up Arrow Key");
		mntmNewMenuItem_3.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_3.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Down - Press Down Arrow Key");
		mntmNewMenuItem_4.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_4.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Right - Press Right Arrow Key");
		mntmNewMenuItem_5.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_5.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Left - Press Left Arrow Key");
		mntmNewMenuItem_6.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_6.setBackground(new Color(255, 255, 255));
		mntmNewMenuItem_6.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kavinda Madushan\\eclipse-workspace\\JavaGame\\images\\snake2.jpg"));
		lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("snake2.jpg")));
		lblNewLabel.setForeground(new Color(2, 120, 0));
		lblNewLabel.setBounds(0, 0, 620, 642);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Window2 w2 = new Window2();
				w2.frmL.setVisible(true);

			}
		});
		btnPlay.setForeground(Color.WHITE);
		btnPlay.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnPlay.setBackground(new Color(2, 120, 0));
		btnPlay.setBounds(245, 580, 120, 53);
		frame.getContentPane().add(btnPlay);
		

	}
}
