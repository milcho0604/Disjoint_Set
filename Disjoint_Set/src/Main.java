// 기본 틀은 학교 강의자료를 바탕으로 작성하였음.
public class Main {
	public static void main(String[] args) {
		System.out.println("milcho");

// 상호배타적 집합을 구현하는 MyDisjointSet 객체를 생성하고 테스트 연산을 수행.
		MyDisjointSet set = new MyDisjointSet();
		set.test();
	}
}

// 트리를 이용하여 상호배타적 집합을 구현하는 클래스를 구현할 것.
class MyDisjointSet {
	private int n = 10; // 원소 개수(원소는 0, 1, 2, ..., n-1)

	private int[] parent;

	public MyDisjointSet() { // 트리 구현을 위해 필요한 자료구조를 초기화
		parent = new int[n];
	}

// 하나의 원소 x로 구성된 집합을 생성하기 위한 메소드.
	public void makeSet(int x) {
		parent[x] = x;
	}

// x의 대표 원소를 알아내기 위한 메소드.
	public int findSet(int x) {
		return 0;
	}

// x가 속한 집합과 y가 속한 집합을 합치기 위한 메소드.
	public void union(int x, int y) {
	}

	public void test() {// 트리의 구현이 올바른지 테스트하기 위한 연산을 수행.
// 각 원소(0, 1, 2, ..., 9)마다 하나의 노드로 구성된 집합 생성(makeSet) - 총 10개의 집합 생성
		for (int i = 0; i < parent.length; i++) {
			makeSet(i);
		}
// 트리 구현이 제대로 되었는지 확인하기 위해 각 노드의 부모를 반복문을 이용하여 출력.
		System.out.print("parent: ");
		for (int i = 0; i < parent.length; i++) {
			System.out.print(parent[i] + " ");
		}
	}
}
