package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P32314 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		System.out.println(w / v >= a ? 1 : 0);
	}
}
