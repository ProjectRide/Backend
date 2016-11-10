package microservices.webserver;

import microservices.accountsserver.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Sebastian on 10.11.16.
 */

@Controller
public class WebAccountsController {

    @Autowired
    protected WebAccountService accountsService;


    public WebAccountsController(WebAccountService accountsService) {
        this.accountsService = accountsService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("accountNumber", "searchText");
    }

    @RequestMapping("/accounts")
    public String goHome() {
        return "index";
    }

    @RequestMapping("/accounts/{accountNumber}")
    public String byNumber(Model model,
                           @PathVariable("accountNumber") String accountNumber) {


        Account account = accountsService.findByNumber(accountNumber);

        model.addAttribute("account", account);
        return "account";
    }

    @RequestMapping("/accounts/owner/{text}")
    public String ownerSearch(Model model, @PathVariable("text") String name) {


        List<Account> accounts = accountsService.byOwnerContains(name);

        model.addAttribute("search", name);
        if (accounts != null)
            model.addAttribute("accounts", accounts);
        return "accounts";
    }


}
