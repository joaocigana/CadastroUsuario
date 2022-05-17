package com.joao.cadastrousuario.exceptions;

public class RegraDeNegocioVioladaException extends RuntimeException {

    public RegraDeNegocioVioladaException(String message) {
        super(message);
    }

    public RegraDeNegocioVioladaException(String message, Throwable cause) {
        super(message, cause);
    }

}
