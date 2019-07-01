package snake;

public class position {
    
    public int x,y;
    
    public position(int nx,int ny){
        this.x=nx;
        this.y=ny;
    }

    public void sposition(int nx,int ny){
        x=nx;
        y=ny;
    }

    public void setX(int nx){
        x=nx;
    }
    
    public void setY(int ny){
        y=ny;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}