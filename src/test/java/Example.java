import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;


/**
 * jpg
 */
public class Example {

    public static void main(String[] args) throws Exception {
        /*File f = new File("D:\\compressPicture\\pic077.jpg");
        System.out.println(f.getTotalSpace());
        BufferedImage bi = ImageIO.read(f);*/

        // rescale(bi);
       /* byte[] afterCompressBytes=null;
        if (afterCompressBytes==null || afterCompressBytes.length > 2)
            System.out.println("hhh");
        for (int i = 1; i < 11; i++) {
            compress(i, bi);
        }*/
        // compress(5, bi);
        // pngTest();
        compressBatch("D:\\compressPicture\\品质\\小图");
    }

    private static void rescale(BufferedImage bi) throws IOException {
        int originalWidth = bi.getWidth();
        int originalHeight = bi.getHeight();
        int type = bi.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : bi.getType();

        //rescale 50%
        BufferedImage resizedImage = new BufferedImage(originalWidth / 2, originalHeight / 2, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(bi, 0, 0, originalWidth / 2, originalHeight / 2, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageIO.write(resizedImage, "jpg", new File("Lenna50.jpg"));
    }

    private static void compress(int compression, File file)
            throws FileNotFoundException, IOException {
        BufferedImage bi = ImageIO.read(file);
        Iterator<ImageWriter> i = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter jpegWriter = i.next();

        // Set the compression quality
        ImageWriteParam param = jpegWriter.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.1f * compression);

        // Write the image to a file
        // FileImageOutputStream out = new FileImageOutputStream(new File("Lenna" + compression + ".jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream(255);
        ImageOutputStream out = ImageIO.createImageOutputStream(bos);
        jpegWriter.setOutput(out);
        jpegWriter.write(null, new IIOImage(bi, null, null), param);
        jpegWriter.dispose();
        BufferedImage imag = ImageIO.read(new ByteArrayInputStream(bos.toByteArray()));
        ImageIO.write(imag, "jpg", new File(file.getParent() + "\\" + file.getName().replaceAll("\\.jpg", "") + compression + ".jpg"));
        out.close();
    }

    public static void pngTest() throws Exception {
        Image sourceImage = new ImageIcon("D:\\Adobe\\Exvoucher_extraxt_get.png").getImage();
        BufferedImage tempImage;
        Graphics2D g2D;
        for (int i = 1; i <= 13; i++) {
            tempImage = new BufferedImage(sourceImage.getWidth(null), sourceImage.getHeight(null), i);
            g2D = (Graphics2D) tempImage.getGraphics();
            g2D.drawImage(sourceImage, 0, 0, null);
            ImageIO.write(tempImage, "png", new File("c_com_" + i + ".png"));
        }
    }

    public static void compressBatch(String dirPath) throws IOException {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        for (File file : files) {
            for (int i = 1; i < 11; i++) {
                compress(i, file);
            }
            //  System.out.println(file.getName());
        }
    }

}