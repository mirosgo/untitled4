public class BasicCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "./users.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index

                String name = csvRecord.get(0);
                String email = csvRecord.get(1);
                String phone = csvRecord.get(2);
                String country = csvRecord.get(3);

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
