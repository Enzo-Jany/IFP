import static org.junit.Assert.assertEquals;

public class main {
    public static void main(String[] args) throws Exception {
        ReporterDAO unReporter = new ReporterDAO();
        NewsDAO uneNews = new NewsDAO("title", "content ", "20000102", 1);

        System.out.println("1. Lire reporter par son ID : " +unReporter.getReporterById(3));

        NewsDAO result = NewsDAO.readNewsById(1);
        System.out.println("2.1 Lire une news avec son journaliste : "+result.getTitle());
    }
}
