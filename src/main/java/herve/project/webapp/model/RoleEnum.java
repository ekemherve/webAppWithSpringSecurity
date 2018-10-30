package herve.project.webapp.model;

public enum RoleEnum {

    USER("USER"), ADMIN("ADMIN");

    private String name;

    private RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleEnum{" +
                "name='" + name + '\'' +
                '}';
    }
}
