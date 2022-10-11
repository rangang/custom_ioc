import com.rg.service.UserService;
import com.rg.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @BelongsProject: custom_ioc
 * @Author: RG
 * @CreateTime: 2022/10/10 5:11 下午
 * @Description:
 */
public class UserTest {

    @Test
    public void testSave() {
        UserService userService = new UserServiceImpl();
        userService.save();
    }

}
