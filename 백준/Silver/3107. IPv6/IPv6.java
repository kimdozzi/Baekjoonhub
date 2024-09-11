import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		if (str.length() == 2 && str.charAt(0) == ':' && str.charAt(1) == ':') {
			System.out.println("0000:0000:0000:0000:0000:0000:0000:0000");
			System.exit(0);
		}

		boolean isExist = false;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == ':' && str.charAt(i + 1) == ':') {
				isExist = true;
				break;
			}
		}

		// ::가 쓰이지 않은 경우
		if (!isExist) {
			String[] strArr = str.split(":");
			StringJoiner sj = new StringJoiner(":");
			for (int i = 0; i < strArr.length; i++) {
				while (strArr[i].length() < 4) {
					strArr[i] = "0" + strArr[i];
				}
				sj.add(strArr[i]);
			}
			System.out.println(sj);

		} else {
			String[] strArr = str.split("::");

			int cnt = -1;
			String[] strArrLeftChild = strArr[0].split(":");
			StringJoiner sjLeft = new StringJoiner(":");
			for (int i = 0; i < strArrLeftChild.length; i++) {
				cnt++;
				while (strArrLeftChild[i].length() < 4) {
					strArrLeftChild[i] = "0" + strArrLeftChild[i];
				}
				sjLeft.add(strArrLeftChild[i]);
			}
			String[] strArrRightChild;
			if (strArr.length < 2) {
				strArrRightChild = new String[] {"0"};
			} else {
				strArrRightChild = strArr[1].split(":");
			}

			StringJoiner sjRight = new StringJoiner(":");
			cnt--;
			for (int i = 0; i < strArrRightChild.length; i++) {
				cnt++;
				while (strArrRightChild[i].length() < 4) {
					strArrRightChild[i] = "0" + strArrRightChild[i];
				}
				sjRight.add(strArrRightChild[i]);
			}

			StringBuilder sb = new StringBuilder();
			sb.append(":");
			while (cnt + 1 < 7) {
				sb.append("0000").append(":");
				cnt++;
			}
			System.out.println(sjLeft.toString() + sb + sjRight);
		}

	}
}
