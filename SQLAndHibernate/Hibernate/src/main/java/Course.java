import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@ToString(exclude = "students")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private int duration;
    @Column(name = "type")
//    @Convert(converter = CourseTypeConverter.class)
    @Enumerated(EnumType.STRING)
    private CourseType type;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;
    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;
    @Column(name = "price")
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
    joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students;

    public Course() {
    }

    public Course(String name, int duration, CourseType type, String description,
                  Teacher teacher, Integer studentsCount, int price, float pricePerHour) {
        this.name = name;
        this.duration = duration;
        this.type = type;
        this.description = description;
        this.teacher = teacher;
        this.studentsCount = studentsCount;
        this.price = price;
        this.pricePerHour = pricePerHour;
    }
}
