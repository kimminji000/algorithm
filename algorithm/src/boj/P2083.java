package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2083 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			if (str.equals("# 0 0")) {
				break;
			}

			StringTokenizer st = new StringTokenizer(str);

			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (age > 17 || weight >= 80) {
				System.out.println(name + " Senior");
			} else {
				System.out.println(name + " Junior");
			}
		}
	}
}
