import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int count=0;
	static List<Integer> list;
	static int[] getSt(String str) {
		int[] st = new int[str.length()];
		int j=0;
		for(int i=1;i<str.length();i++) {
			while(j>0 && str.charAt(i)!=str.charAt(j)) {
				j=st[j-1];
			}
			if(str.charAt(i)==str.charAt(j))
				st[i]=++j;
		}
		return st;
	}
	
	static void KMP(String org, String ptn) {
		int pi[] = getSt(ptn);
		int j=0;
		for(int i=0;i<org.length();i++) {
			while(j>0 && org.charAt(i)!=ptn.charAt(j)) {
				j = pi[j-1];
			}
			if(org.charAt(i)==ptn.charAt(j)) {
				if(j==ptn.length()-1) {
					count++;
					list.add(i-j+1);
					j=pi[j];
				}
				else
					j++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		list = new ArrayList<>();
		KMP(origin,pattern);
		System.out.println(count);
		for(int i=0;i<count;i++)
			System.out.println(li.get(i));
	}
}
