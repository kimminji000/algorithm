package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int cnt = 0;
			int num = x;
			boolean flag = false;

			while (x != m && y != n) {
				if (num == y) {
					flag = true;
					break;
				}

				num += m;
				cnt++;

				while (num > n) {
					num -= n;
				}
			}

			if (num == y) {
				flag = true;
			}

			if (flag) {
				System.out.println(m * cnt + x);
			} else {
				System.out.println(-1);
			}
		}
	}
}
