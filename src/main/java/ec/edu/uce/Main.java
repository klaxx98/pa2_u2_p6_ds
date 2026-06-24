package ec.edu.uce;

import java.math.BigDecimal;

import ec.edu.uce.application.service.CuentaService;
import ec.edu.uce.application.service.TransferenciaService;
import ec.edu.uce.domain.model.CuentaBancaria;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private CuentaService cuentaService;

        @Inject
        private TransferenciaService transferenciaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\n***Abriendo app***\n");

            CuentaBancaria c1 = new CuentaBancaria();
            c1.setCedula("0123456789");
            c1.setApellido("Salazar");
            c1.setNombre("David");
            c1.setSaldo(BigDecimal.valueOf(500.0));
            c1.setTipoCuenta("Ahorros");
            c1.setNumeroCuenta("11111");

            CuentaBancaria c2 = new CuentaBancaria();
            c2.setCedula("9876543210");
            c2.setApellido("Intriago");
            c2.setNombre("Alexander");
            c2.setSaldo(BigDecimal.valueOf(100.0));
            c2.setTipoCuenta("Ahorros");
            c2.setNumeroCuenta("22222");

            this.cuentaService.crearCuenta(c1);
            this.cuentaService.crearCuenta(c2);

            System.out.println(this.cuentaService.buscarPorNumeroCuenta("11111"));
            System.out.println(this.cuentaService.buscarPorNumeroCuenta("22222"));

            this.transferenciaService.realizarTransferencia("11111", "22222", BigDecimal.valueOf(100.0));

            System.out.println(this.cuentaService.buscarPorNumeroCuenta("11111"));
            System.out.println(this.cuentaService.buscarPorNumeroCuenta("22222"));

            // REVISAR CAPTURAS EN CARPETA /resources taller 25

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
