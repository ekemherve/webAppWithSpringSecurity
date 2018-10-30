package herve.project.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    @NotEmpty(message = "You must enter a name !!")
    @NotNull
    @Size(min = 4, max = 12, message = "The name must contains at min 4 and max 12 characters")
    private String name;

    @Min(value = 1)
    @Max(value = 12)
    private Integer age;

    private Boolean male;
    private String hobby;


    private Set<Role> roles = new HashSet<>();



    public User() {
    }

    /*public User(String name, Integer age, Boolean male, String hobby) {
        this.name = name.toLowerCase();
        this.age = age;
        this.male = male;
        this.hobby = hobby;
    }*/

    public User(String name, Integer age, Boolean male, String hobby, Set<Role> roles) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.hobby = hobby;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public boolean exists() {

        return this.name != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName()/*, getAge(), getMale(), getHobby(), getBankAccounts()*/);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", male=" + male +
                ", hobby='" + hobby + '\'' +
                ", roles=" + roles +
                '}';
    }
}
