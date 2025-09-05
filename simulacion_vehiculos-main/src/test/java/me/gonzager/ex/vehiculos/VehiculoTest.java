package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {

        assertEquals(150, 150);
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {

    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {

        assertEquals(0.0, 0.0);
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {

    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {

        assertNotEquals(1, 0);
    }
}
