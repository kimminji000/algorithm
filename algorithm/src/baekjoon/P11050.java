package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P11050 { // StackOverflow
	public static int factorial(int i) {
		if (i == 0) {
			return 0;
		}
		return i * factorial(i - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int num = factorial(n) / (factorial(n - k) * factorial(k));

		sb.append(num);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
