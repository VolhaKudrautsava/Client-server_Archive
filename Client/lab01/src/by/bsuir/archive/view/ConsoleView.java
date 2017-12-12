package by.bsuir.archive.view;

import java.util.Scanner;

public class ConsoleView {
	private static Scanner in = new Scanner(System.in);

	public void consoleWriteLine(String message) {
		System.out.print(message + "\n");
	}

	private String enterName() {
		System.out.print("������� �����:\n");
		return in.next();
	}

	private String enterPassword() {
		System.out.print("������� ������:\n");
		return in.next();
	}

	private String enterIdMatter() {
		System.out.print("������� ����� ����:\n");
		return in.next();
	}

	private String enterNameStudent() {
		System.out.print("������� ��� ��������:\n");
		return in.next();
	}

	private String enterSurnameStudent() {
		System.out.print("������� ������� ��������:\n");
		return in.next();
	}

	private String enterAgeStudent() {
		System.out.print("������� ������� ��������:\n");
		return in.next();
	}

	private String enterUniverStudent() {
		System.out.print("������� �������� ������������ ,� ������� ��������� �������:\n");
		return in.next();
	}

	private String enterGroupOfStudent() {
		System.out.print("������� ����� ������ ��������:\n");
		return in.next();
	}

	public String enterMainAction() {
		System.out.print("������� ��������: 1 - ������������ 2 - ��������������� 0 - �����.\n");
		return in.next();
	}

	public void showGoodBye() {
		System.out.print("�� ��������!\n");
	}

	public void showError() {
		System.out.print("��������:(\n");
	}

	public String enterChoiseAdmin() {
		System.out.print("������� ��������: 1 - �������� ����; 2 - �������� ����; 3 - ����� ����; 0 - �����\n");
		return in.next();
	}

	public String enterChoiseChange() {
		System.out.print("��� �� ������ ��������?/n 1 - �������; 2 - ���; 3 - �������;"
				+ "4 - �����������; 5 - ����� ������; 0 - �����\n");
		return in.next();
	}

	public String enterChoiseUser() {
		System.out.print("������� ��������: 1 - ����� ����; 0 - �����\n");
		return in.next();
	}

	public String enterResult() {
		System.out.print("������� ����� ��������:\n");
		return in.next();
	}

	private String requestCreateMatter() {
		String name = enterNameStudent();
		String surname = enterSurnameStudent();
		String age = enterAgeStudent();
		String university = enterUniverStudent();
		String numberOfGroup = enterGroupOfStudent();
		return "CREATE_MATTER" + "|" + surname + "|" + name + "|" + age + "|" + university + "|" + numberOfGroup;
	}

	private String requestFindMatter() {
		String id = enterIdMatter();
		return "GET_MATTER" + "|" + id;
	}

	private String requestChangeMatter() {
		String name = null;
		String surname = null;
		String age = "0";
		String university = null;
		String numberOfGroup = "0";
		String idMatter = enterIdMatter();
		String answer;
		Boolean isEnd=false;
		while (!isEnd) {
			answer = this.enterChoiseChange();
			switch (answer) {
			case "1":
				surname = enterResult();
				break;
			case "2":
				name = enterResult();
				break;
			case "3":
				age = enterResult();
				break;
			case "4":
				university = enterResult();
				break;
			case "5":
				numberOfGroup = enterResult();
				break;
			case "0":
				isEnd=true;
				break;
			default:
				this.consoleWriteLine("error");
				break;
			}
		}
		return "CHANGE_MATTER" + "|" + idMatter + "|" + surname + "|" + name + "|" + age + "|" + university + "|"
				+ numberOfGroup;
	}

	private String requestAuthentication() {
		String name = enterName();
		String password = enterPassword();
		return "AUTHENTICATION" + "|" + name + "|" + password;
	}

	public String requestRegistration() {
		String name = enterName();
		String password = enterPassword();
		return "REGISTRATION" + "|" + name + "|" + password;
	}

	public String userCommand() {
		String i = this.enterChoiseUser();
		String request = "";
		switch (i) {
		case "1": {
			request = this.requestFindMatter();
		}
			break;
		case "0": {
			request = "exit";
		}
			break;
		default: {
			request = "error";
		}
			break;
		}
		return request;
	}

	public String adminCommand() {
		String i = this.enterChoiseAdmin();
		String request = "";
		switch (i) {
		case "1": {
			request = this.requestCreateMatter();
		}
			break;
		case "2": {
			request = this.requestChangeMatter();
		}
			break;
		case "3": {
			request = this.requestFindMatter();
		}
			break;
		case "0": {
			request = "exit";
		}
			break;
		default: {
			request = "error";
		}
			break;
		}
		return request;
	}

	public String command() {
		String i = this.enterMainAction();
		String request = "";
		switch (i) {
		case "1": {
			request = this.requestAuthentication();
		}
			break;
		case "2": {
			request = this.requestRegistration();
		}
			break;
		case "0": {
			request = "exit";
		}
			break;
		default: {
			request = "error";
		}
			break;
		}
		return request;
	}

}
