package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 11:36
 */
//categoruid categoryname categoryicon categoryrank
@Data
@Entity
@Table(name = "categories")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    //org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL
    // "create table categories (id integer not null auto_increment,
    // create_time timestamp default CURRENT_TIMESTAMP, deleted TINYINT default 0,
    // update_time timestamp default CURRENT_TIMESTAMP, description varchar(100) default '',
    // icon varchar(1023) default ',
    // name varchar(255) not null, rank default 0, primary key (id)) engine=InnoDB" via JDBC Statement
    /**
     * Category name.
     */

    @Column(name = "categroy_rank")
    private Integer categroyrank;

    @Column(name = "categroy_name", columnDefinition = "varchar(255) not null")
    private String categroyname;

    /**
     * Description,can be display on category page.
     */
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    @Column(name = "icon",columnDefinition = "varchar(1023) default ''")
    private String icon;

    @Override
    public void prePersist() {
        super.prePersist();
        id = null;

        if (description == null) {
            description = "";
        }
        if (icon == null){
            icon="";
        }
        if (categroyrank == null){
            categroyrank = 0 ;
        }
    }


}
