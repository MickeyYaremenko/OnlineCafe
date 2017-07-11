package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

public class OpenMainPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/index.jsp";
        return page;
    }
}
