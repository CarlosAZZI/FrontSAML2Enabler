import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getIndexPage(Model model) throws Exception {
        Saml2Authentication auth = (Saml2Authentication) SecurityContextHolder.getContext().getAuthentication();
        String samlResponse = auth.getSaml2Response();
        model.addAttribute("username", auth.getName());
        model.addAttribute("samlresponse", samlResponse);
        return "index";
    }
 }