import flockbase.Bird;
import flockbase.Flock;
import sample.*;

//sample main (which will be replaced by an interactive front-end. 
// You can use the following to test your code. 
// We will assume we have a 1000x1000 2D space in which the birds fly

public class TestFlock {
	public static void main(String[] args) {
		Flock f = new Flock002(); // where FlockX is a concrete derived class of Flock

		// add a bunch of birds

		// repeat the above for the different derived classes of bird
		Bird b1 = new Bird002(); // where BirdX is a derived concrete class of Bird
		b1.setPos(10,10);
		f.addBird(b1);

		/*Bird b3 = new Bird043(); // where BirdX is a derived concrete class of Bird
		b3.setPos(200,10);
		f.addBird(b3);

		Bird b2 = new Bird511(); // where BirdX is a derived concrete class of Bird
		b2.setPos(400,10);
		f.addBird(b2);

		//Bird b5 = new Bird2017016(); // where BirdX is a derived concrete class of Bird
		//b5.setPos(500,10);
		//f.addBird(b5);

        Bird b6 = new Bird2017028();
        b6.setPos(100,10);
        f.addBird(b6);
		
		Bird b4 = new Bird523(); // where BirdX is a derived concrete class of Bird
		b4.setPos(300,10);
		f.addBird(b4);*/

		//Bird b5 = new Bird2017028(); // where BirdX is a derived concrete class of Bird
		//b5.setPos(300,10);
		//f.addBird(b5);
		for(int i=0;i<5;i++){
			Bird b = new Bird002();
			b.setPos(i*100,  10);
			f.addBird(b);
		}
	
		
		FlockDisplay disp = new SwingDisplay();
		//FlockDisplay disp = new TextDisplay();
		
		App app = new App(disp);
		disp.setApp(app);
		app.init(f);
		
		app.setLeader(b1);
		app.setTarget(800,300);
	
		/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		app.setLeader(b2);
		app.setTarget(400, 200);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		/*
		Flock f2 = f.split(2);
		Bird f2lead = f2.getLeader();
		f2lead.setTarget(10, 20);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		f2.joinFlock(f);
		f.getLeader().setTarget(100, 900);
	
		*/
	}
}
