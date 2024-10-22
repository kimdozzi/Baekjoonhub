import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String teamName = br.readLine();
			map.put(teamName, new ArrayList<>());

			int teamMemberCount = Integer.parseInt(br.readLine());
			for (int j = 0; j < teamMemberCount; j++) {
				map.get(teamName).add(br.readLine());
			}
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			int flag = Integer.parseInt(br.readLine());

			// 팀 이름이 주어지고, 멤버 모두 출력.
			if (flag == 0) {
				Set<String> strings = map.keySet();
				for (String s : strings) {
					if (s.equals(name)) {
						List<String> list = map.get(s);
						Collections.sort(list);
						for (String l : list) {
							System.out.println(l);
						}
						break;
					}
				}
			}
			// 멤버 이름이 주어지고, 팀 이름 출력.
			else {
				Set<String> strings = map.keySet();
				for (String s : strings) {
					List<String> list = map.get(s);
					Collections.sort(list);
					for (String l : list) {
						if (l.equals(name)) {
							System.out.println(s);
							break;
						}
					}
				}
			}
		}
	}
}

