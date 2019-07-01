package snake;

import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;


class Window extends JFrame{
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<color>> Grid;
	public static int width = 20;
	public static int height = 20;
	public Window(){
		
		
		Grid = new ArrayList<ArrayList<color>>();
		ArrayList<color> data;
		
		for(int i=0;i<width;i++){
			data= new ArrayList<color>();
			for(int j=0;j<height;j++){
				color c = new color(2);
				data.add(c);
			}
			Grid.add(data);
		}
		
		getContentPane().setLayout(new GridLayout(20,20,0,0));
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				getContentPane().add(Grid.get(i).get(j).gComp);
			}
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		this.addKeyListener((KeyListener) new KeyboardListener());
		this.setTitle("Snake");
		this.setBounds(500, 500, 500, 500);
		this.setVisible(true);
		gamelogic g=new gamelogic();
		g.logic();
	}
}