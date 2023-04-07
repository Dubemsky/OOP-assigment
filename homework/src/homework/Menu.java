package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	
	JFrame frame;
	ImageIcon image;
	JLabel label;
	JPanel panel;
	JMenuBar menubar;
	JMenu aboutmenu, searchmenu, helpmenu,exitmenu;
	JMenuItem searchfile, about,help,exit;
	
	Menu(){
		
		frame = new JFrame();
		image = new ImageIcon(getClass().getResource("img1.png"));
		label = new JLabel(image);
	
		menubar = new JMenuBar();
		
		
		helpmenu = new JMenu("Help");
		searchmenu = new JMenu("Search");
		aboutmenu = new JMenu("About");
		exitmenu = new JMenu("Exit");
		
		
		
		
		
		searchfile = new JMenuItem("Search file");
		about = new JMenuItem("About");
		help = new JMenuItem("Help");
		exit = new JMenuItem("Exit");
		
		
	
	
		//This is for the home page background
		
		
		
		add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Windows");

		
		
		//This is for the menu section
		this.setJMenuBar(menubar);
		menubar.add(searchmenu);
		menubar.add(aboutmenu);
		menubar.add(helpmenu);
		menubar.add(exitmenu);
		
		searchmenu.add(searchfile);	
		aboutmenu.add(about);
		helpmenu.add(help);
		exitmenu.add(exit);
		
		searchfile.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		exit.addActionListener(this);
		
		this.pack();
		this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		//this is if user clicks on the search menu
		if(e.getSource()==searchfile) {
		
			new SearchFile();
		}
		
		
		
		//if user clicks on the help menu
		if(e.getSource()==about) {
			
			
			JOptionPane.showMessageDialog(null, "This is an application that allows users to "
					+ "find a specificfile search"
					+ "", "Search Engine",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		//if user clicks on the about menu
		if(e.getSource()==help) {
			
			
			JOptionPane.showMessageDialog(null, "Click on search to search for file", "Help",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
		
		//if user clicks on exit
		if(e.getSource() == exit) {
			
		int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(answer == 0) {
			
			System.exit(0);
		}
		
	
		
		}
	}
	

}