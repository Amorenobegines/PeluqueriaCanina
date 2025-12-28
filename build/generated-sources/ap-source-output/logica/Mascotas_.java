package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cita;
import logica.Duenio;
import logica.Servicios;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-12-28T08:58:00", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mascotas.class)
public class Mascotas_ { 

    public static volatile ListAttribute<Mascotas, Servicios> servicios;
    public static volatile SingularAttribute<Mascotas, Integer> num_cliente;
    public static volatile SingularAttribute<Mascotas, String> raza;
    public static volatile SingularAttribute<Mascotas, String> color;
    public static volatile ListAttribute<Mascotas, Cita> citas;
    public static volatile SingularAttribute<Mascotas, String> alergico;
    public static volatile SingularAttribute<Mascotas, String> nombreMas;
    public static volatile SingularAttribute<Mascotas, String> observaciones;
    public static volatile SingularAttribute<Mascotas, Duenio> unDuenio;
    public static volatile SingularAttribute<Mascotas, String> atencion_especial;

}