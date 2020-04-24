package com.sample.school.service;

import com.sample.school.exception.SchoolException;
import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.repository.StudentRepository;
import com.sample.school.vo.*;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	private StudentRepository studentRepo = new StudentRepository();

	public void processError(String errorCode) {
		throw new SchoolException(errorCode);
	}

	public void addNewProfessor(Professor professor) {
		Professor[] allProfs = professorRepo.getAllProfessor();

		if (allProfs == null) {
			processError("ERROR_001");
		}

		String email = professor.getEmail();
		for (Professor prof : allProfs) {
			if (email.equals(prof.getEmail())) {
				processError("ERROR_PROF_02");
			}
		}

		professorRepo.insertProfessor(professor);
		System.out.println("----------------------------------------");
		System.out.println("신규 교수[" + professor.getName() + "] 등록 완료");
		System.out.println("교수번호: " + professor.getNo());
		System.out.println("----------------------------------------");
	}

	public void addNewSubject(Subject subject) {
		Subject[] allSubs = subjectRepo.getAllSubject();

		if (allSubs == null) {
			processError("ERROR_001");
		}

		String title = subject.getTitle();
		for (Subject sub : allSubs) {
			if (title.equals(sub.getTitle())) {
				processError("ERROR_SUBJ_02");
			}
		}

		subjectRepo.insertSubject(subject);
		System.out.println("----------------------------------------");
		System.out.println("신규 과목 [" + subject.getTitle() + "] 등록 완료");
		System.out.println("과목번호: " + subject.getNo());
		System.out.println("----------------------------------------");
	}

	public void displayAllSubjectsOfDeptByProfessorNo(int professorNo) {
		Professor[] allProfs = professorRepo.getAllProfessor();
		String dept = null;

		if (allProfs == null) {
			processError("ERROR_001");
		}

		for (Professor prof : allProfs) {
			if (professorNo == prof.getNo()) {
				dept = prof.getDept();
			}
		}

		if (dept == null) {
			processError("ERROR_PROF_01");
		}

		Subject[] allSubs = subjectRepo.getAllSubject();
		if (allSubs == null) {
			processError("ERROR_001");
		}

		System.out.println("----------------------------------------");
		System.out.println("[" + dept + "] 학과 과목 정보 조회");
		System.out.println("----------------------------------------");
		System.out.println("과목번호 학점   과목명  ");
		System.out.println("----------------------------------------");
		for (Subject sub : allSubs) {
			if (dept.equals(sub.getDept())) {
				System.out.print(sub.getNo() + "\t");
				System.out.print(sub.getCredit() + "     ");
				System.out.println(sub.getTitle());
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("[" + dept + "] 학과 과목 조회 완료");
		System.out.println("----------------------------------------");
	}

	public void addNewCourse(Course course) {
		int subjectNo = course.getSubjectNo();
		Subject subject = subjectRepo.getSubjectByNo(subjectNo);

		if (subject == null) {
			processError("ERROR_SUBJ_01");
		}
		
		String dept = subject.getDept();
		int professorNo = course.getProfessorNo();
		Professor professor = professorRepo.getProfessorByNo(professorNo);
		if (professor == null) {
			processError("ERROR_PROF_01");
		}

		if (!(dept.equals(professor.getDept()))) {
			processError("ERROR_002");
		}

		courseRepo.insertCourse(course);
		System.out.println("----------------------------------------");
		System.out.println("[" + course.getName() + "] 과정 개설이 완료되었습니다.");
		System.out.println("과정번호: " + course.getNo());
		System.out.println("----------------------------------------");
	}

	public void displayCoursesByProfessorNo(int professorNo) {
		Professor professor = professorRepo.getProfessorByNo(professorNo);
		if (professor == null) {
			processError("ERROR_PROF_01");
		}

		Course[] allCourses = courseRepo.getAllCourse();
		if (allCourses == null) {
			processError("ERROR_001");
		}
		
		System.out.println("----------------------------------------");
		System.out.println("[" + professor.getName() + "] 교수님의 개설 과정");
		System.out.println("과정번호  정원   과정명");
		System.out.println("----------------------------------------");
		Course course = null;
		for (Course cour : allCourses) {
			if (professorNo == cour.getProfessorNo()) {
				course = cour;
				System.out.print(cour.getNo() + "\t");
				System.out.print(cour.getQuota() + "\t");
				System.out.println(cour.getName());
			}
		}
		if (course == null) {
			processError("ERROR_COUR_02");
		}
		System.out.println("----------------------------------------");
		System.out.println("개설 과정 조회 완료");
		System.out.println("----------------------------------------");
	}

	public void displayRegisteredByProfessorNo(int professorNo, int courseNo) {
		Course course = courseRepo.getCourseByNo(courseNo);
		if (course == null) {
			processError("ERROR_COUR_01");
		}
		
		Professor professor = professorRepo.getProfessorByNo(professorNo);
		if (professor == null) {
			processError("ERROR_PROF_01");
		}
		if (professorNo != course.getProfessorNo()) {
			processError("ERROR_002");
		}

		Registration[] allRegists = registrationRepo.getAllRegistrations();
		if (allRegists == null) {
			processError("ERROR_001");
		}
		
		int subjectNo = course.getSubjectNo();
		Subject subject = subjectRepo.getSubjectByNo(subjectNo);
		System.out.println("[" + course.getName() + "]");
		System.out.println("----------------------------------------");
		System.out.println("과목코드: " + course.getNo());
		System.out.println("과목명  : " + subject.getTitle());
		System.out.println("과정명  : " + course.getName());
		System.out.println("정원    : " + course.getQuota());
		System.out.println("----------------------------------------");

		Registration registration = null;
		System.out.println("[" + course.getName() + "] 과정 신청자 조회");
		System.out.println("----------------------------------------");
		System.out.println(" 학번       이름        상태    학년  학과");
		System.out.println("----------------------------------------");
		for (Registration reg : allRegists) {
			if (course.getNo() == reg.getCourseNo()) {
				registration = reg;
				String isCancle;
				int studentNo = reg.getStudentNo();
				Student student = studentRepo.getStudentByNo(studentNo);
				if (reg.getIsCancle()) {
					isCancle = "취  소";
				} else {
					isCancle = "신청중";
				}
				System.out.print(studentNo + "\t");
				System.out.print(student.getName() + "\t");
				System.out.print(isCancle + "   ");
				System.out.print(student.getGrade() + "   ");
				System.out.println(student.getDept());
			}
		}

		if (registration == null) {
			processError("ERROR_RGST_02");
		}
		
		System.out.println("----------------------------------------");
		System.out.println("신청 내역 조회 완료");
		System.out.println("----------------------------------------");
	}

	public void addNewScore(int professorNo, int registrationNo, int score) {
		Registration registration = registrationRepo.getRegistrationByNo(registrationNo);
		if (registration == null) {
			processError("ERROR_RGST_01");
		}

		int courseNo = registration.getCourseNo();
		Course course = courseRepo.getCourseByNo(courseNo);
		if (course == null) {
			processError("ERROR_COUR_01");
		}

		if (professorNo != course.getProfessorNo()) {
			processError("ERROR_002");
		}

		if (registration.getIsCancle()) {
			processError("ERROR_RGST_03");
			return;
		}

		registration.setScore(score);
		registration.setCredit(score);
		System.out.println("----------------------------------------");
		System.out.println("과정등록번호 [" + registrationNo + "]에 성적 정보를 입력합니다.");
		System.out.println("성적 입력 완료");
		System.out.println("입력된 성적: " + registration.getScore() + "(" + registration.getCredit() + ")");
		System.out.println("----------------------------------------");
	}

	public void addNewStudent(Student student) {
		Student[] allStdnts = studentRepo.getAllStudents();

		if (allStdnts == null) {
			processError("ERROR_001");
		}

		String email = student.getEmail();
		for (Student stud : allStdnts) {
			if (email.equals(stud.getEmail())) {
				processError("ERROR_STUD_02");
			}
		}

		studentRepo.insertStudent(student);
		System.out.println("학생 [" + student.getName() + "] 정보 등록 완료");
		System.out.println("학번: " + student.getNo());
		System.out.println("----------------------------------------");
	}

	public void displayAllSubjectsOfDeptByStudentNo(int studentNo) {
		Student[] allStdnts = studentRepo.getAllStudents();
		String dept = null;

		if (allStdnts == null) {
			processError("ERROR_001");
		}

		for (Student stud : allStdnts) {
			if (studentNo == stud.getNo()) {
				dept = stud.getDept();
			}
		}

		if (dept == null) {
			processError("ERROR_STUD_01");
		}

		Subject[] allSubs = subjectRepo.getAllSubject();
		if (allSubs == null) {
			processError("ERROR_001");
		}

		System.out.println("----------------------------------------");
		System.out.println("[" + dept + "] 학과 과목 정보 조회");
		System.out.println("----------------------------------------");
		System.out.println("과목번호 학점   과목명  ");
		System.out.println("----------------------------------------");
		for (Subject sub : allSubs) {
			if (dept.equals(sub.getDept())) {
				System.out.print(sub.getNo() + "\t");
				System.out.print(sub.getCredit() + "     ");
				System.out.println(sub.getTitle());
			}
		}
		System.out.println("----------------------------------------");
		System.out.println("[" + dept + "] 학과 과목 조회 끝");
		System.out.println("----------------------------------------");
	}

	@Override
	public void displayCoursesByStudentNo(int studentNo) {
		Student student = studentRepo.getStudentByNo(studentNo);
		if (student == null) {
			processError("ERROR_STUD_01");
		}
		String dept = student.getDept();
		
		Course[] allCourses = courseRepo.getAllCourse();
		if (allCourses == null) {
			processError("ERROR_001");
		}
		System.out.println("----------------------------------------");
		System.out.println("[" + student.getDept() + "] 학과의 개설 과정 조회");
		System.out.println("----------------------------------------");
		System.out.println("과정번호  정원    과정명");
		System.out.println("----------------------------------------");

		Course course = null;
		for (Course cour : allCourses) {
			int subjectNo = cour.getSubjectNo();
			Subject subject = subjectRepo.getSubjectByNo(subjectNo);
			if (dept.equals(subject.getDept())) {
				course = cour;
				System.out.print(course.getNo() + "\t");
				System.out.print(course.getQuota() + "\t");
				System.out.println(course.getName());
			}
		}
		if (course == null) {
			processError("ERROR_COUR_02");
		}
		System.out.println("----------------------------------------");
		System.out.println("개설 과정 조회를 마칩니다.");
		System.out.println("----------------------------------------");
	}

	public void registerForCourse(int studentNo, int courseNo) {
		Student student = studentRepo.getStudentByNo(studentNo);
		if (student == null) {
			processError("ERROR_STUD_01");
		}
		String dept = student.getDept();
		Course course = courseRepo.getCourseByNo(courseNo);
		if (course == null) {
			processError("ERROR_COUR_01");
		}

		int count = 0;
		Registration[] allRegists = registrationRepo.getAllRegistrations();
		for (Registration reg : allRegists) {
			if (courseNo == reg.getCourseNo() && !reg.getIsCancle()) {
				count++;
			}
		}
		if (count == course.getQuota()) {
			processError("ERROR_COUR_03");
			return;
		}

		int subjectNo = course.getSubjectNo();
		Subject subject = subjectRepo.getSubjectByNo(subjectNo);

		if (!(dept.equals(subject.getDept()))) {
			processError("ERROR_002");
		}

		Registration registration = new Registration(studentNo, courseNo, false, 0);
		registrationRepo.insertRegistration(registration);
		count++;
		System.out.println("----------------------------------------");
		System.out.println("수강신청이 완료되었습니다.");
		System.out.println("신청번호: " + registration.getNo());
		System.out.println("신청 인원/전체 수강 신청 인원:   " + count + "/" + course.getQuota());
		System.out.println("----------------------------------------");
	}

	public void displayRegisteredByStudentNo(int studentNo) {
		Student student = studentRepo.getStudentByNo(studentNo);
		if (student == null) {
			processError("ERROR_STUD_01");
		}

		Registration[] allRegists = registrationRepo.getAllRegistrations();
		if (allRegists == null) {
			processError("ERROR_001");
		}
		
		System.out.println("----------------------------------------");
		System.out.println("[" + student.getName() + "] 학생 수강 신청 내역 조회");
		System.out.println("----------------------------------------");
		System.out.println("신청번호  상태    과정명");
		System.out.println("----------------------------------------");
		for (Registration reg : allRegists) {
			if (studentNo == reg.getStudentNo()) {
				int courseNo = reg.getCourseNo();
				Course course = courseRepo.getCourseByNo(courseNo);
				String courseName = course.getName();

				System.out.print(reg.getNo() + "    ");
				System.out.print(reg.getIsCancle() + "    ");
				System.out.println(courseName);
			}
		}
		
		System.out.println("----------------------------------------");
		System.out.println("수강 신청 내역 조회 완료");
		System.out.println("----------------------------------------");
	}

	public void cancelRegistration(int studentNo, int registrationNo) {
		Student student = studentRepo.getStudentByNo(studentNo);
		if (student == null) {
			processError("ERROR_STUD_01");
		}

		Registration registration = registrationRepo.getRegistrationByNo(registrationNo);
		if (registration == null) {
			processError("ERROR_001");
		}
		if (!(studentNo == registration.getStudentNo())) {
			processError("ERROR_002");
		}

		registration.setIsCancle(true);

		int courseNo = registration.getCourseNo();
		Course course = courseRepo.getCourseByNo(courseNo);
		String courseName = course.getName();
		System.out.println("----------------------------------------");
		System.out.println("[" + courseName + "] 과정의 신청이 취소되었습니다.");
		System.out.println("----------------------------------------");
	}

	public void displayScoreByStudentNo(int studentNo) {
		Registration[] allRegists = registrationRepo.getAllRegistrations();
		if (allRegists == null) {
			processError("ERROR_001");
		}

		Student student = studentRepo.getStudentByNo(studentNo);
		if (student == null) {
			processError("ERROR_STUD_01");
		}

		System.out.println("----------------------------------------");
		System.out.println(student.getDept() + " [" + student.getName() + "] 학생 성적 조회");
		System.out.println("----------------------------------------");
		System.out.println("과목코드       성적      학점      담당교수   과목명(과정명)");
		System.out.println("----------------------------------------");
		int sumScore = 0;
		int subCount = 0;
		for (Registration reg : allRegists) {
			if (studentNo == reg.getStudentNo()) {
				if (reg.getIsCancle()) {
					continue;
				}
				int courseNo = reg.getCourseNo();
				Course course = courseRepo.getCourseByNo(courseNo);
				int subjectNo = course.getSubjectNo();
				Subject subject = subjectRepo.getSubjectByNo(subjectNo);
				int professorNo = course.getProfessorNo();
				Professor professor = professorRepo.getProfessorByNo(professorNo);
				String courseName = course.getName();
				int score = reg.getScore();
				System.out.print(subject.getNo() + "     ");
				System.out.print(score + "    ");
				System.out.print(reg.getCredit() + "     ");
				System.out.print(professor.getName() + "     ");
				System.out.print(subject.getTitle() + "(");
				System.out.println(courseName + ")");
				sumScore += score;
				subCount++;
			}
		}
		double avgScore = sumScore / subCount;
		double avgCreditScore = avgScore / 100 * 4.5;
		System.out.println("----------------------------------------");
		System.out.println("전체평균성적: " + avgScore + "/100");
		System.out.println("평균평점: " + avgCreditScore + "/4.5");
		System.out.println("성적 조회 완료");
	}

}
