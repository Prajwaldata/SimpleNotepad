package com.simplenotebook;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	GUI gui;
	String fileName;
	String fileAddress;
	public Function_File(GUI gui)
	{
		this. gui = gui;
	}
	public void newFile() 
	{
		fileName = null;
		fileAddress = null;
		gui.textArea.setText("");
		gui.frame.setTitle("New File");
		
	}
//	From here we are writing the code for the Open Command
	public void open()
	{
		FileDialog fd = new FileDialog(gui.frame, "Select The File", FileDialog.LOAD);
		fd.setVisible(true);
//		However with the Only open command we will not able to load the File thus following code
		if(fd.getFile() != null)
		{
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.frame.setTitle(fileName);
		}
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
			System.out.println("File Name and File Address" +fileAddress + fileName);
			gui.textArea.setText("");
			String line=null;
			while((line = br.readLine()) != null)
			{
				gui.textArea.append(line +"\n");
			}
			br.close();
		}
		catch(Exception e)
		{
			System.out.println("The file Not Found");
		}
	}

//	This is the Method for Saving the File
	public void save()
	{
		if(fileName == null)
		{
			saveAs();
		}
		else {
			try
			{
				FileWriter fw = new FileWriter(fileAddress+fileName);
				fw.write(gui.textArea.getText());
				fw.close();
			}
			catch(Exception e)
			{
				System.out.println("SOmething Went Disarray");
			}
			
		}
	}
	public void saveAs()
	{
		FileDialog fd = new FileDialog(gui.frame, "Save",FileDialog.SAVE);
		fd.setVisible(true);
		if(fd.getFile()!= null)
		{
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			gui.frame.setTitle(fileName);
		}
		try
		{
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(gui.textArea.getText());
			fw.close();
		}
		catch(Exception e )
		{
			System.out.println("Something Went Wrong");
		}
	}
	public void exitCommand()
	{
		System.exit(0);
	}
}
