package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] points = new int[n + 1][2];
		List<int[]> zeroPoint = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i][0] = x;
			points[i][1] = y;
		}

		points[n][0] = points[0][0];
		points[n][1] = points[0][1];

		for (int i = 0; i < n; i++) {
			if (points[i][1] < 0 && points[i + 1][1] > 0) {
				zeroPoint.add(new int[] { points[i][0], 0 });
			} else if (points[i][1] > 0 && points[i + 1][1] < 0) {
				zeroPoint.add(new int[] { points[i][0], 0 });
			}
		}

		br.close();
	}
}