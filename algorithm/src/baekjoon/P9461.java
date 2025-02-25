package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			long[] p = new long[n + 5];

			p[1] = 1;
			p[2] = 1;
			p[3] = 1;
			p[4] = 2;
			p[5] = 2;

			for (int j = 6; j <= n; j++) {
				p[j] = p[j - 1] + p[j - 5];
			}

			System.out.println(p[n]);
		}

		br.close();
	}
}
