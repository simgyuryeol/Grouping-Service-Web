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

    private MemberRepository memberRepository;

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
