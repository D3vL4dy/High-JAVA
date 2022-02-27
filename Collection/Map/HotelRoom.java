package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HotelRoom {
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Room> map = new HashMap<Integer, Room>();

	public static void main(String[] args) {
		new HotelRoom().start();
	}

	public void start() {
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		while (true) {
			System.out.println("----------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>> ");
			int input = Integer.parseInt(scan.nextLine());
			System.out.println();

			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomCondition();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				System.exit(0);
				break;
			}
		}
	}

	// 체크인
	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int roomNumber = Integer.parseInt(scan.nextLine());
		
		if (!map.containsKey(roomNumber)) {
			if (roomNumber >= 201 && roomNumber <= 209) {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = scan.nextLine();
				System.out.println("체크인이 완료되었습니다.");
				System.out.println();
				map.put(roomNumber, new Room(roomNumber, "싱글룸", name));
			} else if (roomNumber >= 301 && roomNumber <= 309) {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = scan.nextLine();
				System.out.println("체크인이 완료되었습니다.");
				System.out.println();
				map.put(roomNumber, new Room(roomNumber, "더블룸", name));
			} else if (roomNumber >= 401 && roomNumber <= 409) {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = scan.nextLine();
				System.out.println("체크인이 완료되었습니다.");
				System.out.println();
				map.put(roomNumber, new Room(roomNumber, "스위트룸", name));
			} else {
				System.out.println(roomNumber + "호 객실은 존재하지 않습니다.");
				System.out.println();
			}
		}else {
			System.out.println(roomNumber + "호 객실은 이미 손님이 있습니다.");
			System.out.println();
		}
	}

	// 체크아웃
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int roomNumber = Integer.parseInt(scan.nextLine());
		if (roomNumber >= 201 && roomNumber <= 209) {
			if (map.containsKey(roomNumber)) {
				System.out.println(roomNumber + "호 객실의 " + map.getName() + "님 체크아웃을 완료하였습니다.");
				System.out.println();
				map.remove(roomNumber);
			} else {
				System.out.println(roomNumber + "호 객실에는 체크인 한 사람이 없습니다.");
				System.out.println();
			}
		} else if (roomNumber >= 301 && roomNumber <= 309) {
			if (map.containsKey(roomNumber)) {
				System.out.println(roomNumber + "호 객실의 " + map.getName() + "님 체크아웃을 완료하였습니다.");
				System.out.println();
				map.remove(roomNumber);
			} else {
				System.out.println(roomNumber + "호 객실에는 체크인 한 사람이 없습니다.");
				System.out.println();
			}
		} else if (roomNumber >= 401 && roomNumber <= 409) {
			if (map.containsKey(roomNumber)) {
				System.out.println(roomNumber + "호 객실의 " + map.getName() + "님 체크아웃을 완료하였습니다.");
				System.out.println();
				map.remove(roomNumber);
			} else {
				System.out.println(roomNumber + "호 객실에는 체크인 한 사람이 없습니다.");
				System.out.println();
			}
		} else {
			System.out.println(roomNumber + "호 객실은 존재하지 않습니다.");
			System.out.println();
		}

	}

	// 객실상태
	private void roomCondition() {
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		Set<Integer> keySet = map.keySet();
		
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			Room value = map.get(key);
			System.out.println(key + " ==> " + value);
		}
		System.out.println("--------------------------------");
	}

}

class Room {
	// 방번호(int), 방종류, 투숙객이름
	int roomNumber;
	String roomStyle;
	String name;

	public Room(int roomNumber, String roomStyle, String name) {
		super();
		this.roomNumber = roomNumber;
		this.roomStyle = roomStyle;
		name = null;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomStyle=" + roomStyle + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
