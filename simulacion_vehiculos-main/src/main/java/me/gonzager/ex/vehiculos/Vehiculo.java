package me.gonzager.ex.vehiculos;

public class Vehiculo {
private double combustible; 
    private double kilometraje; 
    private TipoConduccion tipoConduccion;

    
    public Vehiculo(double combustibleInicial) {
        if (combustibleInicial < 0) {
            throw new RuntimeException("La cantidad de combustible no puede ser negativa.");
        }
        this.combustible = combustibleInicial;
        this.kilometraje = 0;
        this.tipoConduccion = new ConduccionEco(); 
    }

   
    public double velocidadMaxima() {
        return tipoConduccion.velocidadMaxima();
    }

    public double getCombustible() {
        return combustible;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public TipoConduccion getTipoConduccion() {
        return tipoConduccion;
    }

    
    public void avanzarTipoConduccion() {
        TipoConduccion siguiente = tipoConduccion.siguiente();
        if (siguiente != null) {
            tipoConduccion = siguiente;
        }
    }

    
    public void retrocederTipoConduccion() {
        TipoConduccion anterior = tipoConduccion.anterior();
        if (anterior != null) {
            tipoConduccion = anterior;
        }
    }

    
    public void desplazar(double kilometrosSolicitados) {
        double consumoActual = tipoConduccion.consumo();
        double kmPosibles = combustible * consumoActual;

        if (kmPosibles >= kilometrosSolicitados) {
            
            combustible -= kilometrosSolicitados / consumoActual;
            kilometraje += kilometrosSolicitados;
        } else {
            
            kilometraje += kmPosibles;
            combustible = 0;
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " +
                kmPosibles + " del total de " + kilometrosSolicitados + " kilometros.");
        }
    }
}


