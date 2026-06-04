import java.util.*;
import java.io.*;
public class DontBeLast {
	static int lines;
	static HashMap<String, Integer> hm;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("notlast.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("notlast.out"));
		StringTokenizer st=new StringTokenizer(br.readLine());
		lines=Integer.parseInt(st.nextToken());
		hm=new HashMap<>();
		String[] cows= {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
		for(String s: cows) {
			hm.put(s, 0);
		}
		for(int i=0; i<lines; i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			int x=Integer.parseInt(st.nextToken());
			hm.put(s, hm.getOrDefault(s, 0)+x);
		}
		int min=Integer.MAX_VALUE;
		for(String s: hm.keySet()) {
			min=Math.min(min, hm.get(s));
		}
		int secondMin=Integer.MAX_VALUE;
		String secondMinCow="";
		for(String s: hm.keySet()) {
			if(!(hm.get(s)==min) && secondMin>hm.get(s)) {
				secondMin=hm.get(s);
				secondMinCow=s;
			}
		}
		if(secondMin==Integer.MAX_VALUE) {
			bw.write("Tie");
		}else {
			boolean repeat=false;
			for(String s: hm.keySet()) {
				if(hm.get(s).equals(secondMin) && !(s.equals(secondMinCow))) {
					bw.write("Tie");
					repeat=true;
				}
			}
			if(!(repeat)) {
				bw.write(""+secondMinCow);
			}
		}
		bw.flush();
		br.close();
		bw.close();
		
		
	}
	

}
