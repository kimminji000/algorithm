package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
	static List<Node>[] graph;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int index, int cost) {
			this.vertex = index;
			this.weight = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static void dijkstra(int n) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(n, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.weight > dist[now.vertex]) {
				continue;
			}

			for (Node next : graph[now.vertex]) {
				if (dist[next.vertex] > dist[now.vertex] + next.weight) {
					dist[next.vertex] = dist[now.vertex] + next.weight;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int vcnt = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		graph = new ArrayList[vcnt + 1];
		dist = new int[vcnt + 1];

		for (int i = 0; i <= vcnt; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(k);

		for (int i = 1; i <= vcnt; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
