package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String story;
    private int cost;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
