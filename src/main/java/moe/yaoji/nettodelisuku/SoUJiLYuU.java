package moe.yaoji.nettodelisuku;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
public class SoUJiLYuU {
    @PostMapping("/up")
    public Integer f1(MultipartFile upfile){
        String originalFilename = upfile.getOriginalFilename();
        File file = new File("D:/data/");
        if (!file.exists()){
            file.mkdirs();//如果文件夹不存在则创建
        }
        try {
            upfile.transferTo(new File(file+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
