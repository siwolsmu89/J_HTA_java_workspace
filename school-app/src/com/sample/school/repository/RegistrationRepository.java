package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Registration;

public class RegistrationRepository {

	private Registration[] db = new Registration[100];
	private int position = 0;
	private int sequence = 50000;

	public RegistrationRepository() {
		insertRegistration(new Registration(60003, 40001, false, 0));
		insertRegistration(new Registration(60003, 40002, false, 0));
		insertRegistration(new Registration(60003, 40003, true, 0));

		insertRegistration(new Registration(60004, 40001, false, 0));
		insertRegistration(new Registration(60004, 40003, false, 0));
		insertRegistration(new Registration(60004, 40005, false, 0));

		insertRegistration(new Registration(60001, 40008, false, 0));
		insertRegistration(new Registration(60001, 40009, false, 0));
		insertRegistration(new Registration(60001, 40010, true, 0));
		insertRegistration(new Registration(60001, 40011, true, 0));

	}

	public void insertRegistration(Registration registration) {
		registration.setNo(sequence);
		db[position] = registration;

		position++;
		sequence++;
	}

	public Registration getRegistrationByNo(int registrationNo) {
		Registration registration = null;

		if (position == 0) {
			return registration;
		}

		for (int i = 0; i < position; i++) {
			if (registrationNo == db[i].getNo()) {
				registration = db[i];
				break;
			}
		}
		return registration;
	}

	public Registration[] getAllRegistrations() {
		return Arrays.copyOfRange(db, 0, position);
	}

}