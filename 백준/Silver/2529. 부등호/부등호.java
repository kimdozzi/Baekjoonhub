

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // static List<Integet> list = new ArrayList<>();
    // Deque<Integer> queue = new ArrayDeque<>();
    // static Set<Integer> hashSet = new HashSet<>();

    //static final int mn = Integer.MIN_VALUE, mx = Integer.MAX_VALUE;
    // -----------------------------------------------
    static int n;
    static char[] a = new char[20];
    static List<String> ans = new ArrayList<>();
    static boolean[] check = new boolean[10];

    private static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) a[i] = st.nextToken().toCharArray()[0];
        go(0,"");
        Collections.sort(ans);
        int m = ans.size();
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));
    }

    private static void go(int index, String num) {
        if(index==n+1) {
            if(ok(num)) {
                ans.add(num);
            }
            return;
        }
        for(int i=0; i<=9; i++) {
            if(check[i]) continue;
            check[i] = true;
            go(index+1, num+Integer.toString(i));
            check[i] = false;
        }
    }

    private static boolean ok(String num) {
        for(int i=0; i<n; i++) {
            if(a[i]=='<') {
                if(num.charAt(i) > num.charAt(i+1)) return false;
            } else if(a[i]=='>') {
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}

