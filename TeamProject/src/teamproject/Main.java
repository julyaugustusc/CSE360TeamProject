package teamproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Main {

	private JFrame frmGradeAnalitica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGradeAnalitica = new JFrame();
		frmGradeAnalitica.setTitle("Grade Analitica");
		frmGradeAnalitica.setBounds(100, 100, 600, 400);
		frmGradeAnalitica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmGradeAnalitica.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel leftBtnPanel = new JPanel();
		panel.add(leftBtnPanel);
		
		JButton btnChangeGrades = new JButton("Change Grades");
		
		JButton btnSummary = new JButton("Display Summary");
		
		JButton btnExit = new JButton("Exit");
		
		JButton btnViewAnalytics = new JButton("View Analytics");
		
		JButton btnHome = new JButton("Home");
		
		//Window is split into three different panels, the left, mid, and right panels. 
		//Each panel has their one set of buttons and elements
		//Each panel has their own layout manager, i used the Group Layout for each panel
		
		//Group Layout groups each components that organize by their relative position from each other
		//This one has all the buttons for left side 
		GroupLayout gl_leftBtnPanel = new GroupLayout(leftBtnPanel);
		
		//creates a group of horizontally aligned components
		gl_leftBtnPanel.setHorizontalGroup(
			gl_leftBtnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftBtnPanel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_leftBtnPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnHome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSummary, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewAnalytics, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChangeGrades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		
		//creates a group of vertically aligned components
		gl_leftBtnPanel.setVerticalGroup(
			gl_leftBtnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_leftBtnPanel.createSequentialGroup()
					.addGap(36)
					.addComponent(btnChangeGrades)
					.addGap(18)
					.addComponent(btnSummary)
					.addGap(18)
					.addComponent(btnExit)
					.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
					.addComponent(btnViewAnalytics)
					.addGap(18)
					.addComponent(btnHome)
					.addGap(29))
		);
		leftBtnPanel.setLayout(gl_leftBtnPanel);
		
		
		
		//Initialization for middle panel buttons
		JPanel midPanel = new JPanel();
		panel.add(midPanel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JList list = new JList();
		
		JButton btnNewButton = new JButton("Percentile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnViewLetterGrades = new JButton("View Letter Grades");
		
		JButton btnNewButton_1 = new JButton("Percentage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//This panel contains buttons and the list component that displays the list data
		GroupLayout gl_midPanel = new GroupLayout(midPanel);
		
		//creates a group of horizontally aligned components
		gl_midPanel.setHorizontalGroup(
			gl_midPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_midPanel.createSequentialGroup()
					.addGroup(gl_midPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_midPanel.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_midPanel.createSequentialGroup()
							.addGap(22)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_midPanel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_midPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnViewLetterGrades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		//creates a group of vertically aligned components
		gl_midPanel.setVerticalGroup(
			gl_midPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_midPanel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnViewLetterGrades)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		midPanel.setLayout(gl_midPanel);
		
		//Initialization for right panel buttons
		JPanel rightPanel = new JPanel();
		panel.add(rightPanel);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		
		JButton btnChangePercents = new JButton("Change Percents");
		
		JButton btnNext = new JButton("Next");
		
		//This panel contains buttons for the right panel
		GroupLayout gl_rightBtnPanel = new GroupLayout(rightPanel);
		gl_rightBtnPanel.setHorizontalGroup(
				
				//creates a group of horizontally aligned components
			gl_rightBtnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_rightBtnPanel.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addGroup(gl_rightBtnPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNext, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChangePercents, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(37))
		);
		
		//creates a group of vertically aligned components
		gl_rightBtnPanel.setVerticalGroup(
			gl_rightBtnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightBtnPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(btnNewButton_2)
					.addGap(18)
					.addComponent(btnChangePercents)
					.addGap(120)
					.addComponent(btnNext)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		rightPanel.setLayout(gl_rightBtnPanel);
	}
}