package vn.edu.rikkei.session06.LuyenTap02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserManagement {

    static String fullName = "";
    static String email = "";
    static String phone = "";
    static String password = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice ;
        do {
            System.out.println("\n******************** QUẢN LÝ NGƯỜI DÙNG ********************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            while (!sc.hasNextInt()){
                System.out.println("Lua chon khong hop le. Nhap tu 1->6:");
                sc.next();
            }
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Moi ban nhap thong tin nguoi dung:");
                    System.out.println("Moi ban nhap ho va ten :");
                    fullName = sc.nextLine();

                    System.out.println("Moi ban nhap email cua ban:");
                    email = sc.nextLine();

                    System.out.println("Moi ban nhap so dien thoai cua ban:");
                    phone = sc.nextLine();

                    System.out.println("Moi ban nhap mat khau cua ban:");
                    password = sc.nextLine();

                    System.out.println("Nhap thong tin thanh cong");
                    break;

                case 2:
                    if (fullName.isEmpty()){
                        System.out.println("Chua co thgong tin nguoi dung");
                    }
                    else {
                        fullName = normalizeName(fullName);
                        System.out.println("Ho va ten sau khi chuan hoa la:" +fullName);
                    }
                    break;

                case 3:
                    if (email.isEmpty()){
                        System.out.println("Chua cos email nao !");
                    }
                    else {
                        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
                        if (Pattern.matches(emailRegex,email)){
                            System.out.println("email hop le" + email);
                        }
                        else {
                            System.out.println("Email khong hop le!");
                        }
                    }
                    break;

                case 4:
                    if (phone.isEmpty()){
                        System.out.println("So dien thoai chua co");
                    }
                    else {
                        String phoneRegex = "^0[3|5|7|8|9][0-9]{8}$";
                        if (Pattern.matches(phoneRegex,phone)){
                            System.out.println("So dien thoai hop le" + phone);
                        }
                        else {
                            System.out.println("So dien thoai khong hop le");
                        }
                    }
                    break;

                case 5:
                    if (password.isEmpty()){
                        System.out.println("Mat khau khong co");
                    }
                    else {
                        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!._-]).{8,}$";
                        if (Pattern.matches(passwordRegex,password)){
                            System.out.println("Password hop le" + password);
                        }
                        else{
                            System.out.println("Password khong hop le");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Cam on da thoat chuong trinh");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. chon tu 1->6");
            }
        }
        while (choice!=6);
        sc.close();
}

    public static String normalizeName(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "";
        }
        str = str.trim().replaceAll("\\s+", " ");
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }
}

