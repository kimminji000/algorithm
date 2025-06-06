package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27433 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long answer = 1;
		for (int i = 1; i <= n; i++) {
			answer *= i;
		}

		System.out.println(answer);
	}
}
