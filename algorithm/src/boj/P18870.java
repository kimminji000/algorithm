package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] xArr = new int[n];
		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			xArr[i] = Integer.parseInt(st.nextToken());
			num[i] = xArr[i];
		}

		Arrays.sort(num);

		num = Arrays.stream(num).distinct().toArray();

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < n; j++) {
				if (num[i] == xArr[j]) {
					xArr[j] = i;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(xArr[i]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
