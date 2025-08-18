
package Modelo;
import javax.persistence.*;


public class Categoria {
    
    private int codigCategoria;
    
    private String nombre;

    public Categoria() {
    }

    public Categoria(int codigCategoria, String nombre) {
        this.codigCategoria = codigCategoria;
        this.nombre = nombre;
    }

    public int getCodigCategoria() {
        return codigCategoria;
    }

    public void setCodigCategoria(int codigCategoria) {
        this.codigCategoria = codigCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codigCategoria=" + codigCategoria + ", nombre=" + nombre + '}';
    }
    
    
}
