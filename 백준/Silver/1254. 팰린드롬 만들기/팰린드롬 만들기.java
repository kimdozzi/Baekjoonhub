import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		if (isPalindrome(s)) {
			System.out.println(s.length());
			System.exit(0);
		}
		
		int minLength = 100;
		for (int i = s.length() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder(s);
			for (int j = i; j >= 0; j--) {
				sb.append(s.charAt(j));
			}
			if (isPalindrome(sb.toString())) {
				minLength = Math.min(minLength, sb.length());
			}
		}
		System.out.println(minLength);
	}

	private static boolean isPalindrome(String str) {
		int l = 0, r = str.length() - 1;
		while (l < r) {
			if (0 <= l && r < str.length() && str.charAt(l) ==
				str.charAt(r)) {
				l++;
				r--;
			} else
				return false;
		}
		return true;
	}
}
