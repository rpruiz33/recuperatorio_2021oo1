package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Efectivo extends Compra{
private double puntosExtra;

public double getPuntosExtra() {
	return puntosExtra;
}

public void setPuntosExtra(double puntosExtra) {
	this.puntosExtra = puntosExtra;
}

public Efectivo(int idCompra, LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados,
		double puntosExtra) {
	super(idCompra, fecha, hora, puntosPorLitro, litrosComprados);
	this.puntosExtra = puntosExtra;
}
@Override
public double calcularPuntaje() {

	return (float) this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosExtra();
	
}
public double calcularPuntaje(LocalDate fecha) {
	 float resul=0;
	if(this.getFecha().isEqual(fecha)){
		
		 resul=(float) (this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosExtra());
	

	}
	return resul;
	
}
public double calcularPuntaje(int anio, int mes) {
	 float resul=0;
	if(this.getFecha().getYear()==anio&&this.getFecha().getMonthValue()==mes){
		
		 resul=(float) (this.getLitrosComprados()*this.getPuntosPorLitro()+this.getPuntosExtra());
	

	}
	return resul;
	
}
}
