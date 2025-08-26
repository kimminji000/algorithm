package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] cnt = new int[2][7];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			cnt[s][grade]++;
		}

		int rooms = 0;

		for (int s = 0; s < 2; s++) {
			for (int grade = 1; grade <= 6; grade++) {
				rooms += cnt[s][grade] % k == 0 ? cnt[s][grade] / k : cnt[s][grade] / k + 1;
			}
		}

		System.out.println(rooms);
	}
}
