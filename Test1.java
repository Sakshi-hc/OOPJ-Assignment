package pkg1;

class Visitors{
	String visitorName;
	String visitedDate;
	public Visitors(String name,String date) {
		this.visitorName=name;
		this.visitedDate=date;
	}
	public void display(){
		String message="Welcome to SMVITM "+visitorName+"is giving a talk on "+visitedDate ;
		System.out.println(message);
	}
}
public class Test1 {

public static void main(String[] args) {
		System.out.println("Visitors database");
		Visitors vigneshpai=new Visitors("Vignesh Pai-Robosoft ","2024-12-14");
		vigneshpai.display();
	}

}
