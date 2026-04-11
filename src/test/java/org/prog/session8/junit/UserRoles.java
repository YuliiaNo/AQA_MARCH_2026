package org.prog.session8.junit;

public enum UserRoles {
    ADMIN("id12345"),
    MANAGER("id872638746"),
    USER("usr128736817263");

    private String internalId;

    UserRoles(String internalId) {
        this.internalId = internalId;
    }

    public String getInternalId() {
        return internalId;
    }
}
