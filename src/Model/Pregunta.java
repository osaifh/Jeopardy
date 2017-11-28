package Model;

public class Pregunta {
    private final String texto;
    private final String[] respuestas;
    private final int respuestaCorrecta;
    private final int valorRespuesta;

    public Pregunta(String texto, String[] respuestas, int respuestaCorrecta, int valorRespuesta) {
        this.texto = texto;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.valorRespuesta = valorRespuesta;
    }
    
    public String getTexto() {
        return texto;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public int getValorRespuesta() {
        return valorRespuesta;
    }
}
