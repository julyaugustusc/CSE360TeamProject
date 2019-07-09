package teamproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.Component;

public class Home {
	
	private File selectedFile;
	private ArrayList<Float> list;
	private float minPoss;
	private float maxPoss;
	
	private GradeAnalytics gaFile;
	
	private static Home window;
	
	private JFrame frmHome;
	private JFrame frmMain;
	private JFrame frmAdd;
	private JFrame frmRemove;
	private JFrame frmChange;

	private JTextField textField;
	private JTextField newValField;
	private JTextField delValField;
	
	private JLabel lblNewLabel = new JLabel("NewManualInput"); 
	
	private DefaultListModel<Float> model;

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
					window.frmAdd.setVisible(false);
					window.frmRemove.setVisible(false);
					window.frmChange.setVisible(false);
					
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
		
		/*JOptionPane optionPane = new JOptionPane(
	    "Are You Sure?\n",
	    JOptionPane.QUESTION_MESSAGE,
	    JOptionPane.YES_NO_OPTION);*/
		
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
			    	
			    	lblNewLabel.setText(selectedFile.getName());
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
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLabel("Grades Menu");
		addPopup(btnChangeGrades, popupMenu);
		
		JButton btnNewButton_3 = new JButton("Add Grades       ");
		popupMenu.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remove Grade  ");
		popupMenu.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update Grade   ");
		popupMenu.add(btnNewButton_5);
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
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JList list1 = new JList();
		
		JButton btnNewButton = new JButton("Percentile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			}
		});
		
		JButton btnViewLetterGrades = new JButton("View Letter Grades");
		
		JButton btnNewButton_1 = new JButton("Percentage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
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
							.addComponent(list1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(list1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
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
		
		
		
		
		//Frame for Adding Grade Window
		frmAdd = new JFrame();
		frmAdd.setBounds(100, 100, 600, 400);
		frmAdd.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));

		JPanel addPanel = new JPanel();
		frmAdd.getContentPane().add(addPanel);

		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");

		JLabel lblNewLabel1 = new JLabel("Add Grades");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Input Grade");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(addPanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(145)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(lblNewLabel1, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(btnSubmit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
					.addGap(160))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(btnSubmit)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		addPanel.setLayout(gl_panel);
		frmAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		//Frame for Remove Grades Window
		frmRemove = new JFrame();
		frmRemove.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));

		JPanel removePanel = new JPanel();
		frmRemove.getContentPane().add(removePanel);
		
		JButton btnSubmit1 = new JButton("Submit");
		
		//needed to display float values on JList
		model = new DefaultListModel<Float>();
		JList<Float> list2 = new JList<Float>(model);

		JLabel removeLbl = new JLabel("Remove Grade");
		removeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		removeLbl.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel removeLbl1 = new JLabel("Choose Grade To Remove");
		removeLbl1.setHorizontalAlignment(SwingConstants.CENTER);

		//Connect this list to original list from main list
		GroupLayout gl_removePanel = new GroupLayout(removePanel);
		gl_removePanel.setHorizontalGroup(
			gl_removePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_removePanel.createSequentialGroup()
					.addGap(145)
					.addGroup(gl_removePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(list2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(btnSubmit1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(removeLbl1, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(removeLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 108, Short.MAX_VALUE))
					.addGap(160))
		);
		gl_removePanel.setVerticalGroup(
				gl_removePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_removePanel.createSequentialGroup()
					.addGap(27)
					.addComponent(removeLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(removeLbl1)
					.addGap(18)
					.addComponent(list2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSubmit1)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		removePanel.setLayout(gl_removePanel);
		frmRemove.setBounds(100, 100, 600, 400);
		frmRemove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		//Frame for the Change Grades Window
		frmChange = new JFrame();
		frmChange.getContentPane().setLayout(new GridLayout(1, 1, 0, 0));

		JPanel chgPanel = new JPanel();
		frmChange.getContentPane().add(chgPanel);
		
		JButton btnSubmit2 = new JButton("Submit");

		JLabel chgLbl = new JLabel("Change Grade");
		chgLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		chgLbl.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel newValLbl1 = new JLabel("New Value");
		newValLbl1.setHorizontalAlignment(SwingConstants.CENTER);

		newValField = new JTextField();
		newValField.setColumns(10);

		JLabel delvalLbl = new JLabel("Delete Value");
		delvalLbl.setHorizontalAlignment(SwingConstants.CENTER);

		delValField = new JTextField();
		delValField.setColumns(10);
		GroupLayout gl_chgPanel1 = new GroupLayout(chgPanel);
		gl_chgPanel1.setHorizontalGroup(
			gl_chgPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chgPanel1.createSequentialGroup()
					.addGap(145)
					.addGroup(gl_chgPanel1.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_chgPanel1.createSequentialGroup()
									.addComponent(newValLbl1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addGap(246))
							.addGroup(Alignment.TRAILING, gl_chgPanel1.createSequentialGroup()
							.addGroup(gl_chgPanel1.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnSubmit2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
									.addComponent(newValField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
									.addComponent(chgLbl, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
									.addComponent(delValField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
									.addComponent(delvalLbl, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
								.addGap(160))))
		);
		gl_chgPanel1.setVerticalGroup(
			gl_chgPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chgPanel1.createSequentialGroup()
					.addGap(27)
					.addComponent(chgLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(newValLbl1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newValField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(delvalLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(delValField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(btnSubmit2)
					.addContainerGap())
		);
		chgPanel.setLayout(gl_chgPanel1);
		frmChange.setBounds(100, 100, 600, 400);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ActionLISTENERS for add/remove/change grades
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(false);
				frmAdd.setVisible(true);
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(false);
				frmRemove.setVisible(true);
				
				model.clear();
				for (int i = 0; i < list.size(); i++) {
					model.add(i,list.get(i));
				}
			}
		});
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(false);
				frmChange.setVisible(true);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				float tempToAdd = Float.parseFloat(textField.getText());
				list.add(tempToAdd);
				gaFile.setList(list);
				System.out.print(list);
				
				frmMain.setVisible(true);
				frmAdd.setVisible(false);	
			}
		});
		
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int indexOfTempToRemove = list2.getSelectedIndex();
				list.remove(indexOfTempToRemove);
				gaFile.setList(list);
				
				frmMain.setVisible(true);
				frmRemove.setVisible(false);
		
			}
		});
		
		btnSubmit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				float tempToAdd = Float.parseFloat(newValField.getText());
				float tempToDel = Float.parseFloat(delValField.getText());
				
				gaFile.replaceGrade(tempToDel, tempToAdd);
				list = gaFile.getList();
				
				frmMain.setVisible(true);
				frmChange.setVisible(false);
				
			}
		});
		
			
		
		
		
		
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
		
}