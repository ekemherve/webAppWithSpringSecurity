package herve.project.webapp.dataAccess.utils;

import herve.project.webapp.dataAccess.entity.RoleEntity;
import herve.project.webapp.dataAccess.entity.UserEntity;
import herve.project.webapp.model.Role;
import herve.project.webapp.model.User;

import java.util.HashSet;
import java.util.Set;

public class ProviderConverter {


    public static User userEntityToUserModel(UserEntity userEntity) {

        User user = new User(userEntity.getName(), userEntity.getAge(), userEntity.getMale(), userEntity.getHobby(), new HashSet<>());

        Set<Role> roles = new HashSet<>();

        userEntity.getRoleEntities().
                forEach(roleEntity -> roles.add(ProviderConverter.roleEntityToRoleModel(roleEntity)));

        user.setRoles(roles);

        return user;
    }

    public static UserEntity userModelToUserEntity(User user) {

        UserEntity userEntity =  new UserEntity(user.getName(), user.getAge(), user.getMale(), user.getHobby(), new HashSet<>());

        Set<RoleEntity> roleEntities = new HashSet<>();

        user.getRoles().stream().
                forEach(role -> roleEntities.add(ProviderConverter.roleToRoleEntity(role)));

        userEntity.setRoleEntities(roleEntities);

        return userEntity;
    }


    public static Role roleEntityToRoleModel(RoleEntity roleEntity) {

        Role role = new Role(roleEntity.getRoleEnum(), new HashSet<>());
        Set<User> users = new HashSet<>();
        roleEntity.
                getUserEntities().stream().
                forEach(userEntity -> users.add(ProviderConverter.userEntityToUserModel(userEntity)));
        role.setUsers(users);
        return role;
    }

    public static RoleEntity roleToRoleEntity(Role role) {

        RoleEntity roleEntity = new RoleEntity(role.getRoleEnum(), new HashSet<>());

        Set<UserEntity> userEntities = new HashSet<>();

        role.getUsers().stream().
                forEach(user -> userEntities.add(ProviderConverter.userModelToUserEntity(user)));

        roleEntity.setUserEntities(userEntities);

        return roleEntity;
    }
}
