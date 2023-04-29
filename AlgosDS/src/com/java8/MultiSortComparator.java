package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSortComparator {

	public static void main(String[] args) {

		String[] data = new String[] { "Alan Rob 92 07MRT233", "Nevil Botton 80 07MRT001", "Nevil Botton 80 07MRT002",
				"Clinton Brooks 83 07MRT236", "Aaron Billy 92 07MRT231",  };
		MultiSortComparator msc = new MultiSortComparator();
		List<Student> students = msc.parse(data);

		
		Collections.sort(students, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				int markedSorted = s2.mark.compareTo(s1.mark);
				if (markedSorted == 0) {
					int nameSorted = s2.fName.compareTo(s1.fName);
					if (nameSorted == 0) {
						return s2.id.compareTo(s1.id);
					}
					return markedSorted;
				}
				return markedSorted;
			}
		});
		 
		
		List<Student> sortedStudents = students.stream()
				.sorted(Comparator.comparingInt(Student::getMark).reversed().thenComparing(
						Comparator.comparing(Student::getfName).thenComparing(Comparator.comparing(Student::getId).reversed())))
				.collect(Collectors.toList());

		for (Student std : sortedStudents) {
			System.out.println(std);
		}

	}

	class Student {

		public String getfName() {
			return fName;
		}

		public void setfName(String fName) {
			this.fName = fName;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		public Integer getMark() {
			return mark;
		}

		public void setMark(Integer mark) {
			this.mark = mark;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		private String fName;
		private String lName;
		private Integer mark;
		private String id;

		public String toString() {
			return "Student [ Mark=" + mark + ", fName=" + fName + ",lName=" + lName + ", ID" + id + "]";
		}
	}

	List<Student> parse(String[] data) {

		List<Student> stdList = new ArrayList<Student>();
		for (String details : data) {

			String[] students = details.split(" ");
			Student std = this.new Student();
			System.out.println(Arrays.asList(students));
			std.fName = students[0];
			std.lName = students[1];
			std.mark = Integer.valueOf(students[2]);
			std.id = students[3];
			stdList.add(std);

		}
		return stdList;
	}

}
