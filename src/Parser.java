
public class Parser {
	
	public static final int MARKER = 0xFF;
	public static final int SOF0 = 0xC0; //Baseline DCT
	public static final int SOF1 = 0xC1; //Extended seq DCT
	public static final int SOF2 = 0xC2; //Progressive DCT
	public static final int SOF3 = 0xC3; //Lossless
	public static final int SOF5 = 0xC5; // 
	public static final int SOF6 = 0xC6;
	public static final int SOF7 = 0xC7; 
	public static final int JPG = 0xC8;
	public static final int SOF9 = 0xC9;
	public static final int DHT = 0xC4;
	public static final int DAC = 0xCC;
	
	public static final int SOI = 0xD8;
	public static final int EOI = 0xD9;
	public static final int SOS = 0xDA;
	public static final int DQT = 0xDB;
	public static final int DNL = 0xDC;
	public static final int DRI = 0xDD;
	public static final int DHP = 0xDE;
	public static final int EXP = 0xDF;
	public static final int COM = 0xFE;
	
	public static int getLength() {
		return 0;
	}
	 
	private boolean markerFound() {
		return true;
	}
	
	public static JPEG createJPEG(byte[] data) {
		int[] newData = new int[data.length];
		int i = 0;
		for(byte b : data) {
			if(b<0) {
				newData[i]=(b & 0xFF);
			}else {
				newData[i]=b;
			}
			i++;
		}
		
//		for(int b : newData){
//			System.out.println(b);
//		}
		JPEG jpeg = new JPEG(newData);

		int z = 0;
		for(int j : newData) {
			if(j == MARKER) {
				switch(newData[z+1]) {
				
					case SOI: 	
//								System.out.println("SOI"); //for testing
								jpeg.put(SOI, z+1);
								break;
					case SOF0: 
//								System.out.println("SOF0"); //for testing
								jpeg.put(SOF0, z+1);
								break;
								
					case SOF1: 
//								System.out.println("SOF1"); //for testing
								jpeg.put(SOF1, z+1);
								break;
								
					case SOF2: 
//								System.out.println("SOF2"); //for testing
								jpeg.put(SOF2, z+1);
								break;
							
					case SOF3: 
//								System.out.println("SOF3"); //for testing
								jpeg.put(SOF3, z+1);
								break;
						
					case SOF5: 
//								System.out.println("SOF5"); //for testing
								jpeg.put(SOF5, z+1);
								break;
						
					case SOF6: 
//								System.out.println("SOF6"); //for testing
								jpeg.put(SOF6, z+1);
								break;
						
					case SOF7: 
//								System.out.println("SOF7"); //for testing
								jpeg.put(SOF7, z+1);
								break;
						
					case SOS: 
//								System.out.println("SOS"); //for testing
								jpeg.put(SOS, z+1);
								break;
								
					case JPG: 
//								System.out.println("JPG"); //for testing
								jpeg.put(JPG, z+1);
								break;
								
					case DAC: 
//								System.out.println("DAC"); //for testing
								jpeg.put(DAC, z+1);
								break;
								
					case DQT: 
//								System.out.println("DQT"); //for testing
								jpeg.put(DQT, z+1);
								break;
					case DNL: 
//						System.out.println("DNL"); //for testing
								jpeg.put(DNL, z+1);
								break;
					case DRI: 
//						System.out.println("DRI"); //for testing
								jpeg.put(DRI, z+1);
								break;
					case DHP: 
//						System.out.println("DHP");
								jpeg.put(DHP, z+1);
								break;
					case EXP: 
//						System.out.println("EXP");
								jpeg.put(EXP, z+1);
								break;
					case COM: 
//						System.out.println("COM");
								jpeg.put(COM, z+1);
								break;
								
					case DHT: 
//						System.out.println("DHT");
								jpeg.put(DHT, z+1);
								break;
								
					case EOI: 
//						System.out.println("EOI");
								jpeg.put(EOI, z+1);
								break;
				}
			}
			z++;
		}
		return jpeg;
	}
	
//	public static JPEG createJPEG(int[] data) {
//		int[] newData = new int[data.length];
//		int i = 0;
//		for(byte b : data) {
//			if(b<0) {
//				newData[i]=(b & 0xFF);
//			}else {
//				newData[i]=b;
//			}
//			i++;
//		}
//		
////		for(int b : newData){
////			System.out.println(b);
////		}
//		JPEG jpeg = new JPEG(newData);
//
//		int z = 0;
//		for(int j : newData) {
//			if(j == MARKER) {
//				switch(newData[z+1]) {
//				
//					case SOI: 	
////								System.out.println("SOI"); //for testing
//								jpeg.put(SOI, z+1);
//								break;
//					case SOF0: 
////								System.out.println("SOF0"); //for testing
//								jpeg.put(SOF0, z+1);
//								break;
//								
//					case SOF1: 
////								System.out.println("SOF1"); //for testing
//								jpeg.put(SOF1, z+1);
//								break;
//								
//					case SOF2: 
////								System.out.println("SOF2"); //for testing
//								jpeg.put(SOF2, z+1);
//								break;
//							
//					case SOF3: 
////								System.out.println("SOF3"); //for testing
//								jpeg.put(SOF3, z+1);
//								break;
//						
//					case SOF5: 
////								System.out.println("SOF5"); //for testing
//								jpeg.put(SOF5, z+1);
//								break;
//						
//					case SOF6: 
////								System.out.println("SOF6"); //for testing
//								jpeg.put(SOF6, z+1);
//								break;
//						
//					case SOF7: 
////								System.out.println("SOF7"); //for testing
//								jpeg.put(SOF7, z+1);
//								break;
//						
//					case SOS: 
////								System.out.println("SOS"); //for testing
//								jpeg.put(SOS, z+1);
//								break;
//								
//					case JPG: 
////								System.out.println("JPG"); //for testing
//								jpeg.put(JPG, z+1);
//								break;
//								
//					case DAC: 
////								System.out.println("DAC"); //for testing
//								jpeg.put(DAC, z+1);
//								break;
//								
//					case DQT: 
////								System.out.println("DQT"); //for testing
//								jpeg.put(DQT, z+1);
//								break;
//					case DNL: 
////						System.out.println("DNL"); //for testing
//								jpeg.put(DNL, z+1);
//								break;
//					case DRI: 
////						System.out.println("DRI"); //for testing
//								jpeg.put(DRI, z+1);
//								break;
//					case DHP: 
////						System.out.println("DHP");
//								jpeg.put(DHP, z+1);
//								break;
//					case EXP: 
////						System.out.println("EXP");
//								jpeg.put(EXP, z+1);
//								break;
//					case COM: 
////						System.out.println("COM");
//								jpeg.put(COM, z+1);
//								break;
//								
//					case DHT: 
////						System.out.println("DHT");
//								jpeg.put(DHT, z+1);
//								break;
//								
//					case EOI: 
////						System.out.println("EOI");
//								jpeg.put(EOI, z+1);
//								break;
//				}
//			}
//			z++;
//		}
//		return jpeg;
//	}
	
}
