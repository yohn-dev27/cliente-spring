package com.prueba.cliente_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gestionar operaciones relacionadas con clientes.
 * Este controlador expone un endpoint para obtener información de un cliente
 * basado en el tipo y número de documento proporcionados como parámetros.
 */
@RestController
public class ClienteController {

    // Logger para registrar información, advertencias y errores en la aplicación.
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    /**
     * Endpoint para obtener información de un cliente.
     * 
     * @param tipo      El tipo de documento (debe ser 'C' o 'P').
     * @param documento El número del documento del cliente.
     * @return Un objeto Cliente con los datos "quemados" (predefinidos).
     * @throws IllegalArgumentException Si el tipo de documento no es válido.
     */
    @GetMapping("/cliente")
    public Cliente obtenerCliente(@RequestParam String tipo, @RequestParam String documento) {
        Cliente cliente = new Cliente();
        // Log de inicio de la solicitud
        logger.info("Recibiendo solicitud para obtener cliente con tipo {} y documento {}", tipo, documento);

        // Validación de los parámetros para asegurar que el tipo de documento es
        // válido.
        if (!tipo.equals("C") && !tipo.equals("P")) {
            // Log de error si el tipo de documento no es válido.
            logger.error("Tipo de documento inválido: {}", tipo);
            // throw new IllegalArgumentException("El tipo de documento debe ser 'C' o
            // 'P'");

            cliente.setMensaje("Error tipo de documento no es valido deve ser C, Cedula o P, Pasaporte");
        } else {

            // Creación de un objeto Cliente con datos predefinidos ("quemados").
            cliente = new Cliente(
                    "José", // Primer nombre del cliente.
                    "Luis", // Segundo nombre del cliente.
                    "Pérez", // Primer apellido del cliente.
                    "González", // Segundo apellido del cliente.
                    "123456789", // Número de teléfono del cliente.
                    "Calle Falsa 123", // Dirección del cliente.
                    "Bogotá", // Ciudad del cliente.
                    "Proceso exitoso");
            // Log de éxito al encontrar el cliente.
            logger.info("Cliente encontrado con documento {}", documento);
            // Retorna el objeto cliente al solicitante.

        }
        return cliente;

    }

}
