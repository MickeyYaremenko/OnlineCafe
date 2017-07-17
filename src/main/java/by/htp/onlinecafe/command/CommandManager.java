package by.htp.onlinecafe.command;

import by.htp.onlinecafe.command.impl.*;
import by.htp.onlinecafe.command.impl.admin.*;
import by.htp.onlinecafe.command.impl.client.*;
import by.htp.onlinecafe.command.impl.general.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final static CommandManager instance = new CommandManager();
    private Map<String, Command> commandMap = new HashMap<>();

    private CommandManager() {
        commandMap.put(null, new OpenMainPageCommand());
        commandMap.put("open_main_page", new OpenMainPageCommand());
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
        commandMap.put("open_order_page", new OpenOrderPageCommand());
        commandMap.put("manage_orders", new ManageOrderPageCommand());
        commandMap.put("manage_menu", new MenuManagementCommand());
        commandMap.put("view_menu_history", new ViewMenuHistoryCommand());
        commandMap.put("manage_menu_items", new MenuItemManagementCommand());
        commandMap.put("edit_item", new EditItemPageCommand());
        commandMap.put("save_item_changes", new EditItemCommand());
        commandMap.put("add_new_item_page", new AddNewItemPageCommand());
        commandMap.put("add_new_item", new AddNewItemCommand());
        commandMap.put("open_admin_page", new OpenAdminPageCommand());
        commandMap.put("set_order_status", new SetOrderStatusCommand());
        commandMap.put("choose_language", new ChooseLanguageCommand());
        commandMap.put("sign_out", new SignOutCommand());
    }

    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String title) {
        System.out.println(title);
        return commandMap.get(title);
    }
}
