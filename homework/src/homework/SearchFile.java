package homework;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchFile extends JFrame implements ActionListener{
	
    JFrame frame;
	JTextField textfield, addfile;
	JPanel panel;
	JButton button,button1,button2,delete;
	JLabel label;
	JMenuBar menubar;
	JMenu backmenu;
	JMenuItem back;
	JTextArea displayarea,textarea;
	JScrollPane scrollpane;
	String SearchedWord;
	File folder = new File("Songs");
    File[] files = folder.listFiles();
	
	
	
	SearchFile(){
		
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton("Search");
		button1 = new JButton("Show files");
		button2 = new JButton("New File");
		addfile = new JTextField();
		textfield = new JTextField();
		menubar = new JMenuBar();
		backmenu = new JMenu("Back");
		back = new JMenuItem("Back");
		label = new JLabel("Enter in terms to search: ");
		displayarea = new JTextArea(10,40);
		
		
		
		
		//making a new frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Search File");
		this.setSize(800,500);
		
		panel.add(label);
		this.add(panel);
		
		//setting a text area
		textfield.setPreferredSize(new Dimension(150,25));
		panel.add(textfield);
		this.add(panel);
		
		
		
		//adding button to the frame
		button.setSize(20,20);
		panel.add(button);
		this.add(panel);
		
		button1.setSize(20,20);
		panel.add(button1);
		this.add(panel);
		
		panel.add(displayarea);
		this.add(panel);
		
		button2.setSize(20,20);
		panel.add(button2);
		this.add(panel);
		
		
		addfile.setPreferredSize(new Dimension(150,25));
		panel.add(addfile);
		this.add(panel);
		
	
		
		
		
		//this is for the menu
		this.setJMenuBar(menubar);
		backmenu.add(back);
		menubar.add(backmenu);
	
		
		
		//adding action listener to any button the user presses
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		back.addActionListener(this);
		
				
		
		
	
		this.setVisible(true);
	

		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
	
		//this is for the file section
		if(e.getSource()== button) {
			
			
			//retrieving the word the user enters
			SearchedWord =textfield.getText();
			try {
				Fold();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			
		}
		
		
		//if the users presses show files
		if(e.getSource() ==button1) {
			
			File folder = new File("Songs");
	        File[] files = folder.listFiles();
	        
	        for (File file : files) {
	          
	        	displayarea.append(file.getName()+"\n");
	        }
	        
	        
			
		}
		
		
		
		//this is for the menu section
		
		if(e.getSource() == back) {
			
			
			
			//this allows users to go back to the front page
			new Menu();
		}
		
		
		
		//this is to add new files
		
		if(e.getSource()==button2) {
			

			String new_file = addfile.getText()+".txt";
			
			
			if (addfile.getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Create a new File!"
    					+ "", "Warning",JOptionPane.INFORMATION_MESSAGE);
                
            } 
			
			else {
				
				addFile(new_file);
				
			}
			
			
		}
		
		
		
	}
	
	
	
	
	void Fold() throws FileNotFoundException{
	
   

        for (File file : files) {
        	int found = 0;
        	
            if (file.isFile()) {
            	
            	Scanner scan = new Scanner(file);
           
        
            	//going through each line in each files
            	while (scan.hasNext()) {
            		
                    String nextWord = scan.next();
                    
                    if (nextWord.toLowerCase().contains(SearchedWord)) {
                    	
                        found++;
                        

                        
                        
                    }//end if loop
                    
            	}//end while loop
            	
            	
            	
            	displayarea.append(file.getName()+": "+found+"\n");
            	
            	
            	
            	//System.out.println(file.getName()+": "+found);
                
                
            }//end if loop
            
        }//end for loop
        
		
       		
	
	}
	
	
	
	
	
	
	//this adds files to the folder
	void addFile(String addfile) {
		
		
		
        File[] files = folder.listFiles();
        
        
        String folderPath = "Songs";
        String fileName = addfile;
        
        File folder = new File(folderPath);
        File file = new File(folder, fileName);
        
	
		
		try {
            boolean success = file.createNewFile();
            if (success) {
            	
            	
            	JOptionPane.showMessageDialog(null, "File created and added!"
    					+ "", "New File",JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
	}
	
	
	

}






