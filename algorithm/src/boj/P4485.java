package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4485 {
	static int[][] dist;

	static class Node implements Comparable<Node> {
		int[] vertax;
		int cost;

		public Node(int[] vertax, int cost) {
			super();
			this.vertax = vertax;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static void dijkstra(int[] n) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n[0]][n[1]] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		while (n != 0) {
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

		}

		dijkstra(new int[] { 0, 0 });

		System.out.println(sb.toString());
	}
}
