package by.htp.onlinecafe.command.impl.client;

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

public class ChangePasswordCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String page = "/WEB-INF/jsp/client/client_account.jsp";
        String page = "/Controller?command=open_change_pass_success_page";
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        String oldPass = request.getParameter("oldpass");
        String newPass1 = request.getParameter("newpass1");
        String newPass2 = request.getParameter("newpass2");

        ClientService clientService = ServiceFactory.getInstance().getClientService();

        boolean success;
        try {
            success = clientService.changePassword(client, oldPass, newPass1, newPass2);
            if (success){
                page = "/Controller?command=open_change_pass_success_page";
            } else {
                page = "/Controller?command=open_change_pass_failed_page";
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
