package by.htp.onlinecafe.util.constant;

/**
 * Contains JSP page's names and redirect instructions
 */
public final class JSPPageConstant {

    private JSPPageConstant(){}

    public static final String WELCOME_PAGE = "/index.jsp";
    public static final String SIGN_IN_PAGE = "/WEB-INF/jsp/sign_in.jsp";
    public static final String MENU_PAGE = "/WEB-INF/jsp/menu.jsp";
    public static final String ITEM_LIST_PAGE = "/WEB-INF/jsp/item_list.jsp";
    public static final String ORDER_PAGE = "/WEB-INF/jsp/order.jsp";
    public static final String ERROR_404_PAGE  = "/WEB-INF/jsp/error/error404.jsp";
    public static final String SIGN_IN_FAILED_PAGE = "/WEB-INF/jsp/sign_in_failed.jsp";
    public static final String CLIENT_ACCOUNT_PAGE  = "/WEB-INF/jsp/client/client_account.jsp";
    public static final String ORDER_SUCCESS_PAGE = "/WEB-INF/jsp/client/order_success.jsp";
    public static final String ORDER_FAIL_PAGE = "/WEB-INF/jsp/client/order_failed.jsp";
    public static final String CHANGE_PASS_SUCCESS_PAGE = "/WEB-INF/jsp/client/password_changed.jsp";
    public static final String CHANGE_PASS_FAIL_PAGE = "/WEB-INF/jsp/client/change_pass_failed.jsp";
    public static final String ORDER_MANAGEMENT_PAGE = "/WEB-INF/jsp/admin/order_management.jsp";
    public static final String MENU_MANAGEMENT_PAGE = "/WEB-INF/jsp/admin/menu_management.jsp";
    public static final String MENU_ITEM_MANAGEMENT_PAGE = "/WEB-INF/jsp/admin/menu_item_management.jsp";
    public static final String EDIT_ITEM_PAGE = "/WEB-INF/jsp/admin/edit_item.jsp";
    public static final String ADD_NEW_ITEM_PAGE = "/WEB-INF/jsp/admin/add_new_item.jsp";
    public static final String ADMIN_PAGE = "/WEB-INF/jsp/admin/admin_page.jsp";
    public static final String EDIT_MENU_PAGE = "/WEB-INF/jsp/admin/edit_menu.jsp";
    public static final String ADD_NEW_MENU_PAGE = "/WEB-INF/jsp/admin/add_new_menu.jsp";
    public static final String OPEN_VIEW_ORDER_PAGE = "/WEB-INF/jsp/client/view_order.jsp";


    public static final String REDIRECT_MAIN_PAGE = "/Controller?command=open_main_page";
    public static final String REDIRECT_SIGN_IN_PAGE = "/Controller?command=sign_in_page";
    public static final String REDIRECT_MENU_PAGE = "/Controller?command=open_menu";
    public static final String REDIRECT_ADMIN_PAGE = "/Controller?command=open_admin_page";
    public static final String REDIRECT_ORDER_PAGE = "/Controller?command=open_order_page";
    public static final String REDIRECT_CHANGE_PASS_SUCCESS_PAGE  = "/Controller?command=open_change_pass_success_page";
    public static final String REDIRECT_CHANGE_PASS_FAIL_PAGE  = "/Controller?command=open_change_pass_failed_page";
    public static final String REDIRECT_ORDER_SUCCESS_PAGE = "/Controller?command=open_order_success_page";
    public static final String REDIRECT_ORDER_FAIL_PAGE = "/Controller?command=open_order_fail_page";
    public static final String REDIRECT_CLIENT_ACCOUNT_PAGE = "/Controller?command=open_client_acc";
    public static final String REDIRECT_MANAGE_MENU_ITEMS = "/Controller?command=manage_menu_items";
    public static final String REDIRECT_MANAGE_ORDERS = "/Controller?command=manage_orders";
    public static final String REDIRECT_MANAGE_MENU = "/Controller?command=manage_menu";
    public static final String REDIRECT_ERROR404_PAGE = "/Controller?command=error404_page";
    public static final String REDIRECT_SIGN_IN_FAILED = "/Controller?command=sign_in_failed";
    public static final String REDIRECT_ADD_NEW_ITEM_PAGE = "/Controller?command=add_new_item_page";
    public static final String REDIRECT_ADD_NEW_MENU_PAGE = "/Controller?command=add_new_menu_page";

}
