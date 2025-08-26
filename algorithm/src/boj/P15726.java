package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		double a = Integer.parseInt(st.nextToken());
		double b = Integer.parseInt(st.nextToken());
		double c = Integer.parseInt(st.nextToken());

		System.out.println((int) Math.max(a * b / c, a / b * c));
	}
}
