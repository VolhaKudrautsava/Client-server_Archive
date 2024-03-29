package by.bsuir.archive.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import by.bsuir.archive.serialization.exception.SerializationException;

public class Serialization {

	public static <T> void serialize(ArrayList<T> list, String fileDBName) throws SerializationException {

		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileDBName))) {
			objectOutputStream.writeObject(list);
		} catch (FileNotFoundException e) {
			throw new SerializationException(e.getLocalizedMessage());
		} catch (IOException ioe) {
			throw new SerializationException(ioe.getLocalizedMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> deserialize(String fileDBName) throws SerializationException {

		ArrayList<T> list = new ArrayList<T>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileDBName))) {
			list = (ArrayList<T>) ois.readObject();
		} catch (IOException ioe) {
			throw new SerializationException(ioe.getLocalizedMessage());
		} catch (ClassNotFoundException c) {
			throw new SerializationException(c.getLocalizedMessage());
		}
		return list;
	}
}
