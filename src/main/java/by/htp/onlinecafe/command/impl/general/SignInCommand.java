package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.util.Encryptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Signs in client to the session.
 */
public class SignInCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = WELCOME_PAGE;
        ClientService clientService = ServiceFactory.getInstance().getClientService();

        String login = request.getParameter(LOGIN);
        byte[] password = request.getParameter(PASSWORD).getBytes();
        String encryptedPass = Encryptor.encodePassword(password);

        try {
            Client client = clientService.signIn(login, encryptedPass);
            if (client == null){
                page = REDIRECT_SIGN_IN_FAILED;
                return page;
            }
            HttpSession session = request.getSession();
            session.setAttribute(CLIENT, client);
            if (client.getRole().equals(Client.Role.CLIENT)){
                page = REDIRECT_MENU_PAGE;
            } else if (client.getRole().equals(Client.Role.ADMIN)){
                page = REDIRECT_ADMIN_PAGE;
            }

        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
