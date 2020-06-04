package leetcode.easy;

public class Prob690_EmployeeImportance {

	public static void main(String[] args) {
		java.util.List<Employee> emps = new java.util.ArrayList<Employee>();

		java.util.List<Integer> e1Subs = new java.util.ArrayList<>();
		e1Subs.add(2);
		e1Subs.add(3);
		emps.add(new Employee(1, 5, e1Subs));

		emps.add(new Employee(2, 3, new java.util.ArrayList<>()));

		emps.add(new Employee(3, 3, new java.util.ArrayList<>()));

		System.out.println(getImportance(emps, 1));

	}

	static public int getImportance(java.util.List<Employee> employees, int id) {
		int ans = 0;

		java.util.Map<Integer, Employee> map = new java.util.HashMap<>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}

		java.util.Queue<Employee> q = new java.util.LinkedList<>();
		q.add(map.get(id));

		while (!q.isEmpty()) {
			Employee e = q.poll();
			ans += e.importance;

			for (Integer subId : e.subordinates) {
				q.add(map.get(subId));
			}
		}
		return ans;
	}

	static class Employee {
		public int id;
		public int importance;
		public java.util.List<Integer> subordinates;

		public Employee(int id, int importance, java.util.List<Integer> subordinates) {
			super();
			this.id = id;
			this.importance = importance;
			this.subordinates = subordinates;
		}

	};
}
