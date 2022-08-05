package general.solomiia_tymoshchuk.lecture3._4;

public class DocReporter extends ReporterBase {

    public DocReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".csv";
        generateFile(fileExtension);
    }
}
