import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			map.put(s, i + 1);
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));

		int cnt = 0;
		for (String key : keySet) {
			System.out.println(key);
			cnt++;
			if (cnt >= K)
				break;
		}
	}
}

