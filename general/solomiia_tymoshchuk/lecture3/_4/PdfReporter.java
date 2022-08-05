package general.solomiia_tymoshchuk.lecture3._4;

public class PdfReporter extends ReporterBase{
    public PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    void generate() {
        String fileExtension = ".pdf";
        generateFile(fileExtension);
    }

}
