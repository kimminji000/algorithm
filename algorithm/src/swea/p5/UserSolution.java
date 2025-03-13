package swea.p5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserSolution {
	class Soldier {
		int id;
		int team;
		int score;

		public Soldier(int id, int team, int score) {
			super();
			this.id = id;
			this.team = team;
			this.score = score;
		}
	}

	Map<Integer, Soldier>[] soldiers;

	public void init() {
		for (int i = 0; i < 6; i++) {
			soldiers[i] = new HashMap<>();
		}
	}

	public void hire(int mID, int mTeam, int mScore) { // 호출 횟수는 100,000 이하
		soldiers[mTeam].put(mID, new Soldier(mID, mTeam, mScore));
	}

	public void fire(int mID) { // 호출 횟수는 100,000 이하
		for (int i = 1; i <= 5; i++) {
			if (soldiers[i].containsKey(mID)) {
				soldiers[i].remove(mID);
			}
		}
	}

	public void updateSoldier(int mID, int mScore) { // 호출 횟수는 100,000 이하
		for (int i = 1; i <= 5; i++) {
			if (soldiers[i].containsKey(mID)) {
				soldiers[i].get(mID).score = mScore;
			}
		}
	}

	public void updateTeam(int mTeam, int mChangeScore) { // 호출 횟수는 100,000 이하
		for(int i=0;i<soldiers[mTeam].size();i++) {
			if (soldiers[mTeam].get(id).score + mChangeScore > 5) {
				soldiers.get(id).score = 5;
			} else if (soldiers.get(id).score + mChangeScore < 1) {
				soldiers.get(id).score = 1;
			} else {
				soldiers.get(id).score += mChangeScore;
			}
		}
		Soldier soldier = soldiersTeam.get(mTeam);
		soldiersId.get(soldier.id).score = mScore;
		soldiersTeam.get(soldier.team).score = mScore;

//		for (int id : soldiers.keySet().stream().mapToInt(Integer::intValue).toArray()) {
//			if (soldiers.get(id).team == mTeam) {
//				if (soldiers.get(id).score + mChangeScore > 5) {
//					soldiers.get(id).score = 5;
//				} else if (soldiers.get(id).score + mChangeScore < 1) {
//					soldiers.get(id).score = 1;
//				} else {
//					soldiers.get(id).score += mChangeScore;
//				}
//			}
//		}

//		for (int i = 1; i <= 100000; i++) {
//			if (soldiers[i] != null) {
//				if (soldiers[i].team == mTeam) {
//					if (soldiers[i].score + mChangeScore > 5) {
//						soldiers[i].score = 5;
//					} else if (soldiers[i].score + mChangeScore < 1) {
//						soldiers[i].score = 1;
//					} else {
//						soldiers[i].score += mChangeScore;
//					}
//				}
//			}
//		}
	}

	public int bestSoldier(int mTeam) { // 호출 횟수는 100 이하
		int maxIndex = 0;
		int max = 1;

		for (int id : soldiers.keySet().stream().mapToInt(Integer::intValue).toArray()) {
			if (soldiers.get(id).team == mTeam) {
				if (soldiers.get(id).team == mTeam) {
					if (max <= soldiers.get(id).score) {
						maxIndex = id;
						max = soldiers.get(id).score;
					}
				}
			}
		}

//		for (int i = 1; i <= 100000; i++) {
//			if (soldiers[i] != null) {
//				if (soldiers[i].team == mTeam) {
//					if (max <= soldiers[i].score) {
//						maxIndex = i;
//						max = soldiers[i].score;
//					}
//				}
//			}
//		}

		return maxIndex;
	}
}