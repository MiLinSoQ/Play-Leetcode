/**
	Url: https://leetcode.com/problems/design-parking-system/
	Author: MiLinSoQ
	Time: 2020-11-31
	Title: Design Parking System
	No: 1603
*/

/**
	設計一個停車場系統 (ParkingSystem)，這個停車場有三種停車位
	1. 大(big)
	2. 中(medium)
	3. 小(small)
	每次停車 (addCar)，都需要傳入車子的大小，並且回傳停車是否成功。
	
	EX: 
		Input
		["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
		[[1, 1, 0], [1], [2], [3], [1]]
		Output
		[null, true, true, false, false]

		Explanation
		ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
		parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
		parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
		parkingSystem.addCar(3); // return false because there is no available slot for a small car
		parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.

*/
public class Solution {
	public static void main(String args[]) {
		
		ParkingSystem park = new ParkingSystem(1, 1, 0);
		
		System.out.println(String.format("Add big car: [ %b ]", park.addCar(1)));
		System.out.println(String.format("Add big car: [ %b ]", park.addCar(1)));
		
		System.out.println(String.format("Add medium car: [ %b ]", park.addCar(2)));
		System.out.println(String.format("Add medium car: [ %b ]", park.addCar(2)));
		
		System.out.println(String.format("Add small car: [ %b ]", park.addCar(3)));
 		
	}
}


class ParkingSystem {

	private Car[] bigs;
	
	private Car[] mediums;
	
	private Car[] smalls;

    public ParkingSystem(int big, int medium, int small) {
        if (big < 0 || medium < 0 || small < 0) throw new IllegalArgumentException("The args is illegal.");
		
		this.bigs = new Car[big];
		this.mediums = new Car[medium];
		this.smalls = new Car[small];
		
    }
    
    public boolean addCar(int carType) {
		if (carType < 1 || carType > 3) return false;
		
		Car car = createCar(carType);
		
		switch (carType) {
			
			case 1:
				return addBig(car);
				
			case 2:
				return addMedium(car);
				
			case 3:
				return addSmall(car);
				
			default:
				return false;
		}
		
    }
	
	private Car createCar(int type) {
		return new Car(type);
	}
	
	private boolean addBig(Car car) {
		for (int i = 0; i < this.bigs.length; i ++) {
			if (this.bigs[i] == null) {
				this.bigs[i] = car;
				return true;
			}
		}
		return false;
	}
	
	private boolean addMedium(Car car) {
		for (int i = 0; i < this.mediums.length; i ++) {
			if (this.mediums[i] == null) {
				this.mediums[i] = car;
				return true;
			}
		}
		return false;
	}
	
	private boolean addSmall(Car car) {
		for (int i = 0; i < this.smalls.length; i ++) {
			if (this.smalls[i] == null) {
				this.smalls[i] = car;
				return true;
			}
		}
		return false;
	}
	
}

class Car {
	
	private int type;
	
	public Car(int type) {
		this.type = type;
	}
	
}
 