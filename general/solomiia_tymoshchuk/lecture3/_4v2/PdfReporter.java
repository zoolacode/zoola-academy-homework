package general.solomiia_tymoshchuk.lecture3._4v2;

public class PdfReporter extends ReporterBase {

    public PdfReporter(String headerData, String fileData, String fileName) {
        super(headerData, fileData, fileName);
    }

    String fileExtension = ".pdf";

    @Override
    void createFile() {
        System.out.printf("Create %s%s file\n", fileName, fileExtension);
    }

    @Override
    void addHeaderData() {
        System.out.printf("Add %s to %s%s file\n", headerData, fileName, fileExtension);
    }

    @Override
    void addFileData() {
        System.out.printf("Add %s to %s%s file\n", fileData, fileName, fileExtension);
    }
}
