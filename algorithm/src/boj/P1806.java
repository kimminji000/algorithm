package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0, left = 0, right = 0, minLen = Integer.MAX_VALUE;

		while (true) {
			if (sum >= s && right > left) {
				minLen = Math.min(minLen, right - left);
				sum -= nums[left++];
			} else if (right == n) {
				break;
			} else {
				sum += nums[right++];
			}
		}

		if (minLen == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLen);
		}
	}
}
