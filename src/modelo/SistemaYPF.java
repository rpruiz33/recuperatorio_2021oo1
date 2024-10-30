package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaYPF {
private List <Tarjeta> tarjetas;

public List<Tarjeta> getTarjetas() {
	return tarjetas;
}

public void setTarjetas(List<Tarjeta> tarjetas) {
	this.tarjetas = tarjetas;
}

public SistemaYPF() {
	super();
	this.tarjetas = new ArrayList <Tarjeta>();
}

public Tarjeta traerTarjeta(String codigoCliente) {
	Tarjeta tar= null;
	int i=0;
	while (tarjetas.size()>i&& tar==null) {
		if(tarjetas.get(i).getCodigoCliente().equals(codigoCliente)) {
			tar=tarjetas.get(i);
		}
		i++;
	}
	return tar;
}
public boolean agregarTarjeta(String codigo,String codigoCliente)throws Exception {
	Tarjeta t=traerTarjeta(codigoCliente);
	if(t!=null) {
		 throw new Exception("tajeta repetida");
	}
	int id=1;
	if(tarjetas.size()>0) {
		id=tarjetas.get(tarjetas.size()-1).getIdTarjeta()+1;
	}
	return tarjetas.add(new Tarjeta(id,codigo,codigoCliente));
	
}


    public List<Tarjeta> traerTarjetasComprasEfectivo(LocalDate fechaDesde, LocalDate fechaHasta) {
        List<Tarjeta> aux = new ArrayList<>();

        for (int i = 0; i < tarjetas.size(); i++) {
            Tarjeta tarjeta = tarjetas.get(i);

            for (int j = 0; j < tarjeta.getCompras().size(); j++) {
                Compra compra = tarjeta.getCompras().get(j);

                if (compra instanceof Efectivo) {
                    LocalDate fechaCompra = compra.getFecha();

                    if ((fechaCompra.equals(fechaDesde) || fechaCompra.equals(fechaHasta)) 
                            || (fechaCompra.isAfter(fechaDesde) && fechaCompra.isBefore(fechaHasta))) {
                        aux.add(tarjeta);
                        break; 
                    }
                }
            }
        }
        return aux;
    
}




}
