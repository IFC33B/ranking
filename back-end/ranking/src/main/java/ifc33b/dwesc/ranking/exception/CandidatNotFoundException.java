package ifc33b.dwesc.ranking.exception;

public class CandidatNotFoundException extends RuntimeException {
    public CandidatNotFoundException(Long id) {
        super("No se ha encontrado el candidato con la ID: " + id);
    }
}
