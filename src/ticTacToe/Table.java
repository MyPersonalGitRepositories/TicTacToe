package ticTacToe;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import acm.graphics.GCanvas;
import acm.graphics.GFillable;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

public class Table extends GRect implements MouseListener {
	
	private GFillable myObject;
	
	private static boolean shouldDrawCross = true;	
	private boolean isFree;
	private int my_i, my_j;	
	
	private TicTacToeGame game;
	private GCanvas canvas;

	public Table(double x, double y, double width, double height, int i, int j) {
		super(x, y, width, height);		
		this.setColor(Color.magenta);
		this.setVisible(false);
		isFree = true;
		my_i = i;
		my_j = j;
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (isFree && !game.isFinished()) {
			if (shouldDrawCross) {
				drawCross();
				game.changeBoardState(my_i, my_j, 1);
			} else {
				drawNaught();
				game.changeBoardState(my_i, my_j, 2);
			}
			isFree = false;
			shouldDrawCross = !shouldDrawCross;
			this.setColor(Color.RED);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setVisible(true);		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setVisible(false);		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {		
	}
	
	public void setGame(TicTacToeGame game) {
		this.game = game;
	}
	
	public void setCanvas(GCanvas canvas) {
		this.canvas = canvas;
	}
	
	public GFillable getMyObject() {
		return myObject;
	}
	
	private void drawCross() {
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		
		GPolygon cross = new GPolygon();		
		cross.addVertex(x + width/4, y);
		cross.addVertex(x + width/2, y + height/4);
		cross.addVertex(x + 3*width/4, y);
		cross.addVertex(x + width, y + height/4);
		cross.addVertex(x + 3*width/4, y + height/2);
		cross.addVertex(x + width, y + 3*height/4);
		cross.addVertex(x + 3*width/4, y + height);
		cross.addVertex(x + width/2, y + 3*height/4);
		cross.addVertex(x + width/4, y + height);
		cross.addVertex(x, y + 3*height/4);
		cross.addVertex(x + width/4, y + height/2);
		cross.addVertex(x, y + height/4);
		cross.setFilled(true);
		cross.setFillColor(Color.BLUE);
		canvas.add(cross);
		
		myObject = cross;
	}
	
	private void drawNaught() {
		int x = (int) this.getX();
		int y = (int) this.getY();
		int width = (int) this.getWidth();
		int height = (int) this.getHeight();
		
		GOval outerCircle = new GOval(x, y, width, height);
		outerCircle.setFilled(true);
		outerCircle.setFillColor(Color.YELLOW);
		
		GOval innerCircle = new GOval(x + width/4, y + width/4, width/2, height/2);
		innerCircle.setFilled(true);
		innerCircle.setFillColor(Color.WHITE);
		
		canvas.add(outerCircle);
		canvas.add(innerCircle);
		
		myObject = outerCircle;
	}
}