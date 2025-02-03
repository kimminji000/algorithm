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

class Person {
	int weight;
	int height;
	int sequence;
	int rank = 0;

	Person(int weight, int height, int sequence) {
		this.weight = weight;
		this.height = height;
		this.sequence = sequence;
	}
}

public class P7568 { // 푸는 중
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Person> people = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			people.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
		}

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.weight == o2.weight) {
					return Integer.compare(o1.height, o2.height) * -1;
				}
				return Integer.compare(o1.weight, o2.weight) * -1;
			}
		});

		for (int i = 0; i < n; i++) {
			if (people.get(i).weight > people.get(i + 1).weight) {
				people.get(i).rank = i;
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(people.get(i).weight).append(" ").append(people.get(i).height).append(" ")
					.append(people.get(i).sequence).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
