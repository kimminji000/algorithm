package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P20920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<String> strArr = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() >= m) {
				strArr.add(str);
			}
		}

		Collections.sort(strArr);

		// sb.append("#").append().append(" ").append().append("\n");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
