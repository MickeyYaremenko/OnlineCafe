package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/menu.jsp";
        ClientService clientService = ClientServiceImpl.getInstance();

        String login = request.getParameter("signIn");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");

        try {
            Client client = clientService.register(login, password, confirmPassword, firstName, lastName, email);
            HttpSession session = request.getSession();
            session.setAttribute("client", client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
