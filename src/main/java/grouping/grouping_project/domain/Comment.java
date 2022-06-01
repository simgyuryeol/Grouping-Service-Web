package grouping.grouping_project.domain;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Table(name = "COMMENT")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer_id")
    private Member id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id")
    private Team team;

    @Column(nullable = false)
    private String content;

    // 연관관계 편의 메서드
    public void confirmWriter(Member id) {

        id.addComment(this);
    }

    public void confirmPost(Team team) {

        team.addComment(this);
    }
}
