package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/24 15:36
 */
@Data
@Entity
@Table(name = "userinfo")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Userinfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;
}
