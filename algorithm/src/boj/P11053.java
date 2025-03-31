package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int maxCnt = 0;

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int maxNum = 0;

			for (int j = i; j < n; j++) {
				if (maxNum < num[j]) {
					cnt++;
					maxNum = num[j];
				}
			}

			maxCnt = Math.max(cnt, maxCnt);
		}

		System.out.println(maxCnt);
	}
}
