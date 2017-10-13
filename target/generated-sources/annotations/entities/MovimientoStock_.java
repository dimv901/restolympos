package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(MovimientoStock.class)
public class MovimientoStock_ { 

    public static volatile SingularAttribute<MovimientoStock, String> movimiento;
    public static volatile SingularAttribute<MovimientoStock, Date> fechaCreacion;
    public static volatile SingularAttribute<MovimientoStock, Date> fechaActualizacion;
    public static volatile SingularAttribute<MovimientoStock, Integer> id;
    public static volatile SingularAttribute<MovimientoStock, Double> cantidad;
    public static volatile SingularAttribute<MovimientoStock, Productos> idProducto;
    public static volatile SingularAttribute<MovimientoStock, Date> fechaMovimiento;

}