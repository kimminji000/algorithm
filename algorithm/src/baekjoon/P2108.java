package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int sum = 0;

		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			nums.add(num);
			sum += num;
		}

		Collections.sort(nums);

		sb.append(sum / n).append("\n").append(nums.get(n / 2)).append("\n").append(nums.get(n - 1) - nums.get(0))
				.append("\n").append(nums.get(n - 1) - nums.get(0));
		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
