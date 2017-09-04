package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens add_new_item.jsp.
 */
public class AddNewItemPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ADD_NEW_ITEM_PAGE;
        return page;
    }
}
