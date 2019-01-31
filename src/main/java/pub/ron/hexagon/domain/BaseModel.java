package pub.ron.hexagon.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseModel {

    @Id
    @GeneratedValue
    private Long id;

}
