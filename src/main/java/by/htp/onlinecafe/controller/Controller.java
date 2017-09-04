package by.htp.onlinecafe.controller;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.command.CommandManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.WELCOME_PAGE;

/**
 * Main servlet of the application.
 */
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
        String page;
        page = command.execute(req);
        if (page == null){
            page = WELCOME_PAGE;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
        String page;
        page = command.execute(req);
        if (page == null){
            page = WELCOME_PAGE;
        }
        resp.sendRedirect(page);
    }

}

