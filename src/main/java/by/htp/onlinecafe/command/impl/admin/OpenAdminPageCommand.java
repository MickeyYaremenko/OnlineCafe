package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenAdminPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/admin_page.jsp";
        return page;
    }
}
