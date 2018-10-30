package herve.project.webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Role {

    private RoleEnum roleEnum;

    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(RoleEnum roleEnum, Set<User> users) {
        this.roleEnum = roleEnum;
        this.users = users;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getRoleEnum() == role.getRoleEnum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleEnum());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleEnum=" + roleEnum +
                '}';
    }
}
