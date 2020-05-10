/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polypro.helper;

/**
 *
 * @author MyPC
 */
public class StringParseHelper {
    public static String GioiTinhtoString(int IntGT) {
        String StringTrangThai = null;
        switch (IntGT) {
            case 0:
                StringTrangThai = "Nữ";
                break;
            case 1:
                StringTrangThai = "Nam";
                break;
            case 2:
                StringTrangThai = "Khác";
                break;
            default:
        }
        return StringTrangThai;
    }
}
