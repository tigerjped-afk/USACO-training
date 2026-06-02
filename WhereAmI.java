import java.util.*;
import java.io.*;
public class WhereAmI {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("whereami.in"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("whereami.out"));
		int wordLength=Integer.parseInt(br.readLine());
		String word=br.readLine();
		for(int i=1; i<wordLength; i++) {
			int excitedLength=wordLength-i+1;
			HashSet<String> hs=new HashSet<>();
			for(int j=0; j<excitedLength; j++) {
				hs.add(word.substring(j, j+i));
			}
			if(hs.size()==excitedLength) {
				bw.write(""+i);
				bw.flush();
				br.close();
				bw.close();
				break;
			}
		}
	}

}
