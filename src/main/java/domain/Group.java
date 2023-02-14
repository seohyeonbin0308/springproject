package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Group {

    @Id @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    private String name;
    private String password;
    private String balance;

    // 그룹에 속한 회웓들
    @ManyToMany
    @JoinTable(name="member_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "member_Id"))
    private List<Member> members = new ArrayList<>();

}
