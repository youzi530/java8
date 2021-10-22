package case2;
import case2.Godness;
import org.junit.Test;
import java.util.Optional;

public class TestOptional3 {

    //获取心中女神的名字
    @Test
    public void test() {

        Optional<Man> man = Optional.empty();
        Optional<Man> man1 = Optional.ofNullable(null);
        String godnessName = getGodnessName(man);
        System.out.println(godnessName);

    }

    public static String getGodnessName(Optional<Man> man) {
        return man.orElse(new Man())
                .getGodness()
                .orElse(new Godness("yyds"))
                .getName();
    }

}
