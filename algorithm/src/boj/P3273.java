package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		Arrays.sort(num);

		int cnt = 0;

//		for (int i = 0; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				if (num[i] + num[j] == x) {
//					cnt++;
//					break;
//				} else if (num[i] + num[j] > x) {
//					break;
//				}
//			}
//		}

		int front = 0, back = n - 1;
		while (front < back) {
			if (num[front] + num[back] == x) {
				cnt++;
				front++;
				back--;
			} else if (num[front] + num[back] < x) {
				front++;
			} else {
				back--;
			}
		}

		bw.write(Integer.toString(cnt));

		br.close();
		bw.flush();
		bw.close();
	}
}
