package entities;

import entities.ComprobantesVentaCabecera;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(ComprobantesVentaDetalle.class)
public class ComprobantesVentaDetalle_ { 

    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> precio;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, ComprobantesVentaCabecera> idCabecera;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Integer> id;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> cantidad;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Productos> idProducto;
    public static volatile SingularAttribute<ComprobantesVentaDetalle, Double> importe;

}