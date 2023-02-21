package com.example.video.controller;

import com.example.video.handler.NonStaticResourceHttpRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/api/baseResource")
public class BaseResourceApiController {

    @Autowired
    private NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @RequestMapping(value = "/video",method = RequestMethod.GET)
    public void video(HttpServletRequest request, HttpServletResponse response){
        try{
            String path="D:/d.mp4";
            File file = new File(path);
            if (file.exists()){
                request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE,path);
                nonStaticResourceHttpRequestHandler.handleRequest(request,response);
            }else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            }
        }catch (Exception e){

        }
    }
}
