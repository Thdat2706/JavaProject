package controller;

import view.MainFrame;

public class Main {

	MainFrame frame;

	public Main() {
		frame = new MainFrame();
		MyTimeCount timeCount = new MyTimeCount();
		timeCount.start();
		new Thread(frame).start();
	}

	public static void main(String[] args) {
		new Main();
	}

	class MyTimeCount extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (frame.isPause()) {
					if (frame.isResume()) {
						frame.time--;
					}
				} else {
					frame.time--;
				}
				if (frame.time == 0) {
					frame.showDialogNewGame("Full time\nDo you want play again?", "Lose", 1);
				}
			}
		}
	}
}