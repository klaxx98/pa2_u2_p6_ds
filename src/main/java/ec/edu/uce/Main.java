package ec.edu.uce;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            //INSERT INTO estudiante(estu_id, estu_apellido, estu_nombre, estu_genero, estu_fecha_nacimiento) VALUES (1, 'Salazar', 'David', 'Masculino', '1998-01-03')

            return 0;
            
        }
        
    }

}
