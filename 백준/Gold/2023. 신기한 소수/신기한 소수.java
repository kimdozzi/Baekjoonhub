import java.util.*;
import java.io.*;

public class Main {
	static char[] num;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		num = new char[n];

		rec_func(0);
	}

	private static void rec_func(int index) {
		// TODO Auto-generated method stub
		if (index == n) {
			if(check()) {
				System.out.println(new String(num));
			}
			return;
		}
		
		int start = (index == 0) ? 1 : 0;
		for(int i=start; i<=9; i++) {
			num[index] = (char)(i + '0');
			rec_func(index+1);
		}
	}

	private static boolean check() {
		int number = 0;
		for(int i=0; i<n; i++) {
			number = number * 10 + (num[i] - '0');
			if(!isPrime(number)) return false;
		}
		return true;
	}

	private static boolean isPrime(int number) {
		if (number<2) return false;
		for(int i=2; i*i<=number; i++) {
			if(number%i==0) return false;
		}
		return true;
	}
	
	
}

