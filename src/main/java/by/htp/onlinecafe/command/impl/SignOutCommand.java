package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/index.jsp";
        HttpSession session = request.getSession();
        session.invalidate();
        return page;
    }
}
