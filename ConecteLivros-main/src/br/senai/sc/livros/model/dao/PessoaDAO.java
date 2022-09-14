package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PessoaDAO {
    private static final Set<Pessoa> listaPessoas = new HashSet<>();


    public void inserir(Pessoa pessoa) throws SQLException {
//        Autor autor = new Autor("12435678", "autor", "Rafaellizin","autor@", Genero.MASCULINO, "123");
        String sql = "insert into pessoa(cpf, nome, sobrenome, email, genero, senha)" +
                "values (?,?,?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conectaBD();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, pessoa.getCPF());
        statement.setString(2, pessoa.getNome());
        statement.setString(3, pessoa.getSobrenome());
        statement.setString(4, pessoa.getEmail());
        statement.setObject(5, pessoa.getGenero());
        statement.setString(6, pessoa.getSenha());
        statement.execute();
        connection.close();
    };

    static{
//        listaPessoas.add(new Autor("12435678", "autor", "Rafaellizin",
//                "autor@", Genero.MASCULINO, "123"));
//        listaPessoas.add(new Revisor("12435678", "revisor", "Rafaellizin",
//                "revisor@", Genero.MASCULINO, "123"));
//        listaPessoas.add(new Revisor("12435678", "Revisor2", "Rafaellizin",
//                "revisor2@", Genero.MASCULINO, "123"));
        listaPessoas.add(new Diretor("12435678", "diretor", "Rafaellizin",
                "diretor@", Genero.MASCULINO, "123"));
    }
//
//    public void inserir(Pessoa pessoa){
//        listaPessoas.add(pessoa);
//    }
//
    public void remover(Pessoa pessoa){
        listaPessoas.remove(pessoa);
    }

    public Pessoa selecionarPorCPF(String CPF){
        for(Pessoa pessoa : listaPessoas){
            if(pessoa.getCPF().equals(CPF)) return pessoa;
        }
        throw new RuntimeException("CPF não encontrado!");
    }
    public Pessoa selecionarPorEmail(String email){
        for(Pessoa pessoa : listaPessoas){
            if(pessoa.getEmail().equals(email)){
                return pessoa;
            }
        }
        throw new RuntimeException("Email não encontrado!");
    }
}
