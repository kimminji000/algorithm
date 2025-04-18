package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int num;
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			if (num < x) {
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
