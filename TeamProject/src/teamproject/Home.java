package teamproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Home {
	
	private File selectedFile;
	private ArrayList<Float> list;
	private float minPoss;
	private float maxPoss;
	
	private GradeAnalytics gaFile;
	
	private static Home window;
	
	private JFrame frmHome;
	private JFrame frmMain;

	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Home();
					
					//Visibility for Frames or Windows
					window.frmHome.setVisible(true);
					window.frmMain.setVisible(false);
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
		
		//Frame For Home Screen
		frmHome = new JFrame();
		frmHome.setFont(new Font("Canadara", Font.BOLD, 15));
		frmHome.setBounds(100, 100, 600, 400);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		//JOptionPane.showMessageDialog(frmHome, "Invalid File.");
		//JOptionPane.showMessageDialog(frmHome, "Cannot Find File.");
		//JOptionPane.showMessageDialog(frmMain, "Cannot Remove File.");
		//JOptionPane.showMessageDialog(frmHome, "Not Within Bounds.");
		
		//do we need to declare this all above and put private? I think so, but we can do later
		JPanel panel = new JPanel();
		frmHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Grade Analitica");
		title.setFont(new Font("Arial Black", Font.PLAIN, 29));
		title.setBounds(159, 81, 252, 66);
		panel.add(title);
		
		JLabel subTitle = new JLabel("The #1 Grade Analysis Tool");
		subTitle.setFont(new Font("Arial", Font.BOLD, 17));
		subTitle.setBounds(179, 158, 206, 33);
		panel.add(subTitle);
		
		JButton btnFile = new JButton("Input File");
		btnFile.setBounds(238, 202, 89, 23);
		panel.add(btnFile);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(485, 327, 89, 23);
		panel.add(btnNext);
	
		JButton btnNext2 = new JButton("Next");
		btnNext2.setBounds(335, 227, 89, 23);
		
		JLabel minText = new JLabel("Insert the minimum possible value:");
		minText.setBounds(50, 50, 250, 40);
		
		JLabel maxText = new JLabel("Insert the maximum possible value:");
		maxText.setBounds(50, 100, 250, 40);
		
		JTextField minPossText = new JTextField();
		minPossText.setBounds(300, 50, 40, 40);
		
		JTextField maxPossText = new JTextField();
		maxPossText.setBounds(300, 100, 40, 40);
		
		//imports file!
		btnFile.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ae) {
		    	  JFileChooser fileChooser = new JFileChooser();
		    	  
		    	  //I personally am trying to figure out how this works. This was partially pulled from
		    	  //an example "approve_option" I believe is making it so an error doesn't occur 
			      int returnValue = fileChooser.showOpenDialog(null);
			      if (returnValue == JFileChooser.APPROVE_OPTION) {
			    	  selectedFile = fileChooser.getSelectedFile();
			    	  
			    	  panel.removeAll();
			    	  
			    	  panel.add(minText);
			    	  panel.add(maxText);
			    	  panel.add(maxPossText);
			    	  panel.add(minPossText);
			    	  panel.add(btnNext2);
			    	  
			    	  panel.repaint();
			      }
		      }
		});
		
		//this button just goes to 
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				panel.removeAll();
		    	  
		    	panel.add(minText);
		    	panel.add(maxText);
		    	panel.add(maxPossText);
		    	panel.add(minPossText);
		    	panel.add(btnNext2);
		    	
		    	panel.repaint();
				
			}
		});
		
		//button that is identical to first but has a different effect, moving it onto the analytics screen
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				//string to Float, but need error catcher later
				maxPoss = Float.parseFloat(maxPossText.getText());
				minPoss = Float.parseFloat(minPossText.getText());	
				
				if(selectedFile == null) {
					gaFile = new GradeAnalytics(minPoss, maxPoss);
				} else {
					FileInput data = new FileInput(selectedFile, minPoss, maxPoss);
			    	list = data.getFloatFileList();
			    	gaFile = new GradeAnalytics(list, minPoss, maxPoss);
				}
				
				window.frmHome.setVisible(false);
				window.frmMain.setVisible(true);
				
			}
		});
		
		//Frame for Main Analysis Screen
		frmMain = new JFrame();
		frmMain.setTitle("Grade Analitica");
		frmMain.setBounds(100, 100, 600, 400);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		frmMain.getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel leftBtnPanel = new JPanel();
		panelMain.add(leftBtnPanel);
		
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
		panelMain.add(midPanel);
		
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
		panelMain.add(rightPanel);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		
		JButton btnChangePercents = new JButton("Change Percents");
		
		JButton btnNext1 = new JButton("Next");
		
		//This panel contains buttons for the right panel
		GroupLayout gl_rightBtnPanel = new GroupLayout(rightPanel);
		gl_rightBtnPanel.setHorizontalGroup(
				
				//creates a group of horizontally aligned components
			gl_rightBtnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_rightBtnPanel.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addGroup(gl_rightBtnPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNext1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
					.addComponent(btnNext1)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		rightPanel.setLayout(gl_rightBtnPanel);
	}
		
}
