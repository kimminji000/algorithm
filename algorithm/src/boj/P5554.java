package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5554 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int time = 0;

		for (int i = 0; i < 4; i++) {
			time += Integer.parseInt(br.readLine());
		}

		System.out.println(time / 60);
		System.out.println(time % 60);
	}
}
