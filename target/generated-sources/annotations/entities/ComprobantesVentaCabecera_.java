package entities;

import entities.Clientes;
import entities.ComprobantesVentaDetalle;
import entities.PedidosCabecera;
import entities.Repartos;
import entities.TipoComprobantes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(ComprobantesVentaCabecera.class)
public class ComprobantesVentaCabecera_ { 

    public static volatile SingularAttribute<ComprobantesVentaCabecera, Double> totalIva10;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Clientes> idCliente;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Double> totalExentas;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, TipoComprobantes> idTipoComprobante;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Double> totalIva5;
    public static volatile ListAttribute<ComprobantesVentaCabecera, Repartos> repartosList;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Date> fechaCreacion;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Date> fechaActualizacion;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Integer> id;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, PedidosCabecera> idPedido;
    public static volatile ListAttribute<ComprobantesVentaCabecera, ComprobantesVentaDetalle> comprobantesVentaDetalleList;
    public static volatile SingularAttribute<ComprobantesVentaCabecera, Double> totalComprobante;

}