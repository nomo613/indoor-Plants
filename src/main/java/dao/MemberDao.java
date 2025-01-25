package dao;

public interface MemberDao {

	dto.Member findByLoginIdAndLoginPass(String loginId, String loginPass);

}
