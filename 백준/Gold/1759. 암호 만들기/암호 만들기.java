
import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	static List<String> answer = new ArrayList<>();
	static HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
	static String[] chArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chArr = br.readLine().split(" ");
		Arrays.sort(chArr);
		
		rec_func(0, 0);
		
		for(String ans : answer) {
			System.out.println(ans);
		}	
	}

	private static void rec_func(int start, int index) {
		if (index == n) {
			if (check()) {
				answer.add(sb.toString());
			}
			return;
		}
		
		for(int i=start; i<m; i++) {
			sb.append(chArr[i]);
			rec_func(i+1, index+1);
			sb.deleteCharAt(index);
		}
	}

	private static boolean check() {
		int m = 0, j = 0;
		for(int i=0; i<sb.length(); i++) {
			if (set.contains(sb.charAt(i))) m++;
			else j++;
		}
		if (m >= 1 && j >= 2) return true;
		return false;
	}
}
