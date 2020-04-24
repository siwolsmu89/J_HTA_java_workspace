package oop2;

import java.util.Scanner;

public class Student {
	String studentName;
	int classNo;
	int studentNo;
	int kor;
	int eng;
	int math;

	int getTotalScore() {
		int getTotalScore = kor + eng + math;

		return getTotalScore;
	}

	int getAvgScore() {
		int getAvgScore = (int) (getTotalScore() / 3);

		return getAvgScore;
	}

	void printStudentsInfo() {
		System.out.print(studentName + "\t");
		System.out.print(classNo + "\t");
		System.out.print(studentNo + "\t");
		System.out.print(kor + "\t");
		System.out.print(eng + "\t");
		System.out.print(math + "\t");
		System.out.print(getTotalScore() + "\t");
		System.out.println(getAvgScore());
	}

	String insertName(String name){
		studentName = name;
		
		return studentName;
	}
	
	int insertClassNo(int no) {
		classNo = no;
		return classNo;
		
	}
}
