public class Adocao {
    private String nome;
    private int idade;
    private Enum Tipo;
    private String raca;
    private String telefone;
    private String endereco;

    public Adocao() {
    }

    public Adocao(String nome, int idade, Enum tipo, String raca, String telefone, String endereco) {
        this.nome = nome;
        this.idade = idade;
        Tipo = tipo;
        this.raca = raca;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Enum getTipo() {
        return Tipo;
    }

    public void setTipo(Enum tipo) {
        Tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
