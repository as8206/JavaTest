package visitorPattern;

import java.util.List;
import java.util.Arrays;

interface BackpackItem {
  public void accept(Visitor v);
}

interface Visitor {
  public void visit(Backpack bp);
  public void visit(TextBook book);
  public void backTrack();
}

class TextBook implements BackpackItem {
  public int price = 100;
  String title;

  public TextBook(String s) {
    title = s;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}

class Backpack implements BackpackItem {
  public int price = 20;
  List<BackpackItem> items;

  public Backpack(List<BackpackItem> lst) {
    items = lst;
  }

  public void accept(Visitor v) {
    v.visit(this);
    for (BackpackItem item: items)
      item.accept(v);
    v.backTrack();
  }
}


class PriceVisitor implements Visitor {
  public int total = 0;

  public void visit(Backpack bp) {
    total += bp.price;
  }

  public void visit(TextBook book) {
    total += book.price;
  }

  public void printPrice() {
    System.out.println("Total is: " + total);
  }

  public void backTrack(){}
}

class PrintVisitor implements Visitor {

	String[] indent = {"", "\t", "\t\t", "\t\t\t", "\t\t\t\t", "\t\t\t\t\t"};
	int index=0;
	
	public void visit(Backpack bp)
	{
		System.out.println(indent[index]+"Backpack: ");
		index++;
	}

	public void visit(TextBook book)
	{
		System.out.println(indent[index]+book.title);
	}

	@Override
	public void backTrack()
	{
		index--;
	}
	
}

public class VP {
  public static void main(String[] s) {
    BackpackItem myBackpack = new Backpack(
      Arrays.asList(new TextBook("Design Patterns"), new Backpack(
        Arrays.asList(new TextBook("Intro to Opera"), new Backpack(
          Arrays.asList(new TextBook("French I"))))), 
      new TextBook("Signal and System")));

    PriceVisitor pv = new PriceVisitor();
    PrintVisitor prv = new PrintVisitor();
    myBackpack.accept(pv);
    pv.printPrice();
    System.out.println();
    myBackpack.accept(prv);
  }
}
