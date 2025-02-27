package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5215_combination2 {
	static int l;
	static int bestScore;
	static int[] score;
	static int[] k;

	static void combination(int depth, int start, int n, int r, int scoreSum, int kSum) {
		if (kSum > l) {
			return;
		}

		if (depth == r) {
			if (kSum <= l) {
				bestScore = Math.max(scoreSum, bestScore);
			}
			return;
		}

		for (int i = start; i < n; i++) {
			combination(depth + 1, i + 1, n, r, scoreSum + score[i], kSum + k[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			score = new int[n];
			k = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				score[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}

			bestScore = 0;

			for (int i = 1; i <= n; i++) {
				combination(0, 0, n, i, 0, 0);
			}

			sb.append("#").append(tc).append(" ").append(bestScore).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
