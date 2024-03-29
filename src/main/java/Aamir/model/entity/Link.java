package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 16:33
 */
@Data
@Entity
@Table(name = "links")
@ToString
@EqualsAndHashCode(callSuper = true)
//linkid linktype linkname linkurl linkdescription linkrank
public class Link extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 友链类别 0-友链 1-推荐 2-个人网站
     */
    @Column(name = "type", columnDefinition = "int default 0")
    private Integer type;

    /**
     * Link name.
     */
    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;

    /**
     * Link website address.
     */
    @Column(name = "url", columnDefinition = "varchar(1023) not null")
    private String url;

    /**
     * Website logo.
     */
    @Column(name = "logo", columnDefinition = "varchar(1023) default ''")
    private String logo;

    /**
     * Website description.
     */
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    /**
     * Sort.
     */
    @Column(name = "priority", columnDefinition = "int default 0")
    private Integer priority;

    @Override
    public void prePersist() {
        super.prePersist();

        id = null;

        if (priority == null) {
            priority = 0;
        }

        if (logo == null) {
            logo = "";
        }

        if (description == null) {
            description = "";
        }
        if (type == null){
            type = 0;
        }
    }
}
