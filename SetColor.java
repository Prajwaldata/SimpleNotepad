package com.simplenotebook;

import java.awt.Color;

public class SetColor {
	public GUI gui;
	public SetColor(GUI gui)
	{
		this.gui = gui;
	}
	public void setColor(String color)
	{
		switch(color)
		{
		case "Black": 
			gui.frame.setBackground(Color.black);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(Color.white);
			break;
		case "Blue":
			gui.frame.setBackground(Color.blue);
			gui.textArea.setBackground(Color.blue);
			gui.textArea.setForeground(Color.white);
			break;
		
		default :
			gui.frame.setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.black);
			break;
		
		}
		
	}

}
