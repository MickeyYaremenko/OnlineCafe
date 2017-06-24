package by.htp.onlinecafe.command;

import by.htp.onlinecafe.command.impl.ChooseCategoryCommand;
import by.htp.onlinecafe.command.impl.RegisterCommand;
import by.htp.onlinecafe.command.impl.SignInCommand;
import by.htp.onlinecafe.command.impl.SignInPageCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final static CommandManager instance = new CommandManager();
    private Map<String, Command> commandMap = new HashMap<>();

    private CommandManager() {
        commandMap.put("sign_in", new SignInCommand());
        commandMap.put("sign_in_page", new SignInPageCommand());
        commandMap.put("register", new RegisterCommand());
        commandMap.put("choose_category", new ChooseCategoryCommand());
    }

    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String title) {
        Command command = commandMap.get(title);
        if (command != null) {
            return command;
        }
        return null; /*change to default page */
    }
}
