package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

public class AddNewItemPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/admin/add_new_item.jsp";
        return page;
    }
}
