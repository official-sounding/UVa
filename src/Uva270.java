import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Uva270 {

	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Scanner lr;
		int cases = in.nextInt();
		List<Point> points;
		List<Double> segments;
		
		in.nextLine();
		in.nextLine();
		while(cases--> 0){
			points = new ArrayList<Point>();
			segments = new ArrayList<Double>();
			boolean cont = true;
			while(cont){
				if(!in.hasNext()){
					cont = false;
					break;
				}
				String line = in.nextLine();
				if(line.equals("")){
					cont = false;
					break;
				}
				lr = new Scanner(line);
				lr.useDelimiter(" ");
				Point dest = new Point(lr.nextInt(), lr.nextInt());
				for(Point src: points){
					segments.add(Math.sqrt(Math.pow((dest.x - src.x),2) + Math.pow((dest.y - src.y),2)));
				}
				points.add(dest);
			}
			
			Collections.sort(segments);
			
			double prev = 0;
			int count = 1;
			int max = 0;
			for(Double s: segments){
				if(s == prev){
					count++;
				}else{
					max = count > max ? count : max;
					count = 1;
					prev = s;
				}
			}
			System.out.println(max);
			if(cases > 0)
				System.out.println();
		}
	}
}


class Point{
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int x;
	public int y;
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Point){
			Point p = (Point)o;
			return p.x == x && p.y == y;
		}
		return false;
	}
}
