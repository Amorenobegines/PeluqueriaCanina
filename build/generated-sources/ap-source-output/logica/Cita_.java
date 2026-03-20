package logica;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Mascotas;
import logica.Servicios;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-03-20T18:25:39", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile ListAttribute<Cita, Servicios> servicios;
    public static volatile SingularAttribute<Cita, LocalDateTime> fechaHora;
    public static volatile SingularAttribute<Cita, Mascotas> mascota;
    public static volatile SingularAttribute<Cita, Integer> id;

}