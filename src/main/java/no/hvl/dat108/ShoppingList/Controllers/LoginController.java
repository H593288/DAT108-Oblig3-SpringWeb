package no.hvl.dat108.ShoppingList.Controllers;

import no.hvl.dat108.ShoppingList.Util.LoginUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.shop}") private String SHOP_URL;
    @Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;
    @Value("${app.login.password}") private String PASSWORD;
    @Value("${app.login.timeoutInSeconds}") private int LOGIN_TIMEOUT_IN_SECONDS;

    @GetMapping
    public String LoginForm() {
        return "loginView";

    }

    @PostMapping
    public String loginPassword(@RequestParam String password, HttpServletRequest request, RedirectAttributes ra) {

        if (!password.equals(PASSWORD)) {
            ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
            return "redirect:" + LOGIN_URL;
        }

        LoginUtil.logInPassword(request, password, LOGIN_TIMEOUT_IN_SECONDS);

        return "redirect:" + SHOP_URL;

    }
}
