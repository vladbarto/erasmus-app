package ro.tucn.erasmusbackend.model;

/**
 * Security relevant. By this, a user is either a mere modifier and heavy viewer, or an admin (which has way more power and features)
 */
public enum Role {
    USER,
    ADMIN
}
