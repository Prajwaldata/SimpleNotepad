package com.simplenotebook;

public class Function_edit {
	GUI gui;
	
	public Function_edit(GUI gui) {
		this.gui= gui;
	}
	public void unDo(){
		gui.um.undo();
	}
	public void reDo() {
		gui.um.redo();
	}
}
