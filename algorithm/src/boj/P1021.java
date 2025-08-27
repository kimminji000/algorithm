package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer> queue = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			int index = queue.indexOf(num);

			if (index < queue.size() - index) {
				cnt += index;
				while (queue.getFirst() != num) {
					queue.(queue.removeFirst());
				}
			} else {
				cnt += queue.size() - index;
				while (queue.getFirst() != num) {
					queue.addFirst(queue.removeLast());
				}
			}

			queue.removeFirst();
		}

		System.out.println(cnt);
	}
}
