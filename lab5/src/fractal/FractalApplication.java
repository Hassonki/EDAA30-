package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;
public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[1] = new Koch(300);

		fractals[0] = new Mountain(new Point(70,450), new Point(260,90), new Point(550,500), 50.0);
	    new FractalView(fractals, "Fraktaler", 600, 600);

		
	}
}
