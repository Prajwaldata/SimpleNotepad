package com.simplenotebook;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.JMenu;
public class GUI implements ActionListener {
//	Basic Frame Object
    JFrame frame; //null Value currently
    // Text Area Objects
    
    JTextArea textArea;
    JScrollPane scrollPane;  //To get the scroll bar vertical vs horizontal
   //Top Menu Bar 
    JMenuBar menuBar;
    JMenu file, color, edit, format;
    private Function_edit tedit = new Function_edit(this);
    
//    File Option Objects
    JMenuItem fNew,fSave, fSaveAs, fExit, fOpen;
//    Format Option
    JMenuItem fWrap, fArial, fSans , fTimes, f8,f10,f12,f15,f18,f20,f24,f28,f30,f32;
    JMenu fFont,fFontSize;
    int fontSize = 18;
    String font="Arial";
    boolean wrapOn = false;
//    JMenu is used when the object has multiple options.
//    JMenuItem is for the Options in the Menu
    Function_File f = new Function_File(this) ;
    Format_Function ff = new Format_Function(this);
    SetColor sc = new SetColor(this);
    JMenuItem white,black,blue;
    
    //Here we are adding the JMenuIteam for the edit option on the Note pad
    JMenuItem reDo,unDo;
    UndoManager um = new UndoManager();;	//this is Important to undo and redo as It is contains method for it

    public GUI() {
        // Constructor can be used for initialization if needed
    }

    public void createFrame() {
        frame = new JFrame("NoteBook");
        frame.setBounds(20, 20, 800, 600);
        
       
        createTextArea();
        
        creatingMenuBar();
        editingText();
        textArea.setFont(new Font(font, Font.PLAIN,fontSize));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea()
    {
    	 textArea = new JTextArea();
    	 textArea.getDocument().addUndoableEditListener(	
    			 new UndoableEditListener() {  //UndoableEditListner is an interface thus when we are using it we need to add the abstract method
    				 public void undoableEditHappened(UndoableEditEvent e)	// It contains that is undoableEditHappened
    				 {
    					 um.addEdit(e.getEdit());
    				 }
    			 }
     		);     	// addUndoableEditListener Bracket Closing
    	 
    	 scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scrollPane.setBorder(BorderFactory.createEmptyBorder());
         frame.add(scrollPane);
    }
    public void creatingMenuBar()
    {
    	menuBar = new JMenuBar();
    	frame.setJMenuBar(menuBar);
    	creatingMenu();
    	creatingFormat();
    	settingColor();
    	
    }
    public void creatingMenu()
    {
    	file = new JMenu("File");
    	menuBar.add(file);
    	edit = new JMenu("Edit");
    	menuBar.add(edit);	
    	format = new JMenu("Format");
    	menuBar.add(format);
    	creatingFileMenu();
    	color = new JMenu("Color");
    	menuBar.add(color);

    }
    public void editingText()
    {
    	unDo = new JMenuItem("Undo");
    	unDo.addActionListener(this);
    	unDo.setActionCommand("undo");
    	edit.add(unDo);
    	
    	reDo = new JMenuItem("Redo");
    	reDo.addActionListener(this);
    	reDo.setActionCommand("redo");
    	edit.add(reDo);
    }
    public void creatingFileMenu()
    {  	
    	fOpen = new JMenuItem("Open");
    	fOpen.addActionListener(this);
    	fOpen.setActionCommand("Open");
    	file.add(fOpen);
    	
    	fNew = new JMenuItem("New");
    	fNew.addActionListener(this);
    	fNew.setActionCommand("New");
    	file.add(fNew);
    	
    	
    	fSave  = new JMenuItem("Save");
    	fSave.addActionListener(this);
    	fSave.setActionCommand("Save");
    	file.add(fSave);
    	
    	fSaveAs = new JMenuItem("Save As");
    	fSaveAs.addActionListener(this);
    	fSaveAs.setActionCommand("SaveAs");
    	file.add(fSaveAs);
    	
    	fExit= new JMenuItem("Exit");
    	fExit.addActionListener(this);
    	fExit.setActionCommand("Exit");
    	file.add(fExit);
    }
    public void creatingFormat()
    {
    	fWrap = new JMenuItem("Word Wrap : Off");
    	fWrap.addActionListener(this);
    	fWrap.setActionCommand("WrapOff");
    	format.add(fWrap);
    	
    	fFont = new JMenu("Font: ");
    	format.add(fFont);
    			
    	fArial = new JMenuItem("Arial");
    	fArial.addActionListener(this);
    	fArial.setActionCommand("Arial");
    	fFont.add(fArial);
    	
    	fTimes = new JMenuItem("Times New Roman");
    	fTimes.addActionListener(this);
    	fTimes.setActionCommand("Times New Roman");
    	fFont.add(fTimes);
    	
    	fSans = new JMenuItem("Comic Sans MS");
    	fSans.addActionListener(this);
    	fSans.setActionCommand("Comic Sans MS");
    	fFont.add(fSans);
//    	, fSans , fCasual
    	
    	fFontSize = new JMenu("FontSize: ");
    	format.add(fFontSize);
    	
    	f8 = new JMenuItem("8");
    	f8.addActionListener(this);
    	f8.setActionCommand("8");
    	fFontSize.add(f8);
    	f10 = new JMenuItem("10");
    	f10.addActionListener(this);
    	f10.setActionCommand("10");
    	fFontSize.add(f10);
    	f12 = new JMenuItem("12");
    	f12.addActionListener(this);
    	f12.setActionCommand("12");
    	fFontSize.add(f12);
    	f15 = new JMenuItem("15");
    	f15.addActionListener(this);
    	f15.setActionCommand("15");
    	fFontSize.add(f15);
    	f18 = new JMenuItem("18");
    	f18.addActionListener(this);
    	f18.setActionCommand("18");
    	fFontSize.add(f18);
    	f20 = new JMenuItem("20");
    	f20.addActionListener(this);
    	f20.setActionCommand("20");
    	fFontSize.add(f20);
    	f24 = new JMenuItem("24");
    	f24.addActionListener(this);
    	f24.setActionCommand("24");
    	fFontSize.add(f24);
    	f28 = new JMenuItem("28");
    	f28.addActionListener(this);
    	f28.setActionCommand("28");
    	fFontSize.add(f28);
    	f32 = new JMenuItem("32");
    	f32.addActionListener(this);
    	f32.setActionCommand("32");
    	fFontSize.add(f32);
    }
    
    public void settingColor()
    {
    	
    	white = new JMenuItem("White");
    	white.addActionListener(this);
    	color.setActionCommand("White");
    	color.add(white);
    	black = new JMenuItem("Black");
    	black.addActionListener(this);
    	color.setActionCommand("Black");
    	color.add(black);
    	blue = new JMenuItem("Blue");
    	blue.addActionListener(this);
    	color.setActionCommand("Blue");
    	color.add(blue);
    }
    

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createFrame();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command)
		{
		case "New"	: 
					f.newFile();break;
		case "Save" : 
					f.save();
					break;
		case "Open" : f.open();break;
		case "SaveAs":
					f.saveAs();
					break;
		case "Exit" : 
					f.exitCommand();
					break;
		case "WrapOff":
	    	ff.wordWrap();
	    	break;
		case "Arial":
			font = "Arial";
			textArea.setFont(new Font(font, Font.PLAIN,fontSize));
			break;
		case "Comic Sans MS":
			font = "Comic Sans MS";
			textArea.setFont(new Font(font, Font.PLAIN,fontSize));break;
		case "Times New Roman":
			font = "Times New Roman";
			textArea.setFont(new Font(font, Font.PLAIN,fontSize));
			break;
		case "Blue":sc.setColor(command);break;
			
		case "Black":sc.setColor(command);break;
		case "White":sc.setColor(command);break;
		case "undo":	tedit.unDo();	break;
		case "redo": 	tedit.reDo();	break;
		default :
			try
			{
				fontSize=Integer.parseInt(command);
				textArea.setFont(new Font(font, Font.PLAIN,fontSize));
			}
			catch(Exception e1)
			{
				System.out.println("don't Select inappropriate Option");
			}
			break;
		}
		
		
	}
}
