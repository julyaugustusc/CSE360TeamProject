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
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

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
	
	JTextField highPPoss = new JTextField();
	JTextField lowPPoss = new JTextField();
	JTextField highEarned = new JTextField();
	JTextField lowEarned = new JTextField();
	JTextField average = new JTextField();
	JTextField median = new JTextField();
	
	private DefaultListModel<Float> model;
	private DefaultListModel<Float> model1;
	private JTextField perDisA;
	private JTextField perDisB;
	private JTextField perDisC;
	private JTextField perDisD;
	private JTextField perDisE;
	private JTextField pdDisA;
	private JTextField pdDisB;
	private JTextField pdDisC;
	private JTextField pdDisD;
	private JTextField pdDisE;

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
			      
			      
			    	//  JOptionPane.showMessageDialog(panel, "Invalid File", "Error", JOptionPane.ERROR_MESSAGE);
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
				}
				
				//string to Float, but need error catcher later
				maxPoss = Float.parseFloat(maxPossText.getText());
				minPoss = Float.parseFloat(minPossText.getText());	
				
					
				if(selectedFile == null) {
					gaFile = new GradeAnalytics(minPoss, maxPoss);
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
		});
		
		//Frame for Main Analysis Screen
		frmMain = new JFrame();
		frmMain.setTitle("Grade Analitica");
		frmMain.setBounds(100, 100, 600, 400);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMain = new JPanel();
		frmMain.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		
		//Panel for Percent Dis w/ High/Low
		JPanel highLowPanel = new JPanel();
		highLowPanel.setBounds(250, 80, 234, 225);
		panelMain.add(highLowPanel);
		highLowPanel.setLayout(null);
		highLowPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Percent Distributions (High/Low)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel pdgradeA = new JLabel("A:");
		pdgradeA.setFont(new Font("Tahoma", Font.BOLD, 20));
		pdgradeA.setBounds(new Rectangle(65, 15, 21, 25));
		pdgradeA.setBounds(65, 15, 21, 25);
		highLowPanel.add(pdgradeA);
		
		JLabel pdgradeB = new JLabel("B:");
		pdgradeB.setFont(new Font("Tahoma", Font.BOLD, 20));
		pdgradeB.setBounds(new Rectangle(65, 50, 21, 25));
		pdgradeB.setBounds(65, 50, 21, 25);
		highLowPanel.add(pdgradeB);
		
		JLabel pdgradeC = new JLabel("C:");
		pdgradeC.setFont(new Font("Tahoma", Font.BOLD, 20));
		pdgradeC.setBounds(new Rectangle(65, 85, 20, 25));
		pdgradeC.setBounds(65, 85, 20, 25);
		highLowPanel.add(pdgradeC);
		
		JLabel pdgradeD = new JLabel("D:");
		pdgradeD.setFont(new Font("Tahoma", Font.BOLD, 20));
		pdgradeD.setBounds(new Rectangle(65, 120, 22, 25));
		pdgradeD.setBounds(65, 120, 22, 25);
		highLowPanel.add(pdgradeD);
		
		JLabel pdgradeE = new JLabel("E:");
		pdgradeE.setFont(new Font("Tahoma", Font.BOLD, 20));
		pdgradeE.setBounds(new Rectangle(65, 155, 19, 25));
		pdgradeE.setBounds(65, 155, 19, 25);
		highLowPanel.add(pdgradeE);
		
		pdDisA = new JTextField("0");
		pdDisA.setFont(new Font("Tahoma", Font.BOLD, 15));
		pdDisA.setBounds(155, 19, 60, 20);
		highLowPanel.add(pdDisA);
		
		pdDisB = new JTextField("0");
		pdDisB.setFont(new Font("Tahoma", Font.BOLD, 15));
		pdDisB.setBounds(155, 54, 60, 20);
		highLowPanel.add(pdDisB);
		
		pdDisC = new JTextField("0");
		pdDisC.setFont(new Font("Tahoma", Font.BOLD, 15));
		pdDisC.setBounds(155, 89, 60, 20);
		highLowPanel.add(pdDisC);
		
		pdDisD = new JTextField("0");
		pdDisD.setFont(new Font("Tahoma", Font.BOLD, 15));
		pdDisD.setBounds(155, 124, 60, 20);
		highLowPanel.add(pdDisD);
		
		pdDisE = new JTextField("0");
		pdDisE.setFont(new Font("Tahoma", Font.BOLD, 15));
		pdDisE.setBounds(155, 159, 60, 20);
		highLowPanel.add(pdDisE);
		
		
		//Panel for View Letter Grades
		JPanel gradePanel = new JPanel();
		gradePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
		"Letter Grades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		gradePanel.setBounds(250, 80, 234, 225);
		panelMain.add(gradePanel);
		gradePanel.setLayout(null);
		
		JLabel gradeA = new JLabel("A:");
		gradeA.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeA.setBounds(new Rectangle(65, 15, 35, 35));
		gradePanel.add(gradeA);
		
		JLabel gradeB = new JLabel("B:");
		gradeB.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeB.setBounds(new Rectangle(10, 21, 27, 14));
		gradeB.setBounds(65, 50, 35, 35);
		gradePanel.add(gradeB);
		
		JLabel gradeC = new JLabel("C:");
		gradeC.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeC.setBounds(new Rectangle(10, 21, 27, 14));
		gradeC.setBounds(65, 85, 35, 35);
		gradePanel.add(gradeC);
		
		JLabel gradeD = new JLabel("D:");
		gradeD.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeD.setBounds(new Rectangle(10, 21, 27, 14));
		gradeD.setBounds(65, 120, 35, 35);
		gradePanel.add(gradeD);
		
		JLabel gradeE = new JLabel("E:");
		gradeE.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradeE.setBounds(new Rectangle(10, 21, 27, 14));
		gradeE.setBounds(65, 155, 35, 35);
		gradePanel.add(gradeE);
		
		JTextField gradeValueA = new JTextField("0");
		gradeValueA.setFont(new Font("Tahoma", Font.BOLD, 15));
		gradeValueA.setBounds(155, 23, 30, 20);
		gradePanel.add(gradeValueA);
		
		JTextField gradeValueB = new JTextField("0");
		gradeValueB.setFont(new Font("Tahoma", Font.BOLD, 15));
		gradeValueB.setBounds(155, 58, 30, 20);
		gradePanel.add(gradeValueB);
		
		JTextField gradeValueC = new JTextField("0");
		gradeValueC.setFont(new Font("Tahoma", Font.BOLD, 15));
		gradeValueC.setBounds(155, 93, 30, 20);
		gradePanel.add(gradeValueC);
		
		JTextField gradeValueD = new JTextField("0");
		gradeValueD.setFont(new Font("Tahoma", Font.BOLD, 15));
		gradeValueD.setBounds(155, 128, 30, 20);
		gradePanel.add(gradeValueD);
		
		JTextField gradeValueE = new JTextField("0");
		gradeValueE.setFont(new Font("Tahoma", Font.BOLD, 15));
		gradeValueE.setBounds(155, 163, 30, 20);
		gradePanel.add(gradeValueE);
		
		
		//Panel for Normal Percentile Dis
		JPanel percentilePanel = new JPanel();
		percentilePanel.setBorder(new TitledBorder(null, "Percentile Distrbutions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		percentilePanel.setBounds(250, 80, 234, 225);
		panelMain.add(percentilePanel);
		percentilePanel.setLayout(null);
		
		JLabel pgradeA = new JLabel("A:");
		pgradeA.setFont(new Font("Tahoma", Font.BOLD, 20));
		pgradeA.setBounds(new Rectangle(65, 15, 21, 25));
		percentilePanel.add(pgradeA);
		
		JLabel pgradeB = new JLabel("B:");
		pgradeB.setFont(new Font("Tahoma", Font.BOLD, 20));
		pgradeB.setBounds(new Rectangle(65, 50, 21, 25));
		percentilePanel.add(pgradeB);
		
		JLabel pgradeC = new JLabel("C:");
		pgradeC.setFont(new Font("Tahoma", Font.BOLD, 20));
		pgradeC.setBounds(new Rectangle(65, 85, 20, 25));
		percentilePanel.add(pgradeC);
		
		JLabel pgradeD = new JLabel("D:");
		pgradeD.setFont(new Font("Tahoma", Font.BOLD, 20));
		pgradeD.setBounds(new Rectangle(65, 120, 22, 25));
		percentilePanel.add(pgradeD);
		
		JLabel pgradeE = new JLabel("E:");
		pgradeE.setFont(new Font("Tahoma", Font.BOLD, 20));
		pgradeE.setBounds(new Rectangle(65, 155, 19, 25));
		percentilePanel.add(pgradeE);
		
		perDisA = new JTextField("0");
		perDisA.setFont(new Font("Tahoma", Font.BOLD, 15));
		perDisA.setBounds(155, 19, 30, 20);
		percentilePanel.add(perDisA);
		
		perDisB = new JTextField("0");
		perDisB.setFont(new Font("Tahoma", Font.BOLD, 15));
		perDisB.setBounds(155, 54, 30, 20);
		percentilePanel.add(perDisB);
		
		perDisC = new JTextField("0");
		perDisC.setFont(new Font("Tahoma", Font.BOLD, 15));
		perDisC.setBounds(155, 89, 30, 20);
		percentilePanel.add(perDisC);
		
		perDisD = new JTextField("0");
		perDisD.setFont(new Font("Tahoma", Font.BOLD, 15));
		perDisD.setBounds(155, 124, 30, 20);
		percentilePanel.add(perDisD);
		
		perDisE = new JTextField("0");
		perDisE.setFont(new Font("Tahoma", Font.BOLD, 15));
		perDisE.setBounds(155, 159, 30, 20);
		percentilePanel.add(perDisE);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(20, 10, 150, 340);
		panelMain.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		
		
		
		//basic screen
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 150, 25);
		buttonPanel.add(btnHome);
		JButton btnNewButton_3 = new JButton("Add a Grade");
		btnNewButton_3.setBounds(0, 35, 150, 25);
		buttonPanel.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("Remove a Grade");
		btnNewButton_4.setBounds(0, 70, 150, 25);
		buttonPanel.add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton("Change a Grade");
		btnNewButton_5.setBounds(0, 105, 150, 25);
		buttonPanel.add(btnNewButton_5);
		JButton btnViewAnalytics = new JButton("View Analytics");
		btnViewAnalytics.setBounds(0, 140, 150, 25);
		buttonPanel.add(btnViewAnalytics);
		JButton btnViewLetterGrades = new JButton("View Letter Grades");
		btnViewLetterGrades.setBounds(0, 175, 150, 25);
		buttonPanel.add(btnViewLetterGrades);
		JButton btnNewButton = new JButton("Percentile");
		btnNewButton.setBounds(0, 210, 150, 25);
		buttonPanel.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Percentage");
		btnNewButton_1.setBounds(0, 245, 150, 25);
		buttonPanel.add(btnNewButton_1);
		JButton btnSummary = new JButton("Display Summary");
		btnSummary.setBounds(0, 280, 150, 25);
		buttonPanel.add(btnSummary);
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(0, 315, 150, 25);
		buttonPanel.add(btnExit);
		
		
		
		//Functionality for 'Exit' button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(btnExit, "Are You Sure?");
				
				if (confirmed == JOptionPane.YES_OPTION) {
				System.exit(0);
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Analysis screen
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		
		//ActionLISTENERS START HERE
		
		//Add/remove/change buttons
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textField.setText("");
				
				frmMain.setVisible(false);
				frmAdd.setVisible(true);
			}
		});
		
		JPanel analysisPanel = new JPanel();
		analysisPanel.setBounds(250, 80, 235, 225);
		panelMain.add(analysisPanel);
		analysisPanel.setLayout(null);
		
		analysisPanel.setVisible(false);
		
		
		//More on the analytics screen
		JLabel highPPossString = new JLabel("Highest Points Possible:");
		highPPossString.setBounds(0, 0, 200, 25);
		analysisPanel.add(highPPossString);
		JLabel lowPPossString = new JLabel("Lowest Points Possible:");
		lowPPossString.setBounds(0, 40, 200, 25);
		analysisPanel.add(lowPPossString);
		JLabel highEarnedString = new JLabel("Highest Points Earned:");
		highEarnedString.setBounds(0, 80, 200, 25);
		analysisPanel.add(highEarnedString);
		JLabel lowEarnedString = new JLabel("Lowest Points Earned:");
		lowEarnedString.setBounds(0, 120, 200, 25);
		analysisPanel.add(lowEarnedString);
		JLabel averageString = new JLabel("Average Value:");
		averageString.setBounds(0, 160, 200, 25);
		analysisPanel.add(averageString);
		JLabel medianString = new JLabel("Median Value:");
		medianString.setBounds(0, 200, 200, 25);
		analysisPanel.add(medianString);
		highPPoss.setBounds(175, 0, 60, 25);
		analysisPanel.add(highPPoss);
		
		//JTEXT are global variables (above) in order to change
    	highPPoss.setEditable(false);
    	lowPPoss.setBounds(175, 40, 60, 25);
    	analysisPanel.add(lowPPoss);
    	lowPPoss.setEditable(false);
    	highEarned.setBounds(175, 80, 60, 25);
    	analysisPanel.add(highEarned);
    	highEarned.setEditable(false);
    	lowEarned.setBounds(175, 120, 60, 25);
    	analysisPanel.add(lowEarned);
    	lowEarned.setEditable(false);
    	average.setBounds(175, 160, 60, 25);
    	analysisPanel.add(average);
    	average.setEditable(false);
    	median.setBounds(175, 200, 60, 25);
    	analysisPanel.add(median);
    	median.setEditable(false);
		
		lblNewLabel.setBounds(300, 10, 150, 50);
		panelMain.add(lblNewLabel);
		
		
		
		


		
		
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
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(panel, "You Must Input A Value!", "Error", JOptionPane.ERROR_MESSAGE);
				}
					
				else {
				float tempToAdd = Float.parseFloat(textField.getText());
				
				list.add(tempToAdd);
				gaFile.setList(list);
				System.out.println(list);
				
				frmMain.setVisible(true);
				frmAdd.setVisible(false);	
				}
			}
			
	});
		
		btnSubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (list2.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(panel, "You Must Select A Value!", "Error", JOptionPane.ERROR_MESSAGE);
			}
				else {
				float tempToDel = list2.getSelectedValue();
				gaFile.deleteGrade(tempToDel);
				list = gaFile.getList();
				System.out.println(list);
				
				frmMain.setVisible(true);
				frmRemove.setVisible(false);
		
			}
		}
	});
		
		btnSubmit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			if (newValField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "You Must Input A Value!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if (list3.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(panel, "You Must Select A Value!", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
			else {
				float tempToAdd = Float.parseFloat(newValField.getText());
				float tempToDel = list3.getSelectedValue();
				
				gaFile.replaceGrade(tempToDel, tempToAdd);
				list = gaFile.getList();
				System.out.println(list);
				
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
		
		
		
		
	}
}