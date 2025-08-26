package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10807 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (num[i] == v) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
