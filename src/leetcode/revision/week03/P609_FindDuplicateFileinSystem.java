package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P609_FindDuplicateFileinSystem {

	public static void main(String[] args) {
		List<List<String>> l = findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"});
		for (List<String> list : l) {
			System.out.println(list);
		}

	}

	static public List<List<String>> findDuplicate(String[] paths) {
		if (paths.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String eachPath : paths) {
			String[] tokens = eachPath.split("\\s");
			String folderPath = tokens[0];
			for (int i = 1; i < tokens.length; i++) {
				String eachFile = tokens[i];

				int indexOfLeftParan = eachFile.indexOf('(');
				String fileName = eachFile.substring(0, indexOfLeftParan);
				String fileContent = eachFile.substring(indexOfLeftParan + 1, eachFile.length() - 1);
				if (map.containsKey(fileContent)) {
					List<String> l = map.get(fileContent);
					l.add(folderPath + "/" + fileName);
					map.put(fileContent, l);
				} else {
					List<String> l = new ArrayList<>();
					l.add(folderPath + "/" + fileName);
					map.put(fileContent, l);
				}
			}
		}

		List<List<String>> onlyDuplicates = new ArrayList<>();
		for (String eachFileContent : map.keySet()) {
			if (map.get(eachFileContent).size() > 1) {
				onlyDuplicates.add(map.get(eachFileContent));
			}
		}
		return onlyDuplicates;
	}
}
