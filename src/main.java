public class main {
    public static void main(String[] args) throws Exception {
        ReporterDAO unReporter = new ReporterDAO();
     //   NewsDAO uneNews = new NewsDAO();

        System.out.println("1. Lire reporter par son ID : " +unReporter.getReporterById(3));
      //  System.out.println("2.1 Lire une news avec son journaliste : "+uneNews.readNewsById(1));
       // NewsDAO.create(12);
    }
}
