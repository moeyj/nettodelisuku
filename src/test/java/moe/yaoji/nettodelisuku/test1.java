package moe.yaoji.nettodelisuku;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    String s="D:/data/";
    @Test
    void f1(){
        File file = new File(s);
        String[] list = file.list();
        List<String> strings = new ArrayList<>();
        for (String s1 : list) {
            if (new File(s+s1).isFile())
                strings.add(s1);
        }
    }
}
