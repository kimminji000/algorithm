package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2441 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				sb.append(" ");
			}
			for (int j = n - i; j > 0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);

//		for (int i = 0; i < n; i++) {
//			System.out.println(" ".repeat(i) + "*".repeat(n-i));
//		}
	}
}
