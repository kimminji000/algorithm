package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);

		for (int i = 0; i < str.length(); i++) {
			if (alpha[str.charAt(i) - 'a'] == -1) {
				alpha[str.charAt(i) - 'a'] = i;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			sb.append(alpha[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
