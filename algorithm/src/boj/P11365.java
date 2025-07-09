package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if (str.equals("END")) {
				break;
			}

			for (int i = str.length(); i > 0; i--) {
				sb.append(str.charAt(i - 1));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
