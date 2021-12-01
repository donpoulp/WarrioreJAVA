package donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ManipCollection {
    private ArrayList<String> test = new ArrayList();

    public void initList(){
        test.add("aaa");
        test.add("rrr");
        test.add("bbb");
        test.add("ssqqqs");
        test.add("eeee");
        test.add("zdzdd");
        test.add("kkk");
        test.add("ggggq");
        test.add("qqq");
        test.add("iiiq");
        test.add("ooo");
        test.add("yyy");
        test.add("nnn");
        System.out.println(test);
    }

    public void searchByString(String lettre){
       List<String> test1 = test.stream().filter(e -> e.contains(lettre)).collect(Collectors.toList());
        System.out.println(test1);
    }

    public void remove(String lettre){
       for (String e : test){
           if (e.contains(lettre)){
               test.remove(e);
           }
       }
       System.out.println(test);
    }
}

