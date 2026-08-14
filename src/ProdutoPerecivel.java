import java.time.LocalDate;

public class ProdutoPerecivel extends Produto{
    private LocalDate dataValidade;

    public boolean validadeUtrapasssada(){
        return dataValidade.isBefore(LocalDate.now());
    }

    @Override
    public void init(LocalDate dataValidade){
        if(validadeUtrapasssada()){
            throw new IllegalArgumentException("Este produto não pode ser cadastrado com uma data de validade anterior ao dia atual");
        }
        this.dataValidade = dataValidade;
    }
    
    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataValidade) {
        super(desc, precoCusto, margemLucro);
        this.dataValidade = dataValidade;
    }

    public ProdutoPerecivel(String desc, double precoCusto, LocalDate dataValidade) {
        super(desc, precoCusto);
        this.dataValidade = dataValidade;
    }

    public void aplicarDesconto(){

    }

    @Override
    public double valorDeVenda(){
        if(validadeUltrapassada()){
            throw new IllegalArgumentException("Não foi possível retornar o preço, produto fora de validade");
        }
        return 0.0;
    }
}
