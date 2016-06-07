package modelDB2;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelDB2.Materialorder;
import modelDB2.Supplier;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-07T22:27:09")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> idOrder;
    public static volatile SingularAttribute<Orders, Supplier> idSupplier;
    public static volatile SingularAttribute<Orders, Date> dateCreate;
    public static volatile CollectionAttribute<Orders, Materialorder> materialorderCollection;
    public static volatile SingularAttribute<Orders, String> status;

}