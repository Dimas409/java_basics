import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private int salary;
    @Column(name = "age")
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
