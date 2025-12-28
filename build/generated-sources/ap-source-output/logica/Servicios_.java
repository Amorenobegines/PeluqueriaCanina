package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cita;
import logica.Mascotas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-28T08:58:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile SingularAttribute<Servicios, Double> precio;
    public static volatile ListAttribute<Servicios, Cita> citas;
    public static volatile SingularAttribute<Servicios, String> tipoServicios;
    public static volatile ListAttribute<Servicios, Mascotas> mascotas;
    public static volatile SingularAttribute<Servicios, Integer> id_servicio;

}