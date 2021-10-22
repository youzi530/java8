package case1;

import org.junit.Test;

public class TestOptional2 {

    //获取心中女神的名字
    @Test
    public void test(){
        Man man = new Man();
        String godnessName = getGodnessName(man);
        System.out.println(godnessName);

    }

    public static String getGodnessName(Man man){
        if(man != null){
            Godness godness = man.getGodness();
            if(godness != null){
               return godness.getName();
            }
        }
        return "默认的女神：yyds";
    }


    @Test
    public void test2(){

    }
}
