package ortiz.tests;

import org.junit.Test;
import ortiz.reactive.AudioProcessor;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class AudioProcessorTest {

    @Test
    public void testFrequencies() throws URISyntaxException, IOException, UnsupportedAudioFileException {
        InputStream resourceAsStream = AudioProcessorTest.class.getResourceAsStream("/440MonoToneGenerator.wav");
        try (AudioProcessor processor = new AudioProcessor(resourceAsStream)) {
            processor.getObservable().subscribe(amplitudeFrequency -> {
                System.out.println("amplitudeFrequency.getNoteWithOctave() = " + amplitudeFrequency.getNoteWithOctave());
            });
        }

    }
}
