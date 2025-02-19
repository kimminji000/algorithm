package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			char[] num = str.toCharArray();
			int swap = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num.length / 2; j++) {
				if (swap == 0) {
					break;
				}

				int maxIndex = j;
				for (int k = j + 1; k < num.length; k++) {
					int now = Integer.parseInt(Character.toString(num[k]));
					if (now >= Integer.parseInt(Character.toString(num[maxIndex]))) {
						maxIndex = k;
					}
				}

				char temp = num[j];
				num[j] = num[maxIndex];
				num[maxIndex] = temp;
				swap--;
			}

			if (swap % 2 == 1) {
				char temp = num[num.length - 2];
				num[num.length - 2] = num[num.length - 1];
				num[num.length - 1] = temp;

				sb.append("#").append(i + 1).append(" ").append(num).append("\n");
			} else {
				sb.append("#").append(i + 1).append(" ").append(num).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
