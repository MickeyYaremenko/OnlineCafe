package by.htp.onlinecafe.command;

import by.htp.onlinecafe.command.impl.RegisterCommand;
import by.htp.onlinecafe.command.impl.SignInPageCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mike Yaremenko on 16.06.2017.
 */
public class CommandManager {

    private final static CommandManager instance = new CommandManager();
    private Map<String, Command> commandMap = new HashMap<>();

    private CommandManager() {
        commandMap.put("login", new RegisterCommand());
        commandMap.put("Sign_in_page", new SignInPageCommand());
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
