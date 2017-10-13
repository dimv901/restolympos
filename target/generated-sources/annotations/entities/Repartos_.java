package entities;

import entities.ComprobantesVentaCabecera;
import entities.Repartidores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Repartos.class)
public class Repartos_ { 

    public static volatile SingularAttribute<Repartos, Boolean> entregado;
    public static volatile SingularAttribute<Repartos, ComprobantesVentaCabecera> idComprobanteVenta;
    public static volatile SingularAttribute<Repartos, Date> fechaCreacion;
    public static volatile SingularAttribute<Repartos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Repartos, Repartidores> idRepartidor;
    public static volatile SingularAttribute<Repartos, Integer> id;
    public static volatile SingularAttribute<Repartos, Date> fechaEntregado;

}