package b0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UserSolution {
	static int n;
	static String[] words;
	static int pointer;

	static class Keyword implements Comparable<Keyword> {
		String word;
		int cnt;

		public Keyword(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Keyword o) {
			if (this.cnt == o.cnt) {
				return this.word.compareTo(o.word);
			}
			return o.cnt - this.cnt;
		}
	}

	static void init(int N) {
		n = N;
		words = new String[n];
		pointer = 0;
	}

	static void add(String str) {
		words[pointer % n] = str;
		pointer++;
	}

	static int top5Keywords(String mRet[]) {
		int nCount;

		if (pointer <= n) {
			nCount = pointer;
		} else {
			nCount = n;
		}

		Map<String, Integer> keywords = new LinkedHashMap<>();

		// 1. 같은 단어 개수 세기
		for (int i = 0; i < nCount; i++) {
			if (keywords.containsKey(words[i])) {
				keywords.put(words[i], keywords.get(words[i]) + 1);
			} else {
				keywords.put(words[i], 1);
			}
		}

		// 2. 연관 단어 찾기
		List<Integer>[] graph = new ArrayList[keywords.size()];

		// 내 코드
//		for (int i = 0; i < keywords.size(); i++) {
//			graph[i] = new ArrayList<>();
//		}
//
//		for (int i = 0; i < keywords.size() - 1; i++) {
//			String wordI = (String) keywords.keySet().toArray()[i];
//
//			for (int j = i + 1; j < keywords.size(); j++) {
//				String wordJ = (String) keywords.keySet().toArray()[j];
//
//				if (wordI.length() == wordJ.length()) {
//					int UnEqualcnt = 0;
//
//					for (int k = 0; k < wordI.length(); k++) {
//						if (wordI.charAt(k) != wordJ.charAt(k)) {
//							UnEqualcnt++;
//						}
//					}
//
//					if (UnEqualcnt < 2) {
//						graph[i].add(j);
//						graph[j].add(i);
//					}
//				}
//			}

		// 3. 연관 단어들 대표 단어로 정리
		List<Keyword> topwords = new ArrayList<>();

		boolean[] visited = new boolean[keywords.size()];

		for (int i = 0; i < keywords.size(); i++) {
			if (!visited[i]) {
				Queue<Integer> queue = new ArrayDeque<>();
				queue.offer(i);
				visited[i] = true;

				String wordI = (String) keywords.keySet().toArray()[i];
				int numOne = i;
				int max = keywords.get(wordI);
				int sum = keywords.get(wordI);

				while (!queue.isEmpty()) {
					int now = queue.poll();

					for (int j : graph[now]) {
						if (!visited[j]) {
							queue.offer(j);
							visited[j] = true;

							String wordOne = (String) keywords.keySet().toArray()[numOne];
							String wordJ = (String) keywords.keySet().toArray()[j];
							sum += keywords.get(wordJ);

							if (max < keywords.get(wordJ)) {
								numOne = j;
								max = keywords.get(wordJ);

							} else if (max == keywords.get(wordJ)) {
								if (wordJ.compareTo(wordOne) < 0) {
									numOne = j;
								}
							}
						}
					}
				}

				topwords.add(new Keyword((String) keywords.keySet().toArray()[numOne], sum));
			}
		}

		topwords.sort(null);

		if (topwords.size() == 0) {
			return 0;
		} else if (topwords.size() < n) {
			for (int i = 0; i < topwords.size(); i++) {
				mRet[i] = topwords.get(i).word;
			}
			return topwords.size();
		} else {
			for (int i = 0; i < n; i++) {
				mRet[i] = topwords.get(i).word;
			}
			return n;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		init(5);

		for (int i = 0; i < 5; i++) {
			add(br.readLine());
		}

		String[] mRet = new String[5];
		int cnt = top5Keywords(mRet);

		for (int i = 0; i < cnt; i++) {
			System.out.println(mRet[i]);
		}
	}
}
