package herve.project.webapp.controller;

import static herve.project.webapp.model.Constants.*;

import herve.project.webapp.dataAccess.dao.UserDAO;
import herve.project.webapp.model.User;
import herve.project.webapp.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({CURRENT_USER})
public class WelcomeController {


    @Autowired
    private HobbyService hobbyService;

    @Autowired
    private UserDAO userDAO;

    @ModelAttribute(CURRENT_USER)
    public User user(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("welcome", "WelcomePage");

        return "integrated:welcome";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(Model model) {

        return "integrated:loginUser";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String register(Model model, @ModelAttribute(CURRENT_USER) User user) {

        //System.out.println(user);
        model.addAttribute("hobbies", hobbyService.getHobbies());
        return "integrated:registerUser";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String validate(@Valid @ModelAttribute(value = CURRENT_USER) User user, final BindingResult errors, Model model) {

        if(errors.hasErrors()) {

            return "integrated:errorPage";
        }

        model.addAttribute(CURRENT_USER, user);

        User userSaved =  user;
        if(userDAO.isValidUser(user)) {
            userSaved = userDAO.save(user);
            System.out.println("User enregistrée : " + userSaved);
        }
        else
            System.out.println("User existe déjà ou est null : " + userSaved);



        return "redirect:/home/register";
    }
}
