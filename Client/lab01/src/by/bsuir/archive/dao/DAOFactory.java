package by.bsuir.archive.dao;

import by.bsuir.archive.dao.impl.DAOMatterImpl;
import by.bsuir.archive.dao.impl.DAOUserImpl;

public class DAOFactory {

	private static final DAOFactory factory = new DAOFactory();

	private final DAOUser userDAO = new DAOUserImpl();
	private final DAOMatter matterDAO = new DAOMatterImpl();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return factory;
	}

	public DAOUser getUserDAO() {
		return userDAO;
	}

	public DAOMatter getMatterDAO() {
		return matterDAO;
	}

}
