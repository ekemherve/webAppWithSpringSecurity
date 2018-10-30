package herve.project.webapp.controller;

import herve.project.webapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import static herve.project.webapp.model.Constants.CURRENT_USER;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes({CURRENT_USER})
public class UserController {


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(CURRENT_USER) User user) {

        model.addAttribute("welcome", "WelcomePage");

        if(user==null) {
            System.out.println("Ajout en session d'un nouveau user");
            model.addAttribute(CURRENT_USER, new User());
        }
        return "integrated:userHomePage";
    }
}
