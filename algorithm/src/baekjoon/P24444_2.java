package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P24444_2 {
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static int cnt = 1;

	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		visited[x] = cnt++;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : graph[now]) {
				if (visited[i] == 0) {
					queue.add(i);
					visited[i] = cnt++;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visited = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		bfs(r);

		for (int i = 1; i <= n; i++) {
			sb.append(visited[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
