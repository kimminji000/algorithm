package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1647 {
	static int[] parent;
	static int[] rank;

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static void makeSet(int size) {
		parent = new int[size];
		rank = new int[size];

		for (int i = 1; i < size; i++) {
			parent[i] = i;
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return;
		}

		if (rank[rootA] > rank[rootB]) {
			parent[rootB] = rootA;
		} else if (rank[rootA] < rank[rootB]) {
			parent[rootA] = rootB;
		} else {
			parent[rootB] = rootA;
			rank[rootA]++;
		}
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[m];
		makeSet(n + 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, c);
		}

		if (n == 2) {
			System.out.println(edges[0].weight);
		}

		Arrays.sort(edges);

		long cnt = 0, sum = 0;

		for (int i = 0; i < m; i++) {
			if (!isConnected(edges[i].from, edges[i].to)) {
				cnt++;
				union(edges[i].from, edges[i].to);
				sum += edges[i].weight;
			}

			if (cnt == n - 2) {
				System.out.println(sum);
				break;
			}
		}
	}
}
