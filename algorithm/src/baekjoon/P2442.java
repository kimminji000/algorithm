package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2442 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				sb.append(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);

//		for (int i = 1; i <= n; i++) {
//			System.out.println(" ".repeat(n - i) + "*".repeat(2 * i - 1));
//		}
	}
}
