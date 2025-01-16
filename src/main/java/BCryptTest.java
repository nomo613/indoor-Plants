import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {



    public static void main(String[] args) {
        // 1. ハッシュ化済みのパスワード (データベースから取得した値を模擬)
        String hashedPassword = "$2a$08$9ikK/v8eUezCQNQwxFG9b.WxdnoU3Myn7esobVDqAWDA97wEZtVVq"; // password123

        // 2. 入力された平文パスワード (例: ユーザーが入力)
        String plainPassword = "NOMOTO";

        // 3. 比較を実行
        boolean matches = BCrypt.checkpw(plainPassword, hashedPassword);

        // 4. 結果を出力
        if (matches) {
            System.out.println("パスワード一致: ログイン成功");
        } else {
            System.out.println("パスワード不一致: ログイン失敗");
        }
    }
}
