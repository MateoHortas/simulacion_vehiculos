package me.gonzager.ex.vehiculos;

public class ConduccionEco implements TipoConduccion {

    @Override
    public Double consumo() {
        return 16.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 120.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return new ConduccionEstandar();
    }

    @Override
    public TipoConduccion anterior() {
        return null;
    }
}
