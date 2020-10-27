package exercicio2e;

public class ChefeCozinha {

    private Builder builder;

    public ChefeCozinha(Builder builder) {
        this.builder = builder;
    }

    public void calabresa(){
        builder.fazMassa();
        builder.molhoTomate();
        builder.calabresa();
        builder.queijo();
    }
    public void cornBacon(){
        builder.fazMassa();
        builder.molhoTomate();
        builder.bacon();
        builder.queijo();
        builder.milho();

    }
    public void daCasa(){
        builder.fazMassa();
        builder.molhoTomate();
        builder.bacon();
        builder.queijo();
        builder.milho();
        builder.calabresa();
        builder.queijoGorgonzola();
        builder.queijoParmezao();
        builder.frango();
        builder.carneGado();
        builder.batataPalha();
    }
}
