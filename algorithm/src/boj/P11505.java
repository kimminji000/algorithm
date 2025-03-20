package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505 {
	static long[] num, tree;

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = num[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end) % 1000000007;

	}

	static long query() {
		return 0;
	}

	static void update() {

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		num = new long[n + 1];
		tree = new long[4 * n];

		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, n);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
//				update(1,1,n,)
			}
		}
	}
}
