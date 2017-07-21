package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePassSuccessPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/client/password_changed.jsp";
        return page;
    }
}
