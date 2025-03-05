package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5215_nextPermutation {
	static int[] permutation;

	static boolean nextPermutation() { // 다음 순열이 존재하면 true, 아니면 false
		// step1: 꼭대기(i) 찾기 => 교환위치(i-1) 찾기 위해
		int i = permutation.length - 1;

		while (i > 0 && permutation[i - 1] >= permutation[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		// step2: 교환위치(i-1)의 값과 교환할 한단계 큰 수를 뒤쪽부터 찾기
		int j = permutation.length - 1;

		while (permutation[i - 1] >= permutation[j]) {
			j--;
		}

		// step3: i-1자리와 j자리의 값 교환
		swap(i - 1, j);

		// step4: i-1자리의 한 단계큰수로 변화를 줬으니 i 꼭대기 위치부터 맨뒤까지 가장 작은 수를 만듦(오름차순 정렬)
		int k = permutation.length - 1;

		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	static void swap(int a, int b) {
		int temp = permutation[a];
		permutation[a] = permutation[b];
		permutation[b] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] score = new int[n];
			int[] k = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				score[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}

			permutation = new int[n];

			for (int i = 0; i < n; i++) {
				permutation[i] = i;
			}

			do {

			} while (nextPermutation());

//			sb.append("#").append(tc).append(" ").append(bestScore).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
