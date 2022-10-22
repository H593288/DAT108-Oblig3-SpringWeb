package no.hvl.dat108.ShoppingList.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import no.hvl.dat108.ShoppingList.model.Shoppinglist;
public class LoginUtil {

    public static void logInPassword(HttpServletRequest request, String password, int loginTimeoutInSeconds) {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(loginTimeoutInSeconds);
        session.setAttribute("password", password);
        session.setAttribute("shoppinglist", new Shoppinglist());



    }

    public static boolean isUserLoggedIn(HttpSession session) {
        return session != null
                && session.getAttribute("password") != null
                && session.getAttribute("shoppinglist") != null;
    }
}
