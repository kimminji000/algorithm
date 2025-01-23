package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P15829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int l = Integer.parseInt(br.readLine());

		long hash = 0;
		long power = 1;
		final long MOD = 1234567891;

		String str = br.readLine();

		for (int i = 0; i < l; i++) {
			hash = (hash + (str.charAt(i) - 'a' + 1) * power) % MOD; // Math.mod()사용시 long 범위를 벗어남
			power = (power * 31) % MOD;
		}

		sb.append(hash);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
