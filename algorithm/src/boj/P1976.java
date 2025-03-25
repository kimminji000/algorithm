package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976 {
	static int[] num;

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			num[b] = a;
		}
	}

	private static int find(int a) {
		if (a == num[a]) {
			return a;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		num = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			num[i] = i;
		}

		for (int i = 1; i <= n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				int a = Integer.parseInt(st.nextToken());

				if (a == 1) {
					union(i, j);
				}
			}
		}

		for (int i = 0; i < m; i++) {

		}

	}

}
