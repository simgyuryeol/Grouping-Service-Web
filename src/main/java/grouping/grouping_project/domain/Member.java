package grouping.grouping_project.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Member {

    @Id @GeneratedValue
    private Long seq; //사용자 시퀀스

    @Column(name="id")
    private String id; // 아이디

    @Column(name="name")
    private String name; //이름

    @Column(name="age")
    private int age; //나이

    @Column(name="email")
    private String email;//email

    @Column(name="img")
    private String img; //사진

}
