package exercicio31;

import sistema_bancario.Banco;
import sistema_bancario.BancoInterface;

import java.io.IOException;

public class Cliente {

    public static void main(String[] args) throws IOException {
        BancoInterface banco = new Banco();
        BancoInterface decorator = new BancoLogDecorator(banco, "log.txt");
    }
}
