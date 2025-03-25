package model;

public class Motocicleta {
	
	    private int id;
	    private String marca;
	    private String modelo;
	    private int cilindraje;
	    private double precio;

	    public Motocicleta(int id, String marca, String modelo, int cilindraje, double precio) {
	        this.id = id;
	        this.marca = marca;
	        this.modelo = modelo;
	        this.cilindraje = cilindraje;
	        this.precio = precio;
	    }

	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getMarca() { return marca; }
	    public void setMarca(String marca) { this.marca = marca; }

	    public String getModelo() { return modelo; }
	    public void setModelo(String modelo) { this.modelo = modelo; }

	    public int getAnio() { return cilindraje; }
	    public void setAnio(int cilindraje) { this.cilindraje = cilindraje; }

	    public double getPrecio() { return precio; }
	    public void setPrecio(double precio) { this.precio = precio; }
	}
