package exercicio6;

import sistema_bancario.Banco;

import java.lang.reflect.Method;

public class ReflexaoBanco {

    public static void main(String[] args) {
        Class classe =  Banco.class;

        for(Method metodo : classe.getMethods()) {
            Class retorno = metodo.getReturnType();
            if (metodo.getAnnotation(AnnotExemplo.class) != null){
                System.out.print((retorno == null ? "void" : retorno.getName()) + " " + metodo.getName() + " (");
                boolean isFirst = true;
                for (Class param : metodo.getParameterTypes()) {
                    if (!isFirst) {
                        System.out.print(", ");
                    }
                    System.out.print(param.getName());
                    isFirst = false;
                }
                System.out.println(")");
            }
        }
    }
}
