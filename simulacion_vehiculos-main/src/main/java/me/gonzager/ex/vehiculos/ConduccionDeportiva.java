package me.gonzager.ex.vehiculos;

public class ConduccionDeportiva implements TipoConduccion {

    @Override
    public Double consumo() {
        return 5.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 200.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return null;
    }

    @Override
    public TipoConduccion anterior() {
        return new ConduccionEstandar();
    }
}
