package entities;

import entities.ComprobantesCompraCabecera;
import entities.ComprobantesVentaCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(TipoComprobantes.class)
public class TipoComprobantes_ { 

    public static volatile SingularAttribute<TipoComprobantes, String> descripcion;
    public static volatile ListAttribute<TipoComprobantes, ComprobantesCompraCabecera> comprobantesCompraCabeceraList;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoComprobantes, Date> fechaActualizacion;
    public static volatile SingularAttribute<TipoComprobantes, Integer> id;
    public static volatile ListAttribute<TipoComprobantes, ComprobantesVentaCabecera> comprobantesVentaCabeceraList;

}