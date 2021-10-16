package moe.yaoji.nettodelisuku;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SoUJiLYuU {
    @Value("${hulairu}")
    String s;
    @PostMapping("/upfile")
    @ResponseBody
    public int f1(MultipartFile upfile) {
        String originalFilename = upfile.getOriginalFilename();
        if (originalFilename!=null&&originalFilename.length()>0){
        File file = new File(s);
        if (!file.exists()) {
            file.mkdirs();//如果文件夹不存在则创建
        }
        try {
            upfile.transferTo(new File(s + originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
        }
        return 1;
    }
    @PostMapping("/filelist")
    @ResponseBody
    public List<String> f2(){
        File file = new File(s);
        String[] list = file.list();
        List<String> strings = new ArrayList<>();
        for (String s1 : list) {
            if (new File(s+s1).isFile())
                strings.add(s1);
        }
        return strings;
    }
}
