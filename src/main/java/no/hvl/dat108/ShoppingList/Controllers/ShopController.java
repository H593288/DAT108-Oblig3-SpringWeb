package no.hvl.dat108.ShoppingList.Controllers;

import no.hvl.dat108.ShoppingList.Util.LoginUtil;
import no.hvl.dat108.ShoppingList.model.ShoppingItem;
import no.hvl.dat108.ShoppingList.model.Shoppinglist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

import no.hvl.dat108.ShoppingList.model.ShoppingItem;

@Controller
@RequestMapping("/${app.url.shop}")
public class ShopController {

    @Value("${app.message.requiresLogin}")
    private String REQUIRES_LOGIN_MESAGE;
    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.shop}")
    private String SHOP_URL;

    @GetMapping
    public String shopView(HttpSession session, RedirectAttributes ra, Model model) {
        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESAGE);
            return "redirect:" + LOGIN_URL;
        }
        return "shopView";
    }

    @PostMapping
    public String modifyShoppingList(
            @RequestParam(name = "item", required = true) String item,
            @RequestParam(name = "action", required = true) String action,
            HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESAGE);
            return "redirect:" + LOGIN_URL;
        }

        if (item.trim().length() > 0)
        {
            Shoppinglist shoppinglist = (Shoppinglist) session.getAttribute("shoppinglist");
            if (shoppinglist != null) {
                if (Objects.equals(action, "add"))
                {
                    shoppinglist.addItem(new ShoppingItem(item));
                }
                else if (Objects.equals(action, "delete"))
                {
                    shoppinglist.removeItem(item);
                }
            }
        }

        return "redirect:" + SHOP_URL;
    }

}
