package Aamir.model.entity;

import Aamir.model.enums.CommentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 13:04
 */
@Data
@Entity
@Table(name = "comments")
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

//commentid 关联的blogid commentotor email website_url comment_body comment_create_time commentator_ip reply_body reply_create_time
//comment_status is_deleted
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Commentator's name.
     */
    @Column(name = "author", columnDefinition = "varchar(50) not null")
    private String author;

    /**
     * Commentator's email.
     */
    @Column(name = "email", columnDefinition = "varchar(255) not null")
    private String email;

    /**
     * Commentator's ip address.
     */
    @Column(name = "ip_address", columnDefinition = "varchar(127) default ''")
    private String ipAddress;

    /**
     * Commentator's website.
     */
    @Column(name = "author_url", columnDefinition = "varchar(512) default ''")
    private String authorUrl;

    /**
     * Comment content.
     */
    @Column(name = "content", columnDefinition = "varchar(1023) not null")
    private String content;

    /**
     * Comment status.
     */
    //TODO
    @Column(name = "status", columnDefinition = "int default 1")
    private Integer status;

    /**
     * Is admin's comment.
     */
    @Column(name = "is_admin", columnDefinition = "tinyint default 0")
    private Boolean isAdmin;

    /**
     * Allow notification.
     */
    @Column(name = "allow_notification", columnDefinition = "tinyint default 1")
    private Boolean allowNotification;

    /**
     * Post id.
     */
    @Column(name = "post_id", columnDefinition = "int not null")
    private Integer postId;

    /**
     * Whether to top the comment.
     */
    @Column(name = "top_priority", columnDefinition = "int default 0")
    private Integer topPriority;

    /**
     * Parent comment.
     */
    @Column(name = "parent_id", columnDefinition = "bigint default 0")
    private Long parentId;

    @Override
    public void prePersist() {
        super.prePersist();
        id = null;

        if (ipAddress == null) {
            ipAddress = "";
        }

        if (authorUrl == null) {
            authorUrl = "";
        }


        if (status == null) {
           status = 1;
        }


        if (isAdmin == null) {
            isAdmin = false;
        }

        if (allowNotification == null) {
            allowNotification = true;
        }

        if (parentId == null){
            parentId =0L;
        }
    }

}
