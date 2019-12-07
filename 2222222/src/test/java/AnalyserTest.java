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

    @Test
    public void shoulReturnException_forImproperFile() throws IOException, ClassNotFoundException {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileRecording("/home/user/PicturesStateCode.csv", "com.dummytesting.StateCensusData");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }

    @Test
    public void shoulReturnExxception_forInCorrectType() throws IOException, ClassNotFoundException {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.csvFileRecording("/home/user/PicturesStateCode.csv", "com.dummytesting.StateCensusData");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }

    @Test
    public void ShouldCatchException_forImproperDelimiter() throws CSVFileException, IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.csvFileRecording("/home/user/Pictures/StateCensusDataDuplicate.csv", "com.dummytesting.StateCode");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.RUNTIME_ERROR, e.type);
        }
    }
}
