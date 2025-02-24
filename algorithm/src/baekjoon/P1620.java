package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] pokemon = new String[n + 1];

		for (int i = 1; i <= n; i++) {
			pokemon[i] = br.readLine();
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();

			if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
				System.out.println(pokemon[Integer.parseInt(str)]);
			} else {
				for (int j = 1; j <= n; j++) {
					if (pokemon[j].equals(str)) {
						System.out.println(j);
					}
				}
			}
		}

		br.close();
	}
}
