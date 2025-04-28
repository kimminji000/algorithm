package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12851 {
	private static boolean[] visited;

	private static class Node {
		int pos;
		int time;

		public Node(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}
	}

	private static void bfs(int n, int k) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(n, 0));

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (visited[now.pos - 1]) {
				queue.offer(new Node(now.pos - 1, now.time + 1));
			}
			queue.offer(new Node(now.pos + 1, now.time + 1));
			queue.offer(new Node(now.pos * 2, now.time + 1));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		visited = new boolean[100001];

		bfs(n, k);
	}
}
