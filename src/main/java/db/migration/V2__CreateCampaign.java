package db.migration;

import java.sql.Connection;
import java.sql.Statement;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

/**
 * @author kawasima
 */
public class V2__CreateCampaign implements JdbcMigration {
    @Override
    public void migrate(Connection connection) throws Exception {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE campaign (" +
                    "campaign_id INTEGER DEFAULT 1 AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(30) NOT NULL," +
                    "statement CLOB NOT NULL," +
                    "goal INTEGER," +
                    "create_user_id INTEGER NOT NULL," +
                    "FOREIGN KEY (create_user_id) REFERENCES user(user_id)" +
                    ")"
                    /*
                    *DEFAULT…データ登録時に値が指定されなかった場合にデフォルト値としてセットされる値
                    *AUTO_INCREMENT…データ追加時にカラムの値をしてしていないと自動的に値を格納する.
                     参考元：https://www.dbonline.jp/sqlite/table/index9.html
                    */
            );
        }
    }
}
