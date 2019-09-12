package application;

public class CommandComputerApp {

	public static void main(String[] args) {
		
		Computer myComp = new Computer();
		User user1 = new User( new StartCommand(myComp), new StopCommand(myComp), new ResetCommand(myComp));
		
		user1.startComputer();
		user1.stopComputer();
		user1.resetComputer();
	}

}

interface Command {
	void execute();
}

// creating receiver

class Computer{
	void start() {System.out.println(" Computer Started");}
	void stop() {System.out.println(" Computer Stopped");}
	void reset() {System.out.println(" Computer Resetted");}
}

// Concrete Command -> Start

class StartCommand implements Command{
	
	Computer MyComputer;
	
	public StartCommand(Computer MyComputer) {this.MyComputer = MyComputer;}
	@Override
	public void execute() {
		MyComputer.start(); // each command calls its own method -> Start
	}
	
}

//Concrete Command -> Stop

class StopCommand implements Command{
	
	Computer MyComputer;
	
	public StopCommand(Computer MyComputer) {this.MyComputer = MyComputer;}
	@Override
	public void execute() {
		MyComputer.stop(); // each command calls its own method -> Stop
	}
	
}
//Concrete Command -> Reset

class ResetCommand implements Command{
	
	Computer MyComputer;
	
	public ResetCommand(Computer MyComputer) {this.MyComputer = MyComputer;}
	@Override
	public void execute() {
		MyComputer.reset(); // each command calls its own method -> Reset
	}
	
}

// this is Invoker

class User{
	
	Command start;
	Command stop;
	Command reset;
	
	public User(Command start, Command stop, Command reset) {
		super();
		this.start = start;
		this.stop = stop;
		this.reset = reset;
	}
	
	void startComputer() {start.execute();}
	
	void stopComputer() {stop.execute();}
	
	void resetComputer() {reset.execute();}
	
	
	
	
}
