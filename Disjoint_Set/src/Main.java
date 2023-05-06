// 기본적인 틀은 강의자료를 참고하여 구성하였음.
public class Main {

	public static void main(String[] args) {
		// 이름 출력
		System.out.println("milcho");

		// Disjoint Set 객체 생성 및 테스트 메소드 호출.
		MyDisjointSet set = new MyDisjointSet();
		set.test();
	}
}

class MyDisjointSet {
	// 멤버 변수 선언.
	private int n = 10; // 원소의 개수.
	private int[] parent; // 부모 노드를 저장할 배열.
	private int[] rank; // 트리의 높이(깊이)를 저장할 배열.
	private int[] representative; // 대표 노드(루트)를 저장할 배열.

	public MyDisjointSet() {
		// 생성자: 모든 멤버 변수 초기화
		parent = new int[n];
		rank = new int[n];
		representative = new int[n];
	}

	public void makeSet(int x) {
		// makeSet 메소드: x를 루트로 하는 새로운 트리를 생성한다.
		parent[x] = x;
		representative[x] = x;
	}

	public int findSet(int x) {
		// findSet 메소드: x가 속한 트리의 루트(대표 노드)를 찾아서 반환한다..
		if (parent[x] != x) {
			parent[x] = findSet(parent[x]); // 경로 압축
		}
		return parent[x];
	}

	public void union(int x, int y) {
		// union 메소드: x가 속한 트리와 y가 속한 트리를 합친다.
		int xRoot = findSet(x);
		int yRoot = findSet(y);

		if (xRoot == yRoot) { // x와 y가 일치할 경우 즉, 이미 같은 트리에 속한 경우
			return;
		}

		if (rank[xRoot] > rank[yRoot]) {
			// x가 속한 트리의 높이가 더 높은 경우 y를 x의 자식으로 둔다.
			parent[yRoot] = xRoot;
			representative[xRoot] = representative[yRoot];
		} else if (rank[xRoot] < rank[yRoot]) {
			// y가 속한 트리의 높이가 더 높은 경우 x를 y의 자식으로 둔다.
			parent[xRoot] = yRoot;
			representative[yRoot] = representative[xRoot];
		} else {
			// x와 y의 높이가 같은 경우 둘 중 아무거나 한 개를 선택해서 자식으로 설정하고 높이를 1 증가시킨다.
			parent[yRoot] = xRoot;
			representative[xRoot] = representative[yRoot];
			rank[xRoot]++;
		}
	}

	public void test() {
		// n개의 원소를 가진 집합을 생성하고, 초기화.
		for (int i = 0; i < n; i++) {
			makeSet(i);
		}

		// 초기 집합 상태를 출력.
		System.out.print("부모 = ");
		for (int i = 0; i < n; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();

		// 원소를 하나씩 연결하면서 집합을 합침.(union)
		union(0, 1);
		union(2, 0);
		union(3, 2);
		union(4, 3);
		union(5, 6);
		union(7, 8);
		union(5, 7);

		// 연결한 후의 집합 상태를 출력.
		System.out.print("부모 = ");
		for (int i = 0; i < n; i++) {
			// i번째 원소의 대표 노드를 찾고(parent[i]를 갱신) 대표 노드의 번호를 출력한다.(즉, findSet 메소드를 호출한다.)
			System.out.print(findSet(i) + " ");
		}
		System.out.println();

		// 각 원소의 대표 노드(집합의 대표 원소)를 출력한다.
		System.out.print("대표 노드 = ");
		for (int i = 0; i < n; i++) {
			System.out.print(representative[i] + " ");
		}
		System.out.println();

		// 다시 각 원소의 대표 노드를 찾고(parent[i]를 갱신) 대표 노드의 번호를 출력한다.(다시 findSet 메소드를 호출한다.)
		System.out.print("부모 = ");
		for (int i = 0; i < n; i++) {
			findSet(i);
			System.out.print(parent[i] + " ");
		}
		System.out.println();
	}
}