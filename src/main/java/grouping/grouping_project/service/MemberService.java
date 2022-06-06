package grouping.grouping_project.service;

import grouping.grouping_project.Dto.MemberForm;
import grouping.grouping_project.Dto.MemberUpdateForm;
import grouping.grouping_project.Dto.MemberloginForm;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.domain.Team;
import grouping.grouping_project.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository; // final 안넣어서 오류남 Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause

    //회원가입
    @Transactional
    public String save(MemberForm request){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        memberRepository.save(Member.builder()
                        .id(request.getId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .age(request.getAge())
                        .email(request.getEmail())
                        .img(request.getImg())
                        .build()
                );
        return "Success";
    }

    //아이디로 정보 찾기
    @Transactional
    public Optional<Member> getMemberForm(String id) {

        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    //로그인
    public String login(MemberloginForm memberloginForm){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password=memberRepository.findById(memberloginForm.getId()).get().getPassword();
        log.info(password);
        if(!(passwordEncoder.matches(memberloginForm.getPassword(),password))){
            return "False";
        }
        return "Success";

    }

    public void update(MemberUpdateForm memberUpdateForm) {

    }
}
