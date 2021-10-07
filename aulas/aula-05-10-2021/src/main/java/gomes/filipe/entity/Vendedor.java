package gomes.filipe.entity;

public class Vendedor {

    private String codigo;
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;

    public Vendedor(String codigo, String cpf, String nome, String endereco, String cidade, String uf) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Vendedor(String cpf, String nome, String endereco , String cidade, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    @Override
    public String toString() {
        return this.codigo
                .concat(" -- " + this.cpf)
                .concat(" -- " + this.nome)
                .concat(" -- " + this.endereco)
                .concat(" -- " + this.cidade)
                .concat(" -- " + this.uf);
    }
}
