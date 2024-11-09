import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().strip();

		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'A';
			alpha[idx]++;
		}

		int isOne = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] % 2 != 0)
				isOne++;
		}

		if (isOne > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alpha.length; i++) {
			for (int j = 0; j < alpha[i] / 2; j++) {
				sb.append((char)(i + 65));
			}
		}
		StringBuilder ans = new StringBuilder(sb.toString());
		String end = sb.reverse().toString();

		for (int j = 0; j < alpha.length; j++) {
			if (alpha[j] % 2 == 1)
				ans.append(((char)(j + 65)));
		}
		ans.append(end);
		System.out.println(ans);
	}
}