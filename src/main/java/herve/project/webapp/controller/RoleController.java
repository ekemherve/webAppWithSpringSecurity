package herve.project.webapp.controller;

import herve.project.webapp.dataAccess.dao.RoleDAO;
import herve.project.webapp.model.Role;
import herve.project.webapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Set;

import static herve.project.webapp.model.Constants.CURRENT_USERROLES;

@Controller
@RequestMapping(value = "/roles")
@SessionAttributes({CURRENT_USERROLES})
public class RoleController {

    private final RoleDAO roleDAO;
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleDAO roleDAO, RoleService roleService) {
        this.roleDAO = roleDAO;
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {

        model.addAttribute("currentUserRoles", new Role());
        model.addAttribute("roles", roleService.getRoleEnums());
        return "integrated:role";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("currentUserRoles")Role role, final BindingResult errors,
                       @ModelAttribute(CURRENT_USERROLES)Set<Role> roles, Model model) {

        if(errors.hasErrors()) {

            return "integrated:errorPage";
        }

        System.out.println("Voici le role à sauvegarder : " + role.getRoleEnum());

        roles.add(role);
        model.addAttribute(CURRENT_USERROLES, roles);
        roleDAO.save(role);

        return "redirect:/home/register";
    }
}
