package by.htp.onlinecafe.controller;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.command.CommandManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        processRequest(req, resp);
        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
        String page;
        if (command != null) {
            page = command.execute(req, resp);
        } else {
            page = "/index.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        processRequest(req, resp);
        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
        String page;
        page = command.execute(req, resp);
        resp.sendRedirect(page);
    }

//    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Command command = CommandManager.getInstance().getCommand(req.getParameter("command"));
//        String page;
//        if (command != null) {
//            page = command.execute(req, resp);
//        } else {
//            page = "/index.jsp";
//        }
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
//        dispatcher.forward(req, resp);
//    }
}

