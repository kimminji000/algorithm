package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5585 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		int change = 1000 - n;

		cnt += change / 500;
		change %= 500;
		cnt += change / 100;
		change %= 100;
		cnt += change / 50;
		change %= 50;
		cnt += change / 10;
		change %= 10;
		cnt += change / 5;
		change %= 5;
		cnt += change / 1;

		System.out.println(cnt);
	}
}
