package Connection;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Thisun Pathirage on 12/1/2017.
 */
public class PostImage {
    static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dxpaymvgg", "api_key", "781569422744352", "api_secret", "aq8RNUt2C5oG2jfHqkxIgItGYPM"));

    public static void upload(String filename, File toUpload) {
        System.out.println(toUpload);
        System.out.println(filename);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(toUpload.toString(), ObjectUtils.asMap("public_id", filename, "transformation", new Transformation().radius("max").width(512).height(512).crop("fit").fetchFormat("png")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}