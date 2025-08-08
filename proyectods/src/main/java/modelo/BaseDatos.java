package modelo;

import modelo.Anfitrion;
import modelo.Huesped;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseDatos {
    private HashMap<Integer, Anfitrion> anfitriones;
    private HashMap<Integer, Huesped> huespedes;
    private static BaseDatos database;       // Singleton

    /* Getters */
    public HashMap<Integer, Anfitrion> getAnfitriones() {
        return anfitriones;
    }
    public HashMap<Integer, Huesped> getHuespedes() {
        return huespedes;
    }

    /* Constructor privado */
    private BaseDatos() {
        anfitriones = new HashMap<Integer, Anfitrion>();
        huespedes = new HashMap<Integer, Huesped>();
    }

    /* Obtener la instancia única de DataBase */
    public static BaseDatos getDataBase() {
        if (database == null) {
            database = new BaseDatos();
        }
        return database;
    }

    /* Agregar un nuevo anfitrión */
    public void agregarAnfitrion(Anfitrion anfitrion) {
        anfitriones.put(anfitrion.getID(), anfitrion);
    }

    /* Agregar un nuevo huésped */
    public void agregarHuesped(Huesped huesped) {
        huespedes.put(huesped.getID(), huesped);
    }

    /* Mostrar anfitriones */
    public void mostrarAnfitriones() {
        for (Anfitrion a : anfitriones.values()) {
            System.out.println(a);
        }
    }

    /* Mostrar huéspedes */
    public void mostrarHuespedes() {
        for (Huesped h : huespedes.values()) {
            System.out.println(h);
        }
    }

    /* Buscar anfitrión por ID */
    public Anfitrion buscarAnfitrion(int id) {
        return anfitriones.get(id);
    }

    /* Buscar huésped por ID */
    public Huesped buscarHuesped(int id) {
        return huespedes.get(id);
    }

    /* Eliminar anfitrión por ID */
    public void eliminarAnfitrion(int id) {
        anfitriones.remove(id);
    }

    /* Eliminar huésped por ID */
    public void eliminarHuesped(int id) {
        huespedes.remove(id);
    }
    public boolean hasAnfitriones(){
        return !anfitriones.isEmpty();
    }
    public boolean hasHuespedes(){
        return !huespedes.isEmpty();
    }
    public void getUbicaciones() {
        java.util.HashSet<String> ubicaciones = new java.util.HashSet<>();
        for (Anfitrion anfitrion : anfitriones.values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                ubicaciones.add(propiedad.getUbicacion());
            }
        }
        System.out.println("Ubicaciones registradas:");
        for (String ubicacion : ubicaciones) {
            System.out.println("- " + ubicacion);
        }
    }
    public ArrayList<Propiedad> buscarPropiedadesPorUbicacion(String ubicacion) {
        ArrayList<Propiedad> resultado = new ArrayList<>();
        for (Anfitrion anfitrion : anfitriones.values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                if (propiedad.getUbicacion().equalsIgnoreCase(ubicacion)) {
                    resultado.add(propiedad);
                }
            }
        }
        return resultado;
    }

}

