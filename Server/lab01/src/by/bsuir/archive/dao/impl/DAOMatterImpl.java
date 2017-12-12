package by.bsuir.archive.dao.impl;

import java.util.ArrayList;

import by.bsuir.archive.dao.DAOMatter;
import by.bsuir.archive.dao.exception.DAOException;
import by.bsuir.archive.domain.Matter;
import by.bsuir.archive.serialization.Serialization;
import by.bsuir.archive.serialization.exception.SerializationException;

public class DAOMatterImpl implements DAOMatter {

	private ArrayList<Matter> listOfMatter;

	private synchronized int getUniqueId() {
		int maxId = 0;
		for (Matter element : listOfMatter) {
			if (element.getId() > maxId) {
				maxId = element.getId();
			}
		}
		return ++maxId;
	}

	@Override
	public synchronized void createMatter(String surname, String name, int age, String univer, int numberOfGroup)
			throws DAOException {
		if (listOfMatter == null) {
			listOfMatter = new ArrayList<Matter>();
			try {
				listOfMatter = Serialization.deserialize();
			} catch (SerializationException e) {
				throw new DAOException(e);
			}
		}
		int id = getUniqueId();
		Matter matter = new Matter(surname, name, age, univer, numberOfGroup, id);
		boolean isInList = false;
		for (Matter element : listOfMatter) {
			if (element.getId() == matter.getId()) {
				isInList = true;
			}
		}
		if (isInList) {
			throw new DAOException("�� ���������� �������������!");
		}
		listOfMatter.add(matter);
		try {
			Serialization.serialize(listOfMatter);
		} catch (SerializationException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public synchronized Matter findMatter(int idMatter) throws DAOException {
		if (listOfMatter == null) {
			listOfMatter = new ArrayList<Matter>();
			try {
				listOfMatter = Serialization.deserialize();
			} catch (SerializationException e) {
				throw new DAOException(e);
			}
		}
		for (Matter element : listOfMatter) {
			if (element.getId() == idMatter) {
				return element;
			}
		}
		throw new DAOException("��� ������ ����!");
	}

	@Override
	public synchronized void changeMatter(int idMatter, String newSurname, String newName, int newAge, String newUniver,
			int newNumberOfGroup) throws DAOException {
		if (listOfMatter == null) {
			listOfMatter = new ArrayList<Matter>();
			try {
				listOfMatter = Serialization.deserialize();
			} catch (SerializationException e) {
				throw new DAOException(e);
			}
		}
		for (Matter element : listOfMatter) {
			if (element.getId() == idMatter) {
				if (!isNull(newSurname)) {
					element.setSurname(newSurname);
				}
				if (!isNull(newName)) {
					element.setNameOfStudent(newName);
				}
				if (!isNull(Integer.toString(newAge))) {
					element.setAgeOfStudent(newAge);
				}
				if (!isNull(newUniver)) {
					element.setUniversity(newUniver);
				}
				if (!isNull(Integer.toString(newNumberOfGroup))) {
					element.setNumberOfGroup(newNumberOfGroup);
				}
				try {
					Serialization.serialize(listOfMatter);
				} catch (SerializationException e) {
					throw new DAOException(e);
				}
				return;
			}
		}

		throw new DAOException("��� ������ ����!");

	}

	private Boolean isNull(String str) {
		return str.equals("0") || str.equals("null");
	}
}
