package swea.p17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class UserSolution {
	static Map<String, int[]> lists;
	static Map<String, String> valueCopy;
	static Map<String, String> addressCopy;
	static Map<String, Map<Integer, Integer>> update;

	public void init() {
		lists = new HashMap<>();
		valueCopy = new HashMap<>();
		addressCopy = new HashMap<>();
		update = new HashMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[]) { // 호출 횟수는 10 이하
		String name = getName(mName);
		int[] newList = Arrays.copyOf(mListValue, mLength);
		lists.put(name, newList);

		Map<Integer, Integer> innerUpdate = new HashMap<>();
		update.put(name, innerUpdate);
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy) { // 호출 횟수는 5,000 이하
		String dest = getName(mDest);
		String src = getName(mSrc);

		lists.put(dest, lists.get(src));

		if (mCopy) { // 값복사
			valueCopy.put(dest, src);
		} else { // 주소복사
			if (addressCopy.containsKey(src)) { // 내가 복사하려는 배열이 다른 배열을 복사하고 있다면
				src = addressCopy.get(src); // 최초의 배열을 복사
			}
			addressCopy.put(dest, src);
		}

		Map<Integer, Integer> innerUpdate = new HashMap<>();
		update.put(dest, innerUpdate);

		if (update.containsKey(src)) { // 만약 내가 복사하려는 배열이 변경 기록이 있으면
			for (Integer i : update.get(src).keySet()) {
				int mIndex = i;
				int mValue = update.get(src).get(i);

				update.get(dest).put(mIndex, mValue);
			}
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue) { // 호출 횟수는 100,000 이하
		String name = getName(mName);

		// 내 값 변경 기록
		update.get(name).put(mIndex, mValue);

		// 나를 주소복사한 배열이 있다면(내가 최초의 배열)
		if (addressCopy.containsValue(name)) {
			for (String str : addressCopy.values()) {
				update.get(str).put(mIndex, mValue);
			}
		}

		// 내가 주소복사한 배열이 있다면
		if (addressCopy.containsKey(name)) {
			String str = addressCopy.get(name); // 내가 주소복사한 배열
			update.get(str).put(mIndex, mValue);

			// 내가 주소복사한 배열을 주소복사한 배열이 있다면
			if (addressCopy.containsValue(str)) {
				for (String str1 : addressCopy.values()) {
					update.get(str1).put(mIndex, mValue);
				}
			}
		}
	}

	public int element(char mName[], int mIndex) { // 호출 횟수는 400 이하
		String name = getName(mName);

		if (update.containsKey(name) && update.get(name).containsKey(mIndex)) { // 만약 배열이 변경 기록이 있으면
			return update.get(name).get(mIndex);
		}
		return lists.get(name)[mIndex];
	}

	public String getName(char[] mName) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < mName.length; i++) {
			if (mName[i] == 0) {
				break;
			}
			sb.append(mName[i]);
		}

		String name = sb.toString();
		return name;
	}
}
