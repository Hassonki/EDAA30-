package mountain;

public class Side {
     Point p1;
     Point p2;

public Side(Point p1, Point p2){
    this.p1 = p1;
    this.p2 = p2;
    
 }

 @Override
 public boolean equals(Object obj) {
    if (obj instanceof Side) {
        Side side = (Side) obj;
        return ((p1.equals(side.p1) && p2.equals(side.p2)) || (p1.equals(side.p2) && p2.equals(side.p1)));
    } else {
        return false;
    }
 }

 @Override
        public int hashCode() {
            return p1.hashCode() + p2.hashCode();
        }
}
