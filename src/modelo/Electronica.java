package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Electronica extends Compra {
private String Medio;
private double puntosDeRegalo;
public String getMedio() {
	return Medio;
}
public void setMedio(String medio) {
	Medio = medio;
}
public double getPuntosDeRegalo() {
	return puntosDeRegalo;
}
public void setPuntosDeRegalo(double puntosDeRegalo) {
	this.puntosDeRegalo = puntosDeRegalo;
}
public Electronica(int idCompra, LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados,
		String medio, double puntosDeRegalo) {
	super(idCompra, fecha, hora, puntosPorLitro, litrosComprados);
	Medio = medio;
	this.puntosDeRegalo = puntosDeRegalo;
}



@Override
public double calcularPuntaje() {

	return (float) this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosDeRegalo();
	
}

public double calcularPuntaje(LocalDate fecha) {
	 float resul=0;
	if(this.getFecha().isEqual(fecha)){
		
		 resul=(float) (this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosDeRegalo());
	

	}
	return resul;
	
}
public double calcularPuntaje(int anio, int mes) {
	 float resul=0;
	if(this.getFecha().getYear()==anio&&this.getFecha().getDayOfMonth()==mes){
		
		 resul=(float) (this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosDeRegalo());
	

	}
	return resul;
	
}

}
