package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:18
 */
@Data
@Entity
@Table(name = "aamirconfig")
@ToString
@EqualsAndHashCode(callSuper = true)
public class AamirConfig extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "config_field", columnDefinition = "varchar(255) not null")
    private String configfield;

    @Column(name = "config_name", columnDefinition = "varchar(255) not null")
    private String configname;

    @Column(name = "config_value", columnDefinition = "varchar(255) not null")
    private String configvalue;

    @Override
    public void prePersist() {
        super.prePersist();
        id = null;
    }
}
