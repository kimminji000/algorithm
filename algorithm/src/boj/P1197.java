package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1197 {
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

	static void makeSet(int size) {
		parent = new int[size];
		rank = new int[size];

		for (int i = 1; i < size; i++) {
			parent[i] = i;
		}
	}

	static void union(int a, int b) {
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

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	static boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		Edge[] edges = new Edge[e];

		makeSet(v + 1);

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, c);
		}

		Arrays.sort(edges);

		int cnt = 0, sum = 0;

		for (int i = 0; i < e; i++) {
			if (!isConnected(edges[i].from, edges[i].to)) {
				cnt++;
				union(edges[i].from, edges[i].to);
				sum += edges[i].weight;
			}

			if (cnt == v - 1) {
				break;
			}
		}

		System.out.println(sum);
	}
}
