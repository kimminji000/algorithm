package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int answer = 0;

		for (int i = 0; i < n; i++) {
			int number = i;
			int sum = i;
			while (number > 0) {
				sum += number % 10;
				number /= 10;
			}
			if (n == sum) {
				answer = i;
				break;
			}
		}

		sb.append(answer);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
