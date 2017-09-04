package by.htp.onlinecafe.command;

import by.htp.onlinecafe.command.impl.admin.*;
import by.htp.onlinecafe.command.impl.client.*;
import by.htp.onlinecafe.command.impl.general.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static by.htp.onlinecafe.util.constant.CommandConstant.*;

/**
 * Class that contains command's map and it's instance.
 */
public class CommandManager {

    private static final Logger LOGGER = LogManager.getLogger(CommandManager.class);

    private final static CommandManager instance = new CommandManager();
    private Map<String, Command> commandMap = new HashMap<>();

    private CommandManager() {
        commandMap.put(null, new OpenMainPageCommand());
        commandMap.put(OPEN_MAIN_PAGE, new OpenMainPageCommand());
        commandMap.put(SIGN_IN, new SignInCommand());
        commandMap.put(SIGN_IN_PAGE, new SignInPageCommand());
        commandMap.put(REGISTER, new RegisterCommand());
        commandMap.put(CHOOSE_CATEGORY, new ChooseCategoryCommand());
        commandMap.put(OPEN_MENU, new OpenMenuCommand());
        commandMap.put(ADD_TO_ORDER, new AddToOrderCommand());
        commandMap.put(UPDATE_ORDER, new UpdateOrderCommand());
        commandMap.put(OPEN_ORDER_PAGE, new OpenOrderPageCommand());
        commandMap.put(CHOOSE_LANGUAGE, new ChooseLanguageCommand());
        commandMap.put(ERROR404_PAGE, new Error404PageCommand());
        commandMap.put(SIGN_IN_FAILED, new OpenSignInFailedPageCommand());

        commandMap.put(OPEN_CLIENT_ACCOUNT, new OpenClientAccountCommand());
        commandMap.put(CHANGE_CLIENT_PASSWORD, new ChangePasswordCommand());
        commandMap.put(MAKE_ORDER, new MakeOrderCommand());
        commandMap.put(ADD_FUNDS, new AddFundsCommand());
        commandMap.put(SIGN_OUT, new SignOutCommand());
        commandMap.put(OPEN_ORDER_SUCCESS_PAGE, new OrderSuccessPageCommand());
        commandMap.put(OPEN_CHANGE_PASS_SUCCESS_PAGE, new ChangePassSuccessPageCommand());
        commandMap.put(OPEN_CHANGE_PASS_FAIL_PAGE, new ChangePassFailedPageCommand());
        commandMap.put(OPEN_ORDER_FAIL_PAGE, new OrderFailedPageCommand());
        commandMap.put(OPEN_VIEW_ORDER, new OpenViewOrderPageCommand());

        commandMap.put(MANAGE_ORDERS, new ManageOrderPageCommand());
        commandMap.put(MANAGE_MENU, new MenuManagementPageCommand());
        commandMap.put(MANAGE_MENU_ITEMS, new MenuItemManagementCommand());
        commandMap.put(EDIT_ITEM, new EditItemPageCommand());
        commandMap.put(SAVE_ITEM_CHANGES, new EditItemCommand());
        commandMap.put(ADD_NEW_ITEM_PAGE, new AddNewItemPageCommand());
        commandMap.put(ADD_NEW_ITEM, new AddNewItemCommand());
        commandMap.put(OPEN_ADMIN_PAGE, new OpenAdminPageCommand());
        commandMap.put(SET_ORDER_STATUS, new SetOrderStatusCommand());
        commandMap.put(EDIT_MENU_PAGE, new EditMenuPageCommand());
        commandMap.put(EDIT_MENU, new EditMenuCommand());
        commandMap.put(ADD_NEW_MENU_PAGE, new AddNewMenuPageCommand());
        commandMap.put(ADD_NEW_MENU, new AddNewMenuCommand());
        commandMap.put(DELETE_ITEM, new DeleteItemCommand());
    }

    /**
     * Returns an instance of CommandManager.
     * @return      {@link CommandManager} object
     */
    public static CommandManager getInstance() {
        return instance;
    }

    /**
     * Returns Command object by its name
     * @param title String representation of @Command
     * @return {@link Command} object
     */
    public Command getCommand(String title) {
        LOGGER.info(title);
        return commandMap.get(title);
    }
}
