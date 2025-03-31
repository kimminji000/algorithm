package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4195 {
	static int[] parent;
	static int[] size;

	static void makeSet(int s) {
		parent = new int[s];
		size = new int[s];

		for (int i = 0; i < s; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return;
		}

		parent[rootB] = rootA;
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int f = Integer.parseInt(br.readLine());
//			Map<String, Integer> dd = HashMap

			for (int i = 0; i < f; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				String id1 = st.nextToken();
				String id2 = st.nextToken();

			}
		}
	}
}
