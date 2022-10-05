public class Main {
    public static void main(String[] args) {
        final PersonaEducada jane = new PersonaEducada("Jane");
        final PersonaEducada juan = new PersonaEducada("Juan");
        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.decirHola(juan);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                juan.decirHola(jane);
            }
        }).start();
    }
    static class PersonaEducada {
        private final String nombre;
        public PersonaEducada(String nombre) {
            this.nombre = nombre;
        }
        public String getNombre() {
            return nombre;
        }
        public void decirHola(PersonaEducada persona) {
            System.out.format("%s: %s" + " me ha dicho hola a mi!%n", this.nombre, persona.getNombre());
            persona.decirRespuestaAHola(this);
        }
        public synchronized void decirRespuestaAHola(PersonaEducada persona) {
            System.out.format("%s: %s" + " me ha respondido a hola!%n", this.nombre, persona.getNombre());
        }
    }
}