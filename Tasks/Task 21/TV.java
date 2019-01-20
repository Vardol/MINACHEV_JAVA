class TV {
	private int currentchannel;
	private final int MAX_CHANNELS = 10;
	private channel channellist[];
	private int lastchannel;
	private boolean on;

	public TV() {
		this.currentchannel = -1;
		this.channellist = new channel[MAX_CHANNELS];
		this.lastchannel = 0;
		this.on = false;
		for (int i = 0; i < this.channellist.length; i++) {
			this.channellist[i] = new channel();
		}
	}

	public int getcurrentchannel() {
		return this.currentchannel + 1;
	}

	public int getchannellistlength() {
		return this.channellist.length;
	}

	public boolean checkpower() {
		return this.on;
	}

	public void setcurrentchannel(int channel) {
		if (channel > MAX_CHANNELS || channel < 1) {
			System.out.println("no such channel");
		} else {
			this.currentchannel = channel - 1;
			System.out.println("channel " + (this.currentchannel + 1) + " set");
		}
	}
	
	public void poweron() {
		this.currentchannel = this.lastchannel;
		this.on = true;
		System.out.println("TV turned on");
	}

	public void poweroff() {
		this.lastchannel = this.currentchannel;
		this.currentchannel = -1;
		this.on = false;
		System.out.println("TV turned off");
	}

	public void status() {
		if (this.on) {
			System.out.println("TV shows " + this.channellist[this.currentchannel].getcurrentprogram() + " on " + (this.currentchannel + 1) + " channel");
		} else {
			System.out.println("TV is off");
		}
	}

	public void watch() {
		if (this.on) {
			System.out.println("You've watched " + this.channellist[this.currentchannel].getcurrentprogram() + " for some time");
			for (int i = 0; i < this.channellist.length; i++) {
				this.channellist[i].nextprogram();
			}
			this.status();
		} else {
			System.out.println("TV is off");
		}
	}

	public void timetable() {
		for (int i = 0; i < this.channellist.length; i++) {
			System.out.println("Channel " + (i + 1) + ":");
			for (int j = 0; j < this.channellist[i].getprogramlistlength(); j++) {
				System.out.print(this.channellist[i].getcurrentprogram(j) + ", ");
			}
			System.out.println("");
		}
	}
}