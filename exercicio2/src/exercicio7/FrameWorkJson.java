package exercicio7;

import javax.print.attribute.standard.NumberUp;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameWorkJson {


    public String  generateJSON(Object object) throws InvocationTargetException, IllegalAccessException {

        Class classe = object.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("{ \n");
        boolean primeiro = true;
        for (Method method : classe.getMethods()) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                    && method.getAnnotation(JSON.class) != null) {

                if(!primeiro){
                    sb.append(", \n");

                }
                String nomeAtributo;
                if (method.getName().startsWith("get")) {
                    nomeAtributo = "\"" + method.getName().substring(3, 4).toLowerCase()
                            + method.getName().substring(4) + "\"";
                } else {
                    nomeAtributo = "\"" + method.getName().substring(2, 3).toLowerCase()
                            + method.getName().substring(3) + "\"";
                }
                sb.append(nomeAtributo).append(" : ");
                Object returnObject = method.invoke(object);
                getValueJSON(returnObject, method.getAnnotation(JSON.class), sb);

                primeiro = false;

            }
        }
        sb.append("}");
        return sb.toString();
    }

    private void getValueJSON(Object object, JSON annotaiton, StringBuffer sb) throws IllegalAccessException, InvocationTargetException {
        if (object == null) {
            sb.append("null");
            return;
        }
        Class returnType = object.getClass();
        String valor = "";
        if (Array.class.isAssignableFrom(returnType) || returnType.isArray()) { // testar quando nao é tipo primitivo
            sb.append("[");
            boolean primeiro = true;
                for(Object obArray : (Object[]) object){
                    if(!primeiro){
                        sb.append(", ");
                    }
                    getValueJSON(obArray,annotaiton,sb);
                    primeiro = false;
                }
            sb.append("]");
        } else if (isNumber(returnType) || isBoolean(returnType)) {
            valor = object.toString();
        } else if (Date.class.isAssignableFrom(returnType)) {
            String format = annotaiton.format();

            if (format.length() > 0) {
                Date data = (Date) object;
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                valor = "\"" + sdf.format(data) + "\"";
            } else {
                valor = "\"" + object.toString() + "\"";
            }
        } else if(String.class.isAssignableFrom(returnType)){
            valor = "\"" + object.toString() + "\"";
        }else{
            valor = generateJSON(object);
        }
        sb.append(valor);

    }

    private boolean isNumber(Class classe) {
        return Number.class.isAssignableFrom(classe)
                || Integer.TYPE.equals(classe)
                || Long.TYPE.equals(classe) || Float.TYPE.equals(classe)
                || Double.TYPE.equals(classe);
    }

    private boolean isBoolean(Class classe) {
        return Boolean.class.isAssignableFrom(classe)
                || Boolean.TYPE.equals(classe);
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ClasseTesteJSON jsonTeste = new ClasseTesteJSON();
        jsonTeste.setData(new Date());
        jsonTeste.setId(1000l);
        jsonTeste.setNome("nome");
        jsonTeste.setTexto("texto longo");
        jsonTeste.setBool(true);
        jsonTeste.setSrtArray(new String[]{"amora", "marchinha", "lilith"});
        jsonTeste.setCoordenadas(new ClasseTesteJSON.SubClasseJSON(23.0,45.7));
        System.out.println(new FrameWorkJson().generateJSON(jsonTeste));
    }
}
