package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AddToOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/order.jsp";
        HttpSession session = request.getSession();
        Map<String, Integer> order = (Map<String, Integer>) session.getAttribute("order");
        if (order == null){
            order = parseOrder(request);
        } else {
            order = parseOrder(request, order);
        }
        session.setAttribute("order", order);
        return page;
    }

    private Map<String, Integer> parseOrder(HttpServletRequest request) {
        Map<String, Integer> order = new HashMap<>();
        String[] tempOrderItems = request.getParameterValues("item");
        String[] tempItemsQuantity1 = request.getParameterValues("quant");
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity1[i]);
            if (tempQuantity > 0) {
                String tempItem = tempOrderItems[i];
                order.put(tempItem, tempQuantity);
            }
        }
        return order;
    }

    private Map<String, Integer> parseOrder(HttpServletRequest request, Map<String, Integer> order) {
        String[] tempOrderItems = request.getParameterValues("item");
        String[] tempItemsQuantity = request.getParameterValues("quant");
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity[i]);
            if (tempQuantity > 0) {
                String tempItem = tempOrderItems[i];
                if (order.containsKey(tempItem)) {
                    order.put(tempItem, order.get(tempItem) + tempQuantity);
                } else {
                    order.put(tempItem, tempQuantity);
                }
            }
        }
        return order;
    }
}
