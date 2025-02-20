package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P5525 { // 시간 초과
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int cnt = 0;

		for (int i = 0; i < s - 2 * t + 1; i++) {
			if (str.charAt(i) == 'I') {
				for (int j = 1; j < 2 * t; j += 2) {
					if (!(str.charAt(i + j) == 'O' && str.charAt(i + j + 1) == 'I')) {
						break;
					}

					if (j == 2 * t - 1) {
						cnt++;
					}
				}
			}
		}

		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
