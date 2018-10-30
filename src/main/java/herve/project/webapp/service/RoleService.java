package herve.project.webapp.service;

import herve.project.webapp.model.Role;
import herve.project.webapp.model.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {

    private Set<RoleEnum> roleEnums = new HashSet<>();

    public RoleService() {
        Role userRole = new Role();
        userRole.setRoleEnum(RoleEnum.USER);

        Role adminRole = new Role();
        adminRole.setRoleEnum(RoleEnum.ADMIN);

        roleEnums.add(userRole.getRoleEnum());
        roleEnums.add(adminRole.getRoleEnum());
    }


    public Set<RoleEnum> getRoleEnums() {
        return roleEnums;
    }

    public void setRoleEnums(Set<RoleEnum> roleEnums) {
        this.roleEnums = roleEnums;
    }
}
