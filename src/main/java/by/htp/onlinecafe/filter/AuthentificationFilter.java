package by.htp.onlinecafe.filter;

import by.htp.onlinecafe.entity.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(servletNames = "Controller",
    initParams = {@WebInitParam(name = "main_page", value = "/Controller?command=open_main_page"),
                @WebInitParam(name = "sign_in", value = "/Controller?command=sign_in_page")})
public class AuthentificationFilter implements Filter{

    private String mainPage;
    private String signInPage;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        mainPage = filterConfig.getInitParameter("main_page");
        signInPage = filterConfig.getInitParameter("sign_in");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession(false);

        if (session != null){
            String command = servletRequest.getParameter("command");
            Client client = (Client) session.getAttribute("client");
            validate(client, command, servletRequest, servletResponse, chain);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }

    private void validate(Client client, String command, ServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("validating");

        List<String> publicCommandList = new ArrayList<>();
        List<String> clientCommandList = new ArrayList<>();
        List<String> adminCommandList = new ArrayList<>();

        publicCommandList.add("open_main_page");
        publicCommandList.add("sign_in");
        publicCommandList.add("sign_in_page");
        publicCommandList.add("register");
        publicCommandList.add("choose_category");
        publicCommandList.add("open_menu");
        publicCommandList.add("add_to_order");
        publicCommandList.add("update_order");
        publicCommandList.add("open_order_page");
        publicCommandList.add("choose_language");

        clientCommandList.add("sign_out");
        clientCommandList.add("make_order");
        clientCommandList.add("add_funds");
        clientCommandList.add("open_client_acc");
        clientCommandList.add("change_client_pass");

        adminCommandList.add("manage_orders");
        adminCommandList.add("manage_menu");
        adminCommandList.add("view_menu_history");
        adminCommandList.add("manage_menu_items");
        adminCommandList.add("edit_item");
        adminCommandList.add("save_item_changes");
        adminCommandList.add("add_new_item_page");
        adminCommandList.add("add_new_item");
        adminCommandList.add("open_admin_page");
        adminCommandList.add("set_order_status");

        if (client == null && (clientCommandList.contains(command) || adminCommandList.contains(command))){
            response.sendRedirect(signInPage);
        } else if (!(client == null) && client.getRole().equals(Client.Role.CLIENT) && adminCommandList.contains(command)){
            response.sendRedirect(mainPage);
        } else {
            chain.doFilter(request, response);
        }
    }
}
