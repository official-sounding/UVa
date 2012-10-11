import java.util.*;


public class UVa706 {
	final static boolean[][] numberrepresentations =	{
		{true,true,true,false,true,true,true},
		{false,false,true,false,false,true,false},
		{true,false,true,true,true,false,true},
		{true,false,true,true,false,true,true},
		{false,true,true,true,false,true,false},
		{true,true,false,true,false,true,true},
		{true,true,false,true,true,true,true},
		{true,false,true,false,false,true,false},
		{true,true,true,true,true,true,true,true},
		{true,true,true,true,false,true,true}};

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int scalingfactor = in.nextInt();
			String numstring  = in.next();
			if(scalingfactor == 0 && numstring.equals("0")){
				continue;
			}else{
				printSevenSeg(numstring.toCharArray(),scalingfactor);
			}
		}
	}


	public static void test(){
		
		char[] teststring = new char[1000];
		Arrays.fill(teststring, '8');
		int scalingfactor = 99;

		printSevenSeg(teststring,scalingfactor);
	}

	public static void printSevenSeg(char[] str, int scalingfactor){
		boolean[][] segments = new boolean[str.length][7];
		
		char[] interiorcharr = new char[scalingfactor];
		char[] dashedline = new char[scalingfactor];
		Arrays.fill(interiorcharr, ' ');
		Arrays.fill(dashedline, '-');
		String blankline = new String(interiorcharr);
		String online = new String(dashedline);
		
		int index = 0;
		int width = (scalingfactor+2)*segments.length - 1;
		
		for(char c: str){
			segments[index] = numberrepresentations[Integer.parseInt(""+c)];
			index++;
		}
		StringBuilder sb = new StringBuilder(width);
		String element1,element2,line;
		
		//print first row (segment 0)
		for(int i = 0; i < segments.length; i++){
			sb.append(" ");
			line = segments[i][0] ? online : blankline;
			sb.append(line);
			sb.append(" ");
			if(i < segments.length-1){
				sb.append(" ");
			}else{
				System.out.println(sb);
			}
		}
		//print s rows (segment 1 and 2)
		sb = new StringBuilder(width);
		for(int i = 0; i < segments.length; i++){
			element1 = segments[i][1] ? "|" : " ";
			element2 = segments[i][2] ? "|" : " ";

			sb.append(element1);
			sb.append(blankline);
			sb.append(element2);
			if(i < segments.length-1){
				sb.append(" ");
			}
		}
		for(int j = 0; j < scalingfactor; j++){
			System.out.println(sb);
		}
		//print row s+1 (segment 3)
		sb = new StringBuilder(width);
		for(int i = 0; i < segments.length; i++){
			
			sb.append(" ");
			line = segments[i][3] ? online : blankline;
			sb.append(line);
			sb.append(" ");
			if(i < segments.length-1){
				sb.append(" ");
			}else{
				System.out.println(sb);
			}
		}
		//print s rows (segment 4 and 5)
		sb = new StringBuilder(width);
		for(int i = 0; i < segments.length; i++){
			
			element1 = segments[i][4] ? "|" : " ";
			element2 = segments[i][5] ? "|" : " ";

			sb.append(element1);
			sb.append(blankline);
			sb.append(element2);
			if(i < segments.length-1){
				sb.append(" ");
			}else{
				
			}
		}
		for(int j = 0; j < scalingfactor; j++){
			System.out.println(sb);
		}
		//print final row (segment 6)
		sb = new StringBuilder(width);
		for(int i = 0; i < segments.length; i++){
			
			sb.append(" ");
			line = segments[i][6] ? online : blankline;
			sb.append(line);
			sb.append(" ");
			if(i < segments.length-1){
				sb.append(" ");
			}else{
				System.out.println(sb);
			}
		}
		
		
	}

}
