package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1043 {
	private static int[] parent;

	private void makeSet(int n) {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	private void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return;
		}

		parent[rootB] = rootA;
	}

	private int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		if (num > 1) {

		}
		int[] people = new int[num];
		for (int i = 0; i < num; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer>[] party = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		System.out.println("dd");
	}
}
