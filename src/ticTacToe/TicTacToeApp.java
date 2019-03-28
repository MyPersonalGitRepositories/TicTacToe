package ticTacToe;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import acm.program.GraphicsProgram;

public class TicTacToeApp extends GraphicsProgram {
	
	private TicTacToeGame tttg;
	
	public void init() {
		this.setSize(720, 720);
		this.tttg = new TicTacToeGame(this.getGCanvas());
		add(new JButton("New Game"), SOUTH);
		addActionListeners();
	}
	
	public void run() {
		this.tttg.newGame();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.getGCanvas().removeAll();
		this.tttg.newGame();
	}
}
