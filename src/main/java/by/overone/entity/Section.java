package by.overone.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "my_db.section")
public class Section {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "child_section"
            , joinColumns = @JoinColumn(name = "section_id")
            , inverseJoinColumns = @JoinColumn(name = "child_id"))
    private Set<Child> children;

    public Section() {}

    public Section(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", children=" + children +
                '}';
    }
}
