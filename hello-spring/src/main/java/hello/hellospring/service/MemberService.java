package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository() {


        //회원 가입
        public Long join(Member member){
            //같은 이름이 있는 중복 회원X
            Optional<Member>result = memberRepository.findByname(member.getName());
            result.ifPresent(m ->{
                throw  new IllegalStateException()
            })
            memberRepository.save(member);
            return member.getId();
        }


    };
}
