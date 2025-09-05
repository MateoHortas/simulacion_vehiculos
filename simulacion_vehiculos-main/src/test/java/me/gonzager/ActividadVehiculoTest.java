package me.gonzager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.vehiculos.Vehiculo;

public class ActividadVehiculoTest {

   @Test
    void vehiculoRetrocediendoYAvanzandoTiposDeConduccionDeberiaRetornarCorrectamenteLaVelocidad() {
        Vehiculo vehiculo = new Vehiculo(3.0);

        vehiculo.retrocederTipoConduccion(); 
        vehiculo.avanzarTipoConduccion();    
        vehiculo.avanzarTipoConduccion();    
        vehiculo.avanzarTipoConduccion();    
        vehiculo.retrocederTipoConduccion(); 

        assertEquals(150.0, vehiculo.velocidadMaxima());
    }

    @Test
    void vehiculoEnConduccionEstandarDeberiaAvanzarCorrectamenteYReducirElCombustible() {
        Vehiculo vehiculo = new Vehiculo(25.0);
        vehiculo.avanzarTipoConduccion(); 

        vehiculo.desplazar(200.0); 

        assertEquals(200.0, vehiculo.getKilometraje());
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberiaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {
        Vehiculo vehiculo = new Vehiculo(13.0);
        vehiculo.avanzarTipoConduccion(); 
        vehiculo.avanzarTipoConduccion(); 

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            vehiculo.desplazar(75.0); 
        });

        assertEquals("Combustible insuficiente, solo pude recorrer 65.0 del total de 75.0 kilometros.", ex.getMessage());
        assertEquals(65.0, vehiculo.getKilometraje());
        assertEquals(0.0, vehiculo.getCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            new Vehiculo(-10.0);
        });

        assertEquals("La cantidad de combustible no puede ser negativa.", ex.getMessage());
    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {
        Vehiculo vehiculo = new Vehiculo(10.0); 

        double velEco = vehiculo.velocidadMaxima();

        vehiculo.avanzarTipoConduccion(); 
        double velEstandar = vehiculo.velocidadMaxima();

        vehiculo.avanzarTipoConduccion(); 
        double velDeportiva = vehiculo.velocidadMaxima();

        assertTrue(velEco < velEstandar);
        assertFalse(velEstandar > velDeportiva);
        assertNotEquals(velEstandar, velDeportiva);
    } 
}
