package data.repo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import data.vo.Data;

public class DataRepo {

	private List<Data> db = new ArrayList<Data>();

	public DataRepo() throws Exception {
		FileInputStream fis = new FileInputStream("C:/files/도로교통공단_전국_사망교통사고정보(2015).csv");
		InputStreamReader isr = new InputStreamReader(fis, "MS949");
		BufferedReader reader = new BufferedReader(isr);

		String text = reader.readLine(); // 첫 줄을 버린다.
		while ((text = reader.readLine()) != null) {
			if (!(text.isEmpty())) {
				String[] items = text.split(",");
				String day = items[1].substring(5, 10);
				String dayOfWeek = items[3];
				int death = Integer.parseInt(items[4]);
				String sido = items[9];
				String gugun = items[10];
				String violation = items[15];

				Data data = new Data();
				data.setDay(day);
				data.setDayOfWeek(dayOfWeek);
				data.setDeath(death);
				data.setSido(sido);
				data.setGugun(gugun);
				data.setViolation(violation);

				db.add(data);
			}
		}
		reader.close();
	}

	public List<Data> getAllData() {
		return db;
	}

	public List<Data> getDataBySido(String sido) {
		List<Data> result = new ArrayList<Data>();
		for (Data data : db) {
			if(sido.equals(data.getSido())) {
				result.add(data);
			}
		}

		return result;
	}

	public List<Data> getDataByDay(String day) {
		List<Data> result = new ArrayList<Data>();
		for (Data data : db) {
			if(day.equals(data.getDay())) {
				result.add(data);
			}
		}

		return result;
	}

}
