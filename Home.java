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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Component;

public class Home {
	
	private File selectedFile;
	private String fileName;
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
	
	private JLabel lblNewLabel = new JLabel("New_Manual_Input"); 
	
	JTextField highPPoss = new JTextField();
	JTextField lowPPoss = new JTextField();
	JTextField highEarned = new JTextField();
	JTextField lowEarned = new JTextField();
	JTextField average = new JTextField();
	JTextField median = new JTextField();
	
	private DefaultListModel<Float> model;
	private DefaultListModel<Float> model1;

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
			    	  
			    	  if (selectedFile.getName().endsWith(".txt") != true) {
				    	   JOptionPane.showMessageDialog(panel, "Invalid File", "Error", JOptionPane.ERROR_MESSAGE);

				      }
			    	  else {

			    	  
			    	  panel.removeAll();
			    	  
			    	  panel.add(minText);
			    	  panel.add(maxText);
			    	  panel.add(maxPossText);
			    	  panel.add(minPossText);
			    	  panel.add(btnNext2);
			    	  
			    	  panel.repaint();
			      }
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
				
				if ((minPossText == null || maxPossText == null) || (minPossText == null && maxPossText == null) ) {
					JOptionPane.showMessageDialog(panel, "Must Enter Values", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
				
				//string to Float, but need error catcher later
				maxPoss = Float.parseFloat(maxPossText.getText());
				minPoss = Float.parseFloat(minPossText.getText());	
				
				if(selectedFile == null) {
					gaFile = new GradeAnalytics(minPoss, maxPoss);
					
			    	highPPoss.setText("" + maxPoss);
			    	lowPPoss.setText("" + minPoss);
			    	highEarned.setText("" + gaFile.getMaxScore());
			    	lowEarned.setText("" + gaFile.getMinScore());
			    	average.setText("" + gaFile.getAverage());
			    	median.setText("" + gaFile.getMedian());
					
				} else {
					FileInput data = new FileInput(selectedFile, minPoss, maxPoss);
			    	list = data.getFloatFileList();
			    	gaFile = new GradeAnalytics(list, minPoss, maxPoss);
			    	
			    	lblNewLabel.setText("File: " + selectedFile.getName());
			    	
			    	highPPoss.setText("" + maxPoss);
			    	lowPPoss.setText("" + minPoss);
			    	highEarned.setText("" + gaFile.getMaxScore());
			    	lowEarned.setText("" + gaFile.getMinScore());
			    	average.setText("" + gaFile.getAverage());
			    	median.setText("" + gaFile.getMedian());
			    	
				}
				
				window.frmHome.setVisible(false);
				window.frmMain.setVisible(true);
				}
				
			}
		});
		
		//Frame for Main Analysis Screen
		frmMain = new JFrame();
		frmMain.setTitle("Grade Analitica");
		frmMain.setBounds(100, 100, 600, 400);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		frmMain.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		//basic screen
		JButton btnHome = new JButton("Home");
		JButton btnNewButton_3 = new JButton("Add a Grade");
		JButton btnNewButton_4 = new JButton("Remove a Grade");
		JButton btnNewButton_5 = new JButton("Change a Grade");
		JButton btnViewAnalytics = new JButton("View Analytics");
		JButton btnViewLetterGrades = new JButton("View Letter Grades");
		JButton btnNewButton = new JButton("Percentile");
		JButton btnNewButton_1 = new JButton("Percentage");
		JButton btnSummary = new JButton("Display Summary");
		JButton btnExit = new JButton("Exit");
		
		JButton btnRename = new JButton("Rename");
		
		btnHome.setBounds(20, 20, 150, 25);
		panelMain.add(btnHome);
		
		btnNewButton_3.setBounds(20, 55, 150, 25);
		panelMain.add(btnNewButton_3);
		
		btnNewButton_4.setBounds(20, 90, 150, 25);
		panelMain.add(btnNewButton_4);
		
		btnNewButton_5.setBounds(20, 125, 150, 25);
		panelMain.add(btnNewButton_5);
		
		btnViewAnalytics.setBounds(20, 160, 150, 25);
		panelMain.add(btnViewAnalytics);
		
		btnViewLetterGrades.setBounds(20, 195, 150, 25);
		panelMain.add(btnViewLetterGrades);
		
		btnNewButton.setBounds(20, 230, 150, 25);
		panelMain.add(btnNewButton);
		
		btnNewButton_1.setBounds(20, 265, 150, 25);
		panelMain.add(btnNewButton_1);
			
		btnSummary.setBounds(20, 300, 150, 25);
		panelMain.add(btnSummary);
		
		btnExit.setBounds(20, 335, 150, 25);
		panelMain.add(btnExit);
		
		lblNewLabel.setBounds(300, 20, 150, 25);
		panelMain.add(lblNewLabel);
		
		btnRename.setBounds(425, 20, 100, 25);
		panelMain.add(btnRename);
		
		
		//More on the analytics screen
		JLabel highPPossString = new JLabel("Highest Points Possible:");
		JLabel lowPPossString = new JLabel("Lowest Points Possible:");
		JLabel highEarnedString = new JLabel("Highest Points Earned:");
		JLabel lowEarnedString = new JLabel("Lowest Points Earned:");
		JLabel averageString = new JLabel("Average Value:");
		JLabel medianString = new JLabel("Median Value:");
		
		//JTEXT are global variables (above) in order to change
    	highPPoss.setEditable(false);
    	lowPPoss.setEditable(false);
    	highEarned.setEditable(false);
    	lowEarned.setEditable(false);
    	average.setEditable(false);
    	median.setEditable(false);
		
		//Labels
		highPPossString.setBounds(250, 80, 200, 25);
		panelMain.add(highPPossString);
		
		lowPPossString.setBounds(250, 120, 200, 25);
		panelMain.add(lowPPossString);
		
		highEarnedString.setBounds(250, 160, 200, 25);
		panelMain.add(highEarnedString);
		
		lowEarnedString.setBounds(250, 200, 200, 25);
		panelMain.add(lowEarnedString);
		
		averageString.setBounds(250, 240, 200, 25);
		panelMain.add(averageString);
		
		medianString.setBounds(250, 280, 200, 25);
		panelMain.add(medianString);
		
		
		//Values
		highPPoss.setBounds(425, 80, 60, 25);
		panelMain.add(highPPoss);
		
		lowPPoss.setBounds(425, 120, 60, 25);
		panelMain.add(lowPPoss);
		
		highEarned.setBounds(425, 160, 60, 25);
		panelMain.add(highEarned);
		
		lowEarned.setBounds(425, 200, 60, 25);
		panelMain.add(lowEarned);
		
		average.setBounds(425, 240, 60, 25);
		panelMain.add(average);
		
		median.setBounds(425, 280, 60, 25);
		panelMain.add(median);
		
		//To rename buttons
		
		JLabel newFileNameString = new JLabel("Enter new name:");
		JTextField newFileName = new JTextField();
		JButton continueName = new JButton("Update");
		
		newFileNameString.setBounds(250, 80, 200, 25);
		panelMain.add(newFileNameString);
		
		newFileName.setBounds(425, 80, 100, 25);
		panelMain.add(newFileName);
		
		continueName.setBounds(425, 20, 100, 25);
		panelMain.add(continueName);
		
		newFileNameString.setVisible(false);
		newFileName.setVisible(false);
		continueName.setVisible(false);
		
		//Grades
		
		JLabel gradeAString = new JLabel("Number of As:");
		JLabel gradeBString = new JLabel("Number of Bs:");
		JLabel gradeCString = new JLabel("Number of Cs:");
		JLabel gradeDString = new JLabel("Number of Ds:");
		JLabel gradeEString = new JLabel("Number of Es:");
		
		JTextField gradeA = new JTextField();
		JTextField gradeB = new JTextField();
		JTextField gradeC = new JTextField();
		JTextField gradeD = new JTextField();
		JTextField gradeE = new JTextField();
		
		gradeAString.setBounds(250, 80, 200, 25);
		panelMain.add(gradeAString);
		
		gradeBString.setBounds(250, 110, 200, 25);
		panelMain.add(gradeBString);
		
		gradeCString.setBounds(250, 140, 200, 25);
		panelMain.add(gradeCString);
		
		gradeDString.setBounds(250, 170, 200, 25);
		panelMain.add(gradeDString);
		
		gradeEString.setBounds(250, 200, 200, 25);
		panelMain.add(gradeEString);
		
		
		//Values
		gradeA.setBounds(425, 80, 60, 25);
		panelMain.add(gradeA);
		
		gradeB.setBounds(425, 110, 60, 25);
		panelMain.add(gradeB);
		
		gradeC.setBounds(425, 140, 60, 25);
		panelMain.add(gradeC);
		
		gradeD.setBounds(425, 170, 60, 25);
		panelMain.add(gradeD);
		
		gradeE.setBounds(425, 200, 60, 25);
		panelMain.add(gradeE);
		
		gradeA.setEditable(false);
		gradeB.setEditable(false);
		gradeC.setEditable(false);
		gradeD.setEditable(false);
		gradeE.setEditable(false);
		
		JButton setGradeCutOff = new JButton("Set Grade Cut Off");
		
		JTextField cutOffA = new JTextField("89.5");
		JTextField cutOffB = new JTextField("79.5");
		JTextField cutOffC = new JTextField("69.5");
		JTextField cutOffD = new JTextField("59.5");
		
		JLabel cutOffAString = new JLabel("Set As (default: 89.5):");
		JLabel cutOffBString = new JLabel("Set Bs (default: 79.5):");
		JLabel cutOffCString = new JLabel("Set Cs (default: 69.5):");
		JLabel cutOffDString = new JLabel("Set Ds (default: 59.5):");

		setGradeCutOff.setBounds(300, 230, 150, 25);
		panelMain.add(setGradeCutOff);
		
		cutOffAString.setBounds(250, 260, 150, 25);
		panelMain.add(cutOffAString);
		cutOffBString.setBounds(250, 290, 150, 25);
		panelMain.add(cutOffBString);
		cutOffCString.setBounds(250, 320, 150, 25);
		panelMain.add(cutOffCString);
		cutOffDString.setBounds(250, 350, 150, 25);
		panelMain.add(cutOffDString);
		
		cutOffA.setBounds(425, 260, 60, 25);
		panelMain.add(cutOffA);
		cutOffB.setBounds(425, 290, 60, 25);
		panelMain.add(cutOffB);
		cutOffC.setBounds(425, 320, 60, 25);
		panelMain.add(cutOffC);
		cutOffD.setBounds(425, 350, 60, 25);
		panelMain.add(cutOffD);
		
		gradeAString.setVisible(false);
		gradeBString.setVisible(false);
		gradeCString.setVisible(false);
		gradeDString.setVisible(false);
		gradeEString.setVisible(false);
		
		gradeA.setVisible(false);
		gradeB.setVisible(false);
		gradeC.setVisible(false);
		gradeD.setVisible(false);
		gradeE.setVisible(false);
		
		setGradeCutOff.setVisible(false);
		
		cutOffA.setVisible(false);
		cutOffB.setVisible(false);
		cutOffC.setVisible(false);
		cutOffD.setVisible(false);
		
		cutOffAString.setVisible(false);
		cutOffBString.setVisible(false);
		cutOffCString.setVisible(false);
		cutOffDString.setVisible(false);
		

		
		
		
		


		
		
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
		
		JButton btnBack2 = new JButton("Back");
		GroupLayout gl_panel = new GroupLayout(addPanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack2)
					.addGap(46)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(btnSubmit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(lblNewLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
					.addGap(160))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnBack2))
					.addContainerGap())
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
		JList<Float> list2 = new JList<Float>((model));

		JLabel removeLbl = new JLabel("Remove Grade");
		removeLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		removeLbl.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel removeLbl1 = new JLabel("Choose Grade To Remove");
		removeLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnBack1 = new JButton("Back");
		
		//Connect this list to original list from main list
		GroupLayout gl_removePanel = new GroupLayout(removePanel);
		gl_removePanel.setHorizontalGroup(
			gl_removePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_removePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack1)
					.addGap(80)
					.addGroup(gl_removePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSubmit1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(scrollPane2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(removeLbl1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(removeLbl, GroupLayout.PREFERRED_SIZE, 279, Short.MAX_VALUE))
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
					.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(gl_removePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack1)
						.addComponent(btnSubmit1))
					.addContainerGap())
		);
		
		scrollPane2.setViewportView(list2);
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
		
		JScrollPane scrollchgPane = new JScrollPane();
		scrollchgPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnBack = new JButton("Back");
		
		newValField = new JTextField();
		newValField.setColumns(10);
		
		JLabel lblDeleteValue = new JLabel("Delete Value");
		lblDeleteValue.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_chgPanel = new GroupLayout(chgPanel);
		gl_chgPanel.setHorizontalGroup(
			gl_chgPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_chgPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack)
					.addGap(46)
					.addGroup(gl_chgPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeleteValue, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(scrollchgPane, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(newValField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(btnSubmit2, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(newValLbl1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
						.addComponent(chgLbl, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
					.addGap(160))
		);
		gl_chgPanel.setVerticalGroup(
			gl_chgPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chgPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(chgLbl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(newValLbl1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newValField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblDeleteValue)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollchgPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_chgPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit2)
						.addComponent(btnBack))
					.addContainerGap())
		);
		
		//needed to display float values on JList
		model1 = new DefaultListModel<Float>();
		JList<Float> list3 = new JList<Float>((model1));
		
		scrollchgPane.setViewportView(list3);
		chgPanel.setLayout(gl_chgPanel);
		frmChange.setBounds(100, 100, 600, 400);
		frmChange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//ActionLISTENERS START HERE
		
		//Add/remove/change buttons
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textField.setText("");
				
				frmMain.setVisible(false);
				frmAdd.setVisible(true);
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(false);
				frmRemove.setVisible(true);
				
				model.clear();
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						model.add(i,list.get(i));
					}
				}
			}
		});
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				newValField.setText("");
				
				model1.clear();
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						model1.add(i,list.get(i));
					}
				}
				frmMain.setVisible(false);
				frmChange.setVisible(true);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "You Must Input A Value!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					float tempToAdd = Float.parseFloat(textField.getText());
					gaFile.addGrade(tempToAdd);
					list = gaFile.getList();
					System.out.println(list);
				
					gaFile.refresh();
					highPPoss.setText("" + maxPoss);
					lowPPoss.setText("" + minPoss);
					highEarned.setText("" + gaFile.getMaxScore());
					lowEarned.setText("" + gaFile.getMinScore());
					average.setText("" + gaFile.getAverage());
					median.setText("" + gaFile.getMedian());
				
					frmMain.setVisible(true);
					frmAdd.setVisible(false);
				}
			}
		});
		
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(list2.getSelectedValue() != null) {
					float tempToDel = list2.getSelectedValue();
					gaFile.deleteGrade(tempToDel);
					list = gaFile.getList();
					System.out.println(list);
				
					gaFile.refresh();
					highPPoss.setText("" + maxPoss);
					lowPPoss.setText("" + minPoss);
					highEarned.setText("" + gaFile.getMaxScore());
					lowEarned.setText("" + gaFile.getMinScore());
					average.setText("" + gaFile.getAverage());
					median.setText("" + gaFile.getMedian());
				
					frmMain.setVisible(true);
					frmRemove.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(panel, "You Must Select A Value!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSubmit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(newValField.getText().equals("") || list3.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(panel, "You Must Input A Value!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					float tempToAdd = Float.parseFloat(newValField.getText());
					float tempToDel = list3.getSelectedValue();
				
					gaFile.replaceGrade(tempToDel, tempToAdd);
					list = gaFile.getList();
					System.out.println(list);
					
					gaFile.refresh();
					highPPoss.setText("" + maxPoss);
					lowPPoss.setText("" + minPoss);
					highEarned.setText("" + gaFile.getMaxScore());
					lowEarned.setText("" + gaFile.getMinScore());
					average.setText("" + gaFile.getAverage());
					median.setText("" + gaFile.getMedian());
				
					frmMain.setVisible(true);
					frmChange.setVisible(false);
				}
					
			}
		});
		
		btnBack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(true);
				frmAdd.setVisible(false);
			}
		});
		
		btnBack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(true);
				frmRemove.setVisible(false);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frmMain.setVisible(true);
				frmChange.setVisible(false);
			}
		});
		
		//Analysis screen
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//Probably need to add it saving/some sort of warning
				panel.removeAll();
				
				panel.add(title);
				panel.add(subTitle);
				panel.add(btnFile);
				panel.add(btnNext);
				
				panel.repaint();
				
				frmMain.setVisible(false);
				frmHome.setVisible(true);
			}
		});
		
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gradeAString.setVisible(false);
				gradeBString.setVisible(false);
				gradeCString.setVisible(false);
				gradeDString.setVisible(false);
				gradeEString.setVisible(false);
				
				gradeA.setVisible(false);
				gradeB.setVisible(false);
				gradeC.setVisible(false);
				gradeD.setVisible(false);
				gradeE.setVisible(false);
				
				setGradeCutOff.setVisible(false);
				
				cutOffA.setVisible(false);
				cutOffB.setVisible(false);
				cutOffC.setVisible(false);
				cutOffD.setVisible(false);
				
				cutOffAString.setVisible(false);
				cutOffBString.setVisible(false);
				cutOffCString.setVisible(false);
				cutOffDString.setVisible(false);
				
				highPPoss.setVisible(false);
		    	lowPPoss.setVisible(false);
		    	highEarned.setVisible(false);
		    	lowEarned.setVisible(false);
		    	average.setVisible(false);
		    	median.setVisible(false);
		    	
				highPPossString.setVisible(false);
		    	lowPPossString.setVisible(false);
		    	highEarnedString.setVisible(false);
		    	lowEarnedString.setVisible(false);
		    	averageString.setVisible(false);
		    	medianString.setVisible(false);
		    	
		    	btnRename.setVisible(false);
		    	
				newFileNameString.setVisible(true);
				newFileName.setVisible(true);
				continueName.setVisible(true);
			}
		});
		
		continueName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (newFileName.getText().equals("")) {
					
				} else {
					fileName = newFileName.getText();
					
					lblNewLabel.setText("File: " + fileName + ".txt");
					
					highPPoss.setVisible(true);
			    	lowPPoss.setVisible(true);
			    	highEarned.setVisible(true);
			    	lowEarned.setVisible(true);
			    	average.setVisible(true);
			    	median.setVisible(true);
			    	
					highPPossString.setVisible(true);
			    	lowPPossString.setVisible(true);
			    	highEarnedString.setVisible(true);
			    	lowEarnedString.setVisible(true);
			    	averageString.setVisible(true);
			    	medianString.setVisible(true);
			    	
			    	btnRename.setVisible(true);
			    	
					newFileNameString.setVisible(false);
					newFileName.setVisible(false);
					continueName.setVisible(false);
				}
			}
		});
		
		btnViewAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				//add all others false
				gradeAString.setVisible(false);
				gradeBString.setVisible(false);
				gradeCString.setVisible(false);
				gradeDString.setVisible(false);
				gradeEString.setVisible(false);
				
				gradeA.setVisible(false);
				gradeB.setVisible(false);
				gradeC.setVisible(false);
				gradeD.setVisible(false);
				gradeE.setVisible(false);
				
				setGradeCutOff.setVisible(false);
				
				cutOffA.setVisible(false);
				cutOffB.setVisible(false);
				cutOffC.setVisible(false);
				cutOffD.setVisible(false);
				
				cutOffAString.setVisible(false);
				cutOffBString.setVisible(false);
				cutOffCString.setVisible(false);
				cutOffDString.setVisible(false);
				
				highPPoss.setVisible(true);
		    	lowPPoss.setVisible(true);
		    	highEarned.setVisible(true);
		    	lowEarned.setVisible(true);
		    	average.setVisible(true);
		    	median.setVisible(true);
		    	
				highPPossString.setVisible(true);
		    	lowPPossString.setVisible(true);
		    	highEarnedString.setVisible(true);
		    	lowEarnedString.setVisible(true);
		    	averageString.setVisible(true);
		    	medianString.setVisible(true);
		    	
		    	btnRename.setVisible(true);
		    	
		    	newFileNameString.setVisible(false);
				newFileName.setVisible(false);
				continueName.setVisible(false);
			}
		});
		
		btnViewLetterGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gradeAString.setVisible(true);
				gradeBString.setVisible(true);
				gradeCString.setVisible(true);
				gradeDString.setVisible(true);
				gradeEString.setVisible(true);
				
				gradeA.setVisible(true);
				gradeB.setVisible(true);
				gradeC.setVisible(true);
				gradeD.setVisible(true);
				gradeE.setVisible(true);
				
				setGradeCutOff.setVisible(true);
				
				highPPoss.setVisible(false);
		    	lowPPoss.setVisible(false);
		    	highEarned.setVisible(false);
		    	lowEarned.setVisible(false);
		    	average.setVisible(false);
		    	median.setVisible(false);
		    	
				highPPossString.setVisible(false);
		    	lowPPossString.setVisible(false);
		    	highEarnedString.setVisible(false);
		    	lowEarnedString.setVisible(false);
		    	averageString.setVisible(false);
		    	medianString.setVisible(false);
		    	
		    	btnRename.setVisible(false);
		    	
		    	newFileNameString.setVisible(false);
				newFileName.setVisible(false);
				continueName.setVisible(false);
				
				gaFile.refresh();
				
				gradeA.setText("" + gaFile.getNumberofAs());
				gradeB.setText("" + gaFile.getNumberofBs());
				gradeC.setText("" + gaFile.getNumberofCs());
				gradeD.setText("" + gaFile.getNumberofDs());
				gradeE.setText("" + gaFile.getNumberofEs());
				
				
				
				
			}
		});
		
		setGradeCutOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cutOffA.setVisible(true);
				cutOffB.setVisible(true);
				cutOffC.setVisible(true);
				cutOffD.setVisible(true);
				
				cutOffAString.setVisible(true);
				cutOffBString.setVisible(true);
				cutOffCString.setVisible(true);
				cutOffDString.setVisible(true);
				if(cutOffA.isVisible()) {
				if(cutOffA.getText().equals("") || cutOffB.getText().equals("") || 
						cutOffC.getText().equals("") || cutOffD.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "You Must Input A Value!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (Float.parseFloat(cutOffA.getText()) < 0 || Float.parseFloat(cutOffB.getText()) < 0 
						|| Float.parseFloat(cutOffC.getText()) < 0 || Float.parseFloat(cutOffD.getText()) < 0) {
					JOptionPane.showMessageDialog(panel, "You Must Input A Valid Value!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					gaFile.setAsCutOff(Float.parseFloat(cutOffA.getText()));
					gaFile.setBsCutOff(Float.parseFloat(cutOffB.getText()));
					gaFile.setCsCutOff(Float.parseFloat(cutOffC.getText()));
					gaFile.setDsCutOff(Float.parseFloat(cutOffD.getText()));
					gaFile.refresh();
					
					gradeA.setText("" + gaFile.getNumberofAs());
					gradeB.setText("" + gaFile.getNumberofBs());
					gradeC.setText("" + gaFile.getNumberofCs());
					gradeD.setText("" + gaFile.getNumberofDs());
					gradeE.setText("" + gaFile.getNumberofEs());
					
					panelMain.repaint();

				}
				}
				
			}
		});
		
		//All The distribution Stuff
		

		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		//Functionality for 'Exit' button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				System.exit(0);
			}
		});
		
		
		
		
	}
}
		
