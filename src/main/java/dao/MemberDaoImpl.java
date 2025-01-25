package dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

public class MemberDaoImpl implements MemberDao {
	
	private DataSource ds;

	public MemberDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Member findByLoginIdAndLoginPass(String loginId,
			String loginPass) {
		Member member = null;

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM admins WHERE login_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String hashedPassword = rs.getString("login_pass");
				System.out.println("データベースから取得したハッシュ値: " + hashedPassword);
				if (BCrypt.checkpw(loginPass, hashedPassword)) {
					System.out.println("パスワード一致");
					member = mapToMember(rs);
				} else {
					System.out.println("パスワード不一致");
				}
			} else {
				System.out.println("指定されたログインIDが見つかりません: " + loginId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return member;
	}

	private Member mapToMember(ResultSet rs) throws Exception {
		Member member = new Member();
		member.setId((Integer) rs.getObject("id"));
		member.setLoginId(rs.getString("login_id"));
		member.setLoginPass(rs.getString("login_pass"));
		return member;
	}

}