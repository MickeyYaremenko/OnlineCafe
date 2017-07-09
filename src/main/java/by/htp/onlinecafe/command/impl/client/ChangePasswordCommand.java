package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/default.jsp";
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        String oldPass = request.getParameter("oldpass");
        String newPass1 = request.getParameter("newpass1");
        String newPass2 = request.getParameter("newpass2");

        ClientService clientService = ClientServiceImpl.getInstance();

        boolean success = false;
        try {
            success = clientService.changePassword(client, oldPass, newPass1, newPass2);
            if (success){
                String msg = "You've successfully changed your password";
                request.setAttribute("changepass", msg);
            } else {
                String msg = "You've entered wrong credentials";
                request.setAttribute("changepass", msg);
            }
            page = "/WEB-INF/jsp/client_account.jsp";
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
