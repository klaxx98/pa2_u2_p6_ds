package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Pedido;
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
        private ClienteService clienteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            Cliente
            */
            Cliente cliente = new Cliente();
            cliente.setCedula("1234567890");
            cliente.setNombre("David");

            /*
            Pedidos
            */
            Pedido p1 = new Pedido();
            p1.setTotal(Double.valueOf(10));
            p1.setCliente(cliente);
            p1.setFecha(LocalDate.of(2026, 06, 15));

            Pedido p2 = new Pedido();
            p2.setTotal(Double.valueOf(100));
            p2.setCliente(cliente);
            p2.setFecha(LocalDate.of(2026, 06, 17));

            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(p1);
            pedidos.add(p2);

            cliente.setPedidos(pedidos);

            // Insert mediante service

            this.clienteService.crearCliente(cliente);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
