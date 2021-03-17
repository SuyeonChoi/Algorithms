import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class p1767 {
	static int N;
	static int[][] lexi;
	static LinkedList<Node> core;
	static int minLines;
	static int maxinstalledCore;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// inputs
			N = Integer.parseInt(br.readLine());
			lexi = new int[N][N];
			core = new LinkedList<>();
			minLines = Integer.MAX_VALUE;
			maxinstalledCore = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					lexi[i][j] = Integer.parseInt(st.nextToken());
					if (lexi[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
						core.add(new Node(i, j));
					}
				}
			}
			boolean[][] vis = new boolean[N][N];
			dfs(0, vis, 0);
			System.out.println("#" + t + " " + minLines);
		}
	}

	private static void dfs(int cnt, boolean[][] vis, int installedCore) {
		// TODO Auto-generated method stub
		if (cnt == core.size()) {
			if(maxinstalledCore > installedCore) {
				return;
			}
			calcLine(vis, installedCore);
		} else {
			int x = core.get(cnt).x;
			int y = core.get(cnt).y;

			if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
				// 가장자리의 경우 계산 따로 안함
				dfs(cnt + 1, vis, installedCore + 1);
			} else {
				// 위쪽전선 설치 확인
				if (dfsUp(x - 1, y, vis)) {
					// 설치
					for (int i = 1; i < N; i++) {
						if (x - i < 0)
							break;
						vis[x - i][y] = true;
					}
					dfs(cnt + 1, vis, installedCore + 1);
					// 설치 취소
					for (int i = 1; i < N; i++) {
						if (x - i < 0)
							break;
						vis[x - i][y] = false;
					}
				}
				// 아래쪽전선 설치 확인
				if (dfsDown(x + 1, y, vis)) {
					// 설치
					for (int i = 1; i < N; i++) {
						if (x + i >= N)
							break;
						vis[x + i][y] = true;
					}
					dfs(cnt + 1, vis, installedCore + 1);
					for (int i = 1; i < N; i++) {
						if (x + i >= N)
							break;
						vis[x + i][y] = false;
					}
				}
				// 왼쪽전선 설치 확인
				if (dfsLeft(x, y - 1, vis)) {
					// 설치
					for (int i = 1; i < N; i++) {
						if (y - i < 0)
							break;
						vis[x][y - i] = true;
					}
					dfs(cnt + 1, vis, installedCore + 1);
					for (int i = 1; i < N; i++) {
						if (y - i < 0)
							break;
						vis[x][y - i] = false;
					}
				}
				// 오른쪽전선 설치 확인
				if (dfsRight(x, y + 1, vis)) {
					// 설치
					for (int i = 1; i < N; i++) {
						if (y + i >= N)
							break;
						vis[x][y + i] = true;
					}
					dfs(cnt + 1, vis, installedCore + 1);
					for (int i = 1; i < N; i++) {
						if (y + i >= N)
							break;
						vis[x][y + i] = false;
					}
				}
				// 설치 안함
				dfs(cnt + 1, vis, installedCore);
			}
		}

	}

	private static boolean dfsDown(int x, int y, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (x >= N)
			return true;
		if (lexi[x][y] == 0 && !visited[x][y]) {
			return dfsDown(x + 1, y, visited);
		} else {
			return false;
		}
	}

	private static boolean dfsUp(int x, int y, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (x < 0)
			return true;
		if (lexi[x][y] == 0 && !visited[x][y]) {
			return dfsUp(x - 1, y, visited);
		} else {
			return false;
		}
	}

	private static boolean dfsLeft(int x, int y, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (y < 0)
			return true;
		if (lexi[x][y] == 0 && !visited[x][y]) {
			return dfsLeft(x, y - 1, visited);
		} else {
			return false;
		}
	}

	private static boolean dfsRight(int x, int y, boolean[][] visited) {
		// TODO Auto-generated method stub
		if (y >= N)
			return true;
		if (lexi[x][y] == 0 && !visited[x][y]) {
			return dfsRight(x, y + 1, visited);
		} else {
			return false;
		}
	}

	// 최종 사용된 전선 길이 구하기
	private static void calcLine(boolean[][] vis, int installedCore) {
		// TODO Auto-generated method stub
		
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (vis[i][j]) {
					sum++;
				}
			}
		}
		if(maxinstalledCore < installedCore) {
			minLines = sum;
			maxinstalledCore = installedCore;
		}else if(maxinstalledCore == installedCore) {
			minLines = Math.min(sum, minLines);
		}
	}
}
