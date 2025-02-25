package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			List<String> category = new ArrayList<>();
			int[] count = new int[n];

			for (int j = 0; j < n; j++) {
				String name = br.readLine();
				String cate = br.readLine();

				if (category.contains(cate)) {
					count[category.indexOf(cate)]++;
				} else {
					category.add(cate);
					count[category.indexOf(cate)]++;
				}
			}

		}

		br.close();
	}
}
