package swea.p17;

import java.util.Arrays;
import java.util.HashMap;

class UserSolution {
	final int MAX_MAKE_LIST = 10;
	final int MAX_LENGTH = 200000;
	final int MAX_ADDRESS = 6000;
	final int MAX_CHANGE = 110000;

	int initNumber; // 원본 배열의 번호
	int[][] initValue; // 원본 배열 (makeList 당시) 정보를 그대로 저장하는 배열

	int addressNumber; // 새로운 배열의 번호 (마지막 배열 번호 + 1)
	HashMap<String, Integer> address; // 배열 이름 -> 원본 배열 번호 mapping

	int eventNumber; // 현재까지 발생한 event 개수 (makeList, copyList, updateElement 모두 포함)
	Pair[] eventLog; // 현재까지 발생한 event 정보
	// makeList : (-1, 원본 배열 번호)
	// copyList : (-1, -1) 정보 추가하기. (깊은 복사를 의미)
	// updateElement : (인덱스, 값) ; 인덱스의 값을 변경

	int[] lastEvent; // lastEvent[i] := i번 배열의 마지막 event 번호
	int[] prevEvent; // prevEvent[i] := i번 변화의 직전 event 번호 (부모노드는 무엇인가)

	class Pair {
		int first;
		int second;

		
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public String getName(char[] mName) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; mName[i] != 0; i++) {
			sb.append(mName[i]);
		}

		return sb.toString();
	}

	public void init() {
		// 원본 배열 초기화
		initNumber = 0;
		initValue = new int[MAX_MAKE_LIST + 1][MAX_LENGTH + 1];

		// 전체 배열 초기화
		addressNumber = 0;
		address = new HashMap<>();

		// 변화 event 정보 초기화
		eventNumber = 0;
		eventLog = new Pair[MAX_CHANGE + 1];
		lastEvent = new int[MAX_ADDRESS + 1];
		prevEvent = new int[MAX_CHANGE + 1];
	}

	public void makeList(char mName[], int mLength, int mListValue[]) { // 호출 횟수는 10 이하
		String name = getName(mName);

		initValue[initNumber++] = Arrays.copyOf(mListValue, mLength);// initNumber 위치에 원본 배열에 저장
		address.put(name, addressNumber++); // name 이름의 배열을 생성

		// 이벤트 기록
		eventLog[eventNumber] = new Pair(-1, initNumber - 1); // 이벤트 기록에 (-1, 원본 배열 번호)
		prevEvent[eventNumber] = -1; // 이전 정점이 없어서
		lastEvent[address.get(name)] = eventNumber; // address.get(name) <- 이 배열의 마지막 이벤트 번호
		eventNumber++;
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy) { // 호출 횟수는 5,000 이하
		String dest = getName(mDest);
		String src = getName(mSrc);

		if (mCopy) { // 값복사
			address.put(dest, addressNumber++); // 배열이 새로 생기는 거라 새 배열 추가

			// 이벤트 기록
			eventLog[eventNumber] = new Pair(-1, -1); // 이벤트 기록에 추가 (깊은 복사)
			prevEvent[eventNumber] = lastEvent[address.get(src)]; // i번 변화의 직전 변화 event 번호 (부모노드는 무엇인가)
			lastEvent[address.get(dest)] = eventNumber; // address.get(dest) <- 이 배열의 마지막 이벤트 번호
			eventNumber++;
		} else { // 주소복사
			address.put(dest, address.get(src)); // (배열 이름, 배열 번호)
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue) { // 호출 횟수는 100,000 이하
		String name = getName(mName);

		// 이벤트 기록
		eventLog[eventNumber] = new Pair(mIndex, mValue); // 이벤트 기록에 (인덱스, 값)
		prevEvent[eventNumber] = lastEvent[address.get(name)]; // i번 변화의 직전 변화 event 번호(부모노드는 무엇인가)
		lastEvent[address.get(name)] = eventNumber; // address.get(name) <- 이 배열의 마지막 이벤트 번호
		eventNumber++;
	}

	public int element(char mName[], int mIndex) { // 호출 횟수는 400 이하
		String name = getName(mName);

		int c = lastEvent[address.get(name)]; // address.get(name) <- 이 배열의 마지막 이벤트 번호
		while (true) {
			if (prevEvent[c] == -1) { // 마지막 이벤트가 없다면 새 배열임
				return initValue[eventLog[c].second][mIndex];
			}
			if (eventLog[c].first == mIndex) { // 값 변경이라면
				return eventLog[c].second;
			}
			c = prevEvent[c]; // 이전 이벤트로
		}
	}
}
