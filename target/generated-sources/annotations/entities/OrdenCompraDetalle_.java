package entities;

import entities.OrdenCompraCabecera;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(OrdenCompraDetalle.class)
public class OrdenCompraDetalle_ { 

    public static volatile SingularAttribute<OrdenCompraDetalle, Double> precio;
    public static volatile SingularAttribute<OrdenCompraDetalle, OrdenCompraCabecera> idCabecera;
    public static volatile SingularAttribute<OrdenCompraDetalle, Date> fechaCreacion;
    public static volatile SingularAttribute<OrdenCompraDetalle, Date> fechaActualizacion;
    public static volatile SingularAttribute<OrdenCompraDetalle, Integer> id;
    public static volatile SingularAttribute<OrdenCompraDetalle, Double> cantidad;
    public static volatile SingularAttribute<OrdenCompraDetalle, Productos> idProducto;
    public static volatile SingularAttribute<OrdenCompraDetalle, Double> importe;

}