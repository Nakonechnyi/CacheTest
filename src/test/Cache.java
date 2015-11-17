package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @autor A_Nakonechnyi
 * @date 16.11.2015.
 */
public class Cache {
    private Map<Object, Pair> cache = new HashMap<>();

    public void put(Class type, Object object, Object id) {
        Pair pair = new Pair(type, object);
        cache.put(id, pair);

        init();
    }

    private void init() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                cache.clear();
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    public <T> T get(Object id) {
        Pair pair = cache.get(id);
        if (pair != null) {
            return (T) pair.object;
        }
        return null;
    }

    class Pair {
        public Class clazz;
        public Object object;

        public Pair(Class clazz, Object object) {
            this.clazz = clazz;
            this.object = object;
        }
    }
}
