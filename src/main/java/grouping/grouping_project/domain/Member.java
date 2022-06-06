package grouping.grouping_project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; //사용자 시퀀스

    @Column(nullable = false, name="id",unique = true)
    private String id; // 아이디

    private String password; //비밀번호

    @Column(nullable = false,name="name")
    private String name; //이름

    @Column(nullable = false,name="age")
    private int age; //나이

    @Column(name="email")
    private String email;//email

    @Column(name="img")
    private String img; //사진

    private String role; //사용자 권한

    // 회원 탈퇴시 작성한 게시물, 댓글 모두 삭제
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teamList = new ArrayList<>();

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();

    //== 연관관계 메서드 ==//
    public void addPost(Team team){
        //post의 writer 설정은 post에서 함
        teamList.add(team);
    }

    public void addComment(Comment comment){
        //comment의 writer 설정은 comment에서 함
        commentList.add(comment);
    }

}
