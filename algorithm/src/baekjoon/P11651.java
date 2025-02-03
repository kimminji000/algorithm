package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Coordinate2 {
	int x;
	int y;

	public Coordinate2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class P11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Coordinate2> coordinates = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coordinates.add(new Coordinate2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(coordinates, new Comparator<Coordinate2>() {

			@Override
			public int compare(Coordinate2 o1, Coordinate2 o2) {
				if (o1.y == o2.y) {
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o1.y, o2.y);
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(coordinates.get(i).x).append(" ").append(coordinates.get(i).y).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
