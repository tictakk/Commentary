import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPEG {

	int[] imageData;
	HashMap<Integer,List<Integer>> markers;
	Map<Integer, Character> ASCII;
	Map<Character, Integer> ASC;
	
	public JPEG(int[] data) {
		this.imageData=data;
		markers=new HashMap<Integer,List<Integer>>();
		ASCII = new HashMap<Integer, Character>();
		ASC=new HashMap<Character, Integer>();
		createASCIItable();
		createASCtable();
	}
	
	public void put(int key, int value) {
		if(markers.containsKey(key)) {
			markers.get(key).add(value);
		}else {
			markers.put(key, new ArrayList<Integer>());
			markers.get(key).add(value);
		}
	}
	
	private HashMap<Integer,List<Integer>> getImageData() { //change to get markers
		return this.markers;
	}
	
	//this is returning the index of each comment location
	private List<Integer> getComments() {
		List<Integer> tables = null;
		if(getImageData().containsKey(0xFE)) {
			tables = getImageData().get(0xFE);
			return tables;
//			return getImageData().remove(0xFF);
		}else {
			System.out.println("no comments");
			return null;
		}
	}
	
	public void readComments() {
		for(Integer i : getComments()) {
//			System.out.println(getComments().size());
			int j = imageData[i];
			while(j!=0xFF) {
//				System.out.print(ASCII.get(j));
				if(ASCII.get(j)!=null) {
					System.out.print(ASCII.get(j));
				}
				j=imageData[i++];
			}
			System.out.println();
		}
	}
	
	private void createASCIItable() {
		Map<Integer, Character> ASCII = new HashMap<Integer, Character>();
		ASCII.put(32, ' ');ASCII.put(33, '!');ASCII.put(34, '"');
		ASCII.put(35, '#');ASCII.put(36, '$');ASCII.put(37, '%');
		ASCII.put(38, '&');ASCII.put(39, '\'');ASCII.put(40, '(');
		ASCII.put(41, ')');ASCII.put(42, '*');ASCII.put(43, '+');
		ASCII.put(44, ',');ASCII.put(45, '-');ASCII.put(46, '.');
		ASCII.put(47, '/');ASCII.put(48, '0');ASCII.put(48, '1');
		ASCII.put(50, '2');ASCII.put(51, '3');ASCII.put(52, '4');
		ASCII.put(53, '5');ASCII.put(54, '6');ASCII.put(55, '7');
		ASCII.put(56, '8');ASCII.put(57, '9');ASCII.put(58, ':');
		ASCII.put(59, ';');ASCII.put(60, '<');ASCII.put(61, '=');
		ASCII.put(62, '>');ASCII.put(63, '?');ASCII.put(64, '@');
		ASCII.put(65, 'A');ASCII.put(66, 'B');ASCII.put(67, 'C');
		ASCII.put(68, 'D');ASCII.put(69, 'E');ASCII.put(70, 'F');
		ASCII.put(71, 'G');ASCII.put(72, 'H');ASCII.put(73, 'I');
		ASCII.put(74, 'J');ASCII.put(75, 'K');ASCII.put(76, 'L');
		ASCII.put(77, 'M');ASCII.put(78, 'N');ASCII.put(79, 'O');
		ASCII.put(80, 'P');ASCII.put(81, 'Q');ASCII.put(82, 'R');
		ASCII.put(83, 'S');ASCII.put(84, 'T');ASCII.put(85, 'U');
		ASCII.put(86, 'V');ASCII.put(87, 'W');ASCII.put(88, 'X');
		ASCII.put(89, 'Y');ASCII.put(90, 'Z');ASCII.put(91, '[');
		ASCII.put(92, '\\');ASCII.put(93, ']');ASCII.put(94, '^');
		ASCII.put(95, '_');ASCII.put(96, '`');ASCII.put(97, 'a');
		ASCII.put(98, 'b');ASCII.put(99, 'c');ASCII.put(100, 'd');
		ASCII.put(101, 'e');ASCII.put(102, 'f');ASCII.put(103, 'g');
		ASCII.put(104, 'h');ASCII.put(105, 'i');ASCII.put(106, 'j');
		ASCII.put(107, 'k');ASCII.put(108, 'l');ASCII.put(109, 'm');
		ASCII.put(110, 'n');ASCII.put(111, 'o');ASCII.put(112, 'p');
		ASCII.put(113, 'q');ASCII.put(114, 'r');ASCII.put(115, 's');
		ASCII.put(116, 't');ASCII.put(117, 'u');ASCII.put(118, 'v');
		ASCII.put(119, 'w');ASCII.put(120, 'x');ASCII.put(121, 'y');
		ASCII.put(122, 'z');ASCII.put(123, '{');ASCII.put(124, '|');
		ASCII.put(125, '}');ASCII.put(126, '~');
		this.ASCII=ASCII;
	}
	
	private void createASCtable() {
//		Map<Integer, Character> ASC = new HashMap<Integer, Character>();
		ASC.put(' ',33);ASC.put('!',33);ASC.put('"',34);
		ASC.put('#',35);ASC.put('$',36);ASC.put('%',37);
		ASC.put('&',38);ASC.put('\'',39);ASC.put('(',40);
		ASC.put(')',41);ASC.put('*',42);ASC.put('+',43);
		ASC.put(',',44);ASC.put('-',45);ASC.put('.',46);
		ASC.put('/',47);ASC.put('0',48);ASC.put('1',48);
		ASC.put('2',50);ASC.put('3',51);ASC.put('4',52);
		ASC.put('5',53);ASC.put('6',54);ASC.put('7',55);
		ASC.put('8',56);ASC.put('9',57);ASC.put(':',58);
		ASC.put(';',59);ASC.put('<',60);ASC.put('=',61);
		ASC.put('>',62);ASC.put('?',63);ASC.put('@',64);
		ASC.put('A',65);ASC.put('B',66);ASC.put('C',67);
		ASC.put('D',68);ASC.put('E',69);ASC.put('F',70);
		ASC.put('G',71);ASC.put('H',72);ASC.put('I',73);
		ASC.put('J',74);ASC.put('K',75);ASC.put('L',76);
		ASC.put('M',77);ASC.put('N',78);ASC.put('O',79);
		ASC.put('P',80);ASC.put('Q',81);ASC.put('R',82);
		ASC.put('S',83);ASC.put('T',84);ASC.put('U',85);
		ASC.put('V',86);ASC.put('W',87);ASC.put('X',88);
		ASC.put('Y',89);ASC.put('Z',90);ASC.put('[',91);
		ASC.put('\\',92);ASC.put(']',93);ASC.put('^',94);
		ASC.put('_',95);ASC.put('`',96);ASC.put('a',97);
		ASC.put('b',98);ASC.put('c',99);ASC.put('d',100);
		ASC.put('e',101);ASC.put('f',102);ASC.put('g',103);
		ASC.put('h',104);ASC.put('i',105);ASC.put('j',106);
		ASC.put('k',107);ASC.put('l',108);ASC.put('m',109);
		ASC.put('n',110);ASC.put('o',111);ASC.put('p',112);
		ASC.put('q',113);ASC.put('r',114);ASC.put('s',115);
		ASC.put('t',116);ASC.put('u',117);ASC.put('v',118);
		ASC.put('w',119);ASC.put('x',120);ASC.put('y',121);
		ASC.put('z',122);ASC.put('{',123);ASC.put('|',124);
		ASC.put('}',125);ASC.put('~',126);
//		this.ASC=ASC;
	}
	
	public void addComment(String comment) {
		int size = comment.length() + 2;
		char comments[] = comment.toCharArray();
		int soiLocation = getImageData().get(0xDA).get(getImageData().get(0xDA).size() -1);
		int[] newImage = new int[size + imageData.length];
		for(int i=newImage.length-1; i>soiLocation; i--) {
			newImage[i]=imageData[i-size];
		}
		for(int j=0; j<soiLocation; j++) {
			newImage[j]=imageData[j];
		}
		
		newImage[soiLocation]=0xFE;
		
		int q = 0;
		for(int z=soiLocation+1; z<soiLocation+size-1;z++) {
			newImage[z] = ASC.get(comments[q]);
			q++;
		}
		this.imageData=newImage;
		put(0xFE,soiLocation);
	}
	
	public void writeFile(String dir) throws IOException {
		File newFile = new File(dir);
		FileOutputStream fos = new FileOutputStream(newFile);
		for(int i : this.imageData) {
			fos.write(i);
		}
		fos.close();
	}
	
	
}
