package service;

import model.Cliente;
import model.Profissional;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static int idAtual = 0;
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario cadastrarCliente(String nome, String email, String contato, String senha) {
        Cliente cliente = new Cliente(idAtual++, nome, email, contato, senha);
        usuarios.add(cliente);
        return cliente;
    }

    public Usuario cadastrarProfissional(String nome, String email, String contato, String senha) {
        Profissional profissional = new Profissional(idAtual++, nome, email, contato, senha);
        usuarios.add(profissional);
        return profissional;
    }

    public Usuario login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}