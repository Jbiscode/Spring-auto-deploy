package hello.deployproject.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
