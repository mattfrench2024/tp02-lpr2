import java.util.UUID;

public class Aluno {
    private String nome;
    private String endereco;
    private int idade;
    private UUID uuid;

    // Construtor
    public Aluno(String nome, String endereco, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.uuid = UUID.randomUUID(); // gera UUID automaticamente
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public UUID getUuid() {
        return uuid;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
