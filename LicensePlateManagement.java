package vn.edu.rikkei.session06.LuyenTap03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LicensePlateManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] listOfVehicleLicensePlates = new String[200];
        int currentLicensePlates = 0;
        int choice;


        do {
            System.out.println("\n********************* QUẢN LÝ BIỂN SỐ XE *********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            if (!sc.hasNextInt()){
                System.out.println("Vui long nhap so tu 1 ->6 :");
                sc.next();
            }
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Nhap so luong bien so xe muon them:");
                    int n = Integer.parseInt(sc.nextLine());

                    if (currentLicensePlates + n > listOfVehicleLicensePlates.length){
                        System.out.println("Khong con du cho de them bien moi");
                        break;
                    }
                    else {
                        String regexLicensePlates = "^[0-9]{2}[A-Z]{1,2}-[0-9]{3}\\.[0-9]{2}$";
                        for (int i = 0; i < n; i++) {
                            System.out.println("Nhap bien so xe thu " + (i+1)+ "(VD: 30F-123.45):");
                            String licensePlates = sc.nextLine().toUpperCase();

                            if (Pattern.matches(regexLicensePlates,licensePlates)){
                                listOfVehicleLicensePlates[currentLicensePlates] = licensePlates;
                                currentLicensePlates++;

                                StringBuffer sb = new StringBuffer("Them thanh cong bien so");
                                sb.append(licensePlates);
                                System.out.println(sb.toString());
                            }
                            else {
                                System.out.println("Bien so xe khong hop le, nhap lai!");
                                i--;
                            }
                        }
                        break;
                    }
                case 2:
                    if (currentLicensePlates==0){
                        System.out.println("Khong co bien so xe nao");
                    }
                    else {
                        StringBuilder sbList = new StringBuilder();
                        for (int i = 0; i < currentLicensePlates; i++) {
                            sbList.append((i+1)).append(". ").append(listOfVehicleLicensePlates[i]).append("\n");

                        }
                        System.out.println(sbList.toString());
                    }
                    break;

                case 3:
                    if (currentLicensePlates==0){
                        System.out.println("Khong co bien so xe nao");
                    }
                    else {
                        System.out.println("Nhap bien so xe can tim chinh xac:");
                        String searchPlate = sc.nextLine().toUpperCase();
                        // Thuật toán tìm kiếm tuyến tính (Linear Search)
                        boolean found = false;
                        for (int i = 0; i < currentLicensePlates; i++) {
                            if (listOfVehicleLicensePlates[i].equals(searchPlate)) {
                                System.out.println("Đã tìm thấy biển số \"" + searchPlate + "\" tại vị trí số " + (i + 1));
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Khong tim thay bien so xe phu hop");

                        }
                    }
                    break;

                case 4:
                    if (currentLicensePlates== 0) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập mã tỉnh cần tìm (VD: 30, 29, 51...): ");
                        String provinceCode = sc.nextLine().trim();

                        boolean foundProvince = false;
                        System.out.println("Các biển số thuộc mã tỉnh " + provinceCode + ":");
                        for (int i = 0; i < currentLicensePlates; i++) {
                            // Kiểm tra xem biển số có bắt đầu bằng mã tỉnh đó không
                            if (listOfVehicleLicensePlates[i].startsWith(provinceCode)) {
                                System.out.println("- " + listOfVehicleLicensePlates[i]);
                                foundProvince = true;
                            }
                        }
                        if (!foundProvince) {
                            System.out.println("Không có biển số xe nào thuộc mã tỉnh này.");
                        }
                    }
                    break;

                case 5:
                    if (currentLicensePlates == 0) {
                        System.out.println("Danh sách trống!");
                    } else {
                        // Thuật toán sắp xếp nổi bọt (Bubble Sort) dựa trên thứ tự từ điển (compareTo)
                        for (int i = 0; i < currentLicensePlates - 1; i++) {
                            for (int j = 0; j < currentLicensePlates- i - 1; j++) {
                                if (listOfVehicleLicensePlates[j].compareTo(listOfVehicleLicensePlates[j + 1]) > 0) {
                                    // Hoán đổi vị trí
                                    String temp = listOfVehicleLicensePlates[j];
                                    listOfVehicleLicensePlates[j] = listOfVehicleLicensePlates[j + 1];
                                   listOfVehicleLicensePlates[j + 1] = temp;
                                }
                            }
                        }
                        System.out.println("Đã sắp xếp danh sách biển số xe tăng dần thành công!");
                        // Hiển thị lại danh sách sau khi sắp xếp
                        for (int i = 0; i < currentLicensePlates; i++) {
                            System.out.println((i + 1) + ". " + listOfVehicleLicensePlates[i]);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 6.");
            }
        }
        while (choice!=6);
        sc.close();

    }

}
