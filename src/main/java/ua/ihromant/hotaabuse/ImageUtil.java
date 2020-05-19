package ua.ihromant.hotaabuse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static int[] extractBytes(String imagePath) throws IOException {
        // open image
        File imgPath = new File(imagePath);
        return extractBytes(ImageIO.read(imgPath));
    }

    public static int[] extractBytes(BufferedImage image) {
        // get DataBufferBytes from Raster
        WritableRaster raster = image.getRaster();
        return extractBytes(raster.getDataBuffer());
    }

    private static int[] extractBytes(DataBuffer dataBuffer) {
        if (dataBuffer instanceof DataBufferByte) {
            byte[] bytes = ((DataBufferByte) dataBuffer).getData();
            int length = bytes.length / 3;
            int[] result = new int[length];
            for (int i = 0; i < length; i++) {
                result[i] = (0xFF << 24) | ((0xFF & bytes[3 * i + 2]) << 16) | ((0xFF & bytes[3 * i + 1]) << 8) | (0xFF & bytes[3 * i]);
            }
            return result;
        }
        if (dataBuffer instanceof DataBufferInt) {
            return ((DataBufferInt) dataBuffer).getData();
        }

        throw new IllegalArgumentException("Not supported class" + dataBuffer.getClass().getSimpleName());
    }

    public static BufferedImage readImageClassPath(String name) {
        try {
            return ImageIO.read(ImageUtil.class.getResourceAsStream("/images/" + name + ".png"));
        } catch (IOException e) {
            throw new IllegalStateException("No resource with name " + name);
        }
    }

    public static boolean compareImages(BufferedImage first, BufferedImage second) {
        int[] bytesLeft = extractBytes(first);
        int[] bytesRight = extractBytes(second);
        if (bytesLeft.length != bytesRight.length) {
            throw new IllegalArgumentException("Provided images with different size");
        }
        int length = bytesLeft.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (bytesLeft[i] == bytesRight[i]) {
                counter++;
            }
        }
        double rate = 1.0 * counter / length;
        return rate > 0.95;
    }
}
