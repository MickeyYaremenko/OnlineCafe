package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/index.jsp";
        ClientService clientService = ClientServiceImpl.getInstance();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            Client client = clientService.signIn(login, password);
            HttpSession session = request.getSession();
            session.setAttribute("client", client);
            if (client.getRole().equals(Client.Role.CLIENT)){
                page = "/WEB-INF/jsp/menu.jsp";
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
