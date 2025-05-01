package fiap.com.br.brinquedos.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_BRINQUEDO")
@SequenceGenerator(name="brinquedo", sequenceName = "SQ_TB_BRINQUEDO", allocationSize = 1)
public class Brinquedo {

    @Id
    @Column(name="id_brinquedo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brinquedo")
    private Integer id;

    @Column(name="nome_brinquedo", nullable = false, length = 80)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_brinquedo", length = 80)
    private TipoBrinquedo tipoBrinquedo;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", length = 80)
    private Classificacao classificacao;

    @Column(name = "tamanho", nullable = false, length = 80)
    private String tamanho;

    @Column(name = "preco", precision = 10, scale = 2)
    private Double preco;

    public Brinquedo() {}

    public Brinquedo(String nome, TipoBrinquedo tipoBrinquedo, Classificacao classificacao, String tamanho, Double preco) {
        this.nome = nome;
        this.tipoBrinquedo = tipoBrinquedo;
        this.classificacao = classificacao;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoBrinquedo getTipoBrinquedo() {
        return tipoBrinquedo;
    }

    public void setTipoBrinquedo(TipoBrinquedo tipoBrinquedo) {
        this.tipoBrinquedo = tipoBrinquedo;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
