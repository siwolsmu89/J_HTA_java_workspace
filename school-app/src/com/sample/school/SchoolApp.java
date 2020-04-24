package com.sample.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sample.school.exception.ErrorCode;
import com.sample.school.exception.SchoolException;
import com.sample.school.service.SchoolService;
import com.sample.school.service.SchoolServiceImple;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolApp {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private static int nextInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (IOException e) {
			return 0;
		}
	}

	private static String next() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "";
		}
	}

	public static void main(String[] args) {
		ErrorCode code = new ErrorCode();
		SchoolService service = new SchoolServiceImple();
		System.out.println("========================================");
		System.out.println("[학사 관리 프로그램]");

		while (true) {
			try {
				System.out.println("========================================");
				System.out.println("1.교수 서비스    2.학생 서비스    0.종료 ");
				System.out.println("========================================");
				System.out.print("원하는 메뉴를 선택하세요: ");
				int menuUser = nextInt();
				if (menuUser == 1) {
					System.out.println("========================================");
					System.out.println("1.신규등록  2.과목등록  3.과목조회  4.과정개설");
					System.out.println("5.과정조회  6.신청조회  7.성적입력  0.처음으로");
					System.out.println("========================================");
					
					System.out.print("메뉴를 선택하세요: ");
					int menuNo = nextInt();

					if (menuNo == 0) {
						System.out.println("========================================");
						System.out.println("[첫 화면으로 돌아갑니다.]");
						continue;
					} else if (menuNo == 1) {
						System.out.println("----------------------------------------");
						System.out.println("[신규 교수 등록]");

						System.out.print("이름을 입력하세요: ");
						String name = next();
						System.out.print("이메일을 입력하세요: ");
						String email = next();
						System.out.print("학과명을 입력하세요: ");
						String dept = next();
						System.out.print("직위를 입력하세요: ");
						String position = next();
						System.out.print("급여를 입력하세요: ");
						int salary = nextInt();

						Professor professor = new Professor(name, email, dept, position, salary);
						service.addNewProfessor(professor);
					} else if (menuNo == 2) {
						System.out.println("----------------------------------------");
						System.out.println("[신규 과목 등록]");
						System.out.print("과목명을 입력하세요: ");
						String title = next();
						System.out.print("학과를 입력하세요: ");
						String dept = next();
						System.out.print("학점을 입력하세요: ");
						int credit = nextInt();

						Subject subject = new Subject(title, dept, credit);
						service.addNewSubject(subject);
					} else if (menuNo == 3) {
						System.out.println("[학과 과목 조회]");
						System.out.print("교수번호를 입력하세요: ");
						int professorNo = nextInt();

						service.displayAllSubjectsOfDeptByProfessorNo(professorNo);
					} else if (menuNo == 4) {
						System.out.println("----------------------------------------");
						System.out.println("[신규 과정 개설]");
						System.out.print("과정명을 입력하세요: ");
						String name = next();
						System.out.print("과목번호를 입력하세요: ");
						int subjectNo = nextInt();
						System.out.print("담당교수번호를 입력하세요: ");
						int professorNo = nextInt();
						System.out.print("정원을 입력하세요: ");
						int quota = nextInt();

						Course course = new Course(name, subjectNo, professorNo, quota);
						service.addNewCourse(course);
					} else if (menuNo == 5) {
						System.out.println("----------------------------------------");
						System.out.println("[개설 과정 조회]");
						System.out.print("담당교수번호를 입력하세요: ");
						int professorNo = nextInt();

						service.displayCoursesByProfessorNo(professorNo);
					} else if (menuNo == 6) {
						System.out.println("----------------------------------------");
						System.out.println("[수강 신청자 조회]");
						System.out.print("담당교수번호를 입력하세요: ");
						int professorNo = nextInt();
						System.out.print("개설과정번호를 입력하세요: ");
						int courseNo = nextInt();

						service.displayRegisteredByProfessorNo(professorNo, courseNo);
					} else if (menuNo == 7) {
						System.out.println("----------------------------------------");
						System.out.println("[학생 성적 입력]");
						System.out.print("담당교수번호를 입력하세요: ");
						int professorNo = nextInt();
						System.out.print("과정등록번호를 입력하세요: ");
						int registrationNo = nextInt();
						System.out.print("점수를 입력하세요: ");
						int score = nextInt();

						service.addNewScore(professorNo, registrationNo, score);
					} 
				} else if (menuUser == 2) {
					System.out.println("========================================");
					System.out.println("1.신규등록  2.과목조회  3.과정조회  4.수강신청");
					System.out.println("5.신청현황  6.신청취소  7.성적확인  0.처음으로");
					System.out.println("========================================");

					System.out.print("메뉴를 선택하세요: ");
					int menuNo = nextInt();

					if (menuNo == 0) {
						System.out.println("========================================");
						System.out.println("[첫 화면으로 돌아갑니다.]");
						continue;
					} else if (menuNo == 1) {
						System.out.println("----------------------------------------");
						System.out.println("[신규 학생 등록]");
						System.out.print("이름을 입력하세요: ");
						String name = next();
						System.out.print("이메일을 입력하세요: ");
						String email = next();
						System.out.print("학과명을 입력하세요: ");
						String dept = next();
						System.out.print("학년을 입력하세요: ");
						int grade = nextInt();

						Student student = new Student(name, email, dept, grade);
						service.addNewStudent(student);
					} else if (menuNo == 2) {
						System.out.println("----------------------------------------");
						System.out.println("[과목 조회]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						
						service.displayAllSubjectsOfDeptByStudentNo(studentNo);
					} else if (menuNo == 3) {
						System.out.println("----------------------------------------");
						System.out.println("[개설 과정 조회]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						
						service.displayCoursesByStudentNo(studentNo);
					} else if (menuNo == 4) {
						System.out.println("----------------------------------------");
						System.out.println("[수강 신청]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						System.out.print("개설 과정 번호를 입력하세요: ");
						int courseNo = nextInt();
						
						service.registerForCourse(studentNo, courseNo);
					} else if (menuNo == 5) {
						System.out.println("----------------------------------------");
						System.out.println("[수강 신청 현황 조회]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						
						service.displayRegisteredByStudentNo(studentNo);
					} else if (menuNo == 6) {
						System.out.println("----------------------------------------");
						System.out.println("[수강 신청 취소]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						System.out.print("수강 신청 번호를 입력하세요: ");
						int registrationNo = nextInt();
						
						service.cancelRegistration(studentNo, registrationNo);
					} else if (menuNo == 7) {
						System.out.println("----------------------------------------");
						System.out.println("[성적 조회]");
						System.out.print("학번을 입력하세요: ");
						int studentNo = nextInt();
						
						service.displayScoreByStudentNo(studentNo);
					}
				} else if (menuUser == 0) {
					System.out.println("----------------------------------------");
					System.out.println("[프로그램 종료]");
					System.out.println("좋은 하루 보내세요.");
					System.out.println("----------------------------------------");
					System.out.println("========================================");
					break;
				}
			} catch (SchoolException e) {
				String errorCode = e.getErrorCode();
				String errorDescription = code.getDescription(errorCode);
				System.err.println("[" + errorCode + "] -> " + errorDescription);
			} catch (Exception e) {
				String errorCode = "ERROR_000";
				String errorDescription = code.getDescription(errorCode);
				System.err.println("[" + errorCode + "] -> " + errorDescription);
			}
		}

	}

}
