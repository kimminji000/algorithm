package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14489 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());

		if (a + b >= 2 * c) {
			System.out.println((a + b) - 2 * c);
		} else {
			System.out.println(a + b);
		}
	}
}
