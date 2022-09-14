package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class LivroDAO {
    private static Collection<Livro> listaLivros = new HashSet<>();

//
//    public boolean inserir(Livro livro) throws SQLException {
//            Pessoa pessoa = new pessoa("Leo Rafaelli", "cabelinho123@netuno.com.br", "00000-0000", 18);
//            String sql = "insert into contatos(nome, email, telefone, idade)" +
//                    "values (?,?,?,?)";
//            br.senai.sc.livros.model.dao.Conexao conexao = new br.senai.sc.livros.model.dao.Conexao();
//            Connection connection = conexao.conectaBD();
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, pessoa.getNome());
//            statement.setString(2, pessoa.getEmail());
//            statement.setString(3, pessoa.getTelefone());
//            statement.setInt(4, pessoa.getIdade());
//            statement.execute();
//            connection.close();
//    };

    static{

        Pessoa pessoa = new PessoaDAO().selecionarPorEmail("autor@");

        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "O fogo", Status.AGUARDANDO_REVISAO, 568, 1234));
        listaLivros.add(new Livro((Autor)pessoa,
                "A água", Status.AGUARDANDO_EDICAO, 348, 2345));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "autor@", Genero.FEMININO, "123"),
                "A pedra", Status.APROVADO, 346, 2542));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "O Henrique", Status.EM_REVISAO, 467, 4367));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "A Camilly", Status.REPROVADO, 346, 2542));
        listaLivros.add(new Livro(new Autor("123", "Bernadete", "#@!", "123@321", Genero.FEMININO, "123"),
                "O Impiedoso Romárinho", Status.PUBLICADO, 467, 4367));
    }


    public boolean inserir(Livro livro){
       Boolean tmp= !listaLivros.contains(livro);
        listaLivros.add(livro);
        return tmp;
    }

    public void remover(Livro livro){
        listaLivros.remove(livro);
    }

    public Livro selecionar(int isbn){
        for(Livro livro : listaLivros){
            if(livro.getISBN() == isbn){
                return livro;
            }
        };
        return null;
    }

    public void atualizar(int isbn, Livro livroAtualizado){
        for (Livro livro : listaLivros){
            if(livro.getISBN() == isbn){
                listaLivros.remove(livro);
                listaLivros.add(livroAtualizado);
            }
        }
    }

    public Collection<Livro> getAllLivros(){
      return Collections.unmodifiableCollection(listaLivros);
    };

    public Collection<Livro> selecionarPorAutor(Pessoa pessoa){
        Collection<Livro> livrosAutor = new ArrayList<>();
        for(Livro livro : getAllLivros()){
            if(livro.getAutor().equals(pessoa)){
                livrosAutor.add(livro);
            }
        }
        return livrosAutor;
    }

    public Collection<Livro> selecionarPorStatus(Status status){
        Collection<Livro> livrosStatus = new ArrayList<>();
        for(Livro livro : getAllLivros()){
            if(livro.getStatus().equals(status)){
                livrosStatus.add(livro);
            }
        }
        return livrosStatus;
    }
    public Collection<Livro> selecionarAtividadesAutor(Pessoa pessoa){
        Collection<Livro> livrosAutor = new ArrayList<>();
        for(Livro livro : getAllLivros()){
            if(livro.getAutor() == pessoa && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)){
                livrosAutor.add(livro);
            };
        }
        return livrosAutor;
    }




}
