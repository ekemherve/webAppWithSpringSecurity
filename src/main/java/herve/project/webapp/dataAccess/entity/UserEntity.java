package herve.project.webapp.dataAccess.entity;


import herve.project.webapp.model.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "male")
    private Boolean male;

    @Column(name = "hobby")
    private String hobby;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_role", referencedColumnName = "name")},
            inverseJoinColumns = { @JoinColumn(name = "role_user", referencedColumnName = "role") })
    private Set<RoleEntity> roleEntities;

    public UserEntity() {
    }

    /*public UserEntity(String name, Integer age, Boolean male, String hobby) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.hobby = hobby;
    }*/

    public UserEntity(String name, Integer age, Boolean male, String hobby, Set<RoleEntity> roleEntities) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.hobby = hobby;
        this.roleEntities = roleEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
