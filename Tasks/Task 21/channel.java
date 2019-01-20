import java.util.Random;

class channel {
	private program programlist[];
	private final int MAX_PROGRAMS = 20;
	private final int MIN_PROGRAMS = 5;
	private int currentprogram = 0;
	private final String genrevariations[];

	public channel() {
		this.genrevariations = new String[8];
		this.genrevariations[0] = "Sports";
		this.genrevariations[1] = "News";
		this.genrevariations[2] = "Cinema";
		this.genrevariations[3] = "Cartoons";
		this.genrevariations[4] = "Talkshow";
		this.genrevariations[5] = "StandUp Comedy";
		this.genrevariations[6] = "Music";
		this.genrevariations[7] = "Educational program";
		this.currentprogram = 0;
		Random rnd = new Random();
		this.programlist = new program[rnd.nextInt(MAX_PROGRAMS - MIN_PROGRAMS + 1) + MIN_PROGRAMS];
//		System.out.println(this.programlist.length); //debug
		for (int i = 0; i < this.programlist.length; i++) {
			this.programlist[i] = new program();
			this.programlist[i].setgenre(this.genrevariations[rnd.nextInt(this.genrevariations.length)]);
		}
	}

	public String getcurrentprogram() {
		return this.programlist[this.currentprogram].getgenre();
	}

	public String getcurrentprogram(int i) {
		return this.programlist[i].getgenre();
	}

	public void nextprogram() {
		if (this.currentprogram == this.programlist.length - 1) {
			this.currentprogram = 0;
		} else {
			this.currentprogram++;
		}
	}

	public int getprogramlistlength() {
		return programlist.length;
	}
}