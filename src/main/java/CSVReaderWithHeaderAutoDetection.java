public class CSVReaderWithHeaderAutoDetection {

    private static final String SAMPLE_CSV_FILE_PATH = "./users-with-header.csv";
//efjefjkek
    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing values by Header names

                String name = csvRecord.get("Name");
                String email = csvRecord.get("Email");
                String phone = csvRecord.get("Phone");
                String country = csvRecord.get("Country");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + name);
                System.out.println("Email : " + email);
                System.out.println("Phone : " + phone);
                System.out.println("Country : " + country);
                System.out.println("---------------\n\n");
            }
        }
    }
}
