package hello.deployproject.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
