package model;

public abstract class Pessoa {
  protected int id;
  protected String nome;
  protected String email;
  protected String contato;
  protected String senha;
  
  public Pessoa(int id, String nome, String email, String contato, String senha) {
    setId(id);
    setNome(nome);
    setEmail(email);
    setContato(contato);
    setSenha(senha);
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getContato() {
    return contato;
  }
  public void setContato(String contato) {
    this.contato = contato;
  }
  
  public String getSenha() {
    return senha;
  }
  public void setSenha(String senha) {
    this.senha = senha;
  }
  
  public abstract String toString();
  
}
