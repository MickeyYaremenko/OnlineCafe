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

        if (language.equals("ru_RU")){
            session.setAttribute("language", "ru_RU");
        } else if (language.equals("en_EN")){
            session.setAttribute("language", "en_EN");
        }

        return page;
    }
}
