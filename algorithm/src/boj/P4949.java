package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class P4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		while (!str.equals(".")) {
			ArrayDeque<Integer> myStack = new ArrayDeque<>();

			boolean flag = false;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					myStack.push(0);
				} else if (str.charAt(i) == '[') {
					myStack.push(1);
				} else if (str.charAt(i) == ')') {
					if (myStack.isEmpty() || myStack.peek() != 0) {
						flag = true;
						break;
					}
					myStack.pop();
				} else if (str.charAt(i) == ']') {
					if (myStack.isEmpty() || myStack.peek() != 1) {
						flag = true;
						break;
					}
					myStack.pop();
				}
			}

			if (myStack.size() != 0 || flag) {
				sb.append("no").append("\n");
			} else {
				sb.append("yes").append("\n");
			}

			str = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
