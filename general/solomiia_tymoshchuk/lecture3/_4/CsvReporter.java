package general.solomiia_tymoshchuk.lecture3._4;

public class CsvReporter extends ReporterBase {

    public CsvReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".csv";
        generateFile(fileExtension);
    }

}
