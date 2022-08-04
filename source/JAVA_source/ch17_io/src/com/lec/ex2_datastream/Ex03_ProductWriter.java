package com.lec.ex2_datastream;
// n 입력할때까지 재고(상품명, 가격, 재고량) 입력받아 파일 출력
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("입력할 재고가 더 있나요?(Y/N)");
				answer = sc.next();
				if(answer.equalsIgnoreCase("n")) {
					break;
				}else if(answer.equalsIgnoreCase("y")) {
					System.out.println("상품명은?");
					dos.writeUTF(sc.next());
					System.out.println("가격은");
					dos.writeInt(sc.nextInt());
					System.out.println("재고수량은?");
					dos.writeInt(sc.nextInt());
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null)
					dos.close();
				if(fos!=null)
					fos.close();
			} catch (Exception e2) {
			}
		}
	}
}
