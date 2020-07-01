package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Prob1496_PathCrossing {

	public static void main(String[] args) {
		System.out.println(isPathCrossing("NES"));
		System.out.println(isPathCrossing("NESWW"));
	}

	static public boolean isPathCrossing(String path) {
		Point p = new Point(0, 0);
		Set<Point> set = new HashSet<>();

		set.add(p);
		
		for (char c : path.toCharArray()) {
			switch (c) {
			case 'N':
				p = new Point(p.i, p.j + 1);
				break;
			case 'S':
				p = new Point(p.i, p.j - 1);
				break;
			case 'E':
				p = new Point(p.i + 1, p.j);
				break;
			case 'W':
				p = new Point(p.i - 1, p.j);
				break;
			}
			if (set.contains(p)) {
				return true;
			} else {
				set.add(p);
			}
		}
		return false;
	}
}

class Point {
	int i;
	int j;

	public Point(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}

}
