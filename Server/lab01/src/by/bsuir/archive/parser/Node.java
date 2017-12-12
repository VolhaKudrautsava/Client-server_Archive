package by.bsuir.archive.parser;

import java.util.*;

public class Node {
	private Node parent;
	private String name;
	private String text;
	private List<Node> childrenNodeList;
	private List<Attribute> attrs;
	private Iterator<Node> nodeIt;

	public Node(String name, String text, Node parent, List<Attribute> attrs) {

		this.name = name;
		this.text = text;
		this.parent = parent;
		this.attrs = attrs;
	}

	public String getName() {

		return name;
	}

	public String getText() {

		return text;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setText(String text) {

		this.text = text;
	}

	public Node getParent() {

		return parent;
	}

	public void setParent(Node parent) {

		this.parent = parent;
	}

	public void addChild(Node child) {

		try {

			childrenNodeList.add(child);

		} catch (Exception ex) {

			childrenNodeList = new LinkedList<Node>();
			childrenNodeList.add(child);
		}
	}

	public Node getFirstChild() {

		try {

			return childrenNodeList.get(0);
		} catch (Exception ex) {

			return null;
		}
	}

	public Node getNextChild() {

		try {
			if (nodeIt.hasNext()) {

				return nodeIt.next();
			}
		} catch (Exception e) {
			try {
				nodeIt = childrenNodeList.listIterator();
				if (nodeIt.hasNext()) {
					return nodeIt.next();
				}
			} catch (Exception ex) {
				return null;
			}
		}
		return null;
	}

	public List<Node> getChildren() {
		return childrenNodeList;
	}

	public List<Attribute> getAttributes() {
		return attrs;
	}

}