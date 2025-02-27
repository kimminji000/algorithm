package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P17281 {
	static int maxScore = 0;
	static boolean visited[];
	static List<int[]> sequence;
	static int[] seq;

	static public void permutation(int depth, int n, int r) {
		if (depth == r) {
			sequence.add(seq);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				seq[depth] = i;
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] score = new int[n][9];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[9];
		sequence = new ArrayList<>();
		seq = new int[9];

		permutation(1, 9, 9);

		for (int i = 0; i < sequence.size(); i++) {
			int temp = sequence.get(i)[0];
			for (int j = 0; j < 3; j++) {
				sequence.get(i)[j] = sequence.get(i)[j + 1];
			}
			sequence.get(i)[3] = temp;
			
			

		}

		sb.append(sequence.size());

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
