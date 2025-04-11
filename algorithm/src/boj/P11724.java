package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724 {
	static List<Integer>[] graph;
	static boolean visited[];

	private static void dfs(int v) {
		if (visited[v]) {
			return;
		}

		visited[v] = true;

		for (int i : graph[v]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];

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

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);
	}
}
