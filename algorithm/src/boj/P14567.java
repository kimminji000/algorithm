package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14567 {
	static int n;
	static List<Integer>[] subjects;

	public static int bfs(int x) {
		int visited[] = new int[n + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(x);
		visited[x] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : subjects[now]) {
				if (visited[i] == 0) {
					queue.offer(i);
					visited[i] = visited[now] + 1;
				}
			}
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			cnt = Math.max(cnt, visited[i]);
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		subjects = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			subjects[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			subjects[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(bfs(i)).append(" ");
		}

		System.out.println(sb.toString());
	}
}
