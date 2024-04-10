package ro.tucn.erasmusbackend.model;

/**
 * Given that Teacher and Secretary have the same fields, we only need one table and a feature which tells us what that person is
 */
public enum Type {
    SECRETARY,
    TEACHER
}
