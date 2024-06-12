package com.example.demo.component;

import java.net.URL;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageUtill {
  public static final String URL = null;

  public void save(String path) throws IOException {
URL url = null;
url = new URL("http://ggoreb.com/images/luffy.jpg");
String fileName = path.substring(path.lastIndexOf("/") + 1);
String fileExt = path.substring(path.lastIndexOf(".") + 1);
BufferedImage img = ImageIO.read(url);
ImageIO.write(img, fileExt, new File(fileName));
}
}
