package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {
	static int cnt;
	static StringBuilder sb;

	private static void hanoi(int num, int from, int to, int other) {
		if (num == 0) {
			return;
		}

		hanoi(num - 1, from, other, to);
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		hanoi(num - 1, other, to, from);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		cnt = 0;

		hanoi(n, 1, 3, 2);

		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
