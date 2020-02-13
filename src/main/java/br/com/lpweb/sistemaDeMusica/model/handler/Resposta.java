package br.com.lpweb.sistemaDeMusica.model.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resposta<T> {

    private T dados;
    private List<StandardError> erros = new ArrayList<>();

    private Resposta() { }

    public static Resposta comDadosDe(Object dados) {
        Resposta resposta = new Resposta<>();
        resposta.setDados(dados );
        return resposta;
    }

    public static Resposta com(List<StandardError> erros) {
        Resposta resposta = new Resposta<>();
        resposta.setErros(erros );
        return resposta;
    }

    public static Resposta com(StandardError erro) {
        Resposta resposta = new Resposta<>();
        resposta.setErros(Arrays.asList(erro) );
        return resposta;
    }

    public void setErros(List<StandardError> erros) {
        this.erros = erros;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public List<StandardError> getErros() {
        return erros;
    }
}
