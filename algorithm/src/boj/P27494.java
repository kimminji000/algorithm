package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27494 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 1000; i <= n; i++) {
			String num = Integer.toString(i);
			
			boolean[] check = new boolean[4];
			for (int j = 0; j < num.length(); j++) {
				if(num.charAt(j)=='2') {
					
				}
			}

		}

		System.out.println(cnt);
	}
}
