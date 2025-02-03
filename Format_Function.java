package com.simplenotebook;
public class Format_Function {
	GUI gui ;
	Format_Function(GUI gui )
	{
		this.gui = gui;
	}
	public void wordWrap()
	{
		if(gui.wrapOn==false)
		{
			gui.wrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.fWrap.setText("Word Wrap : On");
		}
		else
		{
			gui.wrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
		}
	}

}
