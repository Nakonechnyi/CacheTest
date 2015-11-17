package test;

/**
 * @autor A_Nakonechnyi
 * @date 16.11.2015.
 */
public class User {
    public Integer id;
    public String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " | " + name;
    }
}
