package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2170 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] line = new int[n][2];
		int length = 0, start, end;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			line[i][0] = Integer.parseInt(st.nextToken());
			line[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});

		start = line[0][0];
		end = line[0][1];
		for (int i = 0; i < n; i++) {
			int x = line[i][0];
			int y = line[i][1];

			if (x >= start && y <= end) {
				continue;
			} else if (y > end) {
				length += y - end;
				end = y;
			} else {
				length += y - x;
				start = x;
				end = y;
			}
		}

		bw.write(Integer.toString(length));
		bw.flush();
		br.close();
		bw.close();
	}
}
