package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String loginID;
    private String password;
    private int age;

    // 멤버가 속한 그룹리스트
    @ManyToMany(mappedBy = "members")
    private List<Group> groupList = new ArrayList<>();
}
