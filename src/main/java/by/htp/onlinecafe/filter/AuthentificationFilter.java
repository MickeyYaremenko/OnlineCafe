package by.htp.onlinecafe.filter;

import by.htp.onlinecafe.entity.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import by.htp.onlinecafe.util.constant.RoleCommandListConstant;
import static by.htp.onlinecafe.util.constant.CommandConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;
import by.htp.onlinecafe.util.constant.JSPPageConstant;

/**
 * This filter checks if client's role match his request.
 */
@WebFilter(servletNames = "Controller",
    initParams = {@WebInitParam(name = OPEN_MAIN_PAGE, value = JSPPageConstant.REDIRECT_MAIN_PAGE),
                @WebInitParam(name = SIGN_IN_PAGE, value = JSPPageConstant.REDIRECT_SIGN_IN_PAGE),
                @WebInitParam(name = ERROR404_PAGE, value = JSPPageConstant.REDIRECT_ERROR404_PAGE)})

public class AuthentificationFilter implements Filter{

    private String mainPage;
    private String signInPage;
    private String error404Page;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mainPage = filterConfig.getInitParameter(OPEN_MAIN_PAGE);
        signInPage = filterConfig.getInitParameter(SIGN_IN_PAGE);
        error404Page = filterConfig.getInitParameter(ERROR404_PAGE);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession(false);

        if (session != null){
            String command = servletRequest.getParameter(COMMAND);
            Client client = (Client) session.getAttribute(CLIENT);
            validate(client, command, servletRequest, servletResponse, chain);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    /**
     * Checks client's role to process the command
     * @param client for check
     * @param command command for check
     * @param request
     * @param response
     * @param chain
     */
    private void validate(Client client, String command, ServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        List<String> generalCommandList = RoleCommandListConstant.getGeneralCommandList();
        List<String> clientCommandList = RoleCommandListConstant.getClientCommandList();
        List<String> adminCommandList = RoleCommandListConstant.getAdminCommandList();

        if (!(generalCommandList.contains(command) || clientCommandList.contains(command) || adminCommandList.contains(command))){
            response.sendRedirect(error404Page);
        } else if (client == null && (clientCommandList.contains(command) || adminCommandList.contains(command))){
            response.sendRedirect(signInPage);
        } else if (!(client == null) && client.getRole().equals(Client.Role.CLIENT) && adminCommandList.contains(command)){
            response.sendRedirect(mainPage);
        } else {
            chain.doFilter(request, response);
        }
    }
}
