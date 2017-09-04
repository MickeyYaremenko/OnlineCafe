package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.util.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Registers new client in database.
 */
public class RegisterCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(RegisterCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_MENU_PAGE;
        ClientService clientService = ServiceFactory.getInstance().getClientService();

        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        String email = request.getParameter(EMAIL);

        if (null != login && null != password && null != confirmPassword && null != firstName &&
                null != lastName && null != email && Validator.checkLogin(login) &&
                password.equals(confirmPassword) && Validator.checkPassword(password) &&
                Validator.checkEmail(email)){
            try {
                Client client = clientService.register(login, password, confirmPassword, firstName, lastName, email);
                HttpSession session = request.getSession();
                session.setAttribute(CLIENT, client);
            } catch (ServiceException e) {
                LOGGER.error(e);
            }
        }

        return page;
    }
}
