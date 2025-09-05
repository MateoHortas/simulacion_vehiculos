package me.gonzager.ex.vehiculos;

public class ConduccionEstandar implements TipoConduccion {

    @Override
    public Double consumo() {
        return 10.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 150.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return new ConduccionDeportiva();
    }

    @Override
    public TipoConduccion anterior() {
        return new ConduccionEco();
    }
}
