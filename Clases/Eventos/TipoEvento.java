
package Clases.Eventos;
public enum TipoEvento {

    // Diferentes tipos de eventos soportados por la aplicación
    CONCIERTO("Concierto"),
    DEPORTE("Deporte"),
    MUSICAL("Musical"),
    TEATRO("Teatro");

    // Descripción legible del tipo de evento
    private  String descripcion;

    TipoEvento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    @Override
    public String toString() {
        return descripcion;
    }
}
