package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();

			for (int j = m - 1; j >= 0; j--) {
				sb.append(str.charAt(j));
			}
			System.out.println(sb.toString());
		}
	}
}
