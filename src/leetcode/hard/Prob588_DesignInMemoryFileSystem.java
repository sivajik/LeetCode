package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob588_DesignInMemoryFileSystem {

	public static void main(String[] args) {
		FileSystem f = new FileSystem();
		f.ls("/");
		f.mkdir("/a/b/c");
		f.addContentToFile("/a/b/c/d", "hello");
		System.out.println(f.ls("/"));
		System.out.println(f.readContentFromFile("/a/b/c/d"));

	}

	static class FileSystem {
		class Dir {
			Map<String, Dir> dirs = new HashMap<>(); // dir name and its child obj
			Map<String, String> files = new HashMap<>(); // file and its content
		}

		Dir root;

		public FileSystem() {
			this.root = new Dir();
		}

		public List<String> ls(String path) {
			Dir t = root;
			List<String> listOfFiles = new ArrayList<>();

			if (!path.equals("/")) {
				String[] d = path.split("/");
				for (int i = 1; i < d.length - 1; i++) {
					t = t.dirs.get(d[i]);
				}

				if (t.files.containsKey(d[d.length - 1])) {
					listOfFiles.add(d[d.length - 1]);
					return listOfFiles;
				} else {
					t = t.dirs.get(d[d.length - 1]);
				}
			}

			listOfFiles.addAll(new ArrayList<>(t.dirs.keySet()));
			listOfFiles.addAll(new ArrayList<>(t.files.keySet()));
			Collections.sort(listOfFiles);
			return listOfFiles;
		}

		public void mkdir(String path) {
			Dir t = root;
			String[] d = path.split("/");
			for (int i = 1; i < d.length; i++) {
				String eachToken = d[i];
				if (!t.dirs.containsKey(eachToken)) {
					t.dirs.put(eachToken, new Dir());
				}
				t = t.dirs.get(eachToken);
			}
		}

		public void addContentToFile(String filePath, String content) {
			Dir t = root;
			String[] tokens = filePath.split("/");
			for (int i = 1; i < tokens.length - 1; i++) {
				t = t.dirs.get(tokens[i]);
			}
			t.files.put(tokens[tokens.length - 1], t.files.getOrDefault(tokens[tokens.length - 1], "") + content);
		}

		public String readContentFromFile(String filePath) {
			Dir t = root;
			String[] tokens = filePath.split("/");
			for (int i = 1; i < tokens.length - 1; i++) {
				t = t.dirs.get(tokens[i]);
			}
			return t.files.get(tokens[tokens.length - 1]);
		}
	}
}
