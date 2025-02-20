package baekjoon;

import java.io.*;
import java.util.*;

public class P21608_2 {
	static int n;
	static int[][] seats;
	static Map<Integer, Set<Integer>> studentPreferences = new HashMap<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		seats = new int[n][n];

		List<Integer> students = new ArrayList<>();

		for (int i = 0; i < n * n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			students.add(num);
			Set<Integer> preference = new HashSet<>();
			for (int j = 0; j < 4; j++) {
				preference.add(Integer.parseInt(st.nextToken()));
			}
			studentPreferences.put(num, preference);
		}

		for (int num : students) {
			placeStudent(num);
		}

		System.out.println(calculateSatisfaction());
	}

	static void placeStudent(int num) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[2] != b[2])
				return b[2] - a[2]; // 좋아하는 학생 수 내림차순
			if (a[3] != b[3])
				return b[3] - a[3]; // 빈자리 수 내림차순
			if (a[0] != b[0])
				return a[0] - b[0]; // 행 오름차순
			return a[1] - b[1]; // 열 오름차순
		});

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (seats[x][y] == 0) {
					int like = 0, blank = 0;
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d], ny = y + dy[d];
						if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
							if (seats[nx][ny] == 0)
								blank++;
							else if (studentPreferences.get(num).contains(seats[nx][ny]))
								like++;
						}
					}
					pq.add(new int[] { x, y, like, blank });
				}
			}
		}
		int[] best = pq.poll();
		seats[best[0]][best[1]] = num;
	}

	static int calculateSatisfaction() {
		int sum = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				int num = seats[x][y];
				int like = 0;
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d], ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (studentPreferences.get(num).contains(seats[nx][ny]))
							like++;
					}
				}
				sum += (int) Math.pow(10, like - 1);
			}
		}
		return sum;
	}
}
