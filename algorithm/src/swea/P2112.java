package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2112 {
	static List<ArrayList<Integer>> sequence;
	static ArrayList<Integer> seq;

	public static int performanceTest(int[][] map, int d, int w, int k) {
		int colCnt = 0;

		for (int y = 0; y < w; y++) {
			int cnt = 1;

			for (int x = 1; x < d; x++) {
				if (map[x][y] == map[x - 1][y]) {
					cnt++;
				} else {
					cnt = 1;
				}

				if (cnt == k) {
					colCnt++;
					break;
				}
			}
		}

		return colCnt;
	}

	public static void combination(int depth, int start, int n, int r) {
		if (depth == r) {
			sequence.add(new ArrayList<>(seq));
			return;
		}

		for (int i = start; i < n; i++) {
			seq.add(i);
			combination(depth + 1, i + 1, n, r);
			seq.remove(seq.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] map = new int[d][w];

			for (int x = 0; x < d; x++) {
				st = new StringTokenizer(br.readLine());

				for (int y = 0; y < w; y++) {
					map[x][y] = Integer.parseInt(st.nextToken());
				}
			}

			int colCnt = performanceTest(map, d, w, k); // 성능 검사 통과한 열의 수

			if (colCnt == w) {
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}

			sequence = new ArrayList<>();
			seq = new ArrayList<>();

			for (int j = 1; j <= k; j++) {
				combination(0, 0, d, j);
			}

			for (int j = 0; j < sequence.size(); j++) { // 약품 투입 경우의 수 많큼 반복

				for (int o = 0; o < 2; o++) {
					int[][] tempMap = new int[d][w];

					for (int x = 0; x < d; x++) { // 배열 복사
						for (int y = 0; y < w; y++) {
							tempMap[x][y] = map[x][y];
						}
					}

					for (int l = 0; l < sequence.get(j).size(); l++) { // 약품 투입
						for (int y = 0; y < w; y++) {
							tempMap[sequence.get(j).get(l)][y] = o;
						}
					}

					colCnt = performanceTest(tempMap, d, w, k);

					if (colCnt == w) {
						sb.append("#").append(i).append(" ").append(sequence.get(j).size()).append("\n");
						break;
					}
				}

				if (colCnt == w) {
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
