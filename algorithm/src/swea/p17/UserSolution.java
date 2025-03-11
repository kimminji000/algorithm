package swea.p17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class UserSolution {
	static Map<String, int[]> lists;

	public void init() {
		lists = new HashMap<>();
	}

	public void makeList(char mName[], int mLength, int mListValue[]) { // 호출 횟수는 10 이하
		String name = mName.toString();

		int[] newList = Arrays.copyOf(mListValue, mLength);

		lists.put(name, newList);
	}

	public void copyList(char mDest[], char mSrc[], boolean mCopy) { // 호출 횟수는 5,000 이하
		String dest = mDest.toString();
		String src = mSrc.toString();

		if (mCopy) { // 값 모두 복사
			lists.put(dest, lists.get(src).clone());
		} else { // 주소만 복사
			lists.put(dest, lists.get(src));
		}
	}

	public void updateElement(char mName[], int mIndex, int mValue) { // 호출 횟수는 100,000 이하
		String name = mName.toString();
		lists.get(name)[mIndex] = mValue;
	}

	public int element(char mName[], int mIndex) { // 호출 횟수는 400 이하
		String name = mName.toString();
		return lists.get(name)[mIndex];
	}
}
