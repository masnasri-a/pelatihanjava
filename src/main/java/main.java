import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class main {
    static List<String> buah = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        do {
            System.out.println("========= MENU ========");
            System.out.println("[1] Show All Buah");
            System.out.println("[2] Insert Buah");
            System.out.println("[3] Edit Buah");
            System.out.println("[4] Delete Buah");
            System.out.println("[5] Exit");
            System.out.print("PILIH MENU> ");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(inputStreamReader);
            int selectedMenu = Integer.valueOf(input.readLine());

            switch (selectedMenu) {
                case 1:
                    System.out.println("DATA SEMUA BUAH");
                    if (buah.size() == 0) {
                        System.out.println("Stok buah kosong");
                    } else {
                        listBuah();
                    }
                    System.out.println("\n");
                    System.out.print("Press any key to continue");
                    input.readLine();
                    break;
                case 2:
                    boolean temp = true;
                    do {
                        System.out.print("Masukkan nama buah baru: ");
                        String dataBuah = input.readLine();

                        addBuah(dataBuah);

                        System.out.print("Masukkan buah lagi? [Y]");
                        String lanjut = input.readLine();
                        if (lanjut.contains("Y")) {
                            temp = true;
                        } else {
                            temp = false;
                        }
                    } while (temp);
                    break;
                case 3:
                    if (buah.size() == 0) {
                        System.out.println("Buah tidak bisa diedit karena data kosong");
                    } else {
                        listBuah();
                        System.out.print("Pilih Nomor Buah : ");
                        Integer num = Integer.parseInt(input.readLine());
                        System.out.print("Masukkan Nama Baru : ");
                        String namaBaru = input.readLine();
                        editBuah(num,namaBaru);
                    }
                    System.out.println("\n");
                    System.out.print("Press any key to continue");
                    input.readLine();
                    break;
                case 4:
                    if (buah.size() == 0) {
                        System.out.println("Buah tidak bisa hapus karena data kosong");
                    } else {
                        listBuah();
                        System.out.print("Pilih Nomor Buah : ");
                        Integer num = Integer.parseInt(input.readLine());
                        deleteBuah(num);
                    }
                    System.out.println("\n");
                    System.out.print("Press any key to continue");
                    input.readLine();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } while (true);
    }

    public static void listBuah(){
        for (int i = 0; i < buah.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + buah.get(i));
        }
    }

    public static void addBuah(String listBuah){
        buah.add(listBuah);
    }

    public static void editBuah(int index, String namaBuah){
        buah.set(index - 1, namaBuah);
    }

    public static void deleteBuah(int index){
        buah.remove(index - 1);
    }
}
