package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] number = new int[10001];

		for (int i = 0; i < n; i++) {
			number[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < number[i]; j++) {
				sb.append(i).append("\n");
			}
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
