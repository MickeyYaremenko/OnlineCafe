package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mike Yaremenko on 20.06.2017.
 */
public class SignInPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/sign_in.jsp";
        return page;
    }
}
