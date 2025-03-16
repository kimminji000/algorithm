package swea.p5;

class UserSolution {
	static Team[] teams;
	static int[] version; // 병사들 버전관리
	static int[] soldierTeam; // 병사들 팀관리

	class Team {
		Soldier[] heads;
		Soldier[] tails;

		public Team() {
			heads = new Soldier[6];
			tails = new Soldier[6];
			
			for (int i = 1; i <= 5; i++) {
				heads[i] = tails[i] = new Soldier(0, 1);
			}
		}
	}

	class Soldier {
		int id;
		int ver;
		Soldier next;

		public Soldier(int id) {
			this(id, 1);
		}

		public Soldier(int id, int ver) {
			super();
			this.id = id;
			this.ver = ver;
			this.next = null;
		}
	}

	public void init() {
		teams = new Team[6];

		for (int i = 1; i <= 5; i++) {
			teams[i] = new Team();
		}

		version = new int[1000001];

		for (int i = 0; i <= 100000; i++) {
			version[i] = 1;
		}

		soldierTeam = new int[1000001];
	}

	public void hire(int mID, int mTeam, int mScore) { // 호출 횟수는 100,000 이하
		Team team = teams[mTeam];
		Soldier newSoldier = new Soldier(mID, version[mID]);

		team.tails[mScore].next = newSoldier;
		team.tails[mScore] = newSoldier;

		soldierTeam[mID] = mTeam;
	}

	public void fire(int mID) { // 호출 횟수는 100,000 이하
		version[mID] = -1;
	}

	public void updateSoldier(int mID, int mScore) { // 호출 횟수는 100,000 이하
		version[mID]++; 
		hire(mID, soldierTeam[mID], mScore); 
	}

	public void updateTeam(int mTeam, int mChangeScore) { // 호출 횟수는 100,000 이하
//		for(int i=0;i<soldiers[mTeam].size();i++) {
//			if (soldiers[mTeam].get(id).score + mChangeScore > 5) {
//				soldiers.get(id).score = 5;
//			} else if (soldiers.get(id).score + mChangeScore < 1) {
//				soldiers.get(id).score = 1;
//			} else {
//				soldiers.get(id).score += mChangeScore;
//			}
//		}
//		Soldier soldier = soldiersTeam.get(mTeam);
//		soldiersId.get(soldier.id).score = mScore;
//		soldiersTeam.get(soldier.team).score = mScore;

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

//		for (int id : soldiers.keySet().stream().mapToInt(Integer::intValue).toArray()) {
//			if (soldiers.get(id).team == mTeam) {
//				if (soldiers.get(id).team == mTeam) {
//					if (max <= soldiers.get(id).score) {
//						maxIndex = id;
//						max = soldiers.get(id).score;
//					}
//				}
//			}
//		}

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