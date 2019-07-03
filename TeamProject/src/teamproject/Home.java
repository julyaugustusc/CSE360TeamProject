package teamproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home {

	private JFrame frmGradeAnalitica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmGradeAnalitica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradeAnalitica = new JFrame();
		frmGradeAnalitica.setFont(new Font("Canadara", Font.BOLD, 15));
		frmGradeAnalitica.setBounds(100, 100, 450, 300);
		frmGradeAnalitica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGradeAnalitica.getContentPane().setLayout(new GridLayout(0, 1, 0,0));
		
		JPanel panel = new JPanel();
		frmGradeAnalitica.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Grade Analitica");
		title.setFont(new Font("Arial Black", Font.PLAIN, 29));
		title.setBounds(94, 45, 252, 66);
		panel.add(title);
		
		JLabel subTitle = new JLabel("The #1 Grade Analysis Tool");
		subTitle.setFont(new Font("Arial", Font.BOLD, 17));
		subTitle.setBounds(117, 113, 206, 33);
		panel.add(subTitle);
		
		JButton btnFile = new JButton("Input File");
		btnFile.setBounds(173, 178, 89, 23);
		panel.add(btnFile);
	}

}