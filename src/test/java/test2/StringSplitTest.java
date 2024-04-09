package test2;

public class StringSplitTest {

	public static void main(String[] args) {
		String str = "CPU	\r\n"
				+ "[INTEL] i7-13700 (정품)\r\n"
				+ "CPU 쿨러	\r\n"
				+ "[3RSYS] Socoool RANNI SE 240 ARGB (BLACK)\r\n"
				+ "M/B	\r\n"
				+ "[ASUS] ROG STRIX B760-I GAMING WIFI\r\n"
				+ "RAM	\r\n"
				+ "[Team Group] DDR5-5600 CL46 Elite 16GB *2EA\r\n"
				+ "GPU	\r\n"
				+ "[GALAX] RTX 4070 2X D6X 12GB \r\n"
				+ "SSD	\r\n"
				+ "[SK hynix] Gold P31 M.2 NVMe TLC [1TB]\r\n"
				+ "PSU	\r\n"
				+ "[FSP] DAGGER PRO 850W GOLD Full Modular\r\n"
				+ "CASE	\r\n"
				+ "[HYTE] REVOLT 3 블랙";
		
		String[] arr = str.split("\r\n");
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
