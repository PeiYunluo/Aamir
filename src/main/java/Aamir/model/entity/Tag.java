package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 12:56
 */

@Data
@Entity
@Table(name = "tags")
@ToString
@EqualsAndHashCode(callSuper = true)
//tagid tagname
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Tag name.
     */
    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;



    @Override
    protected void prePersist() {
        super.prePersist();
        id = null;
    }

}
