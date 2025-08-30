package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P10773_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}

		int cnt = 0;

		while (!stack.isEmpty()) {
			cnt += stack.pop();
		}

		System.out.println(cnt);
	}
}
