package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Switches languages in session/
 */
public class ChooseLanguageCommand implements Command{

    private static final HashMap<String, String> pageMap;

    static {
        pageMap = new HashMap<>();
        pageMap.put("index", REDIRECT_MAIN_PAGE);
        pageMap.put(null, REDIRECT_MAIN_PAGE);
        pageMap.put("menu", REDIRECT_MENU_PAGE);
        pageMap.put("order", REDIRECT_ORDER_PAGE);
        pageMap.put("item_list", REDIRECT_MENU_PAGE);
        pageMap.put("sign_in", REDIRECT_SIGN_IN_PAGE);
        pageMap.put("menu_item_management", REDIRECT_MANAGE_MENU_ITEMS);
        pageMap.put("sign_in_fail", REDIRECT_SIGN_IN_FAILED);
        pageMap.put("change_pass_failed", REDIRECT_CHANGE_PASS_FAIL_PAGE);
        pageMap.put("client_account", REDIRECT_CLIENT_ACCOUNT_PAGE);
        pageMap.put("order_failed", REDIRECT_ORDER_FAIL_PAGE);
        pageMap.put("order_success", REDIRECT_ORDER_SUCCESS_PAGE);
        pageMap.put("change_pass_success", REDIRECT_CHANGE_PASS_SUCCESS_PAGE);
        pageMap.put("add_new_item", REDIRECT_ADD_NEW_ITEM_PAGE);
        pageMap.put("add_menu", REDIRECT_ADD_NEW_MENU_PAGE);
        pageMap.put("admin_page", REDIRECT_ADMIN_PAGE);
        pageMap.put("edit_item", REDIRECT_MANAGE_MENU_ITEMS);
        pageMap.put("edit_menu", REDIRECT_MANAGE_MENU);
        pageMap.put("menu_item_management", REDIRECT_MANAGE_MENU_ITEMS);
        pageMap.put("menu_management", REDIRECT_MANAGE_MENU);
        pageMap.put("order_management", REDIRECT_MANAGE_ORDERS);
        pageMap.put("view_order", REDIRECT_MAIN_PAGE);
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String language = request.getParameter(LANGUAGE);

        String pageName = (String) session.getAttribute(PAGE);

        String page = pageMap.get(pageName);

        if (language.equals(RUSSIAN)){
            session.setAttribute(LANGUAGE, RUSSIAN);
        } else if (language.equals(ENGLISH)){
            session.setAttribute(LANGUAGE, ENGLISH);
        }

        return page;
    }
}
