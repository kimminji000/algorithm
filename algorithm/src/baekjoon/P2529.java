package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2529 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();

		char[] symbol = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			sb.append(symbol[i]);
		}

		// sb.append("#").append().append(" ").append().append("\n");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
