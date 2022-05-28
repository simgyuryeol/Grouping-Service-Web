package grouping.grouping_project.service;

import grouping.grouping_project.Dto.MemberForm;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository; // final 안넣어서 오류남 Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause


    public String save(MemberForm request){
        memberRepository.save(Member.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .age(request.getAge())
                        .email(request.getEmail())
                        .img(request.getImg())
                        .build()
                );
        return "Success";
    }
}
