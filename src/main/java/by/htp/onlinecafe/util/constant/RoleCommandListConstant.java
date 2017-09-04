package by.htp.onlinecafe.util.constant;

import java.util.ArrayList;
import java.util.List;

import static by.htp.onlinecafe.util.constant.CommandConstant.*;

/**
 * Contains Lists with commands by client's role
 */
public final class RoleCommandListConstant {

    private RoleCommandListConstant(){}

    private static final List<String> GENERAL_COMMAND_LIST;
    private static final List<String> CLIENT_COMMAND_LIST;
    private static final List<String> ADMIN_COMMAND_LIST;

    static {
        GENERAL_COMMAND_LIST = new ArrayList<>();
        GENERAL_COMMAND_LIST.add(OPEN_MAIN_PAGE);
        GENERAL_COMMAND_LIST.add(SIGN_IN);
        GENERAL_COMMAND_LIST.add(SIGN_IN_PAGE);
        GENERAL_COMMAND_LIST.add(REGISTER);
        GENERAL_COMMAND_LIST.add(CHOOSE_CATEGORY);
        GENERAL_COMMAND_LIST.add(OPEN_MENU);
        GENERAL_COMMAND_LIST.add(ADD_TO_ORDER);
        GENERAL_COMMAND_LIST.add(UPDATE_ORDER);
        GENERAL_COMMAND_LIST.add(OPEN_ORDER_PAGE);
        GENERAL_COMMAND_LIST.add(CHOOSE_LANGUAGE);
        GENERAL_COMMAND_LIST.add(ERROR404_PAGE);
        GENERAL_COMMAND_LIST.add(SIGN_IN_FAILED);

        CLIENT_COMMAND_LIST = new ArrayList<>();
        CLIENT_COMMAND_LIST.add(SIGN_OUT);
        CLIENT_COMMAND_LIST.add(MAKE_ORDER);
        CLIENT_COMMAND_LIST.add(ADD_FUNDS);
        CLIENT_COMMAND_LIST.add(OPEN_CLIENT_ACCOUNT);
        CLIENT_COMMAND_LIST.add(CHANGE_CLIENT_PASSWORD);
        CLIENT_COMMAND_LIST.add(OPEN_ORDER_SUCCESS_PAGE);
        CLIENT_COMMAND_LIST.add(OPEN_CHANGE_PASS_SUCCESS_PAGE);
        CLIENT_COMMAND_LIST.add(OPEN_CHANGE_PASS_FAIL_PAGE);
        CLIENT_COMMAND_LIST.add(OPEN_ORDER_FAIL_PAGE);
        CLIENT_COMMAND_LIST.add(OPEN_VIEW_ORDER);

        ADMIN_COMMAND_LIST = new ArrayList<>();
        ADMIN_COMMAND_LIST.add(MANAGE_ORDERS);
        ADMIN_COMMAND_LIST.add(MANAGE_MENU);
        ADMIN_COMMAND_LIST.add(MANAGE_MENU_ITEMS);
        ADMIN_COMMAND_LIST.add(EDIT_ITEM);
        ADMIN_COMMAND_LIST.add(SAVE_ITEM_CHANGES);
        ADMIN_COMMAND_LIST.add(ADD_NEW_ITEM_PAGE);
        ADMIN_COMMAND_LIST.add(ADD_NEW_ITEM);
        ADMIN_COMMAND_LIST.add(OPEN_ADMIN_PAGE);
        ADMIN_COMMAND_LIST.add(SET_ORDER_STATUS);
        ADMIN_COMMAND_LIST.add(EDIT_MENU_PAGE);
        ADMIN_COMMAND_LIST.add(EDIT_MENU);
        ADMIN_COMMAND_LIST.add(ADD_NEW_MENU_PAGE);
        ADMIN_COMMAND_LIST.add(ADD_NEW_MENU);
        ADMIN_COMMAND_LIST.add(DELETE_ITEM);
    }

    public static List<String> getGeneralCommandList() {
        return GENERAL_COMMAND_LIST;
    }

    public static List<String> getClientCommandList() {
        return CLIENT_COMMAND_LIST;
    }

    public static List<String> getAdminCommandList() {
        return ADMIN_COMMAND_LIST;
    }
}
