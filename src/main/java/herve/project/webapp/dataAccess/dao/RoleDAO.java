package herve.project.webapp.dataAccess.dao;

import herve.project.webapp.dataAccess.repository.RoleRepository;
import herve.project.webapp.dataAccess.utils.ProviderConverter;
import herve.project.webapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleDAO {


    @Autowired
    private RoleRepository roleRepository;


    public Set<Role> getAllRoles() {

        return roleRepository.findAll().stream().
                map(roleEntity -> ProviderConverter.roleEntityToRoleModel(roleEntity)).collect(Collectors.toSet());
    }

    public Role save(Role role) {

        return role != null ? ProviderConverter.roleEntityToRoleModel(roleRepository.save(
                ProviderConverter.roleToRoleEntity(role)))
                : null ;
    }

}
