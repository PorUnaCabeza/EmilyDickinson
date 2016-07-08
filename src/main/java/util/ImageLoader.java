package util;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Cabeza on 2016/7/8.
 */
public class ImageLoader {
    private static ClassLoader loader;
    static{
        loader = ImageLoader.class.getClassLoader();
    }
    public static Image getImage(String path){
        URL in = loader.getResource(path);
        return new ImageIcon(in).getImage();
    }
}
