package herve.project.webapp.dataAccess.entity;

import herve.project.webapp.model.RoleEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "role")
@Entity
public class RoleEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum roleEnum;

    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> userEntities = new HashSet<>();

    public RoleEntity() {
    }

    public RoleEntity(RoleEnum roleEnum, Set<UserEntity> userEntities) {
        this.roleEnum = roleEnum;
        this.userEntities = userEntities;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity)) return false;
        RoleEntity that = (RoleEntity) o;
        return getRoleEnum() == that.getRoleEnum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleEnum());
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleEnum=" + roleEnum +
                '}';
    }
}
