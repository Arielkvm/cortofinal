package modelo;

/**
 * @author kevin
 */
public class Filtro {
    private int AFP;
    private String Nombre;
    private String Apellido;
    private String Profesion;
    private boolean Estado;
    
    public Filtro(){
    }

    public Filtro(int id, String nombre, String apellido, String profesion, boolean estado) {
        this.AFP = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Profesion = profesion;
        this.Estado = estado;
    }

    public Filtro(int afp) {
        this.AFP = afp;
    }

    public int getAFP() {
        return AFP;
    }

    public void setAFP(int AFP) {
        this.AFP = AFP;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String profesion) {
        this.Profesion = profesion;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean estado) {
        this.Estado = estado;
    }
    
    
    
    
}
