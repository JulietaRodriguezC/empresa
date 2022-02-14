package getset;

public class variables {

    private static String idempleado;  // Variables estáticas para que la información almacenada en ellas puedan ser tomadas
    private static String nombre;      // y llevadas al formulario que se le mostrará al usuario
    private static String apellido;
    private static String puesto;

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    //Permite recolectar datos de la tabla
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
