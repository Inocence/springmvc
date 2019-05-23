package com.baiyu.hello.controller;

import com.baiyu.hello.pojo.UploadFile;
import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public ModelAndView upload(HttpServletRequest request, UploadFile file) throws IOException {
        String name = RandomStringUtils.randomAlphanumeric(10) + ".jpg";
        File new_file = new File(request.getServletContext().getRealPath("/image"), name);
        new_file.getParentFile().mkdirs();
        System.out.println(request.getServletContext().getRealPath("/image"));
        file.getImage().transferTo(new_file);

        ModelAndView model = new ModelAndView("showImage");
        model.addObject("imageName", name);
        return model;
    }
}
