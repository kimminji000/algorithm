package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5653 {
	static int[][] graph;
	static int[][] visited;

	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] != 0) {
					queue.add(new int[] { i, j });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			graph = new int[n + 400][m + 400];
			visited = new int[n + 400][m + 400];

			for (int x = 0; x < n; x++) {
				st = new StringTokenizer(br.readLine());

				for (int y = 0; y < m; y++) {
					graph[x + 200][y + 200] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs();

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
