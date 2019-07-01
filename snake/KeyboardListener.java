package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter{
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case 39:	// -> Right 
                //if it's not the opposite direction
                if(gamelogic.direction!=2){
                    gamelogic.direction=1;
                    System.out.println("right");
                } 

                break;
            case 38:	// -> Top
                if(gamelogic.direction!=4) {
                    gamelogic.direction=3;
                    System.out.println("up");
                }
                break;
                
            case 37: 	// -> Left 
                if(gamelogic.direction!=1){
                    gamelogic.direction=2;
                    System.out.println("left");
                }
                break;
                        
            case 40:	// -> Bottom
                if(gamelogic.direction!=3){
                    gamelogic.direction=4;
                    System.out.println("dw");
                }
                break;

            default: 	break;
        }
    }
}