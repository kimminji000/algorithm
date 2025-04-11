package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11403 {
	static boolean[] visited;
	static List<Integer>[] graph;

	private static void bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : graph[now]) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		visited = new boolean[n];
		graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					graph[i].add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];

			bfs(i);

			for (int j = 0; j < n; j++) {
				sb.append(visited[j] ? 1 : 0).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
