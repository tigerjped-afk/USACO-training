import java.util.*;
import java.io.*;
public class ItsMooinTime {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		HashMap<String, Integer> hm=new HashMap<>();
		TreeSet<String> ts=new TreeSet<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int length=Integer.parseInt(st.nextToken());
		int count=Integer.parseInt(st.nextToken());
		String text=br.readLine();
		char[] ch=text.toCharArray();
		for(int i=0; i<length-2; i++) {
			if(!(ch[i]==ch[i+1]) && ch[i+1]==ch[i+2]) {
				String s=""+ch[i]+ch[i+1]+ch[i+2];
				hm.put(s, hm.getOrDefault(s,0)+1);
			}
		}
		for(Map.Entry<String, Integer> entry: hm.entrySet()) {
			int num=entry.getValue();
			String moo=entry.getKey();
			if(num>=count) {
				ts.add(moo);
				continue;
			}
			if(num==count-1) {
				char[] c=moo.toCharArray();
				String s=new String(text);
				ArrayList<String> arr=new ArrayList<>();
				while(!(s.indexOf(moo)==-1)) {
					String newString=s.substring(0, s.indexOf(moo));
					if(newString.length()>=3) {
						arr.add(newString);
					}
					s=s.substring(s.indexOf(moo)+3);
				}
				if(s.length()>=3) {
					arr.add(s);
				}
				for(int i=0; i<arr.size(); i++) {
					boolean b=false;
					for(int j=0; j<arr.get(i).length()-2; j++) {
						String word=arr.get(i).substring(j,j+3);
						char[] temp=word.toCharArray();
						if(((""+c[0]+c[1]).equals(""+temp[0]+temp[1])) || ((""+c[0]+c[2]).equals(""+temp[0]+temp[2])) ||
								((""+c[1]+c[2]).equals(""+temp[1]+temp[2]))) {
							ts.add(moo);
							b=true;
							break;
						}
					}
					if(b) {
						break;
					}
				}
			}
			
		}
		if(count == 1) {

    for(int i = 0; i < text.length() - 2; i++) {

        for(char a = 'a'; a <= 'z'; a++) {

            for(char b = 'a'; b <= 'z'; b++) {

                String moo = "" + a + b + b;

                if(a == b) continue;

                int diff = 0;

                for(int k = 0; k < 3; k++) {

                    if(text.charAt(i+k) != moo.charAt(k)) diff++;

                }

                if(diff <= 1) {

                    ts.add(moo);

                }

            }

        }

    }

}
		
		sb.append(ts.size()).append("\n");
		for(String s: ts) {
			sb.append(s).append("\n");
		}
		bw.write(""+sb);
		bw.flush();
		br.close();
		bw.close();
	}

}
