package mountain;

import java.util.*;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
    private Point a,b,c;
    double dev;
    Map<Side,Point> map;

public Mountain(Point a, Point b, Point c, double dev){
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.dev = dev;
        map = new HashMap<>();
}

@Override
public String getTitle() {
    return "Mountain";
}

@Override
	public void draw(TurtleGraphics turtle) {
        fractalTriangel(turtle, order, a,b,c, dev);
        
    }

private void fractalTriangel(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev){
    if(order == 0){
        turtle.moveTo(a.getX(), a.getY());
        turtle.penDown();
        turtle.forwardTo(b.getX(), b.getY());
        turtle.forwardTo(c.getX(), c.getY());
        turtle.forwardTo(a.getX(), a.getY());
        
    }else{
        // int slump = (int) RandomUtilities.randFunc(dev);
        // int slump1 = (int) RandomUtilities.randFunc(dev);
        // int slump2 = (int) RandomUtilities.randFunc(dev);
        

        //Sne mountain
        Point ab = middlePoint(a, b,dev);  //new Point((a.getX()+b.getX())/2, (a.getY()+b.getY())/2 + slump);
        Point bc = middlePoint(b, c,dev); //new Point((b.getX()+c.getX())/2, (b.getY()+c.getY())/2 + slump1);
        Point ca = middlePoint(c, a,dev); //new Point((a.getX()+c.getX())/2, (a.getY()+c.getY())/2 + slump2);

                    //Rak mountain
                    // Point ab = new Point((a.getX()+b.getX())/2, (a.getY()+b.getY())/2);
                    // Point bc = new Point((b.getX()+c.getX())/2, (b.getY()+c.getY())/2);
                    // Point ca = new Point((a.getX()+c.getX())/2, (a.getY()+c.getY())/2);
        
        //dev /=2;
        //Top
        fractalTriangel(turtle, order-1, ab, b, bc,dev/2);
        //Middle
        fractalTriangel(turtle, order-1, ab, bc, ca,dev/2);
        //BottomLEFT
        fractalTriangel(turtle, order-1, a, ab, ca,dev/2);
        //BottomRIGHT
        fractalTriangel(turtle, order-1, ca, bc, c,dev/2);
        
        
    }
}

public Point middlePoint(Point p1, Point p2, double dev){
    Side endPoints = new Side(p1,p2);
    
    if(map.containsKey(endPoints)){
        Point temp = map.get(endPoints);    //spara undan nyckel-värde paret för att returna det
            map.remove(endPoints);          //remove nyckelvärdeparet för används inte fler gånger

            return temp;
    }else{
        int slump = (int) RandomUtilities.randFunc(dev);
        Point temp = new Point((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2 + slump);
        map.put(new Side(p1, p2), temp);
        return temp;
    }
}

}
