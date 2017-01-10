/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
 */
        //Scanner
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        String[] inputs = line.split(" ");
        int N=0,Q=0;
        if(inputs.length==2){
        	N= Integer.valueOf(inputs[0]);
        	Q = Integer.valueOf(inputs[1]);
        }
        String inputString = s.next();

        for (int i = 0; i <Q; i++) {
            line = s.next();
            inputs = line.split(" ");
            int l = Integer.valueOf(inputs[0]);
            int r = Integer.valueOf(inputs[1]);
            System.out.println(countMinDeletion(inputString,l,r));
        } 
       
    }
    
    private static int countMinDeletion(String str, int l, int r){
        HashMap<Character,Integer> countMap = new HashMap<>();
			int minCount=1000;
			int curCount=-1;
			int result=0;
			for(int i=l;i<=r;i++){
				char curChar = str.charAt(i);
				if(countMap.get(curChar)==null){
					countMap.put(curChar, 1);
					curCount=1;
				}else{
					curCount=countMap.get(curChar)+1;
					countMap.put(curChar, curCount);
				}
				if(minCount>curCount)
					minCount=curCount;
			}
			
			Set<Entry<Character, Integer>>set = countMap.entrySet();
			for(Entry<Character, Integer> entry : set){
				result+=entry.getValue()-minCount;
			}
			return result;
    }
}
