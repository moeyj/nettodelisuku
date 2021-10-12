package moe.yaoji.nettodelisuku;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


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
}
