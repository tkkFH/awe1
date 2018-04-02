package de.fhdw.awe1.uebung1;

public class VergleichArrayListUndLinkedList {

	public static void main(String[] args) {

		 MessungArrayList messungArrayList = new MessungArrayList();
		 MessungLinkedList messungLinkedList = new MessungLinkedList();
		
		 messungArrayList.fuehreZeitmessungenAus();
		 messungLinkedList.fuehreZeitmessungenAus();
	}
}
