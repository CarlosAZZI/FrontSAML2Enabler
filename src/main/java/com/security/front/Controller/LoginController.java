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