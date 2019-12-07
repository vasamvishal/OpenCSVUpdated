import com.dummyTesting.Analyser;
import com.dummyTesting.CSVFileException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AnalyserTest {
    @Test
    public void shouldReturnRecords_ForProperFile() throws CSVFileException, IOException, ClassNotFoundException {
        Analyser stateCensusAnalyser = new Analyser();
        int record = stateCensusAnalyser.csvFileRecording("/home/user/Pictures/StateCensusData.csv", "com.dummytesting.StateCensusData");
        Assert.assertEquals(29, record);
    }
}
