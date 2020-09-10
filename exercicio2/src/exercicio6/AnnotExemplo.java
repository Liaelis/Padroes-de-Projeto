package exercicio6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // faz permanecer em runtime
@Target(ElementType.METHOD)// alvo da anotação
public @interface AnnotExemplo {

     String nome() default "semNome"; // default faz o parametro deixar de ser obrigatorio
}
