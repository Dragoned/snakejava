package snake;

import java.util.ArrayList;
import java.util.Random;

public class gamelogic extends Thread{
    ArrayList<ArrayList<color>> data=Window.Grid;
    Random rand=new Random();
    int grid = 20,speed=100;
    boolean ft=true;
    static int hed=0 , teil=2 , direction;
    ArrayList <position> snake = new ArrayList<position>();
    boolean ed=false;
    position aple = new position(rand.nextInt(20),rand.nextInt(20));
    
    public gamelogic(){
        snake.add(new position(0,2));
        snake.add(new position(0,1));
        snake.add(new position(0,0));
        System.out.println(snake.size());
    }

    public void logic(){
        while (true) {
            move();
            colision();
            drow();
            pause();
        }
    }

    public void colision(){
        System.out.println("controllo colisioni");
        if (snake.get(hed).getX()>grid-1||snake.get(hed).getX()<0||snake.get(hed).getY()>grid-1||snake.get(hed).getY()<0) {
            endGame();
        }
        for(int i = 1;i<snake.size();i++){
            if (snake.get(hed).getX()==snake.get(i).getX()&&snake.get(hed).getY()==snake.get(i).getY()) {
                endGame();
            }
        }
        if (snake.get(hed).getX()==aple.getX()&&snake.get(hed).getY()==aple.getY()) {
            eat();            
        }
    }

    public void eat(){
        System.out.println("mangia");
        if (snake.get(hed).getX()==aple.getX()&&snake.get(hed).getY()==aple.getY()) {
            int dirx = snake.get(teil-1).getX()-snake.get(teil).getX(),diry = snake.get(teil-1).getY()-snake.get(teil).getY();
            if (dirx>0) {
                snake.add(new position(snake.get(teil).getX()-1, snake.get(teil).getY()));
            }
            else if (dirx<0) {
                snake.add(new position(snake.get(teil).getX()+1, snake.get(teil).getY()));
            }
            else if (diry>0) {
                snake.add(new position(snake.get(teil).getX(), snake.get(teil).getY()+1));
            }
            else if (diry<0) {
                snake.add(new position(snake.get(teil).getX(), snake.get(teil).getY()-1));
            }
        }
        teil++;
        foodspwn();
    }

    public void drow() {
        System.out.println("disegnia");
        data.get(aple.getX()).get(aple.getY()).lightMeUp(1);
        for(int i = 0;i<snake.size();i++){
            data.get(snake.get(i).getX()).get(snake.get(i).getY()).lightMeUp(0);
        }
    }
    
    public void removetail() {
        System.out.println("rimuovi coda");
        data.get(snake.get(teil).getX()).get(snake.get(teil).getY()).lightMeUp(2);;
    }

    public void move() {
        System.out.println("muovi");
        switch (direction) {
            case 3:     //up
                removetail();
                for(int i=snake.size()-1;i>0;i--){
                    snake.get(i).sposition(snake.get(i-1).getX(),snake.get(i-1).getY());
                }
                snake.get(0).setX(snake.get(0).getX()-1);
                break;
            case 4:     //dw
                removetail();
                for(int i=snake.size()-1;i>0;i--){
                    snake.get(i).sposition(snake.get(i-1).getX(),snake.get(i-1).getY());
                }
                snake.get(0).setX(snake.get(0).getX()+1);
                break;
            case 2:     //left
                removetail();
                for(int i=snake.size()-1;i>0;i--){
                    snake.get(i).sposition(snake.get(i-1).getX(),snake.get(i-1).getY());
                }
                snake.get(0).setY(snake.get(0).getY()-1);
                break;
            case 1:     //raigt
                removetail();
                for(int i=snake.size()-1;i>0;i--){
                    snake.get(i).sposition(snake.get(i-1).getX(),snake.get(i-1).getY());
                }
                snake.get(0).setY(snake.get(0).getY()+1);
                break;
            default:
                break;
        }
    }

    public void foodspwn() {
        System.out.println("spawna cibbo");
        int nx,ny;
        boolean b=true;
        do {
            System.out.println("genero posizione");
            nx = rand.nextInt(20);
            ny = rand.nextInt(20);
            for(int i=0;i<snake.size();i++){
                System.out.println("conrtollo posizione");
                if (nx==snake.get(i).getX()&&ny==snake.get(i).getY()) {
                    b=true;
                    System.out.println("posizione ocupata");
                    break;    
                } else {
                    b=false;
                }
            }
        } while (b==true);
        aple.sposition(nx, ny);       
    }

    public void endGame() {
        System.out.println("end game");
        while (true) {
            pause();
        }
    }

    public void pause(){
        try {
            sleep(speed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}