package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ChooseLanguageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String language = request.getParameter("language");

        Map<String, String> pageMap = new HashMap<>();
        pageMap.put("index", "/index.jsp");
        pageMap.put(null, "/index.jsp");

        String pageName = (String) session.getAttribute("page");

        String page = pageMap.get(pageName);

        if (language.equals("RU_RU")){
            session.setAttribute("language", "RU_RU");
            session.setAttribute("properties", "language_RU_RU");
        } else if (language.equals("EN_EN")){
            session.setAttribute("language", "EN_EN");
            session.setAttribute("properties", "language_EN_EN");
        }

        return page;
    }
}
