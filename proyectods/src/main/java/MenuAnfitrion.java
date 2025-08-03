import modelo.Anfitrion;

public class MenuAnfitrion {
private static Anfitrion Anfitrion;

    /* Getters y Setters */
    public static Anfitrion getAnfitrion() {
        return Anfitrion;
    }
    public static void setAnfitrion(Anfitrion Anfitrion) {
       MenuAnfitrion.Anfitrion = Anfitrion;
   }

    /* Mostrar Menú */
    public static void mostrarMenu(Anfitrion Anfitrion) {
        if (Anfitrion == null) {
            System.out.println("No se ha iniciado sesión como Anfitrion.");
            Main.gestionarAplicacion();
        }
        MenuAnfitrion.setAnfitrion(Anfitrion);
        System.out.println("==========Menú Anfitrión==========");
        System.out.println("1. Buscar Propiedades");
        System.out.println("2. Reservar Propiedad");
        System.out.println("3. Ver Reservas");
   }
}
