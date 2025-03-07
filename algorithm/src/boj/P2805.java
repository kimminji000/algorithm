package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] trees = new int[n];

		st = new StringTokenizer(br.readLine());

		int max = 0;
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		int left = 0, right = max;

		while (left <= right) {
			int mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < n; i++) {
				if (trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}

			if (sum >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}
