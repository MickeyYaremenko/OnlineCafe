package by.htp.onlinecafe.controller;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.command.CommandManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mike Yaremenko on 15.06.2017.
 */
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
        String page = null;
        if (command != null) {
            page = command.execute(req);
        } else {
            page = "/index.jsp";
        }
//        if (req.getAttribute(ATTR_PAGE) == REDIRECT_PAGE) {
//            resp.sendRedirect(page);
//        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
//        }
    }
}

