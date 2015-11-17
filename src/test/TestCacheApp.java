package test;


/**
 * @autor A_Nakonechnyi
 * @date 16.11.2015.
 */
public class TestCacheApp {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        User user = new User(1, "TestName");

        cache.put(user.getClass(), user, 1);

        User getUser = cache.get(1);
        System.out.println(getUser);

        Thread.currentThread().sleep(7000);
        System.out.println(cache.get(1));
    }
}
