import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UVa558 {

	private static final String NOTPOSSIBLE = "not possible";
	private static final String POSSIBLE = "possible";
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int wormholecount,src,dest,len;
		int cases = in.nextInt();
		boolean hasNegative;
		Node[] systems;
		while(cases--> 0){
			// set up graph from input
			systems = new Node[in.nextInt()];
			wormholecount = in.nextInt();
			hasNegative = false;
			
			while(wormholecount--> 0){
				src  = in.nextInt();
				dest = in.nextInt();
				len  = in.nextInt();
				
				if(len < 0){
					hasNegative = true;
				}
				if(systems[src] == null){
					systems[src] = new Node(src);
				}
				
				if(systems[dest] == null){
					systems[dest] = new Node(dest);
				}
				
				Link lnk = new Link(systems[dest],len);
				systems[src].addLink(lnk);
				
			}
			
			if(!hasNegative){
				System.out.println(NOTPOSSIBLE);
				continue;
			}
			//initialize first variable
			systems[0].setDistance(0);
			
			//Bellman-Ford it up
			for(Node u: systems){
				for(Link l: u.getLinks()){
				Node v = l.getDest();
				if(u.getDistance() + l.getLength() < v.getDistance())
					v.setDistance(u.getDistance() + l.getLength());
				}
			}
			
			//check for negative cycles
			boolean hasNegativeCycle = false;
			for(Node u: systems){
				for(Link l: u.getLinks()){
					if(u.getDistance() + l.getLength() < l.getDest().getDistance()){
						hasNegativeCycle = true;
						break;
					}
				}
			}
			
			if(hasNegativeCycle)
				System.out.println(POSSIBLE);
			else
				System.out.println(NOTPOSSIBLE);
		}
	}
	
	
}

class Node{
	List<Link> links;
	int distance;
	public Node(int num){
		links = new ArrayList<Link>();
		distance = Integer.MAX_VALUE;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public void setDistance(int distance){
		this.distance = distance;
	}
	public void addLink(Link link){
		links.add(link);
	}
	
	public List<Link> getLinks(){
		return links;
	}
}

class Link{
	private Node dest;
	private int length;
	
	public Link(Node dest, int length){
		this.dest = dest;
		this.length = length;
	}
	
	public Node getDest(){
		return dest;
	}
	
	public int getLength(){
		return length;
	}
}


