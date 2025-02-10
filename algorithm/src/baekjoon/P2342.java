package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2342 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = st.countTokens(); // 5

		int[] nums = new int[n]; // 1, 2, 2, 4, 0

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[][][] dp = new int[n][5][5];
		dp[0][nums[0]][0] = 2;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (dp[i - 1][j][k] != 0) {
						if (nums[i] == j) { // 같은 지점
							dp[i][nums[i]][k] = dp[i - 1][j][k] + 1;
						} else if (nums[i] == k) {
							dp[i][j][nums[i]] = dp[i - 1][j][k] + 1;
						} else if (k == 0) { // 오른발이 시작 지점
							dp[i][j][nums[i]] = dp[i - 1][j][k] + 2;
						} else if (nums[i - 1] == nums[i + 1]) { // 이전 수가 다음 수랑 같을때
							if (nums[i - 1] == j) { // 이전 수랑 왼발이 같으면 오른발을 움직임
								dp[i][j][nums[i]] = dp[i - 1][j][k] + 4;
							} else {
								dp[i][nums[i]][k] = dp[i - 1][j][k] + 4;
							}
						} else if (Math.abs(j - nums[i]) == 1 || Math.abs(j - nums[i]) == 3) { // 양옆
							dp[i][nums[i]][k] = dp[i - 1][j][k] + 3;
						} else {
							dp[i][j][nums[i]] = dp[i - 1][j][k] + 3;
						}
					}
				}
			}
		}

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if (dp[n - 2][j][k] != 0) {
					sb.append(dp[n - 2][j][k]);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
