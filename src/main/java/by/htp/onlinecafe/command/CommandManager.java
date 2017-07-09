package by.htp.onlinecafe.command;

import by.htp.onlinecafe.command.impl.*;
import by.htp.onlinecafe.command.impl.client.*;

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
        commandMap.put("open_client_acc", new OpenClientAccountCommand());
        commandMap.put("change_client_pass", new ChangePasswordCommand());
        commandMap.put("open_menu", new OpenMenuCommand());
        commandMap.put("add_to_order", new AddToOrderCommand());
        commandMap.put("update_order", new UpdateOrderCommand());
        commandMap.put("make_order", new MakeOrderCommand());
        commandMap.put("add_funds", new AddFundsCommand());
    }

    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String title) {
        System.out.println(title);
        Command command = commandMap.get(title);
        if (command != null) {
            return command;
        }
        return null; /*change to default page */
    }
}
