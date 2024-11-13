package br.com.marcoscorrea.patterns.handler;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String mensagem) {
        super(mensagem);
    }
    public EntityNotFoundException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}
