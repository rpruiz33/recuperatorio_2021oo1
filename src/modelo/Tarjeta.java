package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
private int idTarjeta;
private String codigo;
private String codigoCliente;
private List <Compra> compras;
public int getIdTarjeta() {
	return idTarjeta;
}
public void setIdTarjeta(int idTarjeta) {
	this.idTarjeta = idTarjeta;
}
public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) throws Exception {
	
    if (!codigo.matches("(?=.*[0-9]{6})(?=.*[A-Za-z]{6})^[A-Za-z0-9]{12}$")) {
        throw new Exception("Tarjeta inválida: El código debe tener una longitud de 12 caracteres, con 6 números y 6 letras.");
    }
    this.codigo = codigo;
}
public String getCodigoCliente() {
	return codigoCliente;
}
public void setCodigoCliente(String codigoCliente) {
	this.codigoCliente = codigoCliente;
}
public List<Compra> getCompras() {
	return compras;
}
public void setCompras(List<Compra> compras) {
	this.compras = compras;
}
public Tarjeta(int idTarjeta, String codigo, String codigoCliente) throws Exception {
	super();
	this.idTarjeta = idTarjeta;
	setCodigo(codigo);
	this.codigoCliente = codigoCliente;
	this.compras = new ArrayList <Compra>();
}

public boolean agregarCompra( LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados,double puntosExtra) {

	int id=1;
	if(compras.size()>0) {
		id=compras.get(compras.size()-1).getIdCompra()+1;
	}
	return compras.add(new Efectivo(id,fecha,  hora,  puntosPorLitro,litrosComprados, puntosExtra));
	




}

public boolean agregarCompra(  LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados,
		String medio, double puntosDeRegalo) {

	int id=1;
	if(compras.size()>0) {
		id=compras.get(compras.size()-1).getIdCompra()+1;
	}
	return compras.add(new Electronica(id,  fecha, hora,puntosPorLitro,  litrosComprados,medio,  puntosDeRegalo));
	


}
@Override
public String toString() {
	return "\nTarjeta [idTarjeta=" + idTarjeta + ", codigo=" + codigo + ", codigoCliente=" + codigoCliente + ", compras="
			+ compras + "]";
}

}
