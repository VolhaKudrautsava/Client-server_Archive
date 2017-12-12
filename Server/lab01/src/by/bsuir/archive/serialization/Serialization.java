package by.bsuir.archive.serialization;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;

import by.bsuir.archive.domain.Matter;
import by.bsuir.archive.parser.Document;
import by.bsuir.archive.parser.DocumentBuilder;
import by.bsuir.archive.parser.exception.ParserException;
import by.bsuir.archive.serialization.exception.SerializationException;

public class Serialization {
	private static final String ARCHIVE_NAME = "ARCHIVE.xml";
	private static DocumentBuilder docBuilder;
	private static Document doc;
	
	
	public synchronized static void serialize(ArrayList<Matter> itemList) throws SerializationException {
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(new FileOutputStream(ARCHIVE_NAME));
			encoder.writeObject(itemList);
			encoder.close();
		} catch (FileNotFoundException e) {
			throw new SerializationException(e);
		}
	}

	public synchronized static ArrayList<Matter> deserialize() throws SerializationException {
		docBuilder = new DocumentBuilder();
		try {
			doc = docBuilder.getDocument(ARCHIVE_NAME);
		} catch (ParserException e) {
			throw new SerializationException(e);
		}
		return doc.toArrayList();	
	}
}
