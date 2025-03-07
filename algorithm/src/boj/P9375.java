package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9375 {
	static List<String> category;
	static int[] count;
	static boolean[] subset;
	static int cnt;

	static void powerset(int start, int n) {
		if (start == n) {
			for (int i = 0; i < n; i++) {
				if (subset[i]) {
				}
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			subset[i] = true;
			powerset(i + 1, n);

			subset[i] = false;
			powerset(i + 1, n);

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			category = new ArrayList<>();
			count = new int[n];

			for (int j = 0; j < n; j++) {
				br.readLine(); // name
				String cate = br.readLine();

				if (category.contains(cate)) {
					count[category.indexOf(cate)]++;
				} else {
					category.add(cate);
					count[category.indexOf(cate)]++;
				}
			}

			subset = new boolean[category.size()];

			powerset(0, category.size());

		}

		br.close();
	}
}
