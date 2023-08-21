import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey key;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "price")
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;


}

