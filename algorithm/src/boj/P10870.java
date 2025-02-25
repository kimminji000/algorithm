package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		sb.append(fibonacci(n));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

//	public static int fibonacci(int n) {
//		if (n == 0) {
//			return 0;
//		} else if (n <= 2) {
//			return 1;
//		}
//		return fibonacci(n - 1) + fibonacci(n - 2);
//	}

	public static int fibonacci(int n) {
		int[] fibo = new int[21];

		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i <= n; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		return fibo[n];
	}
}
