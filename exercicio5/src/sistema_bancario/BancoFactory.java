package sistema_bancario;

public class BancoFactory {
    private static  BancoFactory INSTANCE;
    public  static BancoFactory getInstance(){
        synchronized (BancoFactory.class){
            if(INSTANCE == null){
                INSTANCE = new BancoFactory();

            }
        }

        return INSTANCE;
    }
    private BancoFactory (){

    }
    public BancoInterface createInstance(){
        //cria instancia do banco
        //regras para decidir qual banco devera ser instanciado

        return new Banco();
    }
}
