package Aamir.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 16:53
 */

//id   blogid   tagid   creat-time
@Data
@Entity
@Table(name = "posttags")
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
public class PostTag extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Post id.
     */
    @Column(name = "post_id", columnDefinition = "int not null")
    private Integer postId;

    /**
     * Tag id.
     */
    @Column(name = "tag_id", columnDefinition = "int not null")
    private Integer tagId;

    @Override
    public void prePersist() {
        super.prePersist();
        id = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostTag postTag = (PostTag) o;
        return Objects.equals(postId, postTag.postId) &&
                Objects.equals(tagId, postTag.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }
}
