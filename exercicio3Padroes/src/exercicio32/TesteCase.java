package exercicio32;

public class TesteCase {

    public void teste(){

        Produto p1 = new Produto("Abajur"," marfim",true,20.0);
        Produto p2 = new Produto("Taça"," translucida",true,10.0);
        Produto p3 = new Produto("Almofada","Laranja",false,5.0);
        Produto p4 = new Produto("Peso de papel","Coral",true,10.0);
        Produto p5 = new Produto("Faca"," Preta",false,12.0);
        Produto p6 = new Produto("Panela","Aluminio",false,10.0);

        Caixa c1 = new Caixa(1.0);
        Caixa c2 = new Caixa(1.0);
        Caixa c3 = new Caixa(1.0);

        c1.addValor(p1);
        c1.addValor(p2);
        c1.addValor(p3);
        c1.addValor(c2);
        c2.addValor(p4);
        c2.addValor(p5);

        System.out.println("Valor:  "+c1.getValor());
        //assert c1.getValor() == 52.0;
    }

    public static void main(String[] args) {

        new TesteCase().teste();
    }
}
