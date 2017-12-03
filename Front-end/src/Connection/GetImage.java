package Connection;

/**
 * Created by Thisun Pathirage on 12/1/2017.
 */

import java.io.*;
import java.net.URL;

public class GetImage {

    public static void download(String imgId) throws Exception{
        String imgUrl = "http://res.cloudinary.com/dxpaymvgg/image/upload/v1512066420/";

        String fileName = "Front-end\\src\\UI\\Images\\locos\\"+imgId+".png";
        URL url = new URL(imgUrl+imgId+".png");
        InputStream inputStream = url.openStream();
        OutputStream outputStream = new FileOutputStream(fileName);
        byte[] buffer = new byte[2048];

        int length = 0;

        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }

        inputStream.close();
        outputStream.close();


    }
}
