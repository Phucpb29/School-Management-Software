/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polypro.helper;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import polypro.model.NhanVien;

/**
 *
 * @author PC
 */
public class ShareHelper {

    //Ảnh của ứng dụng xuất hiện trên mọi cửa sổ
    public static final Image APP_ICON;

    static {
        //Tải biểu tượng ứng dụng
        String file = "/polypro/icon/fpt.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }

    //Sao chép file chuyên đề vào thư mục logo
    //parent là đối tượng file ảnh
    //return kết quả có chép được hay không
    public static boolean savelogo(File file) {
        File dir = new File("logos");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath(), new String[0]);
            Path destination = Paths.get(newFile.getAbsolutePath(), new String[0]);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    //Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
    public static NhanVien USER = null;

    //Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void logoff() {
        ShareHelper.USER = null;
    }

    //Kiểm tra xem đăng nhập hay chưa
    //@return đăng nhập hay chưa
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
}
