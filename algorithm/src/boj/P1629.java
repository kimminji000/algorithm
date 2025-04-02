package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
	static long muti(int a, int b, int c) {
		if (b == 1) {
			return a % c;
		}
		if (b == 2) {
			return a * a % c;
		}
		if (b == 3) {
			return a * a * a % c;
		}
		return muti(a, b / 2, c) * muti(a, b - b / 2, c) % c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(muti(a, b, c));
	}
}
