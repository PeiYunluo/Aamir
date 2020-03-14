package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/14 15:43
 */
@Data
@Entity
@Table(name = "photos")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Photo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",columnDefinition = "varchar(255) default''")
    private String name;

    @Column(name = "url", columnDefinition = "varchar(1023) not null")
    private String url;

    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    @Column(name = "localurl", columnDefinition = "varchar(1023) default''")
    private String localurl;
    @Override
    public void prePersist() {
        super.prePersist();
        id = null;
        if (url == null) {
            url = "";
        }
    }
}
