import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LinkedPurchaseListKey implements Serializable {
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
}
