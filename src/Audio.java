
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
public class Audio {
	
	static AudioInputStream[] mapSongs = new AudioInputStream[4];
	static ArrayList<Clip> soundEffects = new ArrayList<Clip>();
	static ArrayList<String> soundEffectNames = new ArrayList<String>();
	static  Clip settingMusic;
	static  Clip soundEffect;
	static int lastPlayedSoundEffect;
	public Audio() {
		try {
			mapSongs[0] = AudioSystem.getAudioInputStream(new File("assets/music/Title.wav"));
			mapSongs[1] = AudioSystem.getAudioInputStream(new File("assets/music/WHITESPACE2.wav"));
			mapSongs[2] = AudioSystem.getAudioInputStream(new File("assets/music/ForestChillin.wav"));
			mapSongs[3] = AudioSystem.getAudioInputStream(new File("assets/music/BLACKSPACE.wav"));
			for (int i = 1; i <= 5; i++) {
				soundEffectNames.add("scare" + i);
			}
			soundEffectNames.add("getItem");
			soundEffectNames.add("heal");
			soundEffectNames.add("selectOption");
			soundEffectNames.add("unlockDoor");
			soundEffectNames.add("lockedDoor");
			soundEffectNames.add("interact");
			soundEffectNames.add("hit");
			for (int i = 0; i < soundEffectNames.size(); i++) {
				soundEffects.add(AudioSystem.getClip());
				soundEffects.get(i).open(AudioSystem.getAudioInputStream(new File("assets/sounds/" + soundEffectNames.get(i) + ".wav")));
			}

		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
	}
	

	public void playSettingMusic(int menuState) throws LineUnavailableException, IOException {
	    if (settingMusic != null && settingMusic.isRunning()) {
	        settingMusic.stop();
	        settingMusic.close();
	    }

	    settingMusic = AudioSystem.getClip();
	    settingMusic.open(mapSongs[menuState]);
	    settingMusic.setFramePosition(0);
	    settingMusic.start();
	    settingMusic.loop(Clip.LOOP_CONTINUOUSLY);
	    System.out.println("play it");
	}

	public void playSoundEffect(int n) throws LineUnavailableException, IOException {
		System.out.println("BLAH3");
	    Clip cur = soundEffects.get(n);
	    cur.stop();
	    cur.setFramePosition(0);
	    cur.start();
	    
	}



}
