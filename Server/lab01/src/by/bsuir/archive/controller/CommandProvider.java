package by.bsuir.archive.controller;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.archive.controller.command.Command;
import by.bsuir.archive.controller.command.impl.ChangeMatter;
import by.bsuir.archive.controller.command.impl.CreateMatter;
import by.bsuir.archive.controller.command.impl.GetMatter;
import by.bsuir.archive.controller.command.impl.StartServer;

class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("START", new StartServer());
		commands.put("CREATE_MATTER", new CreateMatter());
		commands.put("GET_MATTER", new GetMatter());
		commands.put("CHANGE_MATTER", new ChangeMatter());
	}

	Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;

	}

}
