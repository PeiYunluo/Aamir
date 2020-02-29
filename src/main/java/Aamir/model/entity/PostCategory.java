package Aamir.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/28 16:54
 */
@Data
@Entity
@Table(name = "postcategories")
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
public class PostCategory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Category id.
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * Post id.
     */
    @Column(name = "post_id")
    private Integer postId;


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
        PostCategory that = (PostCategory) o;
        return categoryId.equals(that.categoryId) &&
                postId.equals(that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, postId);
    }
}
