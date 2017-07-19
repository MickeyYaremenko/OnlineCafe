package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/index.jsp";
        ClientService clientService = ServiceFactory.getInstance().getClientService();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            Client client = clientService.signIn(login, password);
            HttpSession session = request.getSession();
            session.setAttribute("client", client);
            if (client.getRole().equals(Client.Role.CLIENT)){
                page = "/WEB-INF/jsp/menu.jsp";
            } else if (client.getRole().equals(Client.Role.ADMIN)){
                page = "/WEB-INF/jsp/admin/admin_page.jsp";
            }

        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
