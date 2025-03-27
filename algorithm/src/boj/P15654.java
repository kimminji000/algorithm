package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P15654 {
	static List<int[]> perms;
	static int[] perm;
	static boolean[] visited;

	static void permutation(int depth, int n, int r) {
		if (depth == r) {
			perms.add(perm.clone());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[depth] = i;
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int num[] = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		perms = new ArrayList<>();
		perm = new int[m];
		visited = new boolean[n];

		permutation(0, n, m);

		for (int[] i : perms) {
			for (int j = 0; j < m; j++) {
				sb.append(num[i[j]]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
