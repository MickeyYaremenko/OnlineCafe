package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/menu.jsp";
        ClientService clientService = ServiceFactory.getInstance().getClientService();

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
