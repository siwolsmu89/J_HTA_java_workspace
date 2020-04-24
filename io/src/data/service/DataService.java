package data.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

import data.repo.DataRepo;
import data.vo.Data;

public class DataService {

	private DataRepo repo;

	public DataService() throws Exception {
		repo = new DataRepo();
	}

	// 전체 사고건수를 출력하는 기능
	public void printAllDataCount() {
		List<Data> allDatas = repo.getAllData();
		int totalDeath = 0;
		for (Data data : allDatas) {
			totalDeath += data.getDeath();
		}
		System.out.println("전체 사고건수: " + allDatas.size());
		System.out.println("전체 사망자수: " + totalDeath);

	}

	// 시도를 전달받아서 해당 지역의 사고건수를 출력하는 기능
	public void printDataBysido(String sido) {
		List<Data> datas = repo.getDataBySido(sido);
		int totalDeath = 0;
		for (Data data : datas) {
			totalDeath += data.getDeath();
		}
		System.out.println("지역 [" + sido + "]의 검색 결과");
		System.out.println("-----------------------------");
		System.out.println("전체 사고건수: " + datas.size());
		System.out.println("전체 사망자수: " + totalDeath);
	}

	// 날짜를 전달받아서 해당 날짜의 사고건수를 출력하는 기능
	public void printDataByDay(String day) {
		List<Data> datas = repo.getDataByDay(day);
		int totalDeath = 0;
		for (Data data : datas) {
			totalDeath += data.getDeath();
		}
		System.out.println("날짜 [" + day + "]의 검색 결과");
		System.out.println("-----------------------------");
		System.out.println("전체 사고건수: " + datas.size());
		System.out.println("전체 사망자수: " + totalDeath);

	}

	// 시도를 전달받아서 해당 시도의 행정구역별 사고수, 사망자수를 출력하는 기능
	public void printStatBySido(String sido) {
		List<Data> datas = repo.getDataBySido(sido);
		TreeMap<String, Stat> map = new TreeMap<String, Stat>();

		for (Data data : datas) {
			String gugun = data.getGugun();
			int deaths = data.getDeath();

			if (map.containsKey(gugun)) {
				Stat stat = map.get(gugun);
				stat.setRecords(stat.getRecords() + 1);
				stat.setDeaths(stat.getDeaths() + deaths);

			} else {
				Stat stat = new Stat();
				stat.setRecords(1);
				stat.setDeaths(deaths);

				map.put(gugun, stat);
			}
		}

		NavigableSet<String> set = map.navigableKeySet();
		System.out.println("[구군]\t사고건수\t사망자수");
		for (String key : set) {
			Stat stat = map.get(key);
			System.out.println("[" + key + "]\t" + stat.getRecords() + "\t" + stat.getDeaths());
		}
	}

	// 월별 사고현황 통계를 출력하는 기능
	public void printStatByMonth() {
		List<Data> datas = repo.getAllData();
		TreeMap<Integer, Stat> stats = new TreeMap<Integer, Stat>();
		int month = 0;
		for (Data data : datas) {
			String monthString = data.getDay().substring(0, 2);
			if (monthString.startsWith("0")) {
				monthString = monthString.substring(1);
			}
			month = Integer.parseInt(monthString);

			Stat savedStat = stats.get(month); // TreeMap stats에서 month를 key로 하는 Stat 객체를 조회한다.
			if (savedStat == null) { // month에 저장된 값이 없으면
				Stat stat = new Stat(); // 새 Stat 객체를 생성한다.
				stat.setDeaths(data.getDeath());
				stat.setRecords(1);

				stats.put(month, stat); // 사망자수와 사고건수를 담아서 TreeMap stats에 저장한다.
			} else { // TreeMap의 month번째에 저장된 Stat 객체가 있으면
				savedStat.setDeaths(savedStat.getDeaths() + data.getDeath());
				savedStat.setRecords(savedStat.getRecords() + 1); // 해당 객체의 사망건수와 사고건수를 설정해준다.
			}
		}

		System.out.println("월\t사고건수\t사망자수");
		System.out.println("-----------------------------");
		int size = stats.size();
		for (int i = 1; i <= size; i++) {
			Stat stat = stats.get(i);
			System.out.println(i + "월\t" + stat.getRecords() + "\t" + stat.getDeaths());
		}
	}

	// 요일별 사고현황 통계를 출력하는 기능
	public void printStatByDayOfWeek() {

	}

	// 위반내용별 사고현황 통계를 출력하는 기능

	public void printStatByViolation() {

	}

	// 사고현황 요약 결과를 출력하는 기능 (최다 사고발생 시도, 최다 사고발생월, 최다 사고발생일, 최다 사고 발생요일, 최다 사고 발생 유형
	public void printSummary() {
		Map<String, Map<String, Stat>> map = new HashMap<String, Map<String, Stat>>();
		map.put("시도별", new HashMap<String, Stat>());
		map.put("월별", new HashMap<String, Stat>());
		map.put("날짜별", new HashMap<String, Stat>());
		map.put("요일별", new HashMap<String, Stat>());
		map.put("사고유형별", new HashMap<String, Stat>());
		List<Data> datas = repo.getAllData();
		Map<String, Stat> sidoMap = map.get("시도별");
		Map<String, Stat> monthMap = map.get("월별");
		Map<String, Stat> dayMap = map.get("날짜별");
		Map<String, Stat> dayOfWeekMap = map.get("요일별");
		Map<String, Stat> violationMap = map.get("사고유형별");

		for (Data data : datas) {
			String sido = data.getSido();
			String month = data.getDay().substring(0, 2);
			String day = data.getDay();
			String dayOfWeek = data.getDayOfWeek();
			String violation = data.getViolation();
			int death = data.getDeath();

			reduceStat(sido, death, sidoMap);
			reduceStat(month, death, monthMap);
			reduceStat(day, death, dayMap);
			reduceStat(dayOfWeek, death, dayOfWeekMap);
			reduceStat(violation, death, violationMap);
		}
		
		Stat sidoMaxStat = maxStat(sidoMap);
		Stat monthMaxStat = maxStat(monthMap);
		Stat dayMaxStat = maxStat(dayMap);
		Stat dayOfWeekMaxStat = maxStat(dayOfWeekMap);
		Stat violationMaxStat = maxStat(violationMap);
		
		System.out.println("============= 교통사고 현황 요약 =============");
		System.out.println("분               류: \t건수\t사망자수\t항목");
		System.out.println("최다 사고 발생 시도:\t" + sidoMaxStat.getRecords() + "\t" + sidoMaxStat.getDeaths()+"\t"+sidoMaxStat.getName());
		System.out.println("최다 사고 발생 월  :\t" + monthMaxStat.getRecords() + "\t" + monthMaxStat.getDeaths()+"\t"+monthMaxStat.getName());
		System.out.println("최다 사고 발생 날짜:\t" + dayMaxStat.getRecords() + "\t" +dayMaxStat.getDeaths() + "\t" + dayMaxStat.getName());
		System.out.println("최다 사고 발생 요일:\t" + dayOfWeekMaxStat.getRecords() + "\t" +dayOfWeekMaxStat.getDeaths() + "\t" + dayOfWeekMaxStat.getName());
		System.out.println("최다 사고 발생 유형:\t" + violationMaxStat.getRecords() + "\t" +violationMaxStat.getDeaths() + "\t" + violationMaxStat.getName());
	}
	
	private Stat maxStat(Map<String, Stat> map) {
		Collection<Stat> stats = map.values();
		TreeSet<Stat> treeSet = new TreeSet<Stat>(stats);
		return treeSet.last();
	}
	
	private void reduceStat(String key, int death, Map<String, Stat> map) {
		if (map.containsKey(key)) {
			Stat stat = map.get(key);
			stat.setDeaths(stat.getDeaths() + death);
			stat.setRecords(stat.getRecords() + 1);
		} else {
			Stat stat = new Stat();
			stat.setName(key);
			stat.setDeaths(death);
			stat.setRecords(1);

			map.put(key, stat);
		}
	}

	class Stat implements Comparable<Stat> {
		private String name;
		private int records;
		private int deaths;

		public Stat() {
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getRecords() {
			return records;
		}

		public void setRecords(int records) {
			this.records = records;
		}

		public int getDeaths() {
			return deaths;
		}

		public void setDeaths(int deaths) {
			this.deaths = deaths;
		}
		
		@Override
		public int compareTo(Stat o) {
			return this.deaths - o.deaths;
		}
	
	}
}
