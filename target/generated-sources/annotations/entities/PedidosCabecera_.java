package entities;

import entities.Clientes;
import entities.ComprobantesVentaCabecera;
import entities.PedidosDetalle;
import entities.Vendedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(PedidosCabecera.class)
public class PedidosCabecera_ { 

    public static volatile SingularAttribute<PedidosCabecera, Double> latitud;
    public static volatile SingularAttribute<PedidosCabecera, String> estado;
    public static volatile SingularAttribute<PedidosCabecera, Double> longitud;
    public static volatile SingularAttribute<PedidosCabecera, Clientes> idCliente;
    public static volatile SingularAttribute<PedidosCabecera, Vendedores> idVendedor;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaCreacion;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaActualizacion;
    public static volatile SingularAttribute<PedidosCabecera, Date> fechaPedido;
    public static volatile ListAttribute<PedidosCabecera, PedidosDetalle> pedidosDetalleList;
    public static volatile SingularAttribute<PedidosCabecera, Integer> id;
    public static volatile ListAttribute<PedidosCabecera, ComprobantesVentaCabecera> comprobantesVentaCabeceraList;
    public static volatile SingularAttribute<PedidosCabecera, Double> importe;

}