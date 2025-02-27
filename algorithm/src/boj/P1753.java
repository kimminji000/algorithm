package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
	static ArrayList<Node>[] graph;
	static boolean visited[];
	static int dist[];

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static void dijkstra(Node n) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(n);
		visited[n.index] = true;
		dist[n.index] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (Node i : graph[now.index]) {
				dist[i.index] = Math.min(dist[i.index], dist[now.index] + i.cost);

				if (!visited[i.index]) {
					pq.add(i);
					visited[i.index] = true;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int vertex = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		graph = new ArrayList[vertex + 1];
		visited = new boolean[vertex + 1];
		dist = new int[vertex + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 1; i <= vertex; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(new Node(k, 0));

		for (int i = 1; i <= vertex; i++) {
			if (visited[i]) {
				sb.append(dist[i]).append("\n");
			} else {
				sb.append("INF").append("\n");
			}
		}

		System.out.println(sb.toString());

		br.close();
	}
}
