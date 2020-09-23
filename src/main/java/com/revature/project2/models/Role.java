package com.revature.project2.models;

public enum Role {

    // values declared within enums are constants and are comma separated
    USER("User"),
    MANAGER("Manager"),
    ADMIN("Admin"),
    INACTIVE("Inactive");

    private String roleName;

    // enum constructors are implicitly private
    Role(String name) {
        this.roleName = name;
    }

    public static Role getByName(String name) {

        for (Role role : Role.values()) {
            if (role.roleName.equals(name)) {
                return role;
            }
        }

        return INACTIVE;

    }

    @Override
    public String toString() {
        return roleName;
    }

}
