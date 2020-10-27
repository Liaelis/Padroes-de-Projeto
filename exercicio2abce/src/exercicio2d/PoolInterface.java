package exercicio2d;

import java.lang.reflect.InvocationTargetException;

public interface PoolInterface<T> {


    T acquire() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException;

    void release(T t);

}
