package collection.recruit;

import java.util.Scanner;

import collection.recruit.service.RecruitmentService;
import collection.recruit.vo.Career;
import collection.recruit.vo.Resume;

public class RecruitApp {

	public static void main(String[] args) {
		RecruitmentService service = new RecruitmentService();
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("=========================================");
				System.out.println("1.구직자  2.인사담당자  0.종료");
				System.out.println("=========================================");

				System.out.print("메뉴를 선택하세요: ");
				int menuNo = scanner.nextInt();

				if (menuNo == 1) {
					System.out.println("=========================================");
					System.out.println("1.이력서등록 2.경력사항등록 3.채용확인 4.이력서수정 5.구직신청 삭제");
					System.out.println("6.경력수정 7.신청현황");
					System.out.println("=========================================");
					
					System.out.print("구직자 메뉴를 선택하세요");
					int empMenuNo = scanner.nextInt();

					if (empMenuNo == 1) {
						System.out.println("-----------------------------------------");
						System.out.println("[이력서등록]");
						System.out.println("-----------------------------------------");
						// 이름, 전화번호, 지원부서를 입력받는다.
						System.out.print("이름을 입력하세요: ");
						String name = scanner.next();
						System.out.print("전화번호를 입력하세요: ");
						String tel = scanner.next();
						System.out.print("지원부서를 입력하세요: ");
						String dept = scanner.next();

						Resume resume = new Resume();
						resume.setName(name);
						resume.setTel(tel);
						resume.setDept(dept);

						service.addNewResume(resume);
					} else if (empMenuNo == 2) {
						System.out.println("-----------------------------------------");
						System.out.println("[경력사항등록]");
						System.out.println("-----------------------------------------");
						// 구직신청번호, 재직회사명, 근무부서, 직위, 근무년수를 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();
						System.out.print("재직회사명을 입력하세요: ");
						String companyName = scanner.next();
						System.out.print("근무부서를 입력하세요: ");
						String dept = scanner.next();
						System.out.print("직위를 입력하세요: ");
						String position = scanner.next();
						System.out.print("근무년수를 입력하세요: ");
						int year = scanner.nextInt();

						Career career = new Career();
						career.setCompanyName(companyName);
						career.setDept(dept);
						career.setPosition(position);
						career.setYear(year);

						service.addCareer(recruitmentNo, career);
					} else if (empMenuNo == 3) {
						System.out.println("-----------------------------------------");
						System.out.println("[채용상태확인]");
						System.out.println("-----------------------------------------");
						// 구직신청번호를 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();

						service.printRecruitmentDetail(recruitmentNo);
					} else if (empMenuNo == 4) {
						System.out.println("-----------------------------------------");
						System.out.println("[이력서수정]");
						System.out.println("-----------------------------------------");
						// 구직신청번호, 이름, 전화번호, 지원부서를 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();
						System.out.print("이름을 입력하세요: ");
						String name = scanner.next();
						System.out.print("전화번호를 입력하세요: ");
						String tel = scanner.next();
						System.out.print("지원부서를 입력하세요: ");
						String dept = scanner.next();

						Resume resume = new Resume();
						resume.setName(name);
						resume.setTel(tel);
						resume.setDept(dept);

						service.updateResume(recruitmentNo, resume);
					} else if (empMenuNo == 5) {
						System.out.println("-----------------------------------------");
						System.out.println("[구직신청삭제]");
						System.out.println("-----------------------------------------");
						// 구직신청번호를 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();

						service.deleteRecruitment(recruitmentNo);
					} else if (empMenuNo == 6) {
						System.out.println("-----------------------------------------");
						System.out.println("[경력사항 수정]");
						System.out.println("-----------------------------------------");
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();
						System.out.print("재직회사명을 입력하세요: ");
						String companyName = scanner.next();
						
						service.findCareer(recruitmentNo, companyName);
						System.out.println("### 일치하는 정보가 없을 시 다음 메뉴에서 0을 입력하고 초기 화면으로 돌아가세요.");
						
						System.out.println("=========================================");
						System.out.println("1.경력수정  2.경력삭제");
						System.out.println("=========================================");
						System.out.print("메뉴를 선택하세요: ");
						int modifyMenuNo = scanner.nextInt();

						if (modifyMenuNo == 1) {
							System.out.println("-----------------------------------------");
							System.out.println("[경력 수정 메뉴]");
							System.out.println("-----------------------------------------");
							System.out.print("근무부서를 입력하세요: ");
							String dept = scanner.next();
							System.out.print("직위를 입력하세요: ");
							String position = scanner.next();
							System.out.print("근무년수를 입력하세요: ");
							int year = scanner.nextInt();
							
							Career career = new Career();
							career.setCompanyName(companyName);
							career.setDept(dept);
							career.setPosition(position);
							career.setYear(year);
							
							service.updateCareer(recruitmentNo, career);
						} else if (modifyMenuNo == 2) {
							System.out.println("-----------------------------------------");
							System.out.println("[경력 삭제 메뉴]");
							System.out.println("-----------------------------------------");
							System.out.print("정말 삭제합니까? 삭제를 원하시면 Y를 입력하세요: ");
							String really = scanner.next();
							
							if(really.equals("Y")) {
								service.deleteCareer(recruitmentNo, companyName);
							} else {
								System.out.println("삭제 요청에 대한 응답: " + really);
								System.out.println("경력 삭제를 취소합니다.");
							}
							
						}

					} else if (empMenuNo == 7) {
						System.out.println("-----------------------------------------");
						System.out.println("[신청현황조회]");
						System.out.println("=========================================");
						System.out.println("0.전체현황  1.부서별현황  2.평균근무기간");
						System.out.println("=========================================");
						System.out.print("메뉴를 선택하세요: ");
						int displayMenuNo = scanner.nextInt();

						if (displayMenuNo == 1) {
							System.out.println("[부서별 지원자 수 현황]");
							System.out.print("지원 부서를 입력하세요: ");
							String dept = scanner.next();
							
							service.printRecruitsNumByDept(dept);
						} else if (displayMenuNo == 2) {
							System.out.println("[평균근무기간]");
							System.out.print("지원 부서를 입력하세요: ");
							String dept = scanner.next();
							
							service.printAverageYearOfDept(dept);
						} else if (displayMenuNo ==  0) {
							System.out.println("[전체 지원자 수 현황]");
							
							service.printRecuitsNumIgnoresDept();
						}
					}

				} else if (menuNo == 2) {
					System.out.println("=========================================");
					System.out.println("1.채용신청서 간편조회  2.채용신청서 상세조회  3.채용신청서 심사");
					System.out.println("=========================================");
					
					System.out.print("구직자 메뉴를 선택하세요");
					int empMenuNo = scanner.nextInt();

					if (empMenuNo == 1) {
						System.out.println("-----------------------------------------");
						System.out.println("[채용신청서 간편조회]");
						System.out.println("(신청번호, 이름, 경력정보여부, 합격여부만 확인 가능)");
						System.out.println("=========================================");
						System.out.println("1.이름순  2.경력순");
						System.out.println("=========================================");
						int empPrintMenuNo = scanner.nextInt();
						if (empPrintMenuNo == 1) {
							System.out.println("[채용신청서 이름순 조회]");
							
							service.printAllRecruSortedByName();
						} else if (empPrintMenuNo == 2) {
							System.out.println("[채용신청서 경력순 조회]");
							
							service.printAllRecruSortedByYear();
						} 
						
					} else if (empMenuNo == 2) {
						System.out.println("-----------------------------------------");
						System.out.println("[채용신청서 상세조회]");
						System.out.println("-----------------------------------------");
						// 구직신청번호를 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();

						service.printRecruitmentDetail(recruitmentNo);
					} else if (empMenuNo == 3) {
						System.out.println("-----------------------------------------");
						System.out.println("[채용신청서 심사]");
						System.out.println("-----------------------------------------");
						// 구직신청번호와 합격불합격여부를 Y/N으로 입력받는다.
						System.out.print("신청번호를 입력하세요: ");
						int recruitmentNo = scanner.nextInt();
						System.out.print("합격여부를 입력하세요(Y/N): ");
						String isPassed = scanner.next();
						boolean passed = false;
						if (isPassed.equalsIgnoreCase("Y")) {
							passed = true;
						}

						service.checkRecruitment(recruitmentNo, passed);
					}

				} else if (menuNo == 0) {
					System.out.println("=========================================");
					System.out.println("### 프로그램을 종료합니다.");
					System.out.println("=========================================");
					break;
				}

			} catch (Exception e) {
				System.out.println("오류가 발생했습니다.");
			}

		}
	}
}