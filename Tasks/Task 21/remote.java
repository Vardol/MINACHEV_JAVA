class remote {

	public remote () {
	}

	public void power(TV tv) {
		if (tv.checkpower()) {
			tv.poweroff();
		} else {
			tv.poweron();
		}
	}

	public void status(TV tv) {
		tv.status();
	}

	public void changechannel(TV tv, int channel) {
		if (tv.checkpower()) {
			tv.setcurrentchannel(channel);
		} else {
			this.power(tv);
		}
	}

	public void nextchannel(TV tv) {
		int channel = 1;
		if (tv.checkpower()) {
			if (tv.getcurrentchannel() == tv.getchannellistlength()) {
				channel = 1;
			} else {
				channel = tv.getcurrentchannel() + 1;
			}
			tv.setcurrentchannel(channel);
		} else {
			this.power(tv);
		}
	}

	public void prevchannel(TV tv) {
		int channel = 1;
		if (tv.checkpower()) {
			if (tv.getcurrentchannel() == 1) {
				channel = tv.getchannellistlength();
			} else {
				channel = tv.getcurrentchannel() - 1;
			}
			tv.setcurrentchannel(channel);
		} else {
			this.power(tv);
		}
	}

}