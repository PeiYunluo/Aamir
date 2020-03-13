package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 16:40
 */
@Data
@Entity
@Table(name = "posts")
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//postid blogtitle blog_sub_url blog_preface blog_content blog_categroy_id (冗余字段)blog_categroy_name blog_tags
//blogStatus enable_comment
public class Post extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Post title.
     */
    @Column(name = "title", columnDefinition = "varchar(255) not null")
    private String title;

    /**
     * Post status.0-草稿 1-发布
     */
    @Column(name = "status", columnDefinition = "int default 1")
    private Integer status;

    /**
     * Post url.
     */
    @Column(name = "url", columnDefinition = "varchar(255) not null", unique = true)
    private String url;

    /**
     * Original content,not format.
     */
    @Column(name = "original_content", columnDefinition = "longtext not null")
    private String originalContent;

    /**
     * Post summary.
     */
    @Column(name = "summary", columnDefinition = "varchar(1024) default ''")
    private String summary;

    /**
     * Whether to allow comments.
     */
    @Column(name = "disallow_comment", columnDefinition = "int default 0")
    private Boolean disallowComment;
    /**
     * views number
     */
    //bigint defaulf 0怎么加  可能是mysql版本问题
    @Column(name = "visits")
    private Long visits;

    @Override
    protected void prePersist() {
        super.prePersist();
        id = null;
        if (status == null){
            status = 1;
        }
        if (summary == null){
            summary ="";
        }
        if (disallowComment == null){
            disallowComment = false;
        }
        if (visits == null || visits < 0){
            visits = 0L;
        }
    }

}
