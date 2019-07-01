package snake;

import java.util.ArrayList;
import java.awt.Color;

public class color{
    ArrayList<Color> C =new ArrayList<Color>();
	int color;
	GComp gComp;
	
	public color(int col){
		
		C.add(Color.BLACK);//serpente
		C.add(Color.RED);    //mela
		C.add(Color.white);   //sfondo
		color=col;
		gComp = new GComp(C.get(color));
	}

	public void lightMeUp(int c){
		gComp.CColor(C.get(c));
	}
}