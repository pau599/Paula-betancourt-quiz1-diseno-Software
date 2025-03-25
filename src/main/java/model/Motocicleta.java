package model;

public class Motocicleta {
    
    private int id;
    private String marca;
    private String modelo;
    private int cilindraje;  // 🔥 Ahora es int
    private String color;
    private double precio;

    // 🔥 Constructor corregido
    public Motocicleta(int id, String marca, String modelo, int cilindraje, String color, double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.color = color;
        this.precio = precio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getCilindraje() { return cilindraje; }  
    public void setCilindraje(int cilindraje) { this.cilindraje = cilindraje; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
