package by.bsuir.archive.service;

import by.bsuir.archive.service.exception.ServiceException;

public interface MatterService {

	void createMatter(String surname, String name, int age, String univer, int numberOfGroup) throws ServiceException;

	String findMatter(int idMatter) throws ServiceException;

	void changeMatter(int idMatter, String newSurname, String newName, int newAge, String newUniver,
			int newNumberOfGroup) throws ServiceException;
}
