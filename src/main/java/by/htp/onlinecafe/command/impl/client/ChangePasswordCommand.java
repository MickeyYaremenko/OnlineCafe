package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.util.Encryptor;
import by.htp.onlinecafe.util.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Changes client's password.
 */
public class ChangePasswordCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_CHANGE_PASS_FAIL_PAGE;
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(CLIENT);
        byte[] password = request.getParameter(OLD_PASSWORD).getBytes();
        String oldPass = Encryptor.encodePassword(password);
        String newPasstoValidate1 = request.getParameter(NEW_PASSWORD_1);
        String newPassToValidate2 = request.getParameter(NEW_PASSWORD_2);

        if (!(null != newPasstoValidate1 && newPasstoValidate1.equals(newPassToValidate2)
                && Validator.checkPassword(newPasstoValidate1))){
            return page;
        }

        byte[] newPassArray1 = request.getParameter(NEW_PASSWORD_1).getBytes();
        String newPass1 = Encryptor.encodePassword(newPassArray1);
        byte[] newPassArray2 = request.getParameter(NEW_PASSWORD_2).getBytes();
        String newPass2 = Encryptor.encodePassword(newPassArray2);

        ClientService clientService = ServiceFactory.getInstance().getClientService();
        try {
            Boolean success = clientService.changePassword(client, oldPass, newPass1, newPass2);
            if (success){
                page = REDIRECT_CHANGE_PASS_SUCCESS_PAGE;
            } else {
                page = REDIRECT_CHANGE_PASS_FAIL_PAGE;
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
