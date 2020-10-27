package exercicio2d;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PoolGrenerico<T> implements PoolInterface<T>{

    private Class<T> classe;
    private List<T> instanciasDisponiveis = new ArrayList<>(20);
    private List<T> instanciasCriadas = new ArrayList<>(20);

    public PoolGrenerico(Class<T> classe) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.classe = classe; // pra saber qual a classe do T
        for(int i=0; i<3; i++){
            T o = classe.getDeclaredConstructor().newInstance();
            instanciasDisponiveis.add(o);
            instanciasCriadas.add(o);
        }
    }

    @Override
    public T acquire() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InterruptedException {
        synchronized (instanciasDisponiveis){
            if(!instanciasCriadas.isEmpty()){
                return instanciasDisponiveis.remove(0);
            }else if(instanciasCriadas.size() < 20){
                T o = classe.getDeclaredConstructor().newInstance();
                instanciasCriadas.add(o);
                return o;
            }else{
                instanciasDisponiveis.wait();
                return instanciasDisponiveis.remove(0);
            }
        }
    }

    @Override
    public void release(T o) {
        synchronized (instanciasDisponiveis){
            if(!instanciasCriadas.contains(0)){
                return;
            }
            instanciasDisponiveis.add(o);
            if(instanciasDisponiveis.size() == 1){
                instanciasDisponiveis.notify();
            }
        }

    }
}
