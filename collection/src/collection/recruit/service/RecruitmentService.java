package collection.recruit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();

	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		Recruitment recruitment = new Recruitment();
		// 구직신청객체에 전달받은 이력서 객체 저장
		recruitment.setResume(resume);
		// 레포지토리객체를 사용해서 db에 저장하기
		int recruNo = repo.addRecruitment(recruitment);
		// 구직신청번호를 출력한다.
		System.out.println("구직신청번호 [" + recruNo + "]로 등록되었습니다.");
		System.out.println("-----------------------------------------");
	}

	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);

		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		recruitment.addCareer(career);
	}

	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);

		if (recruitment == null) {
			System.out.println("일치하는 구직신청정보가 없습니다.");
			return;
		}

		System.out.println("신청번호 [" + recruitmentNo + "] 구직 신청 정보 조회");
		System.out.println("-----------------------------------------");

		Resume resume = recruitment.getResume();
		System.out.println("이    름: " + resume.getName());
		System.out.println("전화번호: " + resume.getTel());
		System.out.println("희망부서: " + resume.getDept());

		ArrayList<Career> careers = recruitment.getCareers();
		if (careers.isEmpty()) {
			System.out.println("등록된 경력사항이 없습니다.");
		} else {
			System.out.println("등록된 경력 정보");
			System.out.println("[회 사 명]\t[부 서 명]\t[직 급]\t[근무연수]");
			for (Career career : careers) {
				System.out.print(career.getCompanyName() + "\t");
				System.out.print(career.getDept() + "\t");
				System.out.print(career.getPosition() + "\t");
				System.out.print(career.getYear() + "\n");
			}
			System.out.println("경력 정보 조회 끝");
		}
		String passed = "";
		if (recruitment.isPassed()) {
			passed = "합격";
		} else {
			passed = "불합격";
		}
		System.out.println("합격여부: " + passed);
		System.out.println("-----------------------------------------");
		System.out.println("신청번호 [" + recruitmentNo + "] 구직 신청 정보 조회 완료");
		System.out.println("-----------------------------------------");
	}

	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		if (recruitment == null) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}
		recruitment.setResume(resume);
		System.out.println("이력서 수정 완료");
		System.out.println("-----------------------------------------");
	}

	public void findCareer(int recruitmentNo, String companyName) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if (recruitment == null) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}

		boolean isCareer = false;
		ArrayList<Career> careers = recruitment.getCareers();
		for (Career car : careers) {
			String cpName = car.getCompanyName();
			if (companyName.equals(cpName)) {
				isCareer = true;
			}
		}

		if (isCareer = false) {
			System.out.println("일치하는 회사명이 없습니다.");
		} else {
			System.out.println("일치하는 경력 정보를 발견했습니다.");
		}

	}

	public void updateCareer(int recruitmentNo, Career career) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);

		if (recruitment == null) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}

		String companyName = career.getCompanyName();
		String dept = career.getDept();
		String position = career.getPosition();
		int year = career.getYear();

		ArrayList<Career> careers = recruitment.getCareers();
		Iterator<Career> itr = careers.iterator();
		while (itr.hasNext()) {
			Career car = itr.next();
			if (companyName.equals(car.getCompanyName())) {
				car.setCompanyName(companyName);
				car.setDept(dept);
				car.setPosition(position);
				car.setYear(year);
				System.out.println("경력정보 수정이 완료되었습니다.");
				System.out.println("-----------------------------------------");
				break;
			}
		}
	}

	public void deleteCareer(int recruitmentNo, String companyName) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if (recruitment == null) {
			System.out.println("일치하는 구직신청정보가 없습니다.");
			return;
		}

		ArrayList<Career> careers = recruitment.getCareers();
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		Iterator<Career> itr = careers.iterator();
		while (itr.hasNext()) {
			Career car = itr.next();
			if (companyName.equals(car.getCompanyName())) {
				itr.remove();
				System.out.println("삭제완료");
				break;
			}
		}

		System.out.println("-----------------------------------------");
	}

	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();
		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if (recruitment == null) {
			System.out.println("일치하는 구직신청정보가 없습니다.");
			return;
		}

		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		Iterator<Recruitment> itr = allRecruits.iterator();
		while (itr.hasNext()) {
			Recruitment recru = itr.next();
			if (recruitmentNo == recru.getNo()) {
				itr.remove();
				System.out.println("삭제완료");
				break;
			}
		}

		System.out.println("-----------------------------------------");
	}

	public void printRecuitsNumIgnoresDept() {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();
		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}

		int recruitsNum = allRecruits.size();
		System.out.println("전체 지원자 수는 [" + recruitsNum + "명]입니다.");

	}

	public void printRecruitsNumByDept(String dept) {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();
		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}

		int count = 0;
		for (Recruitment recru : allRecruits) {
			String dpt = recru.getResume().getDept();
			if (dpt.equals(dept)) {
				count++;
			}
		}

		System.out.println("[" + dept + "]의 현재 지원자 수는 [" + count + "명]입니다.");
		System.out.println("-----------------------------------------");
	}

	public void printAverageYearOfDept(String dept) {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();
		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}

		int count = 0;
		double sumYear = 0;
		for (Recruitment recru : allRecruits) {
			String dpt = recru.getResume().getDept();
			if (dpt.equals(dept)) {
				count++;

				ArrayList<Career> careers = recru.getCareers();
				for (Career car : careers) {
					sumYear += car.getYear();
				}
			}

		}

		double avgYear = sumYear / count;

		System.out.println("[" + dept + "]의 지원자들(" + count + "명)의 평균 경력은 [" + avgYear + "년]입니다.");
		System.out.println("-----------------------------------------");
	}

	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();
		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}
		System.out.println("-----------------------------------------");
		System.out.println("신청번호\t이름\t경력입력여부\t합격여부");
		for (Recruitment recru : allRecruits) {
			int recruNo = recru.getNo();
			String isCaree = "";
			Resume resume = recru.getResume();
			String passed = "";
			if (recru.isPassed()) {
				passed = "합격";
			} else {
				passed = "불합격";
			}
			ArrayList<Career> careers = recru.getCareers();
			if (careers.isEmpty()) {
				isCaree = "경력정보 미등록";
			} else {
				int size = careers.size();
				isCaree = "경력정보 등록(" + size + "건)";
			}
			System.out.print(recruNo + "\t");
			System.out.print(resume.getName() + "\t");
			System.out.print(isCaree + "\t");
			System.out.print(passed + "\n");

		}
		System.out.println("간단 조회 완료");
		System.out.println("-----------------------------------------");

	}

	public void printAllRecruSortedByName() {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();

		Collections.sort(allRecruits, (r1, r2) -> r1.getResume().getName().compareTo(r2.getResume().getName()));

		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}
		System.out.println("-----------------------------------------");
		System.out.println("신청번호\t이름\t지원부서\t경력합계\t합격여부");
		for (Recruitment recru : allRecruits) {
			int recruNo = recru.getNo();
			String isCaree = "";
			Resume resume = recru.getResume();
			String passed = "";
			if (recru.isPassed()) {
				passed = "합격";
			} else {
				passed = "불합격";
			}
			ArrayList<Career> careers = recru.getCareers();
			if (careers.isEmpty()) {
				isCaree = "경력정보 미등록";
			} else {
				int years = 0;
				for (Career car : careers) {
					years += car.getYear();
				}
				isCaree = "총 " + years + "년";
			}
			System.out.print(recruNo + "\t");
			System.out.print(resume.getName() + "\t");
			System.out.print(resume.getDept() + "\t");
			System.out.print(isCaree + "\t");
			System.out.print(passed + "\n");

		}
		System.out.println("간단 조회 완료");
		System.out.println("-----------------------------------------");

	}

	public void printAllRecruSortedByYear() {
		ArrayList<Recruitment> allRecruits = repo.getAllRecruitments();

		Collections.sort(allRecruits, new Comparator<Recruitment>() {
			@Override
			public int compare(Recruitment o1, Recruitment o2) {
				ArrayList<Career> careers1 = o1.getCareers();
				int o1Year = 0;
				for (Career car : careers1) {
					o1Year += car.getYear();
				}

				ArrayList<Career> careers2 = o2.getCareers();
				int o2Year = 0;
				for (Career car : careers2) {
					o2Year += car.getYear();
				}

				return -(o1Year - o2Year);
			}
		});

		if (allRecruits.isEmpty()) {
			System.out.println("입력된 구직신청정보가 없습니다.");
			return;
		}
		System.out.println("-----------------------------------------");
		System.out.println("신청번호\t이름\t지원부서\t경력합계\t합격여부");
		for (Recruitment recru : allRecruits) {
			int recruNo = recru.getNo();
			String isCaree = "";
			Resume resume = recru.getResume();
			String passed = "";
			if (recru.isPassed()) {
				passed = "합격";
			} else {
				passed = "불합격";
			}
			ArrayList<Career> careers = recru.getCareers();
			if (careers.isEmpty()) {
				isCaree = "경력정보 미등록";
			} else {
				int years = 0;
				for (Career car : careers) {
					years += car.getYear();
				}
				isCaree = "총 " + years + "년";
			}
			System.out.print(recruNo + "\t");
			System.out.print(resume.getName() + "\t");
			System.out.print(resume.getDept() + "\t");
			System.out.print(isCaree + "\t");
			System.out.print(passed + "\n");

		}
		System.out.println("간단 조회 완료");
		System.out.println("-----------------------------------------");

	}

	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if (recruitment == null) {
			System.out.println("일치하는 구직신청정보가 없습니다.");
			return;
		}
		// 합격/불합격여부를 결정한다.
		recruitment.setPassed(passed);
		System.out.println("심사정보가 저장되었습니다.");
		System.out.println("-----------------------------------------");
	}
}
